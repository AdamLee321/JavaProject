package database.operations;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import database.ConnectionDB;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;

public class MemberOperations {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    public MemberOperations(){
        this.conn = ConnectionDB.getConn();
    }

    // Get all members and all their details (except blobs) to display on the main members window
    public ResultSet getAllMembers(){
        String query = "SELECT memberid, memberfname, memberlname, memberstreet, membercity, membercounty," +
                " memberdobd, memberdobm, memberdoby, memberemail, membernumber, memberpoints FROM member";
        try{
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        }catch(SQLException e){
        System.out.println(JOptionPane.showConfirmDialog(null,e));
    }
    return rset;
    }

    // Insert (add) a new member
    public void addMember(String fname, String lname, String street, String city, String county, int bDay, String bMonth, String bYear, String email, int memNum, int memPoints, File memPic){
        String query = "INSERT INTO member (memberId, memberFName, memberLName, memberStreet, memberCity, memberCounty," +
                "memberDOBd, memberDOBm, memberDOBy, memberEmail, memberNumber, memberPoints, memPic)" +
                "VALUES (memberSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?)";
        try{

        pstmt = conn.prepareStatement(query);

        pstmt.setString(1, fname);
        pstmt.setString(2, lname);
        pstmt.setString(3, street);
        pstmt.setString(4, city);
        pstmt.setString(5, county);
        pstmt.setInt(6, bDay);
        pstmt.setString(7, bMonth);
        pstmt.setString(8, bYear);
        pstmt.setString(9, email);
        pstmt.setInt(10, memNum);
        pstmt.setInt(11, memPoints);
        pstmt.setBinaryStream(12, new FileInputStream(memPic));
        pstmt.execute();
        } catch(SQLException q){
            JOptionPane.showMessageDialog(null, "Member Operations - " + q);
        } catch (FileNotFoundException fnf){
            JOptionPane.showMessageDialog(null, "Member Operations - " + fnf);
        }
    }


// method for inserting pictures (file) into blob columns

    public FileInputStream savePic2DB(File pic) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(pic);
        } catch (Exception e) {
            System.out.println(e);
        }
        return in;
    }
}
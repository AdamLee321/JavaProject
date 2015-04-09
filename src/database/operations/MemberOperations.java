package database.operations;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 03/04/2015)
*/

import database.ConnectionDB;
import model.Member;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class MemberOperations {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    public MemberOperations() {
        this.conn = ConnectionDB.getConn();
    }

    // Get all members in the table
    public ResultSet getAllMembers() {
        String query = "SELECT * FROM member";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "MemberOperations - getAllMembers");
        }
        return rset;
    }

//    // Get all members and all their details (except blobs) to display on the main members window
//    public ResultSet getAllMembersMinusBlobs() {
//        String query = "SELECT memberid, memberfname, memberlname, memberstreet, membercity, membercounty," +
//                " memberdobd, memberdobm, memberdoby, memberemail, membernumber, memberpoints FROM member";
//        try {
//            stmt = conn.createStatement();
//            rset = stmt.executeQuery(query);
//        } catch (SQLException e) {
//            System.out.println(JOptionPane.showConfirmDialog(null, "MemberOperations - getAllMembersMinusBlobs"));
//        }
//        return rset;
//    }

    // search through members
    public ResultSet searchMember(String keyword) {
        String query = "SELECT * FROM member WHERE UPPER(memberfname) like UPPER('%" + keyword + "%') or UPPER(memberlname) like UPPER('%" + keyword + "%') or UPPER(memberstreet) like UPPER('%" + keyword + "%') or UPPER(membercity) like UPPER('%" + keyword + "%') or UPPER(membercounty) like UPPER('%" + keyword + "%') or UPPER(memberemail) like UPPER('%" + keyword + "%')";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "MemberOperations - getAllMembers");
        }
        return rset;
    }

    // insert (add) a new member
    public void addMember(String fname, String lname, String street, String city, String county, int bDay, String bMonth, String bYear, String email, int memNum, int memPoints, File memPic) {
        String query = "INSERT INTO member (memberId, memberFName, memberLName, memberStreet, memberCity, memberCounty," +
                "memberDOBd, memberDOBm, memberDOBy, memberEmail, memberNumber, memberPoints, memPic)" +
                "VALUES (memberSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

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
        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "MemberOperations - addMember 1");
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "MemberOperations - addMember 2");
        }
    }

    // update existing member (their id is used as a search parameter)
    public void updateMember(int id, String fname, String lname, String street, String city, String county, int bDay, String bMonth, String bYear, String email, int memNum, int memPoints, File memPic) {
        String query = "UPDATE member SET memberFName = ?, memberLName = ?, memberStreet = ?, memberCity = ?, memberCounty = ?," +
                "memberDOBd = ?, memberDOBm = ?, memberDOBy = ?, memberEmail = ?, memberNumber = ?, memberPoints = ?, memPic = ?  WHERE memberId = " + id;
        try {

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
        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "MemberOperations - updateMember 1");
        } catch (FileNotFoundException fnf) {
            JOptionPane.showMessageDialog(null, "MemberOperations - updateMember 2");
        }
    }

    // delete a member
    public void deleteMember(int idIn) {
        String query = "DELETE FROM member WHERE memberid =" + idIn;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "MemberOperations - deleteMember");
        }
    }

    // return a member object based on id
    public Member getMemberById(int idIn) {
        Member m = null;
        String query = "SELECT memberId, memberFName, memberLName, memberStreet, memberCity, memberCounty, memberDOBd, memberDOBm, memberDOBy, memberEmail, memberNumber, memberPoints, memPic FROM member WHERE memberId = '" + idIn + "'";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(query);
            while (rset.next()) {
                m = new Member(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5),
                        rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10),
                        rset.getString(11), rset.getInt(12), rset.getBytes(13));
            }
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "MemberOperations - memberById");
        }
        return m;
    }

    // check if member exists
    public boolean checkMember(int id) {
        boolean x = true;
        String sql = "SELECT * FROM member WHERE memberid = '" + id + "'";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sql);
            if (!rset.next())
                x = false;
        } catch (SQLException sqlE) {
            System.out.println(sqlE.getMessage());
        }
        return x;
    }

    // Update points for member (their id is used as a search parameter)
    public void updateMemberPoints(int id, int points) {
        String query = "UPDATE member SET memberPoints = ? WHERE memberId = " + id;
        try {
            pstmt = conn.prepareStatement(query);

            pstmt.setInt(1, points);
            pstmt.execute();
        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "MemberOperations - updateMemberPoints");
        }
    }

    // for population of the id field in the member registration
    public int getNextId() {
        int max = 0;
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery("SELECT MAX(memberId) FROM member");
            while (rset.next()) {
                max = rset.getInt(1);
            }
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, "Max ID not found");
        }
        return (max + 1);
    }

    // get all the purchases by a specific member
    public ResultSet getPurchases(int mid) {
        String query = "SELECT sd.saleid, s.saledate, p.prodMake, p.prodModel, p.prodSalePrice, p.prodQTY, s.saleamount FROM product p, sales s, salesdetails sd WHERE p.prodId = sd.prodId AND sd.saleid = s.saleid and sd.memberid = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, mid);
            pstmt.execute();
            rset = pstmt.executeQuery();

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "MemberOperations - getPurchases 1");
        }
        return rset;
    }

    // get specific purchases by a member and sale id
    public ResultSet getPurchases(int mid, int sid) {
        String query = "SELECT sd.saleid, s.saledate, p.prodMake, p.prodModel, p.prodSalePrice, p.prodQTY, s.saleamount FROM product p, sales s, salesdetails sd WHERE p.prodId = sd.prodId AND sd.saleid = s.saleid and sd.memberid = ? and s.saleid = ?";
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, mid);
            pstmt.setInt(2, sid);
            pstmt.execute();
            rset = pstmt.executeQuery();

        } catch (SQLException q) {
            JOptionPane.showMessageDialog(null, "MemberOperations - getPurchases 2");
        }
        return rset;
    }


}


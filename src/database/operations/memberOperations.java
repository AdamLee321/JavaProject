package database.operations;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import database.ConnectionDB;

import javax.swing.*;
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
}
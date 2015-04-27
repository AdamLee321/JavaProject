package database.operations;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import database.ConnectionDB;

import java.sql.*;

public class ReportOperations {
    //Operations and ResultSets go here

    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    public ResultSet getSales(){
        try{
            String sql ="SELECT * FROM sales";
            stmt = ConnectionDB.getConn().createStatement();
            rset = stmt.executeQuery(sql);
        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
        return rset;
    }
}

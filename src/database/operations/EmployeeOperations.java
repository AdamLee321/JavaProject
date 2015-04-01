package database.operations;


import java.sql.*;
import database.ConnectionDB;
import gui.PasswordGenerator;
import model.Employee;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
George
David Lawlor x00107563
*/

public class EmployeeOperations {

    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    ConnectionDB conn;

    public EmployeeOperations(){
        this.conn = conn;
    }

    public ResultSet getEmployees(){
        try {
            String sqlQuery = "SELECT * FROM employee";
            stmt = ConnectionDB.getConn().createStatement();
            rset = stmt.executeQuery(sqlQuery);
        } catch(SQLException e){
            System.out.println(e);
        }
        return rset;
    }

    public ResultSet validatePassword(String uname, char[] pword){
        try{
            String sql = "SELECT position FROM EMPLOYEE WHERE empUsername = ? AND empPassword = ?";
            pstmt = ConnectionDB.getConn().prepareStatement(sql);

            //https://www.owasp.org/index.php/Preventing_SQL_Injection_in_Java
            pstmt.setString(1, uname);
            pstmt.setString(2, PasswordGenerator.hashPassword(new String(pword)));
            rset = pstmt.executeQuery();

        }catch (SQLException sqlE){
            System.out.println("Error in the validate password method");
        }
        return rset;
    }
}
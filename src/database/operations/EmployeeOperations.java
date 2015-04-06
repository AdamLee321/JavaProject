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

    public Employee validatePassword(String uname, char[] pword){
        Employee x = null;
        try{
            String sql = "SELECT empId, deptId, empFName, empLName, position, empStreet, empCity, empCounty, empDOBd, " +
                    "empDOBm, empDOBy, empEmail, salary, empUsername, empPassword, empPic FROM EMPLOYEE " +
                    "WHERE empUsername = ? AND empPassword = ?";
            pstmt = ConnectionDB.getConn().prepareStatement(sql);
            //https://www.owasp.org/index.php/Preventing_SQL_Injection_in_Java
            pstmt.setString(1, uname);
            pstmt.setString(2, PasswordGenerator.hashPassword(new String(pword)));
            rset = pstmt.executeQuery();

            while (rset.next()){
                x = new Employee(rset.getInt(1), rset.getInt(2), rset.getString(3),rset.getString(4),rset.getString(5),
                        rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(9),rset.getString(10),
                        rset.getString(11),rset.getString(12),rset.getDouble(13), rset.getString(14),rset.getString(15),
                        rset.getBytes(16));
            }


        }catch (SQLException sqlE){
            System.out.println("Error in the validate password method");
        }
        return x;
    }
}
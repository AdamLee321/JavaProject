package database.operations;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class EmployeeOperations {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rset;

    public EmployeeOperations(Connection conn){
        this.conn = conn;
    }

    public ResultSet getEmployees(){
        try {
            String sqlQuery = "SELECT * FROM employee";
            stmt = conn.createStatement();
            rset = stmt.executeQuery(sqlQuery);
        } catch(SQLException e){
            System.out.println(e);
        }
        return rset;
    }
}
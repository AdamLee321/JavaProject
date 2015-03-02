package database.create;

import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class CreateDepartment {

    private Connection conn;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;

    public CreateDepartment(Connection connIn){

        conn = connIn;
    }

    public void dropDepartment(){
        try {
            stmt = conn.createStatement();
            try{
                stmt.execute("DROP SEQUENCE deptId_seq");
                System.out.println("Department Sequence Dropped");
            } catch (SQLException e) {}
             try {
                 stmt.execute("DROP TABLE department");
                 System.out.println("Department Table Dropped");
             } catch (SQLException e) {}
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void createDepartments(){
        try{
            // create department table
            stmt = conn.createStatement();
            String sqlTable = "create table department(deptId INTEGER,deptName VARCHAR2(50),Primary Key(deptId))";
            stmt.execute(sqlTable);

            // create department id sequence
            String sqlSequence = "create sequence deptId_seq increment by 1 start with 1";
            stmt.execute(sqlSequence);

            // insert data into employee table
            String sqlData = "INSERT INTO department(deptId_seq.nextVal,?)";
            pstmt = conn.prepareStatement(sqlData);

            // department names
            pstmt.setString(1,"Administration");
            pstmt.setString(1, "Management");
            pstmt.setString(1, "Sales");
            pstmt.setString(1, "HR");
            pstmt.setString(1, "Maintenance");
        } catch (SQLException e){
            System.out.println("e");
        }

    }
}

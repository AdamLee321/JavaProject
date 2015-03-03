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

    public void dropDepartmentTable(){
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE department");
                System.out.println("Department table dropped successfully");
            } catch (SQLException e) {
                System.out.println("Error dropping department table or it may not exist");
            }
            try{
                stmt.execute("DROP SEQUENCE deptSeq");
                System.out.println("Department sequence dropped successfully\n");
            } catch (SQLException e) {
                System.out.println("Error dropping department sequence or it may not exist");
            }
        } catch (SQLException e){
            System.out.println(e);
        }
    }

    public void createDepartmentsTable(){
        try{
            // create department table
            stmt = conn.createStatement();
            String sqlTable = "create table department(deptId INTEGER,deptName VARCHAR2(50),Primary Key(deptId))";
            stmt.execute(sqlTable);
            System.out.println("Department table created successfully");

            // create department id sequence
            String sqlSequence = "create sequence deptSeq increment by 1 start with 1";
            stmt.execute(sqlSequence);
            System.out.println("Department sequence created successfully\n");

            // insert data into employee table
            String sqlData = "INSERT INTO department(deptId, deptName) values(deptSeq.nextVal,?)";
            pstmt = conn.prepareStatement(sqlData);

            // department names
            pstmt.setString(1,"Administration");
            pstmt.execute();

            pstmt.setString(1, "Management");
            pstmt.execute();

            pstmt.setString(1, "Sales");
            pstmt.execute();

            pstmt.setString(1, "HR");
            pstmt.execute();

            pstmt.setString(1, "Maintenance");
            pstmt.execute();

        } catch (SQLException e){
            System.out.println(e);
        }

    }
}

package database.create;

import java.sql.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 02/03/2015)
*/

public class CreateSales {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateSales(Connection connIn) {

        conn = connIn;
    }

    public void dropSalesTable() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP SEQUENCE saleSeq");
                System.out.println("Sales sequence dropped successfully");
            } catch (SQLException e) {
            }
            try {
                stmt.execute("DROP TABLE sales");
                System.out.println("Sales table dropped successfully\n");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createSalesTable() {
        try {
            // create sales table
            stmt = conn.createStatement();
            String sqlTable = "CREATE TABLE sales(" +
                    "saleId INTEGER," +
                    "empId INTEGER," +
                    "saleDate DATE," +
                    "saleTime VARCHAR(20)," +
                    "saleDiscount NUMBER(4,2)," +
                    "saleAmount NUMBER(6,2)," +
                    "PRIMARY KEY (saleId)," +
                    "FOREIGN KEY (empId) references employee(empId) ON DELETE SET NULL" +
                    ")";
            System.out.println("Sales table created successfully");
            stmt.execute(sqlTable);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            // create sales id sequence
            String sqlSequence = "CREATE SEQUENCE saleSeq INCREMENT BY 1 START WITH 1";
            stmt.execute(sqlSequence);
            System.out.println("Sales sequence created successfully\n");
        } catch (SQLException e){
            System.out.println(e);
        }
        try {
            //
            String sqlData = "INSERT INTO sales(saleId, empId, saleDate, saleTime, saleDiscount, saleAmount)" +
            "VALUES(saleSeq.nextVal,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setInt(1,1);
            pstmt.setString(2, "09-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 2099.99);
            pstmt.execute();

            pstmt.setInt(1,1);
            pstmt.setString(2, "14-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 2055.99);
            pstmt.execute();

            pstmt.setInt(1, 3);
            pstmt.setString(2, "02-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 269.99);
            pstmt.execute();

            pstmt.setInt(1, 4);
            pstmt.setString(2, "06-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 299.99);
            pstmt.execute();

            pstmt.setInt(1, 5);
            pstmt.setString(2, "08-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 1599.99);
            pstmt.execute();

            pstmt.setInt(1,6);
            pstmt.setString(2, "08-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 1349);
            pstmt.execute();

            pstmt.setInt(1,6);
            pstmt.setString(2, "10-APR-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 1399.99);
            pstmt.execute();


            pstmt.setInt(1,7);
            pstmt.setString(2, "16-FEB-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 899.99);
            pstmt.execute();

            pstmt.setInt(1,10);
            pstmt.setString(2, "19-MAR-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 329.99);
            pstmt.execute();

            pstmt.setInt(1,8);
            pstmt.setString(2, "20-MAR-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 529.99);
            pstmt.execute();



        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
package database.create;

import java.sql.*;

/**
 * Created by User on 02/03/2015.
 */

public class CreateSales {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateSales(Connection connIn) {

        conn = connIn;
    }

    public void dropSales() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP SEQUENCE saleSeq");
                System.out.println("Sales Sequence Dropped");
            } catch (SQLException e) {
            }
            try {
                stmt.execute("DROP TABLE sales");
                System.out.println("Sales Table Dropped");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createSales() {
        try {
            // create sales table
            stmt = conn.createStatement();
            String sqlTable = "CREATE TABLE sales(" +
                    "saleId INTEGER," +
                    "empId INTEGER," +
                    "saleDate DATE," +
                    "saleTime TIMESTAMP," +
                    "saleDiscount NUMBER(4,2)," +
                    "saleAmount NUMBER(6,4)" +
                    ")";
            System.out.println("Sales Table Created");
            stmt.execute(sqlTable);
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            // create employee id sequence
            String sqlSequence = "create sequence saleSeq increment by 1 start with 1";
            stmt.execute(sqlSequence);
            System.out.println("Sales Sequence Created");
        } catch (SQLException e){
            System.out.println(e);
        }
        try {
            //
            String sqlData = "INSERT INTO sales(saleId,empId,saleDate,saleTime,saleDiscount,saleAmount)" +
            "values(saleSeq.nextVal,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setInt(1,3);
            pstmt.setString(2, "12-mar-2015");
            pstmt.setString(3, "NULL");
            pstmt.setDouble(4, 0);
            pstmt.setDouble(5, 269.99);
            pstmt.execute();

        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
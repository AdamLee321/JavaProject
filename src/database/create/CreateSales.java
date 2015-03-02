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
                System.out.println("\nSales Sequence Dropped");
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
            // create employee table
            stmt = conn.createStatement();
            String sqlTable = "CREATE TABLE sales(" +
                    "saleId INTEGER," +
                    "empId INTEGER," +
                    "saleDate DATE," +
                    "saleTime TIMESTAMP," +
                    "saleDiscount NUMBER(4,2)," +
                    "saleAmount NUMBER" +
                    ")";
            System.out.println("\nEmployee Table Created");
            stmt.execute(sqlTable);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}
package database.create;

import java.sql.*;

/**
 * Created by User on 02/03/2015.
 */

public class CreateSalesDetails {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateSalesDetails(Connection connIn) {
        conn = connIn;
    }

    public void dropSalesDetails() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE salesdetails");
                System.out.println("SalesDetails Table Dropped");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createSalesDetails() {
        try {
            // create salesdetails table
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE salesdetails(" +
                    "prodId INTEGER," +
                    "saleId INTEGER," +
                    "memberId INTEGER," +
                    "PRIMARY KEY(prodId, saleId, memberId)," +
                    "FOREIGN KEY(prodId)REFERENCES product(prodId)," +
                    "FOREIGN KEY (saleId) REFERENCES sales (saleId)," +
                    "FOREIGN KEY (memberId) REFERENCES member (memberId))");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            // insert data into salesdetails
            String sqlData = "INSERT INTO salesdetails (prodId, saleId, memberId) VALUES (?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setInt(1,1);
            pstmt.setInt(2,1);
            pstmt.setInt(3,1);

            pstmt.setInt(1,4);
            pstmt.setInt(2,5);
            pstmt.setInt(3,4);

            pstmt.setInt(1,6);
            pstmt.setInt(2,2);
            pstmt.setInt(3,8);

            pstmt.execute();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}

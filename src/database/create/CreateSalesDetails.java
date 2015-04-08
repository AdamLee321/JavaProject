package database.create;

import javax.swing.*;
import java.sql.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 02/03/2015)
*/

public class CreateSalesDetails {

    private Connection conn;
    private PreparedStatement pstmt;
    private Statement stmt;

    public CreateSalesDetails(Connection connIn) {
        conn = connIn;
    }

    public void dropSalesDetailsTable() {
        try {
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE salesdetails");
                System.out.println("\nSalesDetails table dropped successfully\n");
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void createSalesDetailsTable() {
        try {
            // create salesdetails table
            stmt = conn.createStatement();
            stmt.execute("CREATE TABLE salesdetails(" +
                    "prodId INTEGER," +
                    "saleId INTEGER," +
                    "memberId INTEGER," +
                    "qty INTEGER NOT NULL," +
                    "PRIMARY KEY(prodId, saleId)," +
                    "FOREIGN KEY(prodId)REFERENCES product(prodId) ON DELETE CASCADE," +
                    "FOREIGN KEY (saleId) REFERENCES sales (saleId)," +
                    "FOREIGN KEY (memberId) REFERENCES member (memberId)ON DELETE SET NULL)");
        } catch (SQLException e) {
            System.out.println(e);
        }
        try {
            // insert data into salesdetails
            String sqlData = "INSERT INTO salesdetails (prodId, saleId, memberId, qty) VALUES (?,?,?,?)";
            pstmt = conn.prepareStatement(sqlData);

            pstmt.setInt(1,100000);
            pstmt.setInt(2,1);
            pstmt.setInt(3,1);
            pstmt.setInt(4,1);
            pstmt.execute();

            pstmt.setInt(1,100003);
            pstmt.setInt(2,2);
            pstmt.setInt(3,4);
            pstmt.setInt(4,4);
            pstmt.execute();

            pstmt.setInt(1,100005);
            pstmt.setInt(2,3);
            pstmt.setInt(3,8);
            pstmt.setInt(4,8);
            pstmt.execute();

        } catch (SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
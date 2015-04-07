package database.operations;/*2ndYearProject
  database.operations
  Created by David
  15:50   07/04/2015
  Software Development 3
*/

import database.ConnectionDB;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesDetailsOperations {

  Statement stmt;
  PreparedStatement pstmt;
  ResultSet rset;

  public void insertSalesDetails(int prodId, int saleId, int memberId, int qty) {
    try {
      // insert data into salesdetails
      String sqlData = "INSERT INTO salesdetails (prodId, saleId, memberId, qty) VALUES (?,?,?,?)";
      pstmt = ConnectionDB.getConn().prepareStatement(sqlData);

      pstmt.setInt(1, prodId);
      pstmt.setInt(2, saleId);
      pstmt.setInt(3, memberId);
      pstmt.setInt(4, qty);
      pstmt.execute();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }

  public void insertSalesDetails(int prodId, int saleId, int qty) {
    try {
      // insert data into salesdetails
      String sqlData = "INSERT INTO salesdetails (prodId, saleId, qty) VALUES (?,?,?)";
      pstmt = ConnectionDB.getConn().prepareStatement(sqlData);

      pstmt.setInt(1, prodId);
      pstmt.setInt(2, saleId);
      pstmt.setInt(3, qty);
      pstmt.execute();
    } catch (SQLException e) {
      JOptionPane.showMessageDialog(null, e);
    }
  }
}

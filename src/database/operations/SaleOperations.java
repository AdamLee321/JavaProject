package database.operations;/*2ndYearProject
  database.operations
  Created by David
  14:31   07/04/2015
  Software Development 3
*/

import database.ConnectionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SaleOperations {
  Statement stmt;
  PreparedStatement pstmt;
  ResultSet rset;

  public void insertSale(int empId, String date, String time, double discount, double total) {
    try {
      //
      String sqlData = "INSERT INTO sales(saleId, empId, saleDate, saleTime, saleDiscount, saleAmount)" +
              "VALUES(saleSeq.nextVal,?,?,?,?,?)";
      pstmt = ConnectionDB.getConn().prepareStatement(sqlData);

      pstmt.setInt(1, empId);
      pstmt.setString(2, date);
      pstmt.setString(3, time);
      pstmt.setDouble(4, discount);
      pstmt.setDouble(5, total);
      pstmt.execute();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public int getMaxId(){
    int maxId = 0;
    try {
      String sqlQuery = "SELECT max(saleId) FROM Sales";
      stmt = ConnectionDB.getConn().createStatement();
      rset = stmt.executeQuery(sqlQuery);
      while(rset.next()){
        maxId = rset.getInt(1);
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    return maxId;
  }

  public ResultSet getSales(int empId){
    String sql = "Select saleId, saleDate, saleTime, saleDiscount, saleAmount FROM Sales WHERE empId = '"+ empId +"'";
    try {
      stmt = ConnectionDB.getConn().createStatement();
      rset = stmt.executeQuery(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return rset;
  }


  }



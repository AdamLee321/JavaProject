package database.create;/*2ndYearProject
  database.create
  Created by David
  16:30   02/03/2015
  Software Development 3
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateShop {
  private PreparedStatement pstmt;
  private Statement stmt;
  private Connection conn;

  public CreateShop(Connection connIn){
    conn =  connIn;
  }

  public void dropShopTable() {
    try {
      stmt = conn.createStatement();
      try {
        stmt.execute("DROP TABLE Shop");
        System.out.println("Shop table dropped successfully");
      } catch (SQLException ex) {
        System.out.println("Error dropping shop table or it may not exist");
      }
      try{
        stmt.execute("DROP SEQUENCE shopSeq");
        System.out.println("Shop sequence dropped successfully");
      } catch (SQLException ex) {
        System.out.println("Error dropping shop sequence or if may not exist");
      }
    } catch (SQLException e) {
      //System.out.println(e);
      System.out.println("Error with connection");
    }
  }

  public void createShopTable(){
    try{
      stmt = conn.createStatement();

      //create shop table
      stmt.execute("CREATE TABLE Shop(" +
              "shopId INTEGER," +
              "shopName VARCHAR2(50)," +
              "shopStreet VARCHAR2(80)," +
              "shopCity VARCHAR2(20)," +
              "shopCounty VARCHAR2(25)," +
              "phoneNumber VARCHAR2 (10)," +
              "PRIMARY KEY (shopId)" +
              ")");
      System.out.println("Shop table created successfully");

      //create shop sequence
      stmt.execute("CREATE SEQUENCE shopSeq START WITH 1 INCREMENT BY 1");
      System.out.println("Shop sequence created successfully");

      String sql = "INSERT INTO SHOP (shopId, shopName, shopStreet, shopCity, shopCounty, phoneNumber) VALUES "+
              "(shopSeq.nextVal,?,?,?,?,?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, "DGA Computers");
      pstmt.setString(2, "13 Best Street");
      pstmt.setString(3, "Dublin City");
      pstmt.setString(4, "Dublin");
      pstmt.setString(5, "014789123");
      pstmt.execute();

    }catch(SQLException sqlE){
      System.out.println("Error creating shop table");
    }
  }
}

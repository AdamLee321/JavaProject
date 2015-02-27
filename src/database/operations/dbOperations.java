package database;/*2ndYearProject
  database
  Created by David
  18:41   25/02/2015
  Software Development 3
*/

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbOperations {
  private Connection conn = null;
  private ResultSet rset = null;
  private PreparedStatement pstmt = null;

  public dbOperations() {
    conn = openDB();
  }

  public Connection openDB() {
    try {
      OracleDataSource ods = new OracleDataSource();

      ods.setURL("jdbc:oracle:thin:Dave@localhost:1521/XE");
      ods.setUser("");
      ods.setPassword("");

      conn = ods.getConnection();


    } catch (Exception e) {
      System.out.println(e);
      System.out.println("Cannot establish connection");
    }
    return conn;
  }

}

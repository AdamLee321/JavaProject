package database;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionDB {
  private Connection conn = null;

  public ConnectionDB(){
    conn = openDB();
  }

  public Connection openDB(){
    try{
      OracleDataSource ods = new OracleDataSource();

      ods.setURL("jdbc:oracle:thin:Project@localhost:1521/XE");
      ods.setUser("Project");
      ods.setPassword("1234");

      this.conn = ods.getConnection();
      System.out.println("connected.");

    }catch (Exception e){
      System.out.println(e);
      System.out.println("Cannot establish connection");
    }
    return this.conn;
  }

  public void closeDB() {
    try {
      conn.close();
      System.out.print("Connection closed");
    } catch (SQLException e) {
      System.out.print("Could not close connection ");
      e.printStackTrace();
    }
  }

  public Connection getConn(){
    return conn;
  }
}

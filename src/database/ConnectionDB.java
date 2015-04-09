package database;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionDB {
  private static Connection conn = null;

  public ConnectionDB(){
    conn = openDB();
  }

  public Connection openDB(){
    try {
      OracleDataSource ods = new OracleDataSource();

      ods.setURL("jdbc:oracle:thin:Project@localhost:1521/XE");
      ods.setUser("Project");
      ods.setPassword("1234");

      this.conn = ods.getConnection();
      System.out.println("connected.");

    }catch (SQLException se) {
        SQLExceptionHandler.handleException(se, conn);
        System.exit(0);

    }catch (Exception e){
      System.out.println(e);
      System.out.println("Cannot establish connection");
    }
    return this.conn;
  }

  public static void closeDB() {
    try {
      conn.close();
      System.out.print("Connection closed");
    } catch (SQLException e) {
      System.out.print("Could not close connection ");
      e.printStackTrace();
    }
  }

  public static Connection getConn(){
    return conn;
  }
}

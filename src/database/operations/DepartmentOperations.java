package database.operations;/*2ndYearProject
  database.operations
  Created by David
  14:07   08/04/2015
  Software Development 3
*/

import database.ConnectionDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentOperations {

  Statement stmt;
  PreparedStatement pstmt;
  ResultSet rset;

  public String getDepartmentName(int id){
    String department ="";
    String sql = "SELECT deptName FROM department WHERE deptid = '"+id+"'";
    try{
      stmt = ConnectionDB.getConn().createStatement();
      rset = stmt.executeQuery(sql);
      while (rset.next())
        department = rset.getString(1);
    }catch (SQLException sqlE){
      System.out.println(sqlE.getMessage());
    }
    return department;
  }

  public int getDepartmentId(String department){
    int id = 0;
    String sql = "SELECT deptid FROM department WHERE deptname = '"+department+"'";
    try{
      stmt = ConnectionDB.getConn().createStatement();
      rset = stmt.executeQuery(sql);
      while (rset.next())
        id = rset.getInt(1);
    }catch (SQLException sqlE){
      System.out.println(sqlE.getMessage());
    }
    return id;
  }
}

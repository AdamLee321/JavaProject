package main;/*2ndYearProject
  test
  Created by David
  18:32   25/02/2015
  Software Development 3
*/
import database.ConnectionDB;
import database.create.*;
import gui.MainFrame;
import model.Shop;

public class Main {
  public static void main(String[] args) {

    ConnectionDB connDB = new ConnectionDB();
/*
      CreateShop cs = new CreateShop(connDB.getConn());
      CreateDepartment cd = new CreateDepartment(connDB.getConn());
      CreateShopDepartment sd = new CreateShopDepartment(connDB.getConn());
      CreateEmployee ce = new CreateEmployee(connDB.getConn());
      CreateSales se = new CreateSales(connDB.getConn());
      CreateProduct cp = new CreateProduct(connDB.getConn());
      CreateMember cm = new CreateMember(connDB.getConn());
      CreateSalesDetails sld = new CreateSalesDetails(connDB.getConn());

      sld.dropSalesDetailsTable();
      cm.dropMembersTable();
      cp.dropProductTable();
      se.dropSalesTable();
      ce.dropEmployeesTable();
      sd.dropShopDepartmentTable();
      cd.dropDepartmentTable();
      cs.dropShopTable();

      cs.createShopTable();
      cd.createDepartmentsTable();
      sd.createShopDepartmentTable();
      ce.createEmployeesTable();
      se.createSalesTable();
      cp.createProductTable();
      cm.createMembersTable();
      sld.createSalesDetailsTable();

    //connDB.closeDB();
*/
    MainFrame mf = new MainFrame(connDB.getConn());
    //mf.setVisible(true);
      mf.setMf(mf);
  }
}

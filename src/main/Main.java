package main;/*2ndYearProject
  test
  Created by David
  18:32   25/02/2015
  Software Development 3
*/
import database.ConnectionDB;
import database.create.*;
import model.Shop;

public class Main {
  public static void main(String[] args) {
    ConnectionDB connDB = new ConnectionDB();

    CreateShop cs = new CreateShop(connDB.getConn());
    cs.dropShopTable();
    cs.createShopTable();

    CreateDepartment cd = new CreateDepartment(connDB.getConn());
    cd.dropDepartment();
    cd.createDepartments();

    CreateEmployee ce = new CreateEmployee(connDB.getConn());
    ce.dropEmployees();
    ce.createEmployees();

    CreateSales se = new CreateSales(connDB.getConn());
    se.dropSales();
    se.createSales();

    CreateMember me = new CreateMember();
    me.dropMembers(connDB.getConn());
    me.createMembers();

    CreateShopDepartment sd = new CreateShopDepartment(connDB.getConn());
    sd.dropShopDepartment();

    connDB.closeDB();
  }
}

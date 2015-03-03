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

<<<<<<< HEAD
      CreateShop cs = new CreateShop(connDB.getConn());
      CreateDepartment cd = new CreateDepartment(connDB.getConn());
      CreateShopDepartment sd = new CreateShopDepartment(connDB.getConn());
      CreateEmployee ce = new CreateEmployee(connDB.getConn());
      CreateSales se = new CreateSales(connDB.getConn());
      CreateProduct cp = new CreateProduct(connDB.getConn());
      CreateMember cm = new CreateMember(connDB.getConn());
      //CreateSaleDetails sld = new CreateSaleDetails(connDB.getConn());

      //sld.dropSaleDetailsTable();
      cm.dropMembersTable();
      cp.dropProductTable();
      se.dropSalesTable();
      ce.dropEmployeesTable();
      sd.dropShopDepartmentTable();
      cd.dropDepartmentTable();
      cs.dropShopTable();
=======
    CreateShop cs = new CreateShop(connDB.getConn());
    cs.dropShopTable();
    cs.createShopTable();

    CreateDepartment cd = new CreateDepartment(connDB.getConn());
    cd.dropDepartment();
    cd.createDepartments();
>>>>>>> 26363321cf193cbebd289640200b25c03d478695

      cs.createShopTable();
      cd.createDepartmentsTable();
      sd.createShopDepartmentTable();
      ce.createEmployeesTable();
      se.createSalesTable();
      cp.createProductTable();
      cm.createMembersTable();
      //sld.createSaleDetailTable();

<<<<<<< HEAD

=======
    CreateSales se = new CreateSales(connDB.getConn());
    se.dropSales();
    se.createSales();

    CreateMember me = new CreateMember();
    me.dropMembers(connDB.getConn());
    me.createMembers();
>>>>>>> 26363321cf193cbebd289640200b25c03d478695

    CreateShopDepartment sd = new CreateShopDepartment(connDB.getConn());
    sd.dropShopDepartment();

    connDB.closeDB();
  }
}

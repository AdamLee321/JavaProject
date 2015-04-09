package main;

import database.ConnectionDB;
import database.create.*;
import database.operations.EmployeeOperations;
import gui.PasswordGenerator;
import gui.StartWindow;
import gui.admin.AdminMain;
import gui.sale.SaleMain;
import model.Employee;
import sun.security.util.Password;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
  public static void main(String[] args) {

    ConnectionDB connDB = new ConnectionDB();
//
//    CreateShop cs = new CreateShop(connDB.getConn());
//    CreateDepartment cd = new CreateDepartment(connDB.getConn());
//    CreateShopDepartment sd = new CreateShopDepartment(connDB.getConn());
//    CreateEmployee ce = new CreateEmployee(connDB.getConn());
//    CreateSales se = new CreateSales(connDB.getConn());
//    CreateProduct cp = new CreateProduct(connDB.getConn());
//    CreateMember cm = new CreateMember(connDB.getConn());
//    CreateSalesDetails sld = new CreateSalesDetails(connDB.getConn());
//
//    sld.dropSalesDetailsTable();
//    cm.dropMembersTable();
//    cp.dropProductTable();
//    se.dropSalesTable();
//    ce.dropEmployeesTable();
//    sd.dropShopDepartmentTable();
//    cd.dropDepartmentTable();
//    cs.dropShopTable();
//
//    cs.createShopTable();
//    cd.createDepartmentsTable();
//    sd.createShopDepartmentTable();
//    ce.createEmployeesTable();
//    se.createSalesTable();
//    cp.createProductTable();
//    cm.createMembersTable();
//    sld.createSalesDetailsTable();

    //connDB.closeDB();


    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      Logger.getLogger(StartWindow.class.getName()).log(Level.SEVERE, null, ex);
    }

    char[] y = {'1','2','3','4','5'};
    Employee x = new EmployeeOperations().validatePassword("ruthward", y);

//        new StartWindow();

//     new SaleMain(x);
     new AdminMain(x);
    //new StartWindow();

  }
}

package gui.product;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 09/04/2015)
*/

import database.operations.MemberOperations;
import database.operations.ProductOperations;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

public class PurchaseHistoryTableModel extends DefaultTableModel {

    // Model
    int saleId;
    String saleTime;
    Date saleDate;
    String empName;
    String memName;

    // Table columns
    final static int id = 0;
    final static int time = 1;
    final static int date = 2;
    final static int empN = 3;
    final static int memN = 4;
    final static String[] columnNames = {"Sale ID", "Sale Time", "Sale Date", "Employee Name", "Member Name"};

    // column model
    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    // array for objects
    private static ArrayList<Object> pHistoryRows = new ArrayList();

    public PurchaseHistoryTableModel() {
        TableColumn col;
        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            // col.setMaxWidth(150); disabled because this does not work, width must be set from the JTable (MemberMain) ex... memTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            columnModel.addColumn(col);
        }
    }

    public PurchaseHistoryTableModel(int saleId, String time, Date date, String empName, String memName) {
        this.saleId = saleId;
        this.saleTime = time;
        this.saleDate = date;
        this.empName = empName;
        this.memName = memName;
    }

    // return the main list of employees from the database
    public void getPurchaseList(int pid) {
        try {
            ProductOperations po = new ProductOperations();
            ResultSet rset = po.getPurchases(pid);
            while (rset.next()) {
                pHistoryRows.add(new PurchaseHistoryTableModel(rset.getInt(1), rset.getString(2), rset.getDate(3), (rset.getString(4) + " " + rset.getString(5)), (rset.getString(6) + " " + rset.getString(7))));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }


    public void getPurchaseList(int pid, int sid) {
        try {
            ProductOperations po = new ProductOperations();
            ResultSet rset = po.getPurchases(pid, sid);
            while (rset.next()) {
                pHistoryRows.add(new PurchaseHistoryTableModel(rset.getInt(1), rset.getString(2), rset.getDate(3), (rset.getString(4) + " " + rset.getString(5)), (rset.getString(6) + " " + rset.getString(7))));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        PurchaseHistoryTableModel row = (PurchaseHistoryTableModel) pHistoryRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case id:
                return row.getSaleId();
            case time:
                return row.getSaleTime();
            case date:
                return row.getSaleDate();
            case empN:
                return row.getEmpName();
            case memN:
                return row.getMemName();
            default:
                return "";
        }
    }
    // returns column names - if commented out, columns get auto named - A,B,C,D...
    public String getColumnName(int column) {
        if (columnNames[column] != null)
            return columnNames[column];
        else
            return "";
    }
    public void emptyArray() {
        if (pHistoryRows.size() > 0) {
            for (int i = pHistoryRows.size(); i > 0; i--) {
                pHistoryRows.remove(i - 1);
            }
        }
    }
    public ArrayList<Object> getArray() {
        return pHistoryRows;
    }
    // don't allow editing cells when double clicked
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public Class getColumnClass(int column) {
        return String.class;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return pHistoryRows.size();
    }

// MODEL GETTERS

    public int getSaleId() {
        return saleId;
    }
    public String getSaleTime() {
        return saleTime;
    }
    public Date getSaleDate() {
        return saleDate;
    }
    public String getEmpName() {
        return empName;
    }
    public String getMemName() {
        return memName;
    }
}
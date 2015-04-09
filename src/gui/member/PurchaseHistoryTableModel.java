package gui.member;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/04/2015)
*/

import database.operations.MemberOperations;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PurchaseHistoryTableModel extends DefaultTableModel {

    // Model
    int saleid;
    Date date;
    String prodMake;
    String prodModel;
    double salePrice;
    int quantity;
    double totalPrice;

    // Table columns
    final static int id = 0;
    final static int saleDate = 1;
    final static int make = 2;
    final static int model = 3;
    final static int qty = 4;
    final static int price = 5;
    final static int paid = 6;
    final static String[] columnNames = {"Sale ID", "Sale Date", "Make", "Model", "Quantity", "Price", "Paid"};

    // column model
    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    // array for objects
    private static ArrayList<Object> pHistoryRows = new ArrayList();

    public PurchaseHistoryTableModel() {
        TableColumn col;
        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
//            col.setMaxWidth(150); disabled because this does not work, width must be set from the JTable (MemberMain) ex... memTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            columnModel.addColumn(col);
        }
    }

    public PurchaseHistoryTableModel(int saleId, Date date, String prodMake, String prodModel, double salePrice, int quantity, double totalPrice) {
        this.saleid = saleId;
        this.date = date;
        this.prodMake = prodMake;
        this.prodModel = prodModel;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // return the main list of employees from the database
    public void getPurchaseList(int mid) {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.getPurchases(mid);
            while (rset.next()) {
                pHistoryRows.add(new PurchaseHistoryTableModel(rset.getInt(1), rset.getDate(2), rset.getString(3), rset.getString(4), rset.getDouble(5), rset.getInt(6), rset.getDouble(7)));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void getPurchaseList(int mid, int sid) {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.getPurchases(mid, sid);
            while (rset.next()) {
                pHistoryRows.add(new PurchaseHistoryTableModel(rset.getInt(1), rset.getDate(2), rset.getString(3), rset.getString(4), rset.getDouble(5), rset.getInt(6), rset.getDouble(7)));
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
                return row.getSaleid();
            case saleDate:
                return row.getDate();
            case make:
                return row.getProdMake();
            case model:
                return row.getProdModel();
            case qty:
                return row.getQuantity();
            case price:
                return row.getSalePrice();
            case paid:
                return row.getTotalPrice();
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

















    public int getSaleid() {
        return this.saleid;
    }

    public Date getDate() {
        return date;
    }

    public String getProdMake() {
        return prodMake;
    }

    public String getProdModel() {
        return prodModel;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
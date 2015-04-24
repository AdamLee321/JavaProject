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

public class OrderHistoryTableModel extends DefaultTableModel {

    // Model (OrderHistoryTableModel) variables
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
    final static int itemPrice = 5;
    final static int totalPaid = 6;
    final static String[] columnNames = {"Sale ID", "Sale Date", "Make", "Model", "Quantity", "Item Price", "Total Paid"};

    // column model
    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    // array for objects that Model fills into
    private static ArrayList<Object> pHistoryRows = new ArrayList();

    public OrderHistoryTableModel() {
        TableColumn col;
        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            // col.setMaxWidth(150); disabled because this does not work, width must be set from the JTable (MemberMain) ex... memTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            columnModel.addColumn(col);
        }
    }

    // overloaded constructor for the model
    public OrderHistoryTableModel(int saleId, Date date, String prodMake, String prodModel, double salePrice, int quantity, double totalPrice) {
        this.saleid = saleId;
        this.date = date;
        this.prodMake = prodMake;
        this.prodModel = prodModel;
        this.salePrice = salePrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    // get purchase list from database based on member id and populate the pHistoryRows model array
    public void getPurchaseList(int mid) {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.getPurchases(mid);
            while (rset.next()) {
                pHistoryRows.add(new OrderHistoryTableModel(rset.getInt(1), rset.getDate(2), rset.getString(3), rset.getString(4), rset.getDouble(5), rset.getInt(6), rset.getDouble(7)));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // get purchase list from database based on member id and sale id, and populate the pHistoryRows model array
    public void getPurchaseList(int mid, int sid) {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.getPurchases(mid, sid);
            while (rset.next()) {
                pHistoryRows.add(new OrderHistoryTableModel(rset.getInt(1), rset.getDate(2), rset.getString(3), rset.getString(4), rset.getDouble(5), rset.getInt(6), rset.getDouble(7)));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        OrderHistoryTableModel row = (OrderHistoryTableModel) pHistoryRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case id:
                return row.saleid;
            case saleDate:
                return row.date;
            case make:
                return row.prodMake;
            case model:
                return row.prodModel;
            case qty:
                return row.quantity;
            case itemPrice:
                return row.salePrice;
            case totalPaid:
                return row.totalPrice;
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
}
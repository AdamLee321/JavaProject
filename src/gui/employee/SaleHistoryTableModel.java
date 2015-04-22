package gui.employee;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/04/2015)
David Lawlor
*/

import database.operations.SaleOperations;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class SaleHistoryTableModel extends DefaultTableModel {

    // Model (SaleHistoryTableModel) variables
    private int saleid;
    private String time;
    private String date;
    private double discount;
    private double tPrice;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

    // Table columns
    final static int ID = 0;
    final static int SALE_TIME = 1;
    final static int SALE_DATE = 2;
    final static int SALE_DISCOUNT = 3;
    final static int TOTAL_AMOUNT = 4;
    final static String[] columnNames = {"Sale ID", "Sale Time", "Sale Date", "Discount", "Sale Amount"};

    // column model
    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    // array for objects that Model fills into
    private static ArrayList<Object> saleHistoryRows = new ArrayList();

    public SaleHistoryTableModel() {
        TableColumn col;
        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            // col.setMaxWidth(150); disabled because this does not work, width must be set from the JTable (MemberMain) ex... memTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            columnModel.addColumn(col);
        }
    }

    // overloaded constructor for the model
    public SaleHistoryTableModel(int saleid, String date, String time, double discount, double totalPrice) {
        this.saleid = saleid;
        this.time = time;
        this.date = date;
        this.discount = discount;
        this.tPrice = totalPrice;
    }

    // get sale list
    public void getSaleList(int empID) {
        try {
            emptyArray();
            ResultSet rset = new SaleOperations().getSales(empID);
            while (rset.next()) {
                saleHistoryRows.add(new SaleHistoryTableModel(rset.getInt(1), String.valueOf(dateFormat.format(rset.getDate(2))), rset.getString(3), rset.getDouble(4), rset.getDouble(5)));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        SaleHistoryTableModel row = (SaleHistoryTableModel) saleHistoryRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case ID:
                return row.saleid;
            case SALE_DATE:
                return row.date;
            case SALE_TIME:
                return row.time;
            case SALE_DISCOUNT:
                return row.discount;
            case TOTAL_AMOUNT:
                return row.tPrice;
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
        if (saleHistoryRows.size() > 0) {
            for (int i = saleHistoryRows.size(); i > 0; i--) {
                saleHistoryRows.remove(i - 1);
            }
        }
    }

    public ArrayList<Object> getArray() {
        return saleHistoryRows;
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
        return saleHistoryRows.size();
    }
}
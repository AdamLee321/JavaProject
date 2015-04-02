package gui.member;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 02/04/2015)
*/

import database.operations.MemberOperations;
import database.operations.ProductOperations;
import gui.sale.SaleRow;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberTableModel extends DefaultTableModel {

    final static int id = 0;
    final static int fname = 1;
    final static int lname = 2;
    final static int street = 3;
    final static int city = 4;
    final static int county = 5;
    final static int dobd = 6;
    final static int dobm = 7;
    final static int doby = 8;
    final static int email = 9;
    final static int number = 10;
    final static int points = 11;
    final static String[] columnNames = {"ID", "Name", "Surname", "Street", "City", "County", "BDay", "BMonth", "BYear", "Email", "Number", "Points"};

    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
    private static ArrayList<Object> memberRows = new ArrayList();

    public MemberTableModel() {
        TableColumn col;
        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            col.setWidth(150);
            columnModel.addColumn(col);
        }
    }

    public void getMainList() {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.getAllMembers();
            while (rset.next()) {
                memberRows.add(new MemberRow(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getInt(7), rset.getString(8), rset.getInt(9), rset.getString(10), rset.getString(11), rset.getInt(12)));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        MemberRow row = (MemberRow)memberRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case id:
                return row.getMemberId();
            case fname:
                return row.getMemberFName();
            case lname:
                return row.getMemberLName();
            case street:
                return row.getMemberStreet();
            case city:
                return row.getMemberCity();
            case county:
                return row.getMemberCounty();
            case dobd:
                return row.getDobd();
            case dobm:
                return row.getDobm();
            case doby:
                return row.getDoby();
            case email:
                return row.getMemberEmail();
            case number:
                return row.getMemberNumber();
            case points:
                return row.getMemberPoints();
            default:
                return "";
        }}

    public String getColumnName(int column) {
        if (columnNames[column] != null)
            return columnNames[column];
        else
            return "";
    }

    public void emptyArray() {
        if (memberRows.size() > 0) {
            for (int i = memberRows.size(); i > 0; i--) {
                memberRows.remove(i - 1);
            }
        }
    }

    public static ArrayList<Object> getList(){
        return memberRows;
    }

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
        return memberRows.size();
    }
}
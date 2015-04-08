package gui.member;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 02/04/2015)
*/

import database.operations.MemberOperations;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
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
    final static int email = 6;
    final static String[] columnNames = {"ID", "Name", "Surname", "Street", "City", "County", "E-mail"};

    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();
    private static ArrayList<Object> memberRows = new ArrayList();



    public MemberTableModel() {
        TableColumn col;
        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
//            col.setMaxWidth(150); disabled because this does not work, width must be set from the JTable (MemberMain) ex... memTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            columnModel.addColumn(col);
        }
    }

    // return the main list of employees from the database
    public void getMainList() {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.getAllMembers();
            while (rset.next()) {
                memberRows.add(new MemberRow(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10), rset.getString(11), rset.getInt(12)));
            }
            rset.close();
            fireTableChanged(new TableModelEvent(this, -1, -1));
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }

    // return the searched list from the database
    public void searchMainList(String keyword) {
        try {
            MemberOperations mo = new MemberOperations();
            ResultSet rset = mo.searchMember(keyword);
            while (rset.next()) {
                memberRows.add(new MemberRow(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10), rset.getString(11), rset.getInt(12)));
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
            case email:
                return row.getMemberEmail();
            default:
                return "";
        }}

    // returns column names - if commented out, columns get auto named - A,B,C,D...
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

    public ArrayList<Object> getArray(){
        return memberRows;
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
        return memberRows.size();
    }
}
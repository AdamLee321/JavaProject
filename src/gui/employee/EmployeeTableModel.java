package gui.employee;

import database.operations.EmployeeOperations;
import database.operations.ProductOperations;
import gui.employee.EmployeeTableRow;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by DL on 04/04/2015.
 */
public class EmployeeTableModel extends DefaultTableModel{
    final static int ID = 0;
    final static int FNAME = 1;
    final static int LNAME = 2;
    final static int POSITION = 3;
    final static int DEPARTMENT = 4;
    final static int STREET = 5;
    final static int CITY = 6;
    final static int COUNTY = 7;
    final static int DOB = 8;
    final static int EMAIL = 9;



    final static String[] columnNames = {"ID", "Forename", "Surname", "Position", "Department", "Street",
            "City", "County", "Date of Birth", "Email"};

    private static ArrayList<Object> employeeTableRows = new ArrayList();

    public ArrayList<Object> getList(){
        return employeeTableRows;
    }

    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    DecimalFormat decimalFormat = new DecimalFormat("€###,###.00");

    public EmployeeTableModel() {
        TableColumn col;

        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
//            col.setPreferredWidth(200);
//            if (columnNames[i].equals("ID") || columnNames[i].equals("Department")) {
//                col.setPreferredWidth(50);
//                //System.out.println(col.getWidth());
//            }
            columnModel.addColumn(col);
        }
    }

    public void getAllEmployeesTable(){
        try{
            ResultSet rset = new EmployeeOperations().getEmployees();
            while (rset.next()) {
                employeeTableRows.add(new EmployeeTableRow(rset.getInt(1), rset.getString(3), rset.getString(4),
                        rset.getString(5), rset.getInt(2), rset.getString(6), rset.getString(7), rset.getString(8),
                        (rset.getString(9) +"-" + rset.getString(10) +"-"+ rset.getString(11)), rset.getString(12)));
            }
            rset.close();
        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        EmployeeTableRow row = (EmployeeTableRow)employeeTableRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case ID:
                return row.getId();
            case FNAME:
                return row.getfName();
            case LNAME:
                return row.getlName();
            case POSITION:
                return row.getPosition();
            case DEPARTMENT:
                return row.getDepartment();
            case STREET:
                return row.getStreet();
            case CITY:
                return row.getCity();
            case COUNTY:
                return row.getCounty();
            case DOB:
                return row.getDob();
            case EMAIL:
                return row.getEmail();
            default:
                return "";
        }
    }


    public String getColumnName(int column) {
        if (columnNames[column] != null)
            return columnNames[column];
        else
            return "";
    }

    public void emptyArray() {
        if (employeeTableRows.size() > 0) {
            for (int i = employeeTableRows.size(); i > 0; i--) {
                employeeTableRows.remove(i - 1);
            }
        }
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
        return employeeTableRows.size();
    }
}


package gui.report;

import database.operations.EmployeeOperations;
import database.operations.ReportOperations;
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
 * Created by Adam Lee on 23/04/2015.
 */
public class ReportTableModel extends DefaultTableModel {

    final static int SALE = 0;
    final static int EMP = 1;
    final static int PROD = 2;
    final static int DAY = 3;
    final static int MONTH = 4;
    final static int YEAR = 5;
    final static int TIME = 6;
    final static int DISCOUNT = 7;
    final static int AMOUNT = 8;

    String[] columns = new String[] {
            "Sale ID" , "Emp ID", "Prod ID" , "Day" ,"Month" ,"Year" , "Time", "Sale Discount" , "Sale Amount"
    };

    private static ArrayList<Object> salesTableRow = new ArrayList();

    public ArrayList<Object> getSales(){
        return salesTableRow;
    }

    DefaultTableColumnModel columnsModel = new DefaultTableColumnModel();

    public  ReportTableModel() {
        TableColumn cols;

        for (int i = 0; i < columns.length; i++) {
            cols = new TableColumn(i);
            cols.setHeaderValue(columns[i]);
            columnsModel.addColumn(cols);
        }
    }

    public void queryTableData() throws SQLException{
            ReportOperations ro = new ReportOperations();
            ResultSet rset = ro.getSales();
            while(rset.next()) {
                ReportTableRow row = new ReportTableRow(rset.getInt(1), rset.getInt(2),  rset.getInt(3), rset.getString(4),
                        rset.getString(5),rset.getString(6), rset.getString(7), rset.getDouble(8), rset.getDouble(9));
                salesTableRow.add(row);
            }
        rset.close();
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public Object getValueAt(int rowNum, int colNum) { //Returns the cell value at row and column.
        ReportTableRow row = (ReportTableRow)salesTableRow.get(rowNum);//
        switch (colNum) {
            case SALE:
                return row.getSaleId();
            case EMP:
                return row.getEmpId();
            case PROD:
                return row.getProdId();
            case DAY:
                return row.getSaleDay();
            case MONTH:
                return row.getSaleMonth();
            case YEAR:
                return row.getSaleYear();
            case TIME:
                return row.getSaleTime();
            case DISCOUNT:
                return row.getSaleDiscount();
            case AMOUNT:
                return row.getSaleAmount();
            default:
                return "";
        }
    }

    public String getColumnName(int column) {
        if (columns[column] != null)
            return columns[column];
        else
            return "";
    }

    public int getColumnCount() {
        return columns.length;
    }

    public int getRowCount() {
        return salesTableRow.size();
    }

    public boolean isCellEditable(int row, int column) {
        return false; //To stop anyone editing the sales information.
    }
}

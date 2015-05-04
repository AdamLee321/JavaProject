package gui.report;

import database.operations.ReportOperations;
import gui.employee.EmployeeTableRow;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Adam Lee on 23/04/2015.
 */
public class ReportTableModel extends DefaultTableModel {

    final static int SALE = 0;
    final static int EMP = 1;
    final static int SALEDATE = 2;
    final static int TIME = 3;
    final static int DISCOUNT = 4;
    final static int AMOUNT = 5;

    String[] columns = new String[] {
            "Sale ID" , "Emp ID", "SaleDate" , "Time", "Sale Discount" , "Sale Amount"
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
            clearArray();
            while(rset.next()) {
                 ReportTableRow row = new ReportTableRow(rset.getInt(1), rset.getInt(2),  rset.getString(3), rset.getString(4),
                        rset.getDouble(5),rset.getDouble(6));
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
            case SALEDATE:
                return row.getSaleDate();
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

    public void clearArray() {
        if (salesTableRow.size() > 0) {
            for (int i = salesTableRow.size(); i > 0; i--) {
                salesTableRow.remove(i-1);
            }
        }
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

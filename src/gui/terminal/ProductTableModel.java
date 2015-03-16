package gui.terminal;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {

    final static int id = 0;
    final static int make = 1;
    final static int model = 2;
    final static int price = 3;
    final static int quantity = 4;
    final static String[] columnNames = { "Product ID", "Make", "Model", "Price", "Quantity" };

    private static ArrayList<Object> productRows = new ArrayList();
    final static String sql = "SELECT prodId, prodMake, prodModel, prodSalePrice, prodQTY FROM product ORDER BY prodId";

    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    public ProductTableModel() {
        TableColumn col;

        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            col.setWidth(150);
            columnModel.addColumn(col);
        }
    }

    public void queryTableData(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            ProductRow row = new ProductRow(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getInt(5));
            productRows.add(row);
        }
        rs.close();
        stmt.close();
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public int insertRow() {
        ProductRow row = new ProductRow();

        int rowNum = productRows.size();
        productRows.add(row);

        EmpDatabaseModifier.addToInsert(new ObjectToIntMap(row, rowNum));
        fireTableRowsInserted(rowNum, rowNum);

        return rowNum;
    }

    public void deleteRow(int rowNum) {
        if (rowNum >= 0) {
            ProductRow row = (ProductRow)productRows.get(rowNum);

            if (row.Id == ProductRow.INSERTED)
                EmpDatabaseModifier.removeAddToInsert(rowNum);
            else
                EmpDatabaseModifier.addToDelete(row.Id);

            productRows.remove(rowNum);
            EmpDatabaseModifier.changeRowNumbers(rowNum);
            fireTableRowsDeleted(rowNum, rowNum);
        }
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        ProductRow row = (ProductRow)productRows.get(rowNum);//casting a product from the arraylist to a row type
        switch (colNum) {
            case id:
                return row.productID;
            case make:
                return row.make;
            case model:
                return row.model;
            case price:
                return row.price;
            case quantity:
                return row.quantity;
            default:
                return "";
        }
    }

    public void setValueAt(Object value, int rowNum, int colNum) {
        ProductRow row = (ProductRow)productRows.get(rowNum);
        switch (colNum) {
            case id:
                row.productID = (Integer)value;
                if (row.Id != ProductRow.INSERTED)
                    EmpDatabaseModifier.add2ELNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            case make:
                row.make = (String)value;
                if (row.Id != ProductRow.INSERTED)
                    EmpDatabaseModifier.add2EFNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            case model:
                row.model = (String)value;
                if (row.Id != ProductRow.INSERTED)
                    EmpDatabaseModifier.add2EFNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            case price:
                row.price = (Double)value;
                if (row.Id != ProductRow.INSERTED)
                    EmpDatabaseModifier.add2EFNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            case quantity:
                row.quantity = (Integer)value;
                if (row.Id != ProductRow.INSERTED)
                    EmpDatabaseModifier.add2EFNUpdates(new ObjectToIntMap(value, row.Id));
                break;
            default:
                break;
        }
    }

    public String getColumnName(int column) {
        if (columnNames[column] != null)
            return columnNames[column];
        else
            return "";
    }

    public boolean isCellEditable(int row, int column) {
        return true;
    }

    public Class getColumnClass(int column) {
        return String.class;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return productRows.size();
    }
}

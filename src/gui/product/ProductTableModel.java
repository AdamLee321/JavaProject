package gui.product;

import database.operations.ProductOperations;
import gui.terminal.TerminalProductTableRow;

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
 *
 */
public class ProductTableModel extends DefaultTableModel{
    final static int ID = 0;
    final static int MAKE = 1;
    final static int MODEL = 2;
    final static int SALEPRICE = 3;
    final static int COSTPRICE = 4;
    final static int QUANTITY = 5;
    final static int TYPE = 6;

    final static String[] columnNames = {"Product ID", "Make", "Model", "Cost Price", "Sale Price", "Quantity", "Product Type"};

    private static ArrayList<Object> adminProductRows = new ArrayList<>();

    DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

    DecimalFormat decimalFormat = new DecimalFormat("€###,###.00");

    public ProductTableModel() {
        TableColumn col;

        for (int i = 0; i < columnNames.length; i++) {
            col = new TableColumn(i);
            col.setHeaderValue(columnNames[i]);
            col.setWidth(150);
            columnModel.addColumn(col);
        }
    }

    public void getAllProductsTable(){
        try{
            ResultSet rset = new ProductOperations().getAllProducts();
            while (rset.next()) {
                adminProductRows.add(new AdminProductTableTableRow(rset.getInt(1), rset.getString(2), rset.getString(3),
                        rset.getDouble(4), rset.getDouble(5), rset.getInt(6), rset.getString(7)));
            }
            rset.close();
        }catch (SQLException sqlE){
            System.out.println(sqlE.getMessage());
        }
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public void refreshTableProduct(String category){
        ProductOperations po = new ProductOperations();
        ResultSet rset = po.productManufacturer(category);
        emptyArray();
        try {
            while (rset.next()) {
                adminProductRows.add(new AdminProductTableTableRow(rset.getInt(1), rset.getString(2), rset.getString(3),
                        rset.getDouble(4), rset.getDouble(5), rset.getInt(6), rset.getString(7)));
            }
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public void searchTable(String category){
        ProductOperations po = new ProductOperations();
        ResultSet rset = po.searchProducts(category, "All");
        emptyArray();
        try {
            while (rset.next()) {
                adminProductRows.add(new AdminProductTableTableRow(rset.getInt(1), rset.getString(2), rset.getString(3),
                        rset.getDouble(4), rset.getDouble(5), rset.getInt(6), rset.getString(7)));
            }
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public void refreshTableProduct(String category, String type){
        ProductOperations po = new ProductOperations();
        ResultSet rset = po.productManuMake(category, type);
        emptyArray();
        try {
            while (rset.next()) {
                adminProductRows.add(new AdminProductTableTableRow(rset.getInt(1), rset.getString(2), rset.getString(3),
                        rset.getDouble(4), rset.getDouble(5), rset.getInt(6), rset.getString(7)));
            }
            rset.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        AdminProductTableTableRow row = (AdminProductTableTableRow)adminProductRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case ID:
                return row.getProductID();
            case MAKE:
                return row.getMake();
            case MODEL:
                return row.getModel();
            case COSTPRICE:
                return decimalFormat.format(row.getCostPrice());
            case SALEPRICE:
                return decimalFormat.format(row.getPrice());
            case QUANTITY:
                return row.getQuantity();
            case TYPE:
                return row.getProductType();
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
        if (adminProductRows.size() > 0) {
            for (int i = adminProductRows.size(); i > 0; i--) {
                adminProductRows.remove(i-1);
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
        return adminProductRows.size();
    }


}


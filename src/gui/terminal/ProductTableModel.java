package gui.terminal;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

import database.operations.ProductOperations;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductTableModel extends DefaultTableModel {

    final static int id = 0;
    final static int make = 1;
    final static int model = 2;
    final static int price = 3;
    final static int quantity = 4;
    final static String[] columnNames = { "Product ID", "Make", "Model", "Price €", "Quantity" };

    private static ArrayList<Object> productRows = new ArrayList();

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

    public void queryTableData(String category) throws SQLException {
        ProductOperations po = new ProductOperations();
        ResultSet rset = po.productCategory(category);
        emptyArray();
        while (rset.next()) {
            productRows.add( new ProductRow(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(6)));
        }
        rset.close();
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }

    public void queryTableData(String category, String keyword) throws SQLException {
        ProductOperations po = new ProductOperations();
        ResultSet rset = po.searchProducts(keyword, category);
        emptyArray();
        while (rset.next()) {
            productRows.add( new ProductRow(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(6)));
        }
        rset.close();
        fireTableChanged(new TableModelEvent(this, -1, -1));
    }


    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        ProductRow row = (ProductRow)productRows.get(rowNum);//casting a product from the object arraylist to a row type
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


    public String getColumnName(int column) {
        if (columnNames[column] != null)
            return columnNames[column];
        else
            return "";
    }

    public void reset(){

    }

    public void emptyArray(){
        if (productRows.size()>0){
            for (int i = productRows.size(); i>0; i--){
                productRows.remove(i-1);
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
        return productRows.size();
    }
}

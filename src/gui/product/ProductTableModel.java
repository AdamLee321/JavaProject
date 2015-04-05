package gui.product;

import com.sun.org.apache.xpath.internal.SourceTree;
import database.operations.ProductOperations;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by DL on 04/04/2015.
 */
public class ProductTableModel extends DefaultTableModel{
    final static int prodId = 0;
    final static int prodMake = 1;
    final static int prodModel = 2;
    final static int salePrice = 3;
    final static int costPrice = 4;
    final static int quantity = 5;
    final static int prodtype = 6;

    final static String[] columnNames = {"Product ID", "Make", "Model", "Cost Price", "Sale Price", "Quantity", "Product Type"};

    private static ArrayList<Object> AdminProductRows = new ArrayList();

    public static ArrayList<Object> getList(){
        return AdminProductRows;
    }

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

    public void getAllProductsTable(){
        try{
            ResultSet rset = new ProductOperations().getAllProducts();

            while (rset.next()) {
                AdminProductRows.add(new AdminProductRow(rset.getInt(1), rset.getString(2), rset.getString(3),
                        rset.getDouble(4), rset.getDouble(5), rset.getInt(6), rset.getString(7)));
            }
            System.out.println("???");
            rset.close();
        }catch (SQLException sqlE){
            System.out.println("fuck this");
            System.out.println(sqlE.getMessage());
        }
        System.out.println("so is it here");
        fireTableChanged(new TableModelEvent(this, -1, -1));
        System.out.println("or here");
    }

    //a method just to pass in a column number and row and return that cell value
    public Object getValueAt(int rowNum, int colNum) {
        AdminProductRow row = (AdminProductRow)AdminProductRows.get(rowNum);//casting a product from the object arraylist to a row type
        switch (colNum) {
            case prodId:
                return row.getProductID();
            case prodMake:
                return row.getMake();
            case prodModel:
                return row.getModel();
            case costPrice:
                return row.getCostPrice();
            case salePrice:
                return row.getPrice();
            case quantity:
                return row.getQuantity();
            case prodtype:
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

    public void reset() {

    }

    public void emptyArray() {
        if (AdminProductRows.size() > 0) {
            for (int i = AdminProductRows.size(); i > 0; i--) {
                AdminProductRows.remove(i - 1);
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
        return AdminProductRows.size();
    }
}


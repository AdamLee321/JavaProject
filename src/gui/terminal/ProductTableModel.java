package gui.terminal;

import model.Product;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductTableModel extends AbstractTableModel{

    private final List<Product> productList;

    private final String[] columnNames = new String[]{
            "Product ID", "Make", "Model", "Price", "Quantity"
    };

    private final Class[] columnClass = new Class[] {Integer.class, String.class, String.class, Double.class, Integer.class};

    public ProductTableModel(List<Product> productList) {
        this.productList = productList;
    }


    @Override
    public String getColumnName(int column) {
        return super.getColumnName(column);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getColumnClass(columnIndex);
    }

    @Override
    public int getRowCount() {
        return productList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product pro = productList.get(rowIndex);
        switch (columnIndex){
            case 1:
                return pro.getProdId();
            case 2:
                return pro.getProdMake();
            case 3:
                return pro.getProdModel();
            case 4:
                return pro.getProdCostPrice();
            case 5:
                return pro.getprodQTY();

        }
        return null;
    }
}

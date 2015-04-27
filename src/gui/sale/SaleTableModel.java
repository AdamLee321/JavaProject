package gui.sale;/*2ndYearProject
  gui.sale
  Created by David
  13:10   01/04/2015
  Software Development 3
*/

import model.Product;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaleTableModel extends DefaultTableModel {

  final static int id = 0;
  final static int make = 1;
  final static int model = 2;
  final static int qty = 3;
  final static int price = 4;
  final static String[] columnNames = {"Product ID", "Make", "Model", "Quantity", "Price"};

  private static ArrayList<Object> saleRows = new ArrayList<>();

  public ArrayList<Object> getList(){
    return saleRows;
  }

  DefaultTableColumnModel columnModel = new DefaultTableColumnModel();

  public SaleTableModel() {
    TableColumn col;

    for (int i = 0; i < columnNames.length; i++) {
      col = new TableColumn(i);
      col.setHeaderValue(columnNames[i]);
      col.setWidth(150);
      columnModel.addColumn(col);
    }
  }

//  public void queryTableData(int id, int qty) throws SQLException {
//    ProductOperations po = new ProductOperations();
//    ResultSet rset = po.productByIDR(id);
//    while (rset.next()) {
//      saleRows.add(new SaleRow(rset.getInt(1), rset.getString(2), rset.getString(3), qty, rset.getDouble(4)));
//    }
//    rset.close();
//    fireTableChanged(new TableModelEvent(this, -1, -1));
//  }

  public void queryTableData(Product p, int qty) throws SQLException {
    saleRows.add(new SaleRow(p.getProdId(), p.getProdMake(), p.getProdModel(), qty, p.getProdSalePrice()));
    fireTableChanged(new TableModelEvent(this, -1, -1));
  }


  //a method just to pass in a column number and row and return that cell value
  public Object getValueAt(int rowNum, int colNum) {
    SaleRow row = (SaleRow)saleRows.get(rowNum);//casting a product from the object arraylist to a row type
    switch (colNum) {
      case id:
        return row.getProductCode();
      case make:
        return row.getProdMake();
      case model:
        return row.getProdModel();
      case price:
        return row.getPrice();
      case qty:
        return row.getQty();
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
    if (saleRows.size() > 0) {
      for (int i = saleRows.size(); i > 0; i--) {
        saleRows.remove(i - 1);
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
    return saleRows.size();
  }
}
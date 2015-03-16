package gui.terminal;

import database.operations.ProductOperations;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductResults extends JPanel implements ActionListener {

    private ProductOperations po;
    private JPanel productResultsPanel;
    ProductTable productTable;

    public ProductResults(ProductOperations po){
        this.po = po;
    }

    public JPanel getResults(String category, ResultSet rset) throws SQLException{
        productResultsPanel = new JPanel();

        // Changed from result set to ArrayList
        //try {
        //    while (rset.next()) {
        //      products.add(new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getDouble(5),
        //                rset.getInt(6),
        //                //rset.getBlob(7),
        //                rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10),
        //                rset.getString(11), rset.getString(12), rset.getString(13)));
         //   }
        //}catch(SQLException sqlE){
        //   System.out.println("Error in extracting results from resultSet");
        //}


        productTable = new ProductTable();
        JPanel buttonPanel = new JPanel();

        // Define our Insert Button and its functionality
        JButton insertButton = new JButton("Insert Row");
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProductTableModel model = (ProductTableModel) productTable.getModel();
                int rowNum = model.insertRow();

                productTable.scrollRectToVisible(productTable.getCellRect(rowNum, 0, true));
                productTable.setRowSelectionInterval(rowNum, rowNum);

                productTable.editCellAt(rowNum, 0);
                DefaultCellEditor cellEditor = (DefaultCellEditor) productTable.getCellEditor();
                JComponent cell = (JComponent)cellEditor.getComponent();
                cell.requestFocus();
            }
        });

        // Add the Insert Button
        buttonPanel.add(insertButton);

        // Define our Delete Button and its functionality
        JButton deleteButton = new JButton("Delete Row");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (productTable.isEditing())
                    productTable.getCellEditor().stopCellEditing();

                ProductTableModel model = (ProductTableModel)productTable.getModel();
                int rowNum = productTable.getSelectionModel().getMinSelectionIndex();
                productTable.scrollRectToVisible(productTable.getCellRect(rowNum, 0, true));
                model.deleteRow(rowNum);
                productTable.scrollRectToVisible(productTable.getCellRect(rowNum, 0, true));
            }
        });

        // Add the Delete Button
        buttonPanel.add(deleteButton);

;

        // If Window is closed, do any pending updates
        //addWindowListener(new WindowAdapter() {
          //  public void windowClosing(WindowEvent e) {
           //     if (productTable.isEditing())
           //         productTable.getCellEditor().stopCellEditing();
            //    if (EmpDatabaseModifier.hasTableUpdates())
            //        //EmpDatabaseModifier.doTableUpdates(ConnectionDB.getConn());
            //        System.exit(0);
           // }//
       // });


        // Add Button and Scrollareas to the main canvas
        productResultsPanel.setLayout(new BorderLayout());
        productResultsPanel.add(productTable, BorderLayout.CENTER);
        productResultsPanel.add(buttonPanel, BorderLayout.SOUTH);
        productResultsPanel.setBackground(new Color(98, 169, 221));


        //          Just for testing that the products have been added to the ArrayList
        //          for (Product x : products)
        //          System.out.println(x.getProdId());

        return productResultsPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

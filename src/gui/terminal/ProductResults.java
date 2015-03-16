package gui.terminal;

import database.operations.ProductOperations;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.List;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductResults extends JFrame implements ActionListener {

    private ProductOperations po;
    private JPanel productResultsPanel;
    private JTable resultsTable;
    private JScrollPane tableScroll;
    private JLabel tableLabel;
    private List<Product> products;

    public ProductResults(ProductOperations po){
        this.po = po;
    }

    public JPanel getResults(String category, ResultSet rset) throws SQLException{
        products = new ArrayList<Product>();
        productResultsPanel = new JPanel();

        // Changed from result set to ArrayList
        try {
            while (rset.next()) {
                products.add(new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getDouble(5),
                        rset.getInt(6),
                        //rset.getBlob(7),
                        rset.getString(7), rset.getString(8), rset.getString(9), rset.getString(10),
                        rset.getString(11), rset.getString(12), rset.getString(13)));
            }
        }catch(SQLException sqlE){
           System.out.println("Error in extracting results from resultSet");
        }


        productTable productTable = new productTable();


        //tableScroll = new JScrollPane();
        //tableScroll.add(resultsTable);

        productResultsPanel.setBackground(new Color(98, 169, 221));
        productResultsPanel.add(productTable);

        //          Just for testing that the products have been added to the ArrayList
        //          for (Product x : products)
        //          System.out.println(x.getProdId());

        return productResultsPanel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

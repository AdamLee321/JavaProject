package gui;

import database.operations.ProductOperations;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductSearch implements ActionListener{
    private Connection conn;
    private ResultSet rset;
    private ProductOperations po;

    private MainFrame mf;
    private JPanel jp;
    private JLabel textboxLabel, categoryLabel;
    private JTextField searchText;
    private JComboBox category;
    private JButton searchButton;

    public ProductSearch(MainFrame mf, Connection conn, ProductOperations po){
        this.mf = mf;
        this.conn = conn;
        this.po = po;
    }


    public JPanel getSearch(){
        jp = new JPanel(new GridBagLayout());
        jp.setBackground(new Color(98, 169, 221));

        textboxLabel = new JLabel("Enter Search Query");
        textboxLabel.setFont(new java.awt.Font("Calibri", Font.BOLD, 18));

        searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(300,20));


        categoryLabel = new JLabel("Category");
        categoryLabel.setFont(new java.awt.Font("Calibri", Font.BOLD, 18));

        String[] categoryTypes = {"All", "Desktops", "Laptops", "Apple", "All-In-One"};
        category = new JComboBox(categoryTypes);
        category.setSelectedIndex(0);

        searchButton = new JButton("Search", new ImageIcon("src/res/images/UI Elements/search16.png"));
        searchButton.addActionListener(this);

        jp.add(textboxLabel, getConstraints(0,0,2,1, GridBagConstraints.CENTER, 0,0,10,0));
        jp.add(searchText, getConstraints(0,1,2,1, GridBagConstraints.CENTER, 0,0,20,0));
        jp.add(categoryLabel, getConstraints(0,2,1,1, GridBagConstraints.CENTER, 0,0,20,0));
        jp.add(category, getConstraints(1,2,1,1, GridBagConstraints.LAST_LINE_END, 0,0,20,0));
        jp.add(searchButton, getConstraints(0,3,2,1, GridBagConstraints.CENTER, 0,0,0,0));




        return jp;
    }

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int anchor,
                                              int nIns, int wIns, int sIns, int eIns)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(nIns, wIns, sIns, eIns);
        c.ipadx = 10;
        c.ipady = 10;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = anchor;
        return c;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchButton)) {
            System.out.println("Search1");
            String categoryName = (String) category.getSelectedItem();

            rset = po.searchProducts(searchText.getText(), categoryName);
            mf.setCenterToProductResults(categoryName, rset);
        }

    }
}

package gui.product;

import database.operations.ProductOperations;
import gui.terminal.MainFrame;

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
    private ProductOperations po;

    private MainFrame mf;
    private JPanel jp;
    private JLabel textboxLabel, categoryLabel;
    private JTextField searchText;
    private JComboBox category;
    private JButton searchButton;

    public ProductSearch(MainFrame mf, ProductOperations po){
        this.mf = mf;
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

        jp.add(textboxLabel, MainFrame.getConstraints(0, 0, 2, 1, GridBagConstraints.CENTER, 0, 0, 10, 0));
        jp.add(searchText, MainFrame.getConstraints(0, 1, 2, 1, GridBagConstraints.CENTER, 0, 0, 20, 0));
        jp.add(categoryLabel, MainFrame.getConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, 0, 0, 20, 0));
        jp.add(category, MainFrame.getConstraints(1, 2, 1, 1, GridBagConstraints.LAST_LINE_END, 0, 0, 20, 0));
        jp.add(searchButton, MainFrame.getConstraints(0, 3, 2, 1, GridBagConstraints.CENTER, 0, 0, 0, 0));




        return jp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchButton)) {
            System.out.println("Search1");
            String categoryName = (String) category.getSelectedItem();

            ResultSet rset = po.searchProducts(searchText.getText(), categoryName);
            mf.setToProductResults(categoryName, rset);
        }

    }
}

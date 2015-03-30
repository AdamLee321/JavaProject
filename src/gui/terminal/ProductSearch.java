package gui.terminal;

import gui.Griddy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductSearch implements ActionListener{



    private JPanel jp;
    private JLabel textboxLabel, categoryLabel;
    private JTextField searchText;
    private JComboBox category;
    private JButton searchButton;

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

        //jp.add(textboxLabel, TerminalMode.getConstraints(0, 0, 2, 1, GridBagConstraints.CENTER, 0, 0, 10, 0));
        jp.add(textboxLabel, Griddy.getConstraints(0,0,2,1,10,10,0,0,0,0,0,10,0,GridBagConstraints.CENTER));

        //jp.add(searchText, TerminalMode.getConstraints(0, 1, 2, 1, GridBagConstraints.CENTER, 0, 0, 20, 0));
        jp.add(searchText, Griddy.getConstraints(0,1,2,1,10,10,0,0,0,0,0,20,0,GridBagConstraints.CENTER));

        //jp.add(categoryLabel, TerminalMode.getConstraints(0, 2, 1, 1, GridBagConstraints.CENTER, 0, 0, 20, 0));
        jp.add(categoryLabel, Griddy.getConstraints(0,2,1,1,10,10,0,0,0,0,0,20,0,GridBagConstraints.CENTER));

        //jp.add(category, TerminalMode.getConstraints(1, 2, 1, 1, GridBagConstraints.LAST_LINE_END, 0, 0, 20, 0));
        jp.add(category, Griddy.getConstraints(1,2,1,1,10,10,0,0,0,0,0,20,0,GridBagConstraints.LAST_LINE_END));


        //jp.add(searchButton, TerminalMode.getConstraints(0, 3, 2, 1, GridBagConstraints.CENTER, 0, 0, 0, 0));
        jp.add(searchButton, Griddy.getConstraints(0,3,2,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.CENTER));




        return jp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchButton)) {
            System.out.println("Search1");
            String categoryName = (String) category.getSelectedItem();

            TerminalMode.mf.setToProductResults(categoryName, searchText.getText(), 2);
        }

    }

}

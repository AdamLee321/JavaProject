package gui.terminal;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

import gui.Griddy;
import gui.UIElements;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductSearch implements ActionListener{

    private JPanel jp;
    private JLabel textboxLabel, categoryLabel;
    private JTextField searchText;
    private JComboBox category;
    private JButton searchButton;

    public JPanel getSearch(){
        jp = new JPanel(new GridBagLayout());
        jp.setBackground(UIElements.getColour());

        textboxLabel = new JLabel("Enter Search Query");
        textboxLabel.setFont(new Font("Calibri", Font.BOLD, 18));

        searchText = new JTextField();
        searchText.setPreferredSize(new Dimension(300,20));

        categoryLabel = new JLabel("Category");
        categoryLabel.setFont(new Font("Calibri", Font.BOLD, 18));

        String[] categoryTypes = {"All", "Desktops", "Laptops", "Apple", "All-In-One"};
        category = new JComboBox(categoryTypes);
        category.setSelectedIndex(0);

        searchButton = new JButton("Search", new ImageIcon(UIElements.search16));
        searchButton.addActionListener(this);

        jp.add(textboxLabel, Griddy.getConstraints(0,0,2,1,10,10,0,0,0,0,0,10,0,GridBagConstraints.CENTER));
        jp.add(searchText, Griddy.getConstraints(0,1,2,1,10,10,0,0,0,0,0,20,0,GridBagConstraints.CENTER));
        jp.add(categoryLabel, Griddy.getConstraints(0,2,1,1,10,10,0,0,0,0,0,20,0,GridBagConstraints.CENTER));
        jp.add(category, Griddy.getConstraints(1,2,1,1,10,10,0,0,0,0,0,20,0,GridBagConstraints.LAST_LINE_END));
        jp.add(searchButton, Griddy.getConstraints(0,3,2,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.CENTER));

        return jp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(searchButton)) {
            String categoryName = (String) category.getSelectedItem();
            TerminalMode.mf.setToProductResults(categoryName, searchText.getText(), 2);
        }
    }
}

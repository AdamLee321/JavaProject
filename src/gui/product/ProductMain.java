package gui.product;

import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class ProductMain implements ActionListener, MouseListener {

    private JPanel prodMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewButton;
    private JTextField searchField;
    private JComboBox prodTypes, brandTypes, modelTypes;
    private JPanel managePanel, northPanel, southPanel, searchPanel, searchTopPanel, searchBottomPanel;

    private String[] prodTypess = {"All", "Sales", "Management"};  // this just a placeholder, real info will be populated from DB
    private String[] brandTypess = {"All", "DELL", "HP", "Apple"};  // this just a placeholder, real info will be populated from DB
    private String[] modelTypess = {"All", "Inpiron 5150", "Latitude 1350"};  // this just a placeholder, real info will be populated from DB

    private String textFieldTip = "type your search query...";

    private AdminMain am;

    public JPanel getProductMain(){

    // setup the frame

        prodMain = new JPanel(new BorderLayout());
        //prodMain.getContentPane().setBackground(new Color(98, 169, 221));

// north panel

        northPanel = new JPanel(new GridBagLayout());
        //northPanel.setBackground(new Color(98, 169, 221));

    // manage products panel

        managePanel = new JPanel(new FlowLayout());
        //managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Products")); // set anonymous titled, etched border

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 28));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.addActionListener(this);
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 28));
        editButton.setIcon(new ImageIcon(UIElements.edit16));
        editButton.addActionListener(this);
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 28));
        deleteButton.setIcon(new ImageIcon(UIElements.delete16));
        deleteButton.addActionListener(this);
        managePanel.add(deleteButton);

        northPanel.add(managePanel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

    // search products panel

        searchPanel = new JPanel(new BorderLayout());
        //searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Products")); // set anonymous titled, etched border

        // top panel containing the search field and search button
        searchTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //searchTopPanel.setBackground(new Color(98, 169, 221));
        searchField = new JTextField(29);
        searchField.setText(textFieldTip); // set initial text field search
        searchField.setForeground(Color.GRAY); // set initial colour to gray
        searchField.addMouseListener(this);
        searchTopPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(105, 28));
        searchButton.setIcon(new ImageIcon(UIElements.search16));
        searchTopPanel.add(searchButton);

        // add top panel to search panel
        searchPanel.add(searchTopPanel, BorderLayout.NORTH);

        // buttom panel containing comboboxes for information filtering
        searchBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //searchBottomPanel.setBackground(new Color(98, 169, 221));
        prodTypes = new JComboBox(new DefaultComboBoxModel<String>(prodTypess));
        brandTypes = new JComboBox(new DefaultComboBoxModel<String>(brandTypess));
        modelTypes = new JComboBox(new DefaultComboBoxModel<String>(modelTypess));

        // add bottom panel to search panel
        searchBottomPanel.add(prodTypes);
        searchBottomPanel.add(brandTypes);
        searchBottomPanel.add(modelTypes);

        searchPanel.add(searchBottomPanel, BorderLayout.SOUTH);

        // add all the above to northPanel
        northPanel.add(searchPanel, Griddy.getConstraints(1,0,1,2,0,0,0,0,5,0,0,5,0,GridBagConstraints.CENTER));

        // add the above to the northPanel
        prodMain.add(northPanel, BorderLayout.NORTH);

    // results panel
/////////////////////////////////////////////////////////////////////////////////////

// south panel

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(UIElements.getColour());

        // bottom buttons
        viewButton = new JButton("View Product");
        viewButton.setPreferredSize(new Dimension(150, 28));
        viewButton.setIcon(new ImageIcon(UIElements.product16));
        southPanel.add(viewButton);
        viewButton.addActionListener(this);

        prodMain.add(southPanel, BorderLayout.SOUTH);

        // turns the lights on
        return prodMain;
    }

// BUTTON ACTIONS

    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(searchField)){
            if (searchField.getText().equals(textFieldTip)) {
                searchField.setText("");
                searchField.setForeground(null); // reset colour to black
            }
            searchField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {}
                @Override
                public void focusLost(FocusEvent e) { // set the textFieldTip to be visible in text field on focus loss
                    if (searchField.getText().equals("")){
                        searchField.setText(textFieldTip);
                        searchField.setForeground(Color.GRAY);
                    }
                }
            });
        }
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){
            ProductAddEdit pae = new ProductAddEdit(am,0);
        } // edit product
        else if (e.getSource().equals(editButton)){
            ProductAddEdit pae = new ProductAddEdit(am,1);
        }
        else if (e.getSource().equals(deleteButton)){

        }
        else if (e.getSource().equals(viewButton)){
            ProductView pv = new ProductView(am);
        }
    }
}
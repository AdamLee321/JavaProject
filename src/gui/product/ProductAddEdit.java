package gui.product;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 17/03/2015)
*/

import gui.Griddy;
import gui.UIElements;
import gui.admin.AdminMain;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductAddEdit implements ActionListener {

    private JDialog prodAdd;
    private JButton addButton, removeButton, cancelButton, okButton;
    private JLabel imgLabel, idLabel, makeLabel, modelLabel, salePriceLabel, costPriceLabel, descLabel, qtyLabel, typeLabel, cpuLabel, ramLabel, osLabel, storageLabel, screenLabel;
    private JTextField idTF, makeTF, modelTF, salePriceTF, costPriceTF, qtyTF, typeTF, cpuTF, ramTF, osTF, storageTF, screenTF;
    private JTextArea descTA;
    private JPanel centerPanel, centerLeftPanel, centerRightPanel, southPanel;

    private AdminMain am;  // used for JDialogs as parent

    public ProductAddEdit(JFrame parent, int choice){

        // setup the jdialog
        prodAdd = new JDialog(parent, true);
        prodAdd.setTitle("Add New Product");
        prodAdd.setLayout(new BorderLayout());
        prodAdd.setSize(790, 410);
        prodAdd.setResizable(true);
        prodAdd.setLocationRelativeTo(null);

// CENTER PANEL

        centerPanel = new JPanel(new GridBagLayout()); // flow by default
        centerPanel.setBackground(new Color(98, 169, 221));

    // CENTER LEFT PANEL - Product Picture

        centerLeftPanel = new JPanel(new GridBagLayout());
        centerLeftPanel.setBackground(new Color(98, 169, 221));
        centerLeftPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Product Picture", 2, 2)); // set anonymous titled, etched border, centered title

        imgLabel = new JLabel(new ImageIcon(UIElements.product128));
        centerLeftPanel.add(imgLabel, Griddy.getConstraints(0,0,3,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        addButton = new JButton("Add");
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.setPreferredSize(new Dimension(100, 26));
        centerLeftPanel.add(addButton, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        removeButton = new JButton("Remove");
        removeButton.setIcon(new ImageIcon(UIElements.minus16));
        removeButton.setPreferredSize(new Dimension(100, 26));
        centerLeftPanel.add(removeButton, Griddy.getConstraints(2,1,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        centerPanel.add(centerLeftPanel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

    // CENTER RIGHT PANEL - Product Details

        centerRightPanel = new JPanel(new GridBagLayout());
        centerRightPanel.setBackground(new Color(98, 169, 221));
        centerRightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Product Details", 2, 2)); // set anonymous titled, etched border, centered title

        // id
        idLabel = new JLabel("ID");
        centerRightPanel.add(idLabel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        idTF = new JTextField(15);
        centerRightPanel.add(idTF, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // make
        makeLabel = new JLabel("Make");
        centerRightPanel.add(makeLabel, Griddy.getConstraints(0,1,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        makeTF = new JTextField(15);
        centerRightPanel.add(makeTF, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // model
        modelLabel = new JLabel("Model");
        centerRightPanel.add(modelLabel, Griddy.getConstraints(0,2,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        modelTF = new JTextField(15);
        centerRightPanel.add(modelTF, Griddy.getConstraints(1,2,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // type
        typeLabel = new JLabel("Type");
        centerRightPanel.add(typeLabel, Griddy.getConstraints(2,5,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        typeTF = new JTextField(15);
        centerRightPanel.add(typeTF, Griddy.getConstraints(3,5,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // cpu
        cpuLabel = new JLabel("Processor");
        centerRightPanel.add(cpuLabel, Griddy.getConstraints(2,4,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        cpuTF = new JTextField(15);
        centerRightPanel.add(cpuTF, Griddy.getConstraints(3,4,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // ram
        ramLabel = new JLabel("RAM");
        centerRightPanel.add(ramLabel, Griddy.getConstraints(2,3,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        ramTF = new JTextField(15);
        centerRightPanel.add(ramTF, Griddy.getConstraints(3,3,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // storage
        storageLabel = new JLabel("Storage");
        centerRightPanel.add(storageLabel, Griddy.getConstraints(2,2,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        storageTF = new JTextField(15);
        centerRightPanel.add(storageTF, Griddy.getConstraints(3,2,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // screen
        screenLabel = new JLabel("Screen");
        centerRightPanel.add(screenLabel, Griddy.getConstraints(2,1,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        screenTF = new JTextField(15);
        centerRightPanel.add(screenTF, Griddy.getConstraints(3,1,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // os
        osLabel = new JLabel("OS");
        centerRightPanel.add(osLabel, Griddy.getConstraints(2,0,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        osTF = new JTextField(15);
        centerRightPanel.add(osTF, Griddy.getConstraints(3,0,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // cost price
        costPriceLabel = new JLabel("Cost Price");
        centerRightPanel.add(costPriceLabel, Griddy.getConstraints(0,3,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        costPriceTF = new JTextField(15);
        centerRightPanel.add(costPriceTF, Griddy.getConstraints(1,3,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // sale price
        salePriceLabel = new JLabel("Sale Price");
        centerRightPanel.add(salePriceLabel, Griddy.getConstraints(0,4,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        salePriceTF = new JTextField(15);
        centerRightPanel.add(salePriceTF, Griddy.getConstraints(1,4,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // quantity
        qtyLabel = new JLabel("Quantity");
        centerRightPanel.add(qtyLabel, Griddy.getConstraints(0,5,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        qtyTF = new JTextField(15);
        centerRightPanel.add(qtyTF, Griddy.getConstraints(1,5,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        // description
        descLabel = new JLabel("Description");
        centerRightPanel.add(descLabel, Griddy.getConstraints(0,12,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.WEST));
        descTA = new JTextArea();
        descTA.setPreferredSize(new Dimension(200,112));
        descTA.setLineWrap(true);
        centerRightPanel.add(descTA, Griddy.getConstraints(1,12,4,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        centerPanel.add(centerRightPanel, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        prodAdd.add(centerPanel, BorderLayout.CENTER);

// SOUTH PANEL

        southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        southPanel.setBackground(new Color(98, 169, 221));

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 26));
        cancelButton.setIcon(new ImageIcon(UIElements.cancel6));
        cancelButton.addActionListener(this);
        southPanel.add(cancelButton);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 26));
        okButton.setIcon(new ImageIcon(UIElements.save16));
        okButton.addActionListener(this);
        southPanel.add(okButton);

        prodAdd.add(southPanel, BorderLayout.SOUTH);

        // choice - add(clean fields) or edit(populate fields (1))
        if (choice == 1) {
            costPriceTF.setText("200");
            modelTF.setText("Inspiron");
        }

        // turns the lights on

        prodAdd.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addButton)){

        }
        else if (e.getSource().equals(removeButton)){

        }
        else if (e.getSource().equals(cancelButton)){
            prodAdd.dispose();
        }
        else if (e.getSource().equals(okButton)){

        }
    }
}
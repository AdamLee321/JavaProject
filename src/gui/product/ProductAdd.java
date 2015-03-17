package gui.product;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 17/03/2015)
*/

import gui.admin.AdminMain;

import javax.swing.*;
import java.awt.*;

public class ProductAdd {

    private JDialog prodAdd;
    private JPanel centerLeftPanel, centerRightPanel, southPanel;

    public ProductAdd(JFrame parent){

        // setup the jdialog
        prodAdd = new JDialog(parent, true);
        prodAdd.setTitle("Add New Product");
        prodAdd.setLayout(new BorderLayout());
        prodAdd.setSize(450, 670);
        prodAdd.setResizable(true);
        prodAdd.setLocationRelativeTo(null);

        prodAdd.setVisible(true);
    }

    // return GridBagConstraints for GridBagLayout

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int weightxIn, int leftHorInsetIn, int rightHorInsetIn, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, leftHorInsetIn, 5, rightHorInsetIn);  // horInsets are parameters to control individual indents of components
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.weightx = weightxIn;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = anchor;
        return c;
    }
}
package gui.terminal;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import database.operations.ProductOperations;
import gui.Griddy;
import gui.UIElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ProductCategories implements ActionListener {

    ResultSet rset;
    ProductOperations po;

    JPanel categoriesPanel;
    JButton desktops, laptops, apple, allInOne;

    public ProductCategories(ProductOperations po){
        this.po = po;
    }

    public JPanel getCategories(){
        categoriesPanel = new JPanel(new GridBagLayout());
        categoriesPanel.setBackground(UIElements.getColour());

        desktops = new JButton("Desktops", new ImageIcon("src/res/images/Product Categories/desktop100.png"));
        desktops.setVerticalTextPosition(SwingConstants.BOTTOM);
        desktops.setHorizontalTextPosition(SwingConstants.CENTER);
        desktops.addActionListener(this);

        laptops = new JButton("Laptops", new ImageIcon("src/res/images/Product Categories/Laptop100.png"));
        laptops.setVerticalTextPosition(SwingConstants.BOTTOM);
        laptops.setHorizontalTextPosition(SwingConstants.CENTER);
        laptops.addActionListener(this);

        apple = new JButton("Apple", new ImageIcon("src/res/images/Product Categories/iMac100.png"));
        apple.setVerticalTextPosition(SwingConstants.BOTTOM);
        apple.setHorizontalTextPosition(SwingConstants.CENTER);
        apple.addActionListener(this);

        allInOne = new JButton("All-In-One", new ImageIcon("src/res/images/Product Categories/AIOComputer100.png"));
        allInOne.setVerticalTextPosition(SwingConstants.BOTTOM);
        allInOne.setHorizontalTextPosition(SwingConstants.CENTER);
        allInOne.addActionListener(this);

        //categoriesPanel.add(desktops, TerminalMode.getConstraints(0, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(desktops, Griddy.getConstraints(0,0,1,1,10,10,0,0,0,25,25,0,0,GridBagConstraints.CENTER));
        //categoriesPanel.add(laptops, TerminalMode.getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(laptops, Griddy.getConstraints(1,0,1,1,10,10,0,0,0,25,25,0,0,GridBagConstraints.CENTER));
        //categoriesPanel.add(apple, TerminalMode.getConstraints(2, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(apple, Griddy.getConstraints(2,0,1,1,10,10,0,0,0,25,25,0,0,GridBagConstraints.CENTER));
        //categoriesPanel.add(allInOne, TerminalMode.getConstraints(3, 0, 1, 1, GridBagConstraints.CENTER, 0, 25, 0, 25));
        categoriesPanel.add(allInOne, Griddy.getConstraints(3,0,1,1,10,10,0,0,0,25,25,0,0,GridBagConstraints.CENTER));

        return categoriesPanel;


    }


    @Override
    public void actionPerformed(ActionEvent e){
        String category = "";
        if(e.getSource().equals(desktops)){
            category = desktops.getText();
        }
        else if(e.getSource().equals(laptops)){
            category = laptops.getText();
        }
        else if(e.getSource().equals(apple)){
            category = apple.getText();
        }
        else if(e.getSource().equals(allInOne)){
            category = allInOne.getText();
        };
        TerminalMode.mf.setToProductResults(category);

    }
}

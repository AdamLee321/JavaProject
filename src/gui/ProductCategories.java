package gui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ProductCategories implements ActionListener {
    JPanel categoriesPanel;
    JButton desktops, laptops, apple, allInOne;


    public JPanel getCategories(){
        categoriesPanel = new JPanel(new GridBagLayout());
        categoriesPanel.setBackground(new Color(98, 169, 221));

        desktops = new JButton("Desktops", new ImageIcon("src/res/images/Product Categories/desktop100.png"));
        desktops.setVerticalTextPosition(SwingConstants.BOTTOM);
        desktops.setHorizontalTextPosition(SwingConstants.CENTER);

        laptops = new JButton("Laptops", new ImageIcon("src/res/images/Product Categories/Laptop100.png"));
        laptops.setVerticalTextPosition(SwingConstants.BOTTOM);
        laptops.setHorizontalTextPosition(SwingConstants.CENTER);

        apple = new JButton("Apple", new ImageIcon("src/res/images/Product Categories/iMac100.png"));
        apple.setVerticalTextPosition(SwingConstants.BOTTOM);
        apple.setHorizontalTextPosition(SwingConstants.CENTER);

        allInOne = new JButton("All-In-One", new ImageIcon("src/res/images/Product Categories/AIOComputer100.png"));
        allInOne.setVerticalTextPosition(SwingConstants.BOTTOM);
        allInOne.setHorizontalTextPosition(SwingConstants.CENTER);

        categoriesPanel.add(desktops, getConstraints(0,0,1,1, GridBagConstraints.CENTER, 0,20,0,20));
        categoriesPanel.add(laptops, getConstraints(1,0,1,1, GridBagConstraints.CENTER, 0,20,0,20));
        categoriesPanel.add(apple, getConstraints(2,0,1,1, GridBagConstraints.CENTER, 0,20,0,20));
        categoriesPanel.add(allInOne, getConstraints(3,0,1,1, GridBagConstraints.CENTER, 0,20,0,20));

        return categoriesPanel;


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(desktops)){

        }
        else if(e.getSource().equals(laptops)){

        }
        else if(e.getSource().equals(apple)){

        }
        else if(e.getSource().equals(allInOne)){

        }


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
}

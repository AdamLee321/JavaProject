package gui;

import database.operations.ProductOperations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DL on 08/03/2015.
 */
public class ProductResults extends JFrame implements ActionListener {

    ProductOperations po;
    JPanel jp;
    JTable jt;
    JLabel tableLabel;

    public ProductResults(ProductOperations po){
        this.po = po;
    }

    public JPanel getResults(String category){
        jp = new JPanel();
        jt = new JTable();

        jp.setBackground(new Color(98, 169, 221));

        jp.add(jt);

        return jp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

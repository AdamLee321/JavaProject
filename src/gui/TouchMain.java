package gui;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TouchMain implements ActionListener {
    JPanel browseSearchPanel;
    JButton browse, search;

    public JPanel getTouchMain(){
        browse = new JButton(new ImageIcon("src/res/images/UI Elements/product150.png"));
        search = new JButton(new ImageIcon("src/res/images/UI Elements/search150.png"));

        browseSearchPanel.add(browse);
        browseSearchPanel.add(search);

        return browseSearchPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

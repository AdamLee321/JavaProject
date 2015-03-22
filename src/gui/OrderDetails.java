package gui;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 22/03/2015)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderDetails extends JDialog implements ActionListener {

    JPanel pnlCenter, pnlSouth;
    JButton btnBack, btnPrint, btnEdit;

    public OrderDetails(){

        this.setTitle("Order");
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setSize(700,500);
        this.getContentPane().setBackground(UIElements.getColour());
        this.setLocationRelativeTo(null);

// CENTER

        pnlCenter = new JPanel();
        pnlCenter.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Order Details", 2,2)); // anonymous, etched, titled, centered
        pnlCenter.setBackground(UIElements.getColour());
        this.add(pnlCenter);

// SOUTH

        pnlSouth = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlSouth.setBorder(BorderFactory.createEtchedBorder()); // just etched border around buttons
        pnlSouth.setBackground(UIElements.getColour());

        btnBack = new JButton("Back");
        btnBack.setPreferredSize(new Dimension(100, 26));
        btnBack.setIcon(new ImageIcon(UIElements.cancel6));
        btnBack.addActionListener(this);
        pnlSouth.add(btnBack);

        btnEdit = new JButton("Edit");
        btnEdit.setPreferredSize(new Dimension(100, 26));
        btnEdit.setIcon(new ImageIcon(UIElements.edit16));
        pnlSouth.add(btnEdit);

        btnPrint = new JButton("Print");
        btnPrint.setPreferredSize(new Dimension(100, 26));
        btnPrint.setIcon(new ImageIcon(UIElements.print16));
        pnlSouth.add(btnPrint);

        this.add(pnlSouth, BorderLayout.SOUTH);

        // make the window visible
        this.setVisible(true);
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(btnBack)){
            this.dispose();
        }
    }
}

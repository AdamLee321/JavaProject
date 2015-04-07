package gui.sale;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 30/03/2015)
David
*/

import gui.FormValidator;
import gui.UIElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cash extends JDialog implements ActionListener {

    private JButton btnCancel, btnOK;
    private JLabel lblEuro;
    private JTextField tfCash;
    private JPanel main;

    SaleMain sm;

    public Cash(SaleMain sm){

// SETUP JDIALOG

        this.setTitle("Take Payment");
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(UIElements.getColour());
        this.setSize(245, 125);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setModal(true); // lock this dialog into view, don't allow clicking behind this

// MAIN PANEL

        main = new JPanel(new FlowLayout(FlowLayout.LEFT, 5,5));
        main.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Amount Tendered", 2, 2)); // set anonymous titled, etched border);
        main.setBackground(UIElements.getColour());

        lblEuro = new JLabel("€");
        main.add(lblEuro);

        tfCash = new JTextField(17);
        main.add(tfCash);

        btnCancel = new JButton("Cancel", new ImageIcon(UIElements.cancel6));
        btnCancel.setPreferredSize(new Dimension(105, 26));
        btnCancel.addActionListener(this);
        main.add(btnCancel);

        btnOK = new JButton("OK", new ImageIcon(UIElements.plus16));
        btnOK.setPreferredSize(new Dimension(105, 26));
        btnOK.addActionListener(this);
        main.add(btnOK);

        this.add(main);

        this.sm = sm;

        this.setVisible(true);
    }

    public double getAmount() {
        return Double.parseDouble(tfCash.getText());
    }

// BUTTON ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(btnCancel)){
            this.dispose();
        }
        else if (e.getSource().equals(btnOK)){
            if (FormValidator.isEmptyField(tfCash.getText()))
                JOptionPane.showMessageDialog(this, "Empty Field", "No data", JOptionPane.WARNING_MESSAGE);
            else if(!FormValidator.isNumber(tfCash.getText()))
                JOptionPane.showMessageDialog(this, "Not a valid number", "Invalid", JOptionPane.WARNING_MESSAGE);
            else if(sm.getTotal()> Double.parseDouble(tfCash.getText()))
                JOptionPane.showMessageDialog(this, "Not enough cash tendered", "Cash", JOptionPane.INFORMATION_MESSAGE);
            else {
                sm.setPaymentTypeR(tfCash.getText(), "Cash");
                this.dispose();
            }
        }
    }
}
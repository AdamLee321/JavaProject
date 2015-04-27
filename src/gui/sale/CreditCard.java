package gui.sale;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 30/03/2015)
*/

import gui.Griddy;
import gui.UIElements;
import gui.ccValidation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditCard extends JDialog implements ActionListener {

    private JPanel pnlMain, pnlSouth;
    private JLabel lblName, lblCCtype, lblCCnumber, lblSecCode, lblExpiration;
    private JTextField tfName, tfCCnumber, tfSecCode;
    private JComboBox cbYear, cbMonth;
    private JButton btnCancel, btnOK;
    private JRadioButton rbVisa, rbMaster;
    private ButtonGroup radioGroup = new ButtonGroup(); // for mutual exclusivity of radio buttons

    private String[] years = {"2016", "2017", "2018", "2019", "2020"};
    private String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

    private ccValidation ccv;
    private SaleMain sm;

    public CreditCard(SaleMain sm){ // pass in SaleMain object

// SETUP JDIALOG

        this.setTitle("Credit Card Payment");
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(UIElements.getColour());
        this.setSize(320, 280);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setModal(true); // lock this dialog into view, don't allow clicking behind this

// MAIN PANEL

        pnlMain = new JPanel(new GridBagLayout());
        pnlMain.setBackground(UIElements.getColour());
        pnlMain.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Enter Credit Card Details", 2, 2)); // set anonymous titled, etched border);

        lblName = new JLabel("Name");
        pnlMain.add(lblName, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        tfName = new JTextField();
        pnlMain.add(tfName, Griddy.getConstraints(1,0,2,1,0,0,0,0,5,5,5,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        lblCCtype = new JLabel("Credit Card Type");
        pnlMain.add(lblCCtype, Griddy.getConstraints(0,1,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        rbVisa = new JRadioButton("VISA");
        rbVisa.setBackground(UIElements.getColour());
        radioGroup.add(rbVisa);
        pnlMain.add(rbVisa, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        rbMaster = new JRadioButton("MasterCard");
        rbMaster.setBackground(UIElements.getColour());
        radioGroup.add(rbMaster);
        pnlMain.add(rbMaster, Griddy.getConstraints(2,1,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        lblCCnumber = new JLabel("Credit Card Number");
        pnlMain.add(lblCCnumber, Griddy.getConstraints(0,2,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        tfCCnumber = new JTextField();
        pnlMain.add(tfCCnumber, Griddy.getConstraints(1,2,2,1,0,0,0,0,5,5,5,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST));

        lblSecCode = new JLabel("Security Code");
        pnlMain.add(lblSecCode, Griddy.getConstraints(0,3,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        tfSecCode = new JTextField();
        pnlMain.add(tfSecCode, Griddy.getConstraints(1,3,1,1,0,0,0,0,5,5,5,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.WEST));

        lblExpiration = new JLabel("Expiration Date");
        pnlMain.add(lblExpiration, Griddy.getConstraints(0,4,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        cbMonth = new JComboBox(new DefaultComboBoxModel<>(months));
        pnlMain.add(cbMonth, Griddy.getConstraints(1,4,1,1,0,0,0,0,5,5,0,0,0,GridBagConstraints.WEST));

        cbYear = new JComboBox(new DefaultComboBoxModel<>(years));
        pnlMain.add(cbYear, Griddy.getConstraints(2,4,1,1,0,0,0,0,5,0,0,0,0,GridBagConstraints.WEST));

        this.add(pnlMain, BorderLayout.CENTER);

// SOUTH - BUTTONS

        pnlSouth = new JPanel(); // flow centered by default
        pnlSouth.setBackground(UIElements.getColour());

        btnCancel = new JButton("Cancel", new ImageIcon(UIElements.cancel6));
        btnCancel.setPreferredSize(new Dimension(100, 28));
        btnCancel.addActionListener(this);
        pnlSouth.add(btnCancel);

        btnOK = new JButton("OK", new ImageIcon(UIElements.save16));
        btnOK.setPreferredSize(new Dimension(100, 28));
        btnOK.addActionListener(this);
        pnlSouth.add(btnOK);

        this.add(pnlSouth, BorderLayout.SOUTH);

        ccv = new ccValidation(); // initialize validation object
        this.sm = sm; // initialize passed SaleMain object

        this.setVisible(true);
    }

// MAIN PANEL

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(btnCancel)){
            this.dispose();
        }
        else if(e.getSource().equals(btnOK)){
            if(rbMaster.isSelected()){
                if (ccv.isCreditCardValid(tfCCnumber.getText(), ccValidation.MASTERCARD)) {
                    sm.setPaymentTypeR("MasterCard");
                    this.dispose();
                }
                else{
                    System.out.println(ccv.isCreditCardValid(tfCCnumber.getText(), ccValidation.MASTERCARD));
                    JOptionPane.showMessageDialog(this, ccv.getMessage(), "Credit Card Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if (rbVisa.isSelected()){
                if(ccv.isCreditCardValid(tfCCnumber.getText(), ccValidation.VISA)){
                    sm.setPaymentTypeR("VISA");
                    this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(this,ccv.getMessage(),"Credit Card Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                    JOptionPane.showMessageDialog(this,"Select The Card Type","Tard Alert",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
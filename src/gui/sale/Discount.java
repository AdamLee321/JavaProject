package gui.sale;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 22/03/2015)
David
*/

import database.operations.MemberOperations;
import gui.FormValidator;
import gui.UIElements;
import model.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Discount extends JDialog implements ActionListener, MouseListener {

    private JButton btnApply, btnCancel;
    private JTextField tfPercent, tfMemberId;
    private JRadioButton rbPercent, rbMemberId;
    private ButtonGroup radioGroup = new ButtonGroup(); // for mutual exclusivity of radio buttons
    private JPanel main; // need main because can't set border on JFrame

    final double[] DISCOUNT_RATES = {2, 4, 6, 8, 10};

    SaleMain sm;

    public Discount(SaleMain sm) {

        this.sm = sm;

// SETUP JDIALOG

        this.setTitle("Discount");
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(UIElements.getColour());
        this.setSize(247, 240);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setModal(true);

// MAIN PANEL

        main = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        main.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Discount Type", 2, 2)); // set anonymous titled, etched border);
        main.setBackground(UIElements.getColour());

        rbPercent = new JRadioButton("Percent");
        rbPercent.setSelected(true);
        rbPercent.setBackground(UIElements.getColour());
        radioGroup.add(rbPercent);
        rbPercent.addActionListener(this);
        rbPercent.addMouseListener(this);
        main.add(rbPercent);

        tfPercent = new JTextField(18);
        tfPercent.addMouseListener(this);
        main.add(tfPercent);

        rbMemberId = new JRadioButton("Member ID");
        rbMemberId.setBackground(UIElements.getColour());
        radioGroup.add(rbMemberId);
        rbMemberId.addActionListener(this);
        rbMemberId.addMouseListener(this);
        main.add(rbMemberId);

        tfMemberId = new JTextField(18);
        tfMemberId.setBackground(Color.LIGHT_GRAY);
        tfMemberId.setEnabled(false);

        main.add(tfMemberId);

        btnCancel = new JButton("Cancel", new ImageIcon(UIElements.cancel6));
        btnCancel.setPreferredSize(new Dimension(100, 26));
        btnCancel.addActionListener(this);
        main.add(btnCancel);

        btnApply = new JButton("Apply", new ImageIcon(UIElements.plus16)); // initialize the search button, add a add and icon
        btnApply.setPreferredSize(new Dimension(100, 26));
        btnApply.addActionListener(this);
        main.add(btnApply);

        this.add(main);

        this.setVisible(true);
    }

// BUTTON ACTIONS

    // MOUSE
    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}

    public void mouseClicked(MouseEvent e) {
       if (e.getSource().equals(rbPercent)){
           tfPercent.setEnabled(true);
           tfPercent.setBackground(Color.WHITE);
           tfPercent.requestFocus();
           tfMemberId.setEnabled(false);
           tfMemberId.setBackground(Color.LIGHT_GRAY);
        }
        else if (e.getSource().equals(rbMemberId)){
           tfMemberId.setEnabled(true);
           tfMemberId.setBackground(Color.WHITE);
           tfMemberId.requestFocus();
           tfPercent.setEnabled(false);
           tfPercent.setBackground(Color.LIGHT_GRAY);
       }
    }

//    public void focusGained(FocusEvent e) {
//        if (e.getSource().equals(rbMemberId) || e.getSource().equals(tfMemberId)) {
//            tfPercent.setEnabled(false);
//            tfPercent.setBackground(Color.LIGHT_GRAY);
//        } else if (e.getSource().equals(rbPercent) || e.getSource().equals(tfPercent)) {
//            tfMemberId.setEnabled(false);
//            tfMemberId.setBackground(Color.LIGHT_GRAY);
//        }
//    }
//    public void focusLost(FocusEvent e){
//        if (e.getSource().equals(rbMemberId) || e.getSource().equals(tfMemberId)) {
//            tfPercent.setEnabled(true);
//            tfPercent.setBackground(Color.WHITE);
//        } else if (e.getSource().equals(rbPercent) || e.getSource().equals(tfPercent)) {
//            tfMemberId.setEnabled(true);
//            tfMemberId.setBackground(Color.white);
//        }
//    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnCancel)) {
            this.dispose();
        } else if (e.getSource().equals(btnApply)) {
            MemberOperations mo = new MemberOperations();
            if (FormValidator.isEmptyField(tfMemberId.getText()) && FormValidator.isEmptyField(tfPercent.getText()))
                JOptionPane.showMessageDialog(this, "Enter a value", "No values", JOptionPane.WARNING_MESSAGE);
            else if (rbPercent.isSelected()) {
                if (!FormValidator.isNumber(tfPercent.getText()))
                    JOptionPane.showMessageDialog(this, "Not a number", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
                else {
                    this.dispose();
                    sm.setMemberDetails(Double.parseDouble(tfPercent.getText()), "-", 0, 0);
                }
            } else if (rbMemberId.isSelected()) {
                if (!FormValidator.isNumber(tfMemberId.getText()))
                    JOptionPane.showMessageDialog(this, "Not a number", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
                else {
                    if (mo.checkMember(Integer.parseInt(tfMemberId.getText()))) {
                        Member m = mo.getMemberById(Integer.parseInt(tfMemberId.getText()));
                        int points = m.getMemberPoints();
                        double rate = 0;
                        if (points < 8)
                            rate = DISCOUNT_RATES[0];
                        else if (points < 16)
                            rate = DISCOUNT_RATES[1];
                        else if (points < 32)
                            rate = DISCOUNT_RATES[2];
                        else if (points < 64)
                            rate = DISCOUNT_RATES[3];
                        else
                            rate = DISCOUNT_RATES[4];
                        sm.setMemberDetails(rate, m.getMemberFName() + " " + m.getMemberLName(), points, m.getMemberId());
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Member does not exist", "Member", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        }
    }
}
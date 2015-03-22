package gui.sale;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 22/03/2015)
*/

import gui.Griddy;
import gui.UIElements;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleMain extends JFrame {

    JButton btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero, btnDoubleZero, btnClear, btnOK, btnRemove, btnRegister, btnDiscount, btnReturnProduct, btnCheckout, btnLogout;
    JRadioButton rbCash, rbCC;
    ButtonGroup radioGroup = new ButtonGroup(); // for mutual exclusivity of radio buttons
    JTextField tfProdNum, tfQty;
    JLabel lblSubtotal, lblVAT, lblDiscount, lblTotal, lblCustomer, lblSalesperson, lblDate, lblCashTender, lblChangeDue, lblLoggedName, lblLoggedUname, lblLoggedNumber, lblLoggedPosition;
    JLabel lblSubtotalR, lblVATR, lblDiscountR, lblTotalR, lblCustomerR, lblSalespersonR, lblDateR, lblCashTenderR, lblChangeDueR;
    JPanel pnlTable, pnlKeypad, pnlCheckout, pnlSaleInfo, pnlLoggedIn, pnlPaymentType;

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    Date date = new Date();

    public SaleMain(){

        super("DGA Sale");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(UIElements.getColour());

// KEYPAD PANEL

        pnlKeypad = new JPanel(new GridBagLayout());
        pnlKeypad.setBackground(UIElements.getColour());
        pnlKeypad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Product")); // set anonymous titled, etched border

        tfProdNum = new JTextField();
        pnlKeypad.add(tfProdNum, Griddy.getConstraints(0,0,3,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnOne = new JButton("1");
        pnlKeypad.add(btnOne, Griddy.getConstraints(0,1,1,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnTwo = new JButton("2");
        pnlKeypad.add(btnTwo, Griddy.getConstraints(1,1,1,1,0,0,1,1,2,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnThree = new JButton("3");
        pnlKeypad.add(btnThree, Griddy.getConstraints(2,1,1,1,0,0,1,1,2,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnFour = new JButton("4");
        pnlKeypad.add(btnFour, Griddy.getConstraints(0,2,1,1,0,0,1,1,0,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnFive = new JButton("5");
        pnlKeypad.add(btnFive, Griddy.getConstraints(1,2,1,1,0,0,1,1,0,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnSix = new JButton("6");
        pnlKeypad.add(btnSix, Griddy.getConstraints(2,2,1,1,0,0,1,1,0,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnSeven = new JButton("7");
        pnlKeypad.add(btnSeven, Griddy.getConstraints(0,3,1,1,0,0,1,1,0,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnEight = new JButton("8");
        pnlKeypad.add(btnEight, Griddy.getConstraints(1,3,1,1,0,0,1,1,0,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnNine = new JButton("9");
        pnlKeypad.add(btnNine, Griddy.getConstraints(2,3,1,1,0,0,1,1,0,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnDoubleZero = new JButton("00");
        pnlKeypad.add(btnDoubleZero, Griddy.getConstraints(0,4,1,1,0,0,1,1,0,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnZero = new JButton("0");
        pnlKeypad.add(btnZero, Griddy.getConstraints(1,4,1,1,0,0,1,1,0,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnClear = new JButton("C");
        pnlKeypad.add(btnClear, Griddy.getConstraints(2,4,1,1,0,0,1,1,0,0,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        tfQty = new JTextField();
        pnlKeypad.add(tfQty, Griddy.getConstraints(0,5,3,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnOK = new JButton("OK", new ImageIcon(UIElements.plus16));
        pnlKeypad.add(btnOK, Griddy.getConstraints(0,6,3,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnRemove = new JButton("Remove", new ImageIcon(UIElements.minus16));
        pnlKeypad.add(btnRemove, Griddy.getConstraints(0,7,3,1,0,0,1,1,0,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.EAST));

        this.add(pnlKeypad, Griddy.getConstraints(2,0,1,1,0,0,1,1,0,1,0,0,1,GridBagConstraints.CENTER));

// CHECKOUT PANEL (right, bottom corner)

        pnlCheckout = new JPanel(new GridBagLayout());
        pnlCheckout.setBackground(UIElements.getColour());
        pnlCheckout.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Checkout")); // set anonymous titled, etched border

        btnRegister = new JButton("Register", new ImageIcon(UIElements.person16));
        pnlCheckout.add(btnRegister, Griddy.getConstraints(0,0,1,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnDiscount = new JButton("Discount", new ImageIcon(UIElements.minus16));
        pnlCheckout.add(btnDiscount, Griddy.getConstraints(1,0,1,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnReturnProduct = new JButton("Return Product", new ImageIcon(UIElements.product16));
        pnlCheckout.add(btnReturnProduct, Griddy.getConstraints(0,1,2,1,0,0,1,1,0,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

            // PAYMENT TYPE PANEL - panel in a panel... Inception!!!
            pnlPaymentType = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlPaymentType.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Payment Type")); // set anonymous titled, etched border
            pnlPaymentType.setBackground(UIElements.getColour());

            rbCash = new JRadioButton("Cash");
            rbCash.setBackground(UIElements.getColour());
            rbCC = new JRadioButton("Credit Card");
            rbCC.setBackground(UIElements.getColour());

            radioGroup.add(rbCash);
            radioGroup.add(rbCC);

            pnlPaymentType.add(rbCash);
            pnlPaymentType.add(rbCC);

            pnlCheckout.add(pnlPaymentType, Griddy.getConstraints(0,2,2,1,0,0,0,0,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        btnCheckout = new JButton("Checkout", new ImageIcon(UIElements.save16));
        pnlCheckout.add(btnCheckout, Griddy.getConstraints(0,3,2,2,0,0,1,1,0,0,0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        this.add(pnlCheckout, Griddy.getConstraints(2,1,1,1,0,0,1,1,0,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

// SALE INFO PANEL

        pnlSaleInfo = new JPanel(new GridBagLayout());
        pnlSaleInfo.setBackground(UIElements.getColour());
        pnlSaleInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sale Info")); // set anonymous titled, etched border

        lblSubtotal = new JLabel("SubTotal");
        pnlSaleInfo.add(lblSubtotal, Griddy.getConstraints(0,0,1,1,0,0,1,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblSubtotalR = new JLabel("0");
        pnlSaleInfo.add(lblSubtotalR, Griddy.getConstraints(1,0,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblVAT = new JLabel("VAT");
        pnlSaleInfo.add(lblVAT, Griddy.getConstraints(0,1,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblVATR = new JLabel("0");
        pnlSaleInfo.add(lblVATR, Griddy.getConstraints(1,1,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblDiscount = new JLabel("Discount");
        pnlSaleInfo.add(lblDiscount, Griddy.getConstraints(0,2,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblDiscountR = new JLabel("0");
        pnlSaleInfo.add(lblDiscountR, Griddy.getConstraints(1,2,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblTotal = new JLabel("Total");
        pnlSaleInfo.add(lblTotal, Griddy.getConstraints(0,3,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblTotalR = new JLabel("0");
        pnlSaleInfo.add(lblTotalR, Griddy.getConstraints(1,3,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblCustomer = new JLabel("Customer");
        pnlSaleInfo.add(lblCustomer, Griddy.getConstraints(0,4,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblCustomerR = new JLabel("-");
        pnlSaleInfo.add(lblCustomerR, Griddy.getConstraints(1,4,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblSalesperson = new JLabel("Salesperson");
        pnlSaleInfo.add(lblSalesperson, Griddy.getConstraints(0,5,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblSalespersonR = new JLabel("-");
        pnlSaleInfo.add(lblSalespersonR, Griddy.getConstraints(1,5,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblDate = new JLabel("Date");
        pnlSaleInfo.add(lblDate, Griddy.getConstraints(0,6,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblDateR = new JLabel(dateFormat.format(date));
        pnlSaleInfo.add(lblDateR, Griddy.getConstraints(1,6,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblCashTender = new JLabel("Cash Tendered");
        pnlSaleInfo.add(lblCashTender, Griddy.getConstraints(0,7,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblCashTenderR = new JLabel("0");
        pnlSaleInfo.add(lblCashTenderR, Griddy.getConstraints(1,7,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        lblChangeDue = new JLabel("Change Due");
        pnlSaleInfo.add(lblChangeDue, Griddy.getConstraints(0,8,1,1,0,0,0,0,0,5,0,0,0,GridBagConstraints.WEST));
        lblChangeDueR = new JLabel("0");
        pnlSaleInfo.add(lblChangeDueR, Griddy.getConstraints(1,8,1,1,0,0,0,0,0,0,5,0,0,GridBagConstraints.EAST));

        this.add(pnlSaleInfo, Griddy.getConstraints(1,1,1,1,0,0,1,1,0,0,0,0,GridBagConstraints.BOTH,GridBagConstraints.EAST));

// LOGGED IN PANEL

        pnlLoggedIn = new JPanel(new GridBagLayout());
        pnlLoggedIn.setBackground(UIElements.getColour());
        pnlLoggedIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Currently Logged In")); // set anonymous titled, etched border

        btnLogout = new JButton("Log Out", new ImageIcon(UIElements.logout16));
        btnLogout.setPreferredSize(new Dimension(100,100));
        pnlLoggedIn.add(btnLogout, Griddy.getConstraints(0,0,1,4,0,0,0,0,5,5,10,5,0,GridBagConstraints.EAST));

        lblLoggedName = new JLabel("John Smith");
        pnlLoggedIn.add(lblLoggedName, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,5,10,5,0,GridBagConstraints.WEST));

        lblLoggedUname = new JLabel("j.smith1");
        pnlLoggedIn.add(lblLoggedUname, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,5,10,5,0,GridBagConstraints.WEST));

        lblLoggedNumber = new JLabel("0");
        pnlLoggedIn.add(lblLoggedNumber, Griddy.getConstraints(1,2,1,1,0,0,0,0,5,5,10,5,0,GridBagConstraints.WEST));

        lblLoggedPosition = new JLabel("Sales");
        pnlLoggedIn.add(lblLoggedPosition, Griddy.getConstraints(1,3,1,1,0,0,0,0,0,5,10,5,0,GridBagConstraints.WEST));

        this.add(pnlLoggedIn, Griddy.getConstraints(0,1,1,1,0,0,0,0,0,0,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST));




        this.setVisible(true);

    }
}

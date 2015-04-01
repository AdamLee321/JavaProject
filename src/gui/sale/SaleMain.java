package gui.sale;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 22/03/2015)
*/

import gui.FormValidator;
import gui.Griddy;
import gui.StartWindow;
import gui.UIElements;
import gui.employee.SalesView;
import gui.member.MemberAddEdit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaleMain extends JFrame implements ActionListener, MouseListener {

    private JButton btnAdd, btnRemove, btnRegister, btnDiscount, btnReturnProduct, btnCheckout, btnLogout;
    private JRadioButton rbCash, rbCC;
    private ButtonGroup radioGroup = new ButtonGroup(); // for mutual exclusivity of radio buttons
    private JTextField tfProdNum, tfQty;
    private JLabel lblSubtotal, lblVAT, lblDiscount, lblTotal, lblCustomer, lblSalesperson, lblDate, lblPaymentType, lblChangeDue, lblLoggedName, lblLoggedUname, lblLoggedNumber, lblLoggedPosition;
    private JLabel lblSubtotalR, lblVATR, lblDiscountR, lblTotalR, lblCustomerR, lblSalespersonR, lblDateR, lblPaymentTypeR, lblChangeDueR;
    private JPanel pnlBasket, pnlKeypad, pnlCheckout, pnlSaleInfo, pnlLoggedIn, pnlPaymentType;

    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
    private Date date = new Date();

    private String prodFieldTip = "product number...";
    private String qtyFieldTip = "quantity...";

    public SaleMain(){

        super("DGA Sale");
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(UIElements.getColour());

// ADD PRODUCT PANEL

        pnlKeypad = new JPanel(new GridBagLayout());
        pnlKeypad.setBackground(UIElements.getColour());
        pnlKeypad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Product")); // set anonymous titled, etched border

        tfProdNum = new JTextField();
        tfProdNum.setText(prodFieldTip); // set initial text field search
        tfProdNum.setForeground(Color.GRAY); // set initial colour to gray
        tfProdNum.addMouseListener(this);
        pnlKeypad.add(tfProdNum, Griddy.getConstraints(0,0,3,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        tfQty = new JTextField();
        tfQty.setText(qtyFieldTip); // set initial text field search
        tfQty.setForeground(Color.GRAY); // set initial colour to gray
        tfQty.addMouseListener(this);
        pnlKeypad.add(tfQty, Griddy.getConstraints(0,1,3,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnAdd = new JButton("Add", new ImageIcon(UIElements.plus16));
        btnAdd.addActionListener(this);
        pnlKeypad.add(btnAdd, Griddy.getConstraints(0,2,1,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnRemove = new JButton("Remove", new ImageIcon(UIElements.minus16));
        btnRemove.addActionListener(this);
        pnlKeypad.add(btnRemove, Griddy.getConstraints(1,2,1,1,0,0,0,0,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.EAST));

        this.add(pnlKeypad, Griddy.getConstraints(1,0,1,1,0,0,1,1,0,1,0,0,1,GridBagConstraints.CENTER));

// CHECKOUT PANEL (right, bottom corner)

        pnlCheckout = new JPanel(new GridBagLayout());
        pnlCheckout.setBackground(UIElements.getColour());
        pnlCheckout.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Checkout")); // set anonymous titled, etched border

        btnRegister = new JButton("Register", new ImageIcon(UIElements.person16));
        btnRegister.addActionListener(this);
        pnlCheckout.add(btnRegister, Griddy.getConstraints(0,0,1,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnDiscount = new JButton("Discount", new ImageIcon(UIElements.minus16));
        btnDiscount.addActionListener(this);
        pnlCheckout.add(btnDiscount, Griddy.getConstraints(1,0,1,1,0,0,1,1,2,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        btnReturnProduct = new JButton("Return Product", new ImageIcon(UIElements.product16));
        btnReturnProduct.addActionListener(this);
        pnlCheckout.add(btnReturnProduct, Griddy.getConstraints(0,1,2,1,0,0,1,1,0,2,2,2,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

            // PAYMENT TYPE PANEL - panel in a panel... Inception!!!
            pnlPaymentType = new JPanel(new FlowLayout(FlowLayout.CENTER));
            pnlPaymentType.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Payment Type")); // set anonymous titled, etched border
            pnlPaymentType.setBackground(UIElements.getColour());

            rbCash = new JRadioButton("Cash");
            rbCash.setBackground(UIElements.getColour());
            rbCash.addActionListener(this);
            rbCC = new JRadioButton("Credit Card");
            rbCC.setBackground(UIElements.getColour());
            rbCC.addActionListener(this);

            radioGroup.add(rbCash);
            radioGroup.add(rbCC);

            pnlPaymentType.add(rbCash);
            pnlPaymentType.add(rbCC);

            pnlCheckout.add(pnlPaymentType, Griddy.getConstraints(0,2,2,1,0,0,0,0,0,0,0,0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        btnCheckout = new JButton("Checkout", new ImageIcon(UIElements.save16));
        btnCheckout.addActionListener(this);
        pnlCheckout.add(btnCheckout, Griddy.getConstraints(0,3,2,2,0,0,1,1,0,0,0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

        this.add(pnlCheckout, Griddy.getConstraints(1,1,1,1,0,0,1,1,0,1,0,0,GridBagConstraints.BOTH,GridBagConstraints.CENTER));

// LOGGED IN PANEL

        pnlLoggedIn = new JPanel(new GridBagLayout());
        pnlLoggedIn.setBackground(UIElements.getColour());
        pnlLoggedIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Currently Logged In")); // set anonymous titled, etched border

        lblLoggedName = new JLabel("John Smith");
        pnlLoggedIn.add(lblLoggedName, Griddy.getConstraints(0,0,1,1,0,0,1,0,5,5,5,5,0,GridBagConstraints.WEST));

        lblLoggedUname = new JLabel("j.smith1");
        pnlLoggedIn.add(lblLoggedUname, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.EAST));

        lblLoggedNumber = new JLabel("0");
        pnlLoggedIn.add(lblLoggedNumber, Griddy.getConstraints(0,1,1,1,0,0,0,0,5,5,5,5,0,GridBagConstraints.WEST));

        lblLoggedPosition = new JLabel("Sales");
        pnlLoggedIn.add(lblLoggedPosition, Griddy.getConstraints(1,1,1,1,0,0,0,0,0,5,5,5,0,GridBagConstraints.EAST));

        btnLogout = new JButton("Log Out", new ImageIcon(UIElements.logout16));
        btnLogout.addActionListener(this);
        pnlLoggedIn.add(btnLogout, Griddy.getConstraints(0, 2, 2, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER));

        this.add(pnlLoggedIn, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.WEST));

// SALE INFO PANEL

        pnlSaleInfo = new JPanel(new GridBagLayout());
        pnlSaleInfo.setBackground(UIElements.getColour());
        pnlSaleInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sale Info")); // set anonymous titled, etched border

        lblSubtotal = new JLabel("SubTotal");
        pnlSaleInfo.add(lblSubtotal, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 1, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblSubtotalR = new JLabel("-");
        pnlSaleInfo.add(lblSubtotalR, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblVAT = new JLabel("VAT");
        pnlSaleInfo.add(lblVAT, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblVATR = new JLabel("-");
        pnlSaleInfo.add(lblVATR, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblDiscount = new JLabel("Discount");
        pnlSaleInfo.add(lblDiscount, Griddy.getConstraints(0, 2, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblDiscountR = new JLabel("-");
        pnlSaleInfo.add(lblDiscountR, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblTotal = new JLabel("Total");
        pnlSaleInfo.add(lblTotal, Griddy.getConstraints(0, 3, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblTotalR = new JLabel("-");
        pnlSaleInfo.add(lblTotalR, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblCustomer = new JLabel("Customer");
        pnlSaleInfo.add(lblCustomer, Griddy.getConstraints(0, 4, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblCustomerR = new JLabel("-");
        pnlSaleInfo.add(lblCustomerR, Griddy.getConstraints(1, 4, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblSalesperson = new JLabel("Salesperson");
        pnlSaleInfo.add(lblSalesperson, Griddy.getConstraints(0, 5, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblSalespersonR = new JLabel(lblLoggedName.getText());
        pnlSaleInfo.add(lblSalespersonR, Griddy.getConstraints(1, 5, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblDate = new JLabel("Date");
        pnlSaleInfo.add(lblDate, Griddy.getConstraints(0, 6, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblDateR = new JLabel(dateFormat.format(date));
        pnlSaleInfo.add(lblDateR, Griddy.getConstraints(1, 6, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblPaymentType = new JLabel("Payment");
        pnlSaleInfo.add(lblPaymentType, Griddy.getConstraints(0, 7, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblPaymentTypeR = new JLabel("-");
        pnlSaleInfo.add(lblPaymentTypeR, Griddy.getConstraints(1, 7, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblChangeDue = new JLabel("Change Due");
        pnlSaleInfo.add(lblChangeDue, Griddy.getConstraints(0, 8, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblChangeDueR = new JLabel("-");
        pnlSaleInfo.add(lblChangeDueR, Griddy.getConstraints(1, 8, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        this.add(pnlSaleInfo, Griddy.getConstraints(1,2,1,1,0,0,1,1,0,0,0,0,GridBagConstraints.BOTH,GridBagConstraints.EAST));


// BASKET PANEL

        pnlBasket = new JPanel();
        pnlBasket.setBackground(UIElements.getColour());
        pnlBasket.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Basket")); // set anonymous titled, etched border
        this.add(pnlBasket, Griddy.getConstraints(0,0,1,4,0,0,0,0,0,0,0,0,GridBagConstraints.BOTH,GridBagConstraints.WEST));

        this.setVisible(true);
    }

// METHODS - SETTERS

    // set payment type
    public void setPaymentTypeR(String approved){
        lblPaymentTypeR.setText(approved);
    }

    // set discount %
    public void setDiscountR(String discount){
        lblDiscountR.setText(discount);
    }


// BUTTON ACTIONS - don't forget to add action listeners to buttons and implement ActionListener class

    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(tfProdNum)) {
            if (tfProdNum.getText().equals(prodFieldTip)) { // if the product field textfield is populated with the preset text
                tfProdNum.setText(""); // empty it
                tfProdNum.setForeground(null);  // reset colour to black

                if (tfQty.getText().equals("")) {
                    tfQty.setText(prodFieldTip);
                    tfQty.setForeground(Color.GRAY);
                }
                tfProdNum.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        if (tfProdNum.getText().equals("")) {
                            tfProdNum.setText(prodFieldTip);
                            tfProdNum.setForeground(Color.GRAY);
                        }
                    }
                });
            }
            } else if (e.getSource().equals(tfQty)) {
                if (tfQty.getText().equals(qtyFieldTip)) {
                    tfQty.setText("");
                    tfQty.setForeground(null);

                    if (tfProdNum.getText().equals("")) {
                        tfProdNum.setText(prodFieldTip);
                        tfProdNum.setForeground(Color.GRAY);
                    }
                    tfQty.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                        }
                        @Override
                        public void focusLost(FocusEvent e) {
                            if (tfQty.getText().equals("")) {
                                tfQty.setText(qtyFieldTip);
                                tfQty.setForeground(Color.GRAY);
                            }
                        }
                    });
                }
            }
        }

    public void actionPerformed(ActionEvent e){
        if(e.getSource().equals(rbCash) && rbCash.isSelected()){
            Cash cashola = new Cash(this);
        }
        else if (e.getSource().equals(rbCC) && rbCC.isSelected()){
            CreditCard cc = new CreditCard(this);
        }
        else if (e.getSource().equals(btnDiscount)){
            Discount disc = new Discount(this);
        }
        else if (e.getSource().equals(btnRegister)){
            MemberAddEdit mae = new MemberAddEdit(this, 0);
        }
        else if (e.getSource().equals(btnReturnProduct)){
            SalesView sv = new SalesView();
        }
        else if (e.getSource().equals(btnAdd)){
            if(!FormValidator.isNumber(tfProdNum.getText()) || !FormValidator.isNumber(tfQty.getText())){
                JOptionPane.showMessageDialog(this,"Please Enter A Number In Both Fields","Invalid Entry",JOptionPane.WARNING_MESSAGE);
            }
        }
        else if (e.getSource().equals(btnRemove)){

        }
        else if (e.getSource().equals(btnCheckout)){

        }
        else if (e.getSource().equals(btnLogout)){
            StartWindow sw = new StartWindow();
            this.dispose();
        }
    }
}
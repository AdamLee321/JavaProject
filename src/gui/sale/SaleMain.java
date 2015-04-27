package gui.sale;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George, David - 22/03/2015)
*/

import database.operations.MemberOperations;
import database.operations.ProductOperations;
import database.operations.SaleOperations;
import database.operations.SalesDetailsOperations;
import gui.*;
import gui.member.MemberAddEdit;
import model.Employee;
import model.Product;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SaleMain extends JFrame implements ActionListener, MouseListener {

    private ProductOperations po;

    private JButton btnAdd, btnRemove, btnRegister, btnDiscount, btnVoidSale, btnCheckout, btnLogout, btnHelp;
    private JRadioButton rbCash, rbCC;
    private ButtonGroup radioGroup = new ButtonGroup(); // for mutual exclusivity of radio buttons
    private JTextField tfProdNum, tfQty;
    private JLabel lblSubtotal, lblVAT, lblDiscount, lblTotal, lblCustomer, lblSalesperson, lblDate, lblPaymentType, lblChangeDue, lblLoggedName, lblLoggedUname, lblLoggedNumber, lblLoggedPosition, lblPaymentMethod, lblPaymentMethodR;
    private JLabel lblSubtotalR, lblVATR, lblDiscountR, lblTotalR, lblCustomerR, lblSalespersonR, lblDateR, lblPaymentTypeR, lblChangeDueR;
    private JPanel pnlBasket, pnlKeypad, pnlCheckout, pnlSaleInfo, pnlLoggedIn, pnlPaymentType;

    private DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
    private Date date = new Date();

    private double total = 0;
    private double changeDue = 0;
    private double cashPaid = 0;
    private double subTotal = 0;
    private double discountApplied = 0;
    private double vat = 0;
    private String cashOrCard = "";
    final private double VAT_RATE = .21;
    private ArrayList<Product> products;
    private ArrayList<Integer> indexes;

    private String prodFieldTip = "product number...";
    private String qtyFieldTip = "quantity...";

    private JTable saleTable;
    private SaleTableModel tableModel;
    private DecimalFormat decimalFormat = new DecimalFormat("€###,###.00");
    private Employee loggedOn;
    private int memberPoints;
    private int memberid;
    private double runningTotal;
    private String loggedInTime;
    private String loggedInDate;

    public SaleMain(Employee e) {

        super("DGA Sale");
        this.setSize(1000, 710);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setMinimumSize(new Dimension(1000,710));
        this.setLayout(new GridBagLayout());
        this.getContentPane().setBackground(UIElements.getColour());
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() { // add window listener for when clicking X to close the window
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                UIPrompts.exitProgram();
            }
        });

        po = new ProductOperations();
        products = po.allProductsArray();
        indexes = new ArrayList<Integer>();

        loggedOn = e;

// ADD PRODUCT PANEL

        pnlKeypad = new JPanel(new GridBagLayout());
        pnlKeypad.setBackground(UIElements.getColour());
        pnlKeypad.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Add Product")); // set anonymous titled, etched border

        tfProdNum = new JTextField();
        tfProdNum.setText(prodFieldTip); // set initial text field search
        tfProdNum.setForeground(Color.GRAY); // set initial colour to gray
        tfProdNum.addMouseListener(this);
        pnlKeypad.add(tfProdNum, Griddy.getConstraints(0, 0, 2, 1, 0, 0, 1, 1, 2, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        tfQty = new JTextField();
        tfQty.setText(qtyFieldTip); // set initial text field search
        tfQty.setForeground(Color.GRAY); // set initial colour to gray
        tfQty.addMouseListener(this);
        pnlKeypad.add(tfQty, Griddy.getConstraints(0, 1, 2, 1, 0, 0, 1, 1, 2, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        btnAdd = new JButton("Add Item", new ImageIcon(UIElements.plus16));
        btnAdd.setToolTipText("Add item to the basket");
        btnAdd.addActionListener(this);
        pnlKeypad.add(btnAdd, Griddy.getConstraints(0, 2, 1, 1, 0, 10, 1, 1, 2, 2, 0, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        btnRemove = new JButton("Remove ", new ImageIcon(UIElements.minus16));
        btnRemove.setToolTipText("Remove item from the basket");
        btnRemove.addActionListener(this);
        pnlKeypad.add(btnRemove, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 1, 1, 2, 0, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.EAST));

        this.add(pnlKeypad, Griddy.getConstraints(1, 0, 2, 1, 0, 0, 0, 1, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

// CHECKOUT PANEL (right, bottom corner)

        pnlCheckout = new JPanel(new GridBagLayout());
        pnlCheckout.setBackground(UIElements.getColour());
        pnlCheckout.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Checkout")); // set anonymous titled, etched border

        btnRegister = new JButton("Register", new ImageIcon(UIElements.person16));
        btnRegister.setToolTipText("Register a new member");
        btnRegister.addActionListener(this);
        pnlCheckout.add(btnRegister, Griddy.getConstraints(0, 0, 1, 1, 0, 10, 1, 1, 2, 2, 0, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        btnDiscount = new JButton("Discount", new ImageIcon(UIElements.minus16));
        btnDiscount.setToolTipText("Apply a discount to the sale");
        btnDiscount.addActionListener(this);
        pnlCheckout.add(btnDiscount, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 1, 1, 2, 0, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        btnVoidSale = new JButton("Void Sale", new ImageIcon(UIElements.product16));
        btnVoidSale.setToolTipText("Clears the current sale");
        btnVoidSale.addActionListener(this);
        pnlCheckout.add(btnVoidSale, Griddy.getConstraints(0, 1, 2, 1, 0, 10, 1, 1, 0, 2, 2, 2, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        // PAYMENT TYPE PANEL - panel in a panel... Inception!!!
        pnlPaymentType = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlPaymentType.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Payment Type")); // set anonymous titled, etched border
        pnlPaymentType.setBackground(UIElements.getColour());

        rbCash = new JRadioButton("Cash");
        rbCash.setToolTipText("Pay by cash");
        rbCash.setBackground(UIElements.getColour());
        rbCash.addActionListener(this);
        rbCC = new JRadioButton("Credit Card");
        rbCC.setToolTipText("Pay by credit card");
        rbCC.setBackground(UIElements.getColour());
        rbCC.addActionListener(this);

        radioGroup.add(rbCash);
        radioGroup.add(rbCC);

        pnlPaymentType.add(rbCash);
        pnlPaymentType.add(rbCC);

        pnlCheckout.add(pnlPaymentType, Griddy.getConstraints(0, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        btnCheckout = new JButton("Checkout", new ImageIcon(UIElements.save16));
        btnCheckout.setToolTipText("Finalize the sale");
        btnCheckout.addActionListener(this);
        pnlCheckout.add(btnCheckout, Griddy.getConstraints(0, 3, 2, 2, 0, 20, 1, 1, 2, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        this.add(pnlCheckout, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

// LOGGED IN PANEL

        pnlLoggedIn = new JPanel(new GridBagLayout());
        pnlLoggedIn.setBackground(UIElements.getColour());
        pnlLoggedIn.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Currently Logged In")); // set anonymous titled, etched border

        lblLoggedName = new JLabel(loggedOn.getEmpFName() +" " + loggedOn.getEmpLName());
        pnlLoggedIn.add(lblLoggedName, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 1, 0, 10, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.WEST));

        lblLoggedUname = new JLabel(loggedOn.getEmpUsername());
        pnlLoggedIn.add(lblLoggedUname, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 0, 0, 10, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.EAST));

        lblLoggedNumber = new JLabel(Integer.toString(loggedOn.getEmpId()));
        pnlLoggedIn.add(lblLoggedNumber, Griddy.getConstraints(0, 1, 1, 1, 0, 0, 0, 0, 5, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.WEST));

        lblLoggedPosition = new JLabel(loggedOn.getPosition());
        pnlLoggedIn.add(lblLoggedPosition, Griddy.getConstraints(1, 1, 1, 1, 0, 0, 0, 0, 0, 5, 5, 5, GridBagConstraints.BOTH, GridBagConstraints.EAST));

        btnLogout = new JButton("Log Out", new ImageIcon(UIElements.logout16));
        btnLogout.addActionListener(this);
        pnlLoggedIn.add(btnLogout, Griddy.getConstraints(0, 3, 1, 1, 0, 10, 0, 0, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

        btnHelp = new JButton("", new ImageIcon(UIElements.info16));
        btnHelp.addActionListener(this);
        pnlLoggedIn.add(btnHelp, Griddy.getConstraints(1, 3, 1, 1, 0, 10, 0, 0, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.EAST));

        this.add(pnlLoggedIn, Griddy.getConstraints(1, 3, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.CENTER));

// SALE INFO PANEL

        pnlSaleInfo = new JPanel(new GridBagLayout());
        pnlSaleInfo.setBackground(UIElements.getColour());
        pnlSaleInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Sale Info")); // set anonymous titled, etched border

        lblSubtotal = new JLabel("SubTotal");
        pnlSaleInfo.add(lblSubtotal, Griddy.getConstraints(0, 0, 1, 1, 0, 0, 1, 0, 10, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblSubtotalR = new JLabel("-");
        pnlSaleInfo.add(lblSubtotalR, Griddy.getConstraints(1, 0, 1, 1, 0, 0, 0, 0, 0, 10, 5, 0, 0, GridBagConstraints.EAST));

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

        lblPaymentMethod = new JLabel("Payment Type");
        pnlSaleInfo.add(lblPaymentMethod, Griddy.getConstraints(0, 8, 1, 1, 0, 0, 0, 0, 0, 5, 0, 0, 0, GridBagConstraints.WEST));
        lblPaymentMethodR = new JLabel("-");
        pnlSaleInfo.add(lblPaymentMethodR, Griddy.getConstraints(1, 8, 1, 1, 0, 0, 0, 0, 0, 0, 5, 0, 0, GridBagConstraints.EAST));

        lblChangeDue = new JLabel("Change Due");
        pnlSaleInfo.add(lblChangeDue, Griddy.getConstraints(0, 9, 1, 1, 0, 0, 0, 0, 0, 5, 0, 10, 0, GridBagConstraints.WEST));
        lblChangeDueR = new JLabel("-");
        pnlSaleInfo.add(lblChangeDueR, Griddy.getConstraints(1, 9, 1, 1, 0, 0, 0, 0, 0, 0, 5, 10, 0, GridBagConstraints.EAST));

        this.add(pnlSaleInfo, Griddy.getConstraints(1, 2, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.EAST));


// BASKET PANEL

        tableModel = new SaleTableModel();
        saleTable = new JTable(tableModel);
        saleTable.setRowHeight(30);
        saleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // don't allow multirow selection


        // Set the table width, depending upon the width of
        // the columns
        int tableWidth = 0;
        int columnCount = tableModel.columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++)
            tableWidth += tableModel.columnModel.getColumn(i).getWidth();

        JScrollPane scrollPane = new JScrollPane(saleTable);
        scrollPane.setBorder(new BevelBorder(BevelBorder.LOWERED));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlBasket = new JPanel(new GridLayout());
        pnlBasket.setBackground(UIElements.getColour());
        pnlBasket.setPreferredSize(new Dimension(700, 500));
        pnlBasket.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Basket")); // set anonymous titled, etched border
        pnlBasket.add(scrollPane);
        this.add(pnlBasket, Griddy.getConstraints(0, 0, 1, 4, 0, 0, 5, 1, 0, 0, 0, 0, GridBagConstraints.BOTH, GridBagConstraints.WEST));

        setLoggedInTime();

        this.setVisible(true);
    }

// METHODS

    public void setLoggedInTime(){
        loggedInTime = String.valueOf(new Time(System.currentTimeMillis()));
        loggedInDate = dateFormat.format(date);
    }

    // update all the labels
    public void updateLabels(){
        lblSubtotalR.setText(decimalFormat.format(subTotal));
        lblVATR.setText(decimalFormat.format(vat));
        lblDiscountR.setText(Double.toString(discountApplied) + "%");
        lblTotalR.setText(decimalFormat.format(total));
        lblPaymentTypeR.setText(decimalFormat.format(cashPaid));
        lblChangeDueR.setText(decimalFormat.format(changeDue));
 }

    // set discount %
    public void setMemberDetails(double discount, String name, int points, int id) {
        memberid = id;
        lblCustomerR.setText(name);
        memberPoints = points;
        discountApplied = discount;
        total -= (discountApplied / 100) * total;
        updateLabels();
    }

    // set payment type
    public void setPaymentTypeR(String cashOrCard, String cash) {
        if (FormValidator.isNumber(cashOrCard)) {
            cashPaid = Double.parseDouble(cashOrCard);
            changeDue = cashPaid - total;
            lblPaymentMethodR.setText(cash);
        }
        updateLabels();
    }

    public void setPaymentTypeR(String cash) {
        cashPaid = total;
        changeDue = cashPaid - total;
        lblPaymentMethodR.setText(cash);
        updateLabels();
    }

    public void calcChangeDue(){
        changeDue = cashPaid - total;
    }



    public double getTotal(){
        return total;
    }

    public void updatePrice() {
        total = 0;
        for (int i = 0; i < tableModel.getList().size(); i++) {
            SaleRow sr = (SaleRow) tableModel.getList().get(i);
            total += sr.getPrice() * sr.getQty();
        }
        if (tableModel.getList().size() == 0) {
            total = 0;
            cashPaid = 0;
            calcChangeDue();
            discountApplied = 0;
            lblCustomerR.setText("-");
        }
        vat = total * VAT_RATE;
        subTotal = (total - vat);
        updateLabels();
    }

    public void addToBasket(int index) {
        // Get the data!
        try {
            boolean found = false;
            for (int i = 0; i < tableModel.getList().size() ; i++) {
                SaleRow s = (SaleRow) tableModel.getList().get(i);
                    if(s.getProductCode() ==  Integer.parseInt(tfProdNum.getText())){
                        s.setQty(s.getQty()+Integer.parseInt(tfQty.getText()));
                        found = true;
                        tableModel.fireTableDataChanged();
//                        resetProductFields();
                    }
                }
            if(!found) {
                tableModel.queryTableData(products.get(index), Integer.parseInt(tfQty.getText()));
                indexes.add(index);
            }
            resetProductFields();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "SQL Problem");
        }
    }

    public int searchArray(int x){
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if(products.get(i).getProdId() == x) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void refreshBasket() {
        tableModel.fireTableChanged(new TableModelEvent(tableModel, -1, -1));
    }

    public void resetProductFields(){
        tfProdNum.setText(prodFieldTip);
        tfProdNum.setForeground(Color.GRAY);
        tfQty.setText(qtyFieldTip);
        tfQty.setForeground(Color.GRAY);
    }

// BUTTON ACTIONS - don't forget to add action listeners to buttons and implement ActionListener class

    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAdd)) {
            if (!FormValidator.isNumber(tfProdNum.getText()) || !FormValidator.isNumber(tfQty.getText()))
                JOptionPane.showMessageDialog(this, "Please enter a number in both fields", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
            else {
                int index = searchArray(Integer.parseInt(tfProdNum.getText()));
                if ( index != -1) {
                    if (products.get(index).getprodQTY() >= Integer.parseInt(tfQty.getText())) {
                        products.get(index).setProdQTY(products.get(index).getprodQTY() - Integer.parseInt(tfQty.getText()));
                        addToBasket(index);
                        updatePrice();
                    }
                    else
                        JOptionPane.showMessageDialog(this, "Not enough in stock", "Quantity", JOptionPane.WARNING_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(this, "Item does not exist", "Quantity", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource().equals(btnLogout)) {
            try (BufferedWriter bf = new BufferedWriter(new FileWriter("src/res/log.txt",true))) {
                bf.append("Login\t" + loggedInTime + " " + loggedInDate + "\r\n");
                bf.append("Name:\t" + loggedOn.getEmpFName() + " " + loggedOn.getEmpLName() + "\r\n");
                bf.append("ID:\t" + loggedOn.getEmpId() + "\r\n");
                bf.append("");
                bf.append("Logout\t" + String.valueOf(new Time(System.currentTimeMillis())) + " " + dateFormat.format(new Date()) + "\r\n");
                bf.append("Sales\t" + decimalFormat.format(runningTotal) + "\r\n");
                bf.append("\r\n");
            } catch(IOException io){
                System.out.println("File not found");
            }
            new StartWindow();
            this.dispose();
        } else if (e.getSource().equals(btnRegister)) {
            new MemberAddEdit(this, 2, null, null);
        } else if (e.getSource().equals(btnVoidSale)) {
            tableModel.emptyArray();
            refreshBasket();
            updatePrice();
        } else if (e.getSource().equals(btnHelp)){
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File("src/res/SaleManual.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Cannot open file","No supported application",JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            if (tableModel.getList().size() == 0)
                JOptionPane.showMessageDialog(this, "Nothing in the basket", "Invalid Entry", JOptionPane.WARNING_MESSAGE);
            else if (e.getSource().equals(rbCash) && rbCash.isSelected())
                new Cash(this);
            else if (e.getSource().equals(rbCC) && rbCC.isSelected())
                new CreditCard(this);
            else if (e.getSource().equals(btnDiscount))
                new Discount(this);
            else if (e.getSource().equals(btnRemove)) {
                if (saleTable.getSelectedRow() == -1)
                    JOptionPane.showMessageDialog(this, "Select item to remove", "Invalid choice", JOptionPane.WARNING_MESSAGE);
                else {
                    tableModel.getList().remove(saleTable.getSelectedRow());
                    indexes.remove(saleTable.getSelectedRow());
                    refreshBasket();
                    updatePrice();
                    calcChangeDue();
                    updateLabels();
                }
            } else if (e.getSource().equals(btnCheckout)) {
                if (cashPaid < total) {
                    lblPaymentTypeR.setText(cashOrCard);
                    JOptionPane.showMessageDialog(this, "Please enter payment first", "Sales", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    new MemberOperations().updateMemberPoints(memberid, (memberPoints + 1));
                    SaleOperations so = new SaleOperations();
                    so.insertSale(loggedOn.getEmpId(), String.valueOf(dateFormat.format(date)), String.valueOf(new Time(System.currentTimeMillis())), discountApplied, total);
                    SalesDetailsOperations sd = new SalesDetailsOperations();
                    int saleId = so.getMaxId();
                    for (int i = 0; i < tableModel.getList().size(); i++) {
                        SaleRow s = (SaleRow) tableModel.getList().get(i);
                        if (memberid == 0)
                            sd.insertSalesDetails(s.getProductCode(), saleId, s.getQty());
                        else
                            sd.insertSalesDetails(s.getProductCode(), saleId, memberid, s.getQty()); // this needs to be fixed - pushes the total quantity
                        po.updateProduct(s.getProductCode(), products.get(indexes.get(i)).getprodQTY());
                    }
                    JOptionPane.showMessageDialog(this, "Sale completed!", "Sales", JOptionPane.INFORMATION_MESSAGE);
                    tableModel.emptyArray();
                    tableModel.fireTableDataChanged();
                    runningTotal += total;
                    updatePrice();
                }
            }
        }
    }
}
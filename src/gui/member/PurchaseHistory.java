package gui.member;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 22/03/2015)
*/

import gui.FormValidator;
import gui.OrderDetails;
import gui.UIElements;
import gui.admin.AdminMain;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class PurchaseHistory extends JDialog implements MouseListener, ActionListener, KeyListener {

    private JPanel pnlNorth, pnlCenter, pnlSouth;
    private JButton btnSearch, btnBack;
    private JTextField tfSearch;
    private String textFieldTip = "type in the order number...";
    PurchaseHistoryTableModel purhisModel;
    JTable purTable;
    int memberId;

    public PurchaseHistory(int memberId) {

        this.memberId = memberId;

        this.setTitle("Order History");
        this.setLayout(new BorderLayout()); // tip: border(don't indicate position), grid or gridbag layouts will stretch a component to the whole screen
        this.setSize(1000, 500);
        this.setResizable(true);
        this.setModal(true);
        this.getContentPane().setBackground(UIElements.getColour());
        this.setLocationRelativeTo(null);

// NORTH

        pnlNorth = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // center and add padding
        pnlNorth.setBorder(BorderFactory.createEtchedBorder()); // set empty etched border
        pnlNorth.setBackground(UIElements.getColour());

        tfSearch = new JTextField(30);
        tfSearch.setText(textFieldTip); // set initial text field search
        tfSearch.setForeground(Color.GRAY); // set initial colour to gray
        tfSearch.addMouseListener(this);
        tfSearch.addKeyListener(this);
        pnlNorth.add(tfSearch);

        btnSearch = new JButton("Search", new ImageIcon(UIElements.search16)); // initialize the search button, add a add and icon
        btnSearch.setPreferredSize(new Dimension(100, 28));
        btnSearch.addActionListener(this);
        pnlNorth.add(btnSearch);

        this.add(pnlNorth, BorderLayout.NORTH);

// CENTER - Tables

        purhisModel = new PurchaseHistoryTableModel();
        purTable = new JTable(purhisModel);
        purhisModel.emptyArray();
        purhisModel.getPurchaseList(memberId);
        purTable.setFillsViewportHeight(true); // fill out the height of the table
        purTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // don't allow multirow selection

        JScrollPane scroll = new JScrollPane(purTable);
        scroll.setBorder(new BevelBorder(BevelBorder.LOWERED));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pnlCenter = new JPanel(new GridLayout());
        pnlCenter.add(scroll);

        this.add(pnlCenter, BorderLayout.CENTER);

// SOUTH

        pnlSouth = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlSouth.setBorder(BorderFactory.createEtchedBorder());
        pnlSouth.setBackground(UIElements.getColour());

        btnBack = new JButton("Back", new ImageIcon(UIElements.cancel6)); // initialize the search button, add a add and icon);
        btnBack.setPreferredSize(new Dimension(100, 28));
        btnBack.addActionListener(this);
        pnlSouth.add(btnBack);

        this.add(pnlSouth, BorderLayout.SOUTH);

// turns the lights on
        this.setVisible(true);
    }

// METHODS

    // display all purchases with a passed member id
    public void displayPurchases(){
        purhisModel.emptyArray(); // clear object array (rows) so it does not keep duplicating entries to the table on every call
        purhisModel.getPurchaseList(memberId);
    }

    // search for a specific order - used for: keyboard listener and mouse listener
    public void searchOrders() {
        if (FormValidator.isNumber(tfSearch.getText()) || tfSearch.getText().equals(textFieldTip)) {

            if (tfSearch.getText().equals("")) {
                displayPurchases();
            }
            if (tfSearch.getText().equals(textFieldTip)) {
                displayPurchases();
            } else {
                purhisModel.emptyArray();
                System.out.println(memberId + " " + Integer.parseInt(tfSearch.getText()));
                purhisModel.getPurchaseList(memberId, Integer.parseInt(tfSearch.getText()));
                resetSearchField();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please use numbers only", "Invalid order number", JOptionPane.WARNING_MESSAGE);
            resetSearchField();
        }
    }

    public void resetSearchField(){
        tfSearch.setText(textFieldTip);
        tfSearch.setForeground(Color.GRAY);
    }

// BUTTON ACTIONS

    // MOUSE
    // have to implement these methods for MouseListener
    public void mouseExited(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(tfSearch)) {
            if (tfSearch.getText().equals(textFieldTip)) {
                tfSearch.setText("");
                tfSearch.setForeground(null); // reset colour to black
            }
            tfSearch.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                }

                @Override
                public void focusLost(FocusEvent e) { // set the textFieldTip to be visible in text field on focus loss
                    if (tfSearch.getText().equals("")) {
                        resetSearchField();
                    }
                }
            });
        }
    }

    // KEYBOARD
    // have to implement these methods for KeyboardListener
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e){}

    public void keyReleased(KeyEvent e){
        if (e.getSource().equals(tfSearch)){
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_ENTER) {
                searchOrders();
//                sortTables(); --- do I need this?
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBack)) {
            this.dispose();
        }
        else if (e.getSource().equals(btnSearch)){
            if (FormValidator.isNumber(tfSearch.getText()) || tfSearch.getText().equals(textFieldTip)){
                searchOrders();
                resetSearchField();
            }
        }
    }
}
package gui.member;

import database.operations.MemberOperations;
import gui.*;
import gui.admin.AdminMain;
import model.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 08/03/2015)
*/

public class MemberAddEdit implements ActionListener {

    private JDialog memberAdd;
    private JPanel picturePanel, pictureButtonsPanel, detailsPanel, buttonsPanel;
    private JLabel profilePictureLabel, memberIdLabel, memberNumberLabel, memberFNameLabel, memberLNameLabel, memberStreetLabel, memberCityLabel, memberCountyLabel, memberDOB, memberEmailLabel, memberPointsLabel;
    private JTextField memberIdField, memberFNameField, memberNumberField, memberLNameField, memberStreetField, memberCityField, memberCountyField, memberEmailField, memberPointsField;
    private JComboBox<String> birthDayCBox, birthMonthCBox, birthYearCBox;;
    private JButton addButton, removeButton, cancelButton, previewButton, okButton;
    private File fImg = new File(UIElements.person128); // create initialize a new file for database update when adding (db insert expects a file, so this is needed)
    private JFileChooser fc;
    private DateGenerator dg;
    private AdminMain am;  // used for JDialogs as parent
    private MemberOperations mo;
    private MemberMain mm;
    private Member m;
    private int choice = 0;

    public MemberAddEdit(JFrame parent, int choice, MemberMain mm, Member m){

    // setup the jdialog

        memberAdd = new JDialog(parent, true);
        memberAdd.setTitle("Add New Member");
        memberAdd.setLayout(new BorderLayout());
        memberAdd.setSize(450, 620);
        memberAdd.setResizable(false);
        memberAdd.setLocationRelativeTo(null);

    // picture panel + picture buttons  panel inside it

        picturePanel = new JPanel(new BorderLayout());
        picturePanel.setBackground(UIElements.getColour());
        picturePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Profile Picture",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        profilePictureLabel = new JLabel(new ImageIcon(UIElements.person128));
        picturePanel.add(profilePictureLabel, BorderLayout.NORTH);

        // buttons panel
        pictureButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));  // alignment, hgap, vgap
        pictureButtonsPanel.setBackground(UIElements.getColour());

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon(UIElements.plus16));
        addButton.addActionListener(this);
        pictureButtonsPanel.add(addButton);

        removeButton = new JButton("Remove");
        removeButton.setPreferredSize(new Dimension(100, 26));
        removeButton.setIcon(new ImageIcon(UIElements.minus16));
        removeButton.addActionListener(this);
        pictureButtonsPanel.add(removeButton);

        picturePanel.add(pictureButtonsPanel, BorderLayout.SOUTH);

        // add picture panel to the main JDialog
        memberAdd.add(picturePanel, BorderLayout.NORTH);

    // detailsPanel - GridBagLayout

        detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(UIElements.getColour());

//        // ID
//        memberIdLabel = new JLabel("Member ID");
//        detailsPanel.add(memberIdLabel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
//        memberIdField = new JTextField();
//        memberIdField.setEditable(false);
//        detailsPanel.add(memberIdField, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Name
        memberFNameLabel = new JLabel("Member Name");
        detailsPanel.add(memberFNameLabel, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberFNameField = new JTextField();
        detailsPanel.add(memberFNameField, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Surname
        memberLNameLabel = new JLabel("Member Surname");
        detailsPanel.add(memberLNameLabel, Griddy.getConstraints(0,1,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberLNameField = new JTextField();
        detailsPanel.add(memberLNameField, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Email
        memberEmailLabel = new JLabel("Member Email");
        detailsPanel.add(memberEmailLabel, Griddy.getConstraints(0,2,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberEmailField = new JTextField();
        detailsPanel.add(memberEmailField, Griddy.getConstraints(1,2,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Phone Number
        memberNumberLabel = new JLabel("Phone Number");
        detailsPanel.add(memberNumberLabel, Griddy.getConstraints(0,3,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberNumberField = new JTextField();
        detailsPanel.add(memberNumberField, Griddy.getConstraints(1,3,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // DOB

        dg = new DateGenerator();  // this needs DateGen class, to get correct days, months and years

        memberDOB = new JLabel("Date Of Birth");
        detailsPanel.add(memberDOB, Griddy.getConstraints(0,4,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));

        birthYearCBox = new JComboBox<String>(new DefaultComboBoxModel<String>(dg.getPastCentury()));
        // can either directly pass the parameters as displayed above, or do separately as displayed below
        // birthYearCBox = new JComboBox<String>()
        // birthYearCBox.setModel(new DefaultComboBoxModel<String>(dg.getPastCentury()));
        birthYearCBox.addActionListener(this);

        birthMonthCBox = new JComboBox<String>(new DefaultComboBoxModel<String>(dg.getMonths()));
        birthMonthCBox.setEnabled(false);
        birthMonthCBox.addActionListener(this);

        birthDayCBox = new JComboBox<String>(dg.getMonthDays(birthMonthCBox.getSelectedIndex() + 1, Integer.parseInt(birthYearCBox.getSelectedItem().toString())));
        birthDayCBox.setEnabled(false);

            // add day, month, year comboboxes to details panel
        detailsPanel.add(birthYearCBox, Griddy.getConstraints(1,4,1,1,0,0,0,0,5,125,140,5,0,GridBagConstraints.WEST));
        detailsPanel.add(birthMonthCBox, Griddy.getConstraints(1,4,1,1,0,0,0,0,5,65,200,5,0,GridBagConstraints.WEST));
        detailsPanel.add(birthDayCBox, Griddy.getConstraints(1,4,1,1,0,0,0,0,5,15,260,5,0,GridBagConstraints.WEST));

        // Street
        memberStreetLabel = new JLabel("Member Street");
        detailsPanel.add(memberStreetLabel, Griddy.getConstraints(0,5,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberStreetField = new JTextField();
        detailsPanel.add(memberStreetField, Griddy.getConstraints(1,5,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // City
        memberCityLabel = new JLabel("Member City");
        detailsPanel.add(memberCityLabel, Griddy.getConstraints(0,6,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberCityField = new JTextField();
        detailsPanel.add(memberCityField, Griddy.getConstraints(1,6,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // County
        memberCountyLabel = new JLabel("Member County");
        detailsPanel.add(memberCountyLabel, Griddy.getConstraints(0,7,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberCountyField = new JTextField();
        detailsPanel.add(memberCountyField, Griddy.getConstraints(1,7,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Points
        memberPointsLabel = new JLabel("Member Points");
        detailsPanel.add(memberPointsLabel, Griddy.getConstraints(0,8,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        memberPointsField = new JTextField();
        detailsPanel.add(memberPointsField, Griddy.getConstraints(1,8,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        memberAdd.add(detailsPanel, BorderLayout.CENTER);

    // bottom, buttons panel - FlowLayout, added to main's South border

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  // layout, horizontal padding, vertical padding
        buttonsPanel.setBackground(UIElements.getColour());

        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 26));
        cancelButton.setIcon(new ImageIcon(UIElements.cancel6));
        cancelButton.addActionListener(this);
        buttonsPanel.add(cancelButton);

        previewButton = new JButton("Preview");
        previewButton.setPreferredSize(new Dimension(100, 26));
        previewButton.setIcon(new ImageIcon(UIElements.person16));
        previewButton.addActionListener(this);
        buttonsPanel.add(previewButton);

        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(100, 26));
        okButton.setIcon(new ImageIcon(UIElements.save16));
        okButton.addActionListener(this);
        buttonsPanel.add(okButton);

        memberAdd.add(buttonsPanel, BorderLayout.SOUTH);

        this.mm = mm; // pass MemberMain to refresh the list but button click
        this.m = m; // pass Member object from Member to set details
        this.choice = choice; // declared a class variable and initialized for reuse with buttons (edit/add decision)

        // choice - add(clean fields) or edit(populate fields (1))
        if (choice == 1) {

            birthDayCBox.setEnabled(true);
            birthMonthCBox.setEnabled(true);

            try {
                profilePictureLabel.setIcon(new ImageIcon(DataProcessor.fitImageByte(m.getMemberPic(), 128, 128)));
                fImg = DataProcessor.byteToFile(m.getMemberPic(), fImg);
            } catch (IOException e){
                JOptionPane.showMessageDialog(memberAdd,"Image Problem");
            }
            memberFNameField.setText(m.getMemberFName());
            memberLNameField.setText(m.getMemberLName());
            memberEmailField.setText(m.getMemberEmail());
            memberNumberField.setText(m.getMemberNumber());
            birthYearCBox.setSelectedItem(m.getDoby());
            birthMonthCBox.setSelectedItem(m.getDobm());
            birthDayCBox.setSelectedItem(m.getDobd());
            memberStreetField.setText(m.getMemberStreet());
            memberCityField.setText(m.getMemberCity());
            memberCountyField.setText(m.getMemberCounty());
            memberPointsField.setText(Integer.toString(m.getMemberPoints()));
        }

// turns the lights on

        memberAdd.setVisible(true);
    }

// METHODS

    public File getfImg() {
        return fImg;
    }

    public void setfImg(File fImg) {
        this.fImg = fImg;
    }

    // BUTTION ACTIONS

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == birthYearCBox){
            birthDayCBox.setModel(new DefaultComboBoxModel<String>(dg.getMonthDays(birthMonthCBox.getSelectedIndex() + 1, Integer.parseInt(birthYearCBox.getSelectedItem().toString()))));
            birthMonthCBox.setEnabled(true);
        }
        else if(e.getSource() == birthMonthCBox){
            birthDayCBox.setModel(new DefaultComboBoxModel<String>(dg.getMonthDays(birthMonthCBox.getSelectedIndex() + 1, Integer.parseInt(birthYearCBox.getSelectedItem().toString()))));
            birthDayCBox.setEnabled(true);
        }
        else if(e.getSource() == cancelButton){
            memberAdd.dispose();
        }
        else if(e.getSource() == previewButton){
            MemberPreview mp = new MemberPreview(am);
        }
        else if(e.getSource() == addButton){
            fc = new JFileChooser(); // initialize the JFileChooser - Initializing on button action because if initialized in the constructor, it slows down the UI response to the button
            fc.setFileFilter(DataProcessor.imageFilter); // set image filter on JFileChooser
            fc.setPreferredSize(new Dimension(600, 400)); // JFileChooser size
            fc.setMultiSelectionEnabled(false); // don't allow multifile selection
            fc.setDialogTitle("Select Employee Image"); // title
            fc.setAcceptAllFileFilterUsed(false); // turn off viewing of all files
            int open = fc.showOpenDialog(memberAdd); // could've done "this" if I was extending the JDialog
            if (open == JFileChooser.APPROVE_OPTION) {  // if JFileChooser is open (int 1)
                fImg = fc.getSelectedFile();
                try{
                    profilePictureLabel.setIcon(new ImageIcon(DataProcessor.fitImageFile(fImg, 128, 128)));
                } catch (IOException ip){
                    JOptionPane.showMessageDialog(null, "Image Problem");
                }
            }
        }
        else if(e.getSource() == removeButton){
            profilePictureLabel.setIcon(new ImageIcon(UIElements.person128));
        }
        else if(e.getSource() == okButton){
            if (!FormValidator.isNumber(memberFNameField.getText())
             && !FormValidator.isNumber(memberLNameField.getText())
             && !FormValidator.isNumber(memberCityField.getText())
             && FormValidator.isValidEmail(memberEmailField.getText())
             && FormValidator.isNumber(memberPointsField.getText())
             && birthDayCBox.isEnabled()
             && birthMonthCBox.isEnabled()){
                if(choice == 0) { // if all the above validation is OK, and the choice is 0, add a new member
                    // initialize member ops, add a new member(pass all the paramemters), display message
                    mo = new MemberOperations();
                    mo.addMember(memberFNameField.getText(), memberLNameField.getText(), memberStreetField.getText(), memberCityField.getText(), memberCountyField.getText(), birthDayCBox.getSelectedIndex() + 1, birthMonthCBox.getItemAt(birthMonthCBox.getSelectedIndex()), birthYearCBox.getItemAt(birthYearCBox.getSelectedIndex()), memberEmailField.getText(), Integer.parseInt(memberNumberField.getText()), Integer.parseInt(memberPointsField.getText()), fImg);
                    JOptionPane.showMessageDialog(null, "New Member Added", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // refresh the MemberMain list after adding a new member
                    mm.displayMembers();
                    // close window
                    memberAdd.dispose();
                }
                else if (choice == 1){ // if all the above validation is OK, and the choice is 1, update existing member
                    // initialize member ops, add a new member(pass all the paramemters), display message
                    mo = new MemberOperations();
                    mo.updateMember(m.getMemberId(), memberFNameField.getText(), memberLNameField.getText(), memberStreetField.getText(), memberCityField.getText(), memberCountyField.getText(), birthDayCBox.getSelectedIndex() + 1, birthMonthCBox.getItemAt(birthMonthCBox.getSelectedIndex()), birthYearCBox.getItemAt(birthYearCBox.getSelectedIndex()), memberEmailField.getText(), Integer.parseInt(memberNumberField.getText()), Integer.parseInt(memberPointsField.getText()), fImg);
//                    if (memberPointsField.revalidate());
                    JOptionPane.showMessageDialog(null, "Member Information Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // refresh the MemberMain list after adding a new member
                    mm.displayMembers();
                    // close window
                    memberAdd.dispose();
                }
            }
            else {
                if (FormValidator.isEmptyField(memberFNameField.getText())
                 || FormValidator.isEmptyField(memberLNameField.getText())
                 || FormValidator.isEmptyField(memberStreetField.getText())
                 || FormValidator.isEmptyField(memberCityField.getText())
                 || FormValidator.isEmptyField(memberCountyField.getText())
                 || FormValidator.isEmptyField(memberPointsField.getText())) {
                    JOptionPane.showMessageDialog(null, "Please Fill-In All Fields Of The Form", "Empty Fields", JOptionPane.WARNING_MESSAGE);
                }
                else if (!FormValidator.isValidEmail(memberEmailField.getText())){
                    JOptionPane.showMessageDialog(null,"Please Enter A Valid Email Address","Invalid Email",JOptionPane.WARNING_MESSAGE);
                }
                else if(!birthDayCBox.isEnabled() || !birthMonthCBox.isEnabled()){
                    JOptionPane.showMessageDialog(null, "Please Pick The Full Date", "Date Invalid", JOptionPane.WARNING_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please Enter Valid Data For Each Field","Invalid Data",JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
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
    private JPanel pnlPicture, pnlPictureButtons, pnlDetails, pnlButtons;
    private JLabel lblProfilePicture, lblMemberId, lblMemberNumber, lblMemberFName, lblMemberLName, lblMemberStreet, lblMemberCity, lblMemberCounty, lblMemberDOB, lblMemberEmail, lblMemberPoints;
    private JTextField tfMemberId, tfMemberFName, tfMemberNumber, tfMemberLName, tfMemberStreet, tfMemberCity, tfMemberCounty, tfMemberEmail, tfMemberPoints;
    private JComboBox<String> cbBirthDay, cbBirthMonth, cbBirthYear;
    private JButton btnAdd, btnRemove, btnCancel, btnPreview, btnOK;
    private File fImg = new File(UIElements.person128); // create initialize a new file for database update when adding (db insert expects a file, so this is needed)
    private JFileChooser fc;
    private DateGenerator dg;
    private AdminMain am;  // used for JDialogs as parent
    private MemberOperations mo;
    private MemberMain mm;
    private Member m;
    private int choice = 0;
    private int dayBefore;


    public MemberAddEdit(JFrame parent, int choice, MemberMain mm, Member m){

        // initializing all the passed parameters
        this.mm = mm; // pass MemberMain to refresh the list but button click
        this.m = m; // pass Member object from Member to set details
        this.choice = choice; // declared a class variable and initialized for reuse with buttons (edit/add decision)
        mo = new MemberOperations();

        // setup the jdialog

        memberAdd = new JDialog(parent, true);
        memberAdd.setTitle("Add New Member");
        memberAdd.setLayout(new BorderLayout());
        memberAdd.setSize(450, 680);
        memberAdd.setResizable(false);
        memberAdd.setLocationRelativeTo(null);

    // picture panel + picture buttons  panel inside it

        pnlPicture = new JPanel(new BorderLayout());
        pnlPicture.setBackground(UIElements.getColour());
        pnlPicture.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Profile Picture",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        lblProfilePicture = new JLabel(new ImageIcon(UIElements.person128));
        pnlPicture.add(lblProfilePicture, BorderLayout.NORTH);

        // buttons panel
        pnlPictureButtons = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));  // alignment, hgap, vgap
        pnlPictureButtons.setBackground(UIElements.getColour());

        btnAdd = new JButton("Add");
        btnAdd.setPreferredSize(new Dimension(100, 28));
        btnAdd.setIcon(new ImageIcon(UIElements.plus16));
        btnAdd.addActionListener(this);
        pnlPictureButtons.add(btnAdd);

        btnRemove = new JButton("Remove");
        btnRemove.setPreferredSize(new Dimension(100, 28));
        btnRemove.setIcon(new ImageIcon(UIElements.minus16));
        btnRemove.addActionListener(this);
        pnlPictureButtons.add(btnRemove);

        pnlPicture.add(pnlPictureButtons, BorderLayout.SOUTH);

        // add picture panel to the main JDialog
        memberAdd.add(pnlPicture, BorderLayout.NORTH);

    // pnlDetails - GridBagLayout

        pnlDetails = new JPanel(new GridBagLayout());
        pnlDetails.setBackground(UIElements.getColour());

        // ID
        lblMemberId = new JLabel("Member ID");
        pnlDetails.add(lblMemberId, Griddy.getConstraints(0,0,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberId = new JTextField();
        tfMemberId.setEditable(false);
        tfMemberId.setText(Integer.toString(mo.getNextId()));
        tfMemberId.setBackground(Color.LIGHT_GRAY);
        pnlDetails.add(tfMemberId, Griddy.getConstraints(1,0,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Name
        lblMemberFName = new JLabel("Member Name");
        pnlDetails.add(lblMemberFName, Griddy.getConstraints(0,1,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberFName = new JTextField();
        pnlDetails.add(tfMemberFName, Griddy.getConstraints(1,1,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Surname
        lblMemberLName = new JLabel("Member Surname");
        pnlDetails.add(lblMemberLName, Griddy.getConstraints(0,2,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberLName = new JTextField();
        pnlDetails.add(tfMemberLName, Griddy.getConstraints(1,2,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Email
        lblMemberEmail = new JLabel("Member Email");
        pnlDetails.add(lblMemberEmail, Griddy.getConstraints(0,3,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberEmail = new JTextField();
        pnlDetails.add(tfMemberEmail, Griddy.getConstraints(1,3,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Phone Number
        lblMemberNumber = new JLabel("Phone Number");
        pnlDetails.add(lblMemberNumber, Griddy.getConstraints(0,4,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberNumber = new JTextField();
        pnlDetails.add(tfMemberNumber, Griddy.getConstraints(1,4,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // DOB

        dg = new DateGenerator();  // this needs DateGen class, to get correct days, months and years

        lblMemberDOB = new JLabel("Date Of Birth");
        pnlDetails.add(lblMemberDOB, Griddy.getConstraints(0,5,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));

        cbBirthYear = new JComboBox<String>(new DefaultComboBoxModel<String>(dg.getPastCentury()));
        // can either directly pass the parameters as displayed above, or do separately as displayed below
        // cbBirthYear = new JComboBox<String>()
        // cbBirthYear.setModel(new DefaultComboBoxModel<String>(dg.getPastCentury()));
        cbBirthYear.addActionListener(this);

        cbBirthMonth = new JComboBox<String>(new DefaultComboBoxModel<String>(dg.getMonths()));
        cbBirthMonth.setEnabled(false);
        cbBirthMonth.addActionListener(this);

        cbBirthDay = new JComboBox<String>(dg.getMonthDays(cbBirthMonth.getSelectedIndex() + 1, Integer.parseInt(cbBirthYear.getSelectedItem().toString())));
        cbBirthDay.setEnabled(false);

            // add day, month, year comboboxes to details panel
        pnlDetails.add(cbBirthYear, Griddy.getConstraints(1,5,1,1,0,0,0,0,5,125,140,5,0,GridBagConstraints.WEST));
        pnlDetails.add(cbBirthMonth, Griddy.getConstraints(1,5,1,1,0,0,0,0,5,65,200,5,0,GridBagConstraints.WEST));
        pnlDetails.add(cbBirthDay, Griddy.getConstraints(1,5,1,1,0,0,0,0,5,15,260,5,0,GridBagConstraints.WEST));

        // Street
        lblMemberStreet = new JLabel("Member Street");
        pnlDetails.add(lblMemberStreet, Griddy.getConstraints(0,6,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberStreet = new JTextField();
        pnlDetails.add(tfMemberStreet, Griddy.getConstraints(1,6,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // City
        lblMemberCity = new JLabel("Member City");
        pnlDetails.add(lblMemberCity, Griddy.getConstraints(0,7,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberCity = new JTextField();
        pnlDetails.add(tfMemberCity, Griddy.getConstraints(1,7,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // County
        lblMemberCounty = new JLabel("Member County");
        pnlDetails.add(lblMemberCounty, Griddy.getConstraints(0,8,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberCounty = new JTextField();
        pnlDetails.add(tfMemberCounty, Griddy.getConstraints(1,8,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        // Points
        lblMemberPoints = new JLabel("Member Points");
        pnlDetails.add(lblMemberPoints, Griddy.getConstraints(0,9,1,1,0,0,0,0,5,15,5,5,0,GridBagConstraints.WEST));
        tfMemberPoints = new JTextField();
        pnlDetails.add(tfMemberPoints, Griddy.getConstraints(1,9,1,1,0,0,0,0,5,15,15,5,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER));

        memberAdd.add(pnlDetails, BorderLayout.CENTER);

    // bottom, buttons panel - FlowLayout, added to main's South border

        pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));  // layout, horizontal padding, vertical padding
        pnlButtons.setBackground(UIElements.getColour());

        btnCancel = new JButton("Cancel");
        btnCancel.setPreferredSize(new Dimension(100, 28));
        btnCancel.setIcon(new ImageIcon(UIElements.cancel6));
        btnCancel.addActionListener(this);
        pnlButtons.add(btnCancel);

//        btnPreview = new JButton("Preview");
//        btnPreview.setPreferredSize(new Dimension(100, 26));
//        btnPreview.setIcon(new ImageIcon(UIElements.person16));
//        btnPreview.addActionListener(this);
//        pnlButtons.add(btnPreview);

        btnOK = new JButton("OK");
        btnOK.setPreferredSize(new Dimension(100, 28));
        btnOK.setIcon(new ImageIcon(UIElements.save16));
        btnOK.addActionListener(this);
        pnlButtons.add(btnOK);

        memberAdd.add(pnlButtons, BorderLayout.SOUTH);

        // choice - add(clean fields) or edit(populate fields (1))
        if (choice == 1) {

            cbBirthDay.setEnabled(true);
            cbBirthMonth.setEnabled(true);

            try {
                lblProfilePicture.setIcon(new ImageIcon(DataProcessor.fitImageByte(m.getMemberPic(), 128, 128)));
                fImg = DataProcessor.byteToFile(m.getMemberPic());
            } catch (IOException e){
                JOptionPane.showMessageDialog(memberAdd,"Image Problem");
            }
            tfMemberId.setText(Integer.toString(m.getMemberId()));
            tfMemberFName.setText(m.getMemberFName());
            tfMemberLName.setText(m.getMemberLName());
            tfMemberEmail.setText(m.getMemberEmail());
            tfMemberNumber.setText(m.getMemberNumber());
            cbBirthYear.setSelectedItem(m.getDoby());
            cbBirthMonth.setSelectedItem(m.getDobm());
            cbBirthDay.setSelectedItem(m.getDobd());
            tfMemberStreet.setText(m.getMemberStreet());
            tfMemberCity.setText(m.getMemberCity());
            tfMemberCounty.setText(m.getMemberCounty());
            tfMemberPoints.setText(Integer.toString(m.getMemberPoints()));
        }

// turns the lights on

        memberAdd.setVisible(true);
    }

// METHODS

   public boolean noChanges() {
       return (tfMemberFName.getText().equals(m.getMemberFName())
               && tfMemberLName.getText().equals(m.getMemberLName())
               && tfMemberEmail.getText().equals(m.getMemberEmail())
               && tfMemberNumber.getText().equals(m.getMemberNumber())
               && cbBirthDay.getSelectedItem().equals(m.getDobd())
               && cbBirthMonth.getSelectedItem().equals(m.getDobm())
               && cbBirthYear.getSelectedItem().equals(m.getDoby())
               && tfMemberStreet.getText().equals(m.getMemberStreet())
               && tfMemberCity.getText().equals(m.getMemberCity())
               && tfMemberCounty.getText().equals(m.getMemberCounty())
               && tfMemberPoints.getText().equals(Integer.toString(m.getMemberPoints()))
               && FormValidator.isSameImage(m.getMemberPic(),fImg));
   }

    // BUTTION ACTIONS

    public void actionPerformed(ActionEvent e){ // the two methods below set the correct day, based on year and month, both month and year comboboxes set correct days. "dayBefore" is to remember what day was set before and set it again, otherwise it resets to 1 ... ex, Person A, birthday 4th, this way when selecting month,year, it stays at 4th, without beforeDay, day combobox would reset to 1
        if (e.getSource() == cbBirthYear){
            dayBefore = cbBirthDay.getSelectedIndex();
            cbBirthDay.setModel(new DefaultComboBoxModel<String>(dg.getMonthDays(cbBirthMonth.getSelectedIndex() + 1, Integer.parseInt(cbBirthYear.getSelectedItem().toString()))));
            cbBirthDay.setSelectedIndex(dayBefore);
            cbBirthMonth.setEnabled(true);
        }
        else if(e.getSource() == cbBirthMonth){
            dayBefore = cbBirthDay.getSelectedIndex();
            cbBirthDay.setModel(new DefaultComboBoxModel<String>(dg.getMonthDays(cbBirthMonth.getSelectedIndex() + 1, Integer.parseInt(cbBirthYear.getSelectedItem().toString()))));
            cbBirthDay.setSelectedIndex(dayBefore);
            cbBirthDay.setEnabled(true);
        }
        else if(e.getSource() == btnCancel){
            memberAdd.dispose();
        }
//        else if(e.getSource() == btnPreview){
//            MemberPreview mp = new MemberPreview(am);
//        }
        else if(e.getSource() == btnAdd){
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
                    lblProfilePicture.setIcon(new ImageIcon(DataProcessor.fitImageFile(fImg, 128, 128)));
                } catch (IOException ip){
                    JOptionPane.showMessageDialog(null, "Image Problem");
                }
            }
        }
        else if(e.getSource() == btnRemove){
            lblProfilePicture.setIcon(new ImageIcon(UIElements.person128));
        }
        else if(e.getSource() == btnOK){
            if (!FormValidator.isNumber(tfMemberFName.getText())
             && !FormValidator.isNumber(tfMemberLName.getText())
             && !FormValidator.isNumber(tfMemberCity.getText())
             && FormValidator.isValidEmail(tfMemberEmail.getText())
             && FormValidator.isNumber(tfMemberPoints.getText())
             && FormValidator.isNumber(tfMemberNumber.getText())
             && cbBirthDay.isEnabled()
             && cbBirthMonth.isEnabled()){
                if(choice == 0) { // if all the above validation is OK, and the choice is 0, add a new member
                    // initialize member ops, add a new member(pass all the paramemters), display message
                    mo = new MemberOperations();
                    mo.addMember(tfMemberFName.getText(), tfMemberLName.getText(), tfMemberStreet.getText(), tfMemberCity.getText(), tfMemberCounty.getText(), cbBirthDay.getSelectedIndex() + 1, cbBirthMonth.getItemAt(cbBirthMonth.getSelectedIndex()), cbBirthYear.getItemAt(cbBirthYear.getSelectedIndex()), tfMemberEmail.getText(), Integer.parseInt(tfMemberNumber.getText()), Integer.parseInt(tfMemberPoints.getText()), fImg);
                    JOptionPane.showMessageDialog(null, "New Member Added", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // refresh the MemberMain list after adding a new member
                    mm.displayMembers();
                    // close window
                    memberAdd.dispose();
                }
                else if (choice == 1){ // if all the above validation is OK, and the choice is 1, update existing member
                    System.out.println(FormValidator.isSameImage(m.getMemberPic(),fImg));

                    // initialize member ops, add a new member(pass all the paramemters), display message
                    if (noChanges()){ // if there were no changes just close the window
                        memberAdd.dispose();
                    } else{ // if something changed then prompt and update the info
                        mo = new MemberOperations();
                        mo.updateMember(m.getMemberId(), tfMemberFName.getText(), tfMemberLName.getText(), tfMemberStreet.getText(), tfMemberCity.getText(), tfMemberCounty.getText(), cbBirthDay.getSelectedIndex() + 1, cbBirthMonth.getItemAt(cbBirthMonth.getSelectedIndex()), cbBirthYear.getItemAt(cbBirthYear.getSelectedIndex()), tfMemberEmail.getText(), Integer.parseInt(tfMemberNumber.getText()), Integer.parseInt(tfMemberPoints.getText()), fImg);
                        JOptionPane.showMessageDialog(null, "Member Information Updated", "Information", JOptionPane.INFORMATION_MESSAGE);
                        // refresh the MemberMain list after adding a new member and sort it properly
                        mm.displayMembers();
                        mm.alignTables();
                        // sort tables, close window
                        memberAdd.dispose();
                    }
                }
                else if (choice == 2){
                    // initialize member ops, add a new member(pass all the paramemters), display message
                    mo = new MemberOperations();
                    mo.addMember(tfMemberFName.getText(), tfMemberLName.getText(), tfMemberStreet.getText(), tfMemberCity.getText(), tfMemberCounty.getText(), cbBirthDay.getSelectedIndex() + 1, cbBirthMonth.getItemAt(cbBirthMonth.getSelectedIndex()), cbBirthYear.getItemAt(cbBirthYear.getSelectedIndex()), tfMemberEmail.getText(), Integer.parseInt(tfMemberNumber.getText()), Integer.parseInt(tfMemberPoints.getText()), fImg);
                    JOptionPane.showMessageDialog(null, "New Member Added", "Information", JOptionPane.INFORMATION_MESSAGE);
                    // sort tables, close window
                    mm.alignTables();
                    memberAdd.dispose();
                }
                else if (choice == 3){
                    // initialize member ops, add a new member(pass all the paramemters), display message
                    mo = new MemberOperations();
                    mo.addMember(tfMemberFName.getText(), tfMemberLName.getText(), tfMemberStreet.getText(), tfMemberCity.getText(), tfMemberCounty.getText(), cbBirthDay.getSelectedIndex() + 1, cbBirthMonth.getItemAt(cbBirthMonth.getSelectedIndex()), cbBirthYear.getItemAt(cbBirthYear.getSelectedIndex()), tfMemberEmail.getText(), Integer.parseInt(tfMemberNumber.getText()), Integer.parseInt(tfMemberPoints.getText()), fImg);
                    JOptionPane.showMessageDialog(null, "New Member Added", "Information", JOptionPane.INFORMATION_MESSAGE);
                    memberAdd.dispose();
                }
            }
            else {
                if (FormValidator.isEmptyField(tfMemberFName.getText())
                 || FormValidator.isEmptyField(tfMemberLName.getText())
                 || FormValidator.isEmptyField(tfMemberStreet.getText())
                 || FormValidator.isEmptyField(tfMemberCity.getText())
                 || FormValidator.isEmptyField(tfMemberCounty.getText())
                 || FormValidator.isEmptyField(tfMemberPoints.getText())) {
                    JOptionPane.showMessageDialog(null, "Please fill-in all the fields of the form", "Empty fields", JOptionPane.WARNING_MESSAGE);
                }
                else if (!FormValidator.isValidEmail(tfMemberEmail.getText())){
                    JOptionPane.showMessageDialog(null,"Please enter a valid email address","Invalid email",JOptionPane.WARNING_MESSAGE);
                }
                else if(!cbBirthDay.isEnabled() || !cbBirthMonth.isEnabled()){
                    JOptionPane.showMessageDialog(null, "Please pick a full date", "Invalid data", JOptionPane.WARNING_MESSAGE);
                }
                else if(!FormValidator.isNumber(tfMemberNumber.getText())){
                    JOptionPane.showMessageDialog(null,"Number must be numbers only","Not number",JOptionPane.WARNING_MESSAGE);
                }
                else if(!FormValidator.isNumber(tfMemberPoints.getText())) {
                    JOptionPane.showMessageDialog(null,"Points must be numbers only","Not number",JOptionPane.WARNING_MESSAGE);
                }
                else if(FormValidator.isNumber(tfMemberFName.getText())){
                    JOptionPane.showMessageDialog(null,"First name must be letters only","Not number",JOptionPane.WARNING_MESSAGE);
                }
                else if (FormValidator.isNumber(tfMemberLName.getText())){
                    JOptionPane.showMessageDialog(null,"Last  name must be letters only","Not number",JOptionPane.WARNING_MESSAGE);
                }
                else if (FormValidator.isNumber(tfMemberCity.getText())) {
                    JOptionPane.showMessageDialog(null, "City name must be letters only", "Not number", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }
}
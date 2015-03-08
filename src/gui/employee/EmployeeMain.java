package gui.employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 07/03/2015.
 */

public class EmployeeMain {

    private JFrame empMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton, backButton;
    private JTextField searchField;
    private JComboBox empTypes;
    private JPanel managePanel, northPanel, southPanel, searchPanel, searchTopPanel, searchBottomPanel;

    String[] eempTypes = {"All", "Sales", "Management"};  // this just a placeholder, real info will be populated from DB

    public EmployeeMain(){

    // setup the frame

        empMain = new JFrame("Employees");
        empMain.setLayout(new BorderLayout());
        empMain.setSize(800, 500);
        empMain.setLocationRelativeTo(null);
        //empMain.getContentPane().setBackground(new Color(98, 169, 221));

// north panel

        northPanel = new JPanel(new GridBagLayout());
        northPanel.setBackground(new Color(98, 169, 221));

    // manage employees panel

        managePanel = new JPanel(new FlowLayout());
        managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Employees")); // set anonymous titled, etched border

        addButton = new JButton("Add");
        addButton.setPreferredSize(new Dimension(100, 26));
        addButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        managePanel.add(addButton);

        editButton = new JButton("Edit");
        editButton.setPreferredSize(new Dimension(100, 26));
        editButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        managePanel.add(editButton);

        deleteButton = new JButton("Delete");
        deleteButton.setPreferredSize(new Dimension(100, 26));
        deleteButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        managePanel.add(deleteButton);

        northPanel.add(managePanel, getConstraints(0,0,1,1,0,0,0,GridBagConstraints.CENTER));

    // search employees panel

        searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Employees")); // set anonymous titled, etched border

        // top panel containing the search field and search button
        searchTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchTopPanel.setBackground(new Color(98, 169, 221));
        searchField = new JTextField(20);
        searchTopPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 26));
        searchButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        searchTopPanel.add(searchButton);

        // add top panel to search panel
        searchPanel.add(searchTopPanel, BorderLayout.NORTH);

        // buttom panel containing comboboxes for information filtering
        searchBottomPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchBottomPanel.setBackground(new Color(98, 169, 221));
        empTypes = new JComboBox(new DefaultComboBoxModel<String>(eempTypes));

        // add bottom panel to search panel
        searchBottomPanel.add(empTypes);

        searchPanel.add(searchBottomPanel, BorderLayout.SOUTH);

        // add all the above to northPanel
        northPanel.add(searchPanel, getConstraints(1,0,1,2,0,0,0,GridBagConstraints.CENTER));

        // add the above to the northPanel
        empMain.add(northPanel, BorderLayout.NORTH);

    // results panel
/////////////////////////////////////////////////////////////////////////////////////
// south panel

        southPanel = new JPanel(new GridBagLayout());
        southPanel.setBackground(new Color(98, 169, 221));

    // bottom buttons

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(150, 26));
        backButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        backButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        southPanel.add(backButton, getConstraints(0,0,1,1,0,15,15,GridBagConstraints.WEST));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                empMain.setVisible(false);  // lights off
            }
        });

        viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.setPreferredSize(new Dimension(150, 26));
        viewOrdersButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        southPanel.add(viewOrdersButton, getConstraints(1, 0, 1, 1, 0, 15, 15, GridBagConstraints.EAST));

        empMain.add(southPanel, BorderLayout.SOUTH);

// turns the lights on

        empMain.setVisible(true);
    }

    // return GridBagConstraints for GridBagLayout

    private GridBagConstraints getConstraints(int gridx, int gridy, int gridwidth, int gridheight, int weightxIn, int leftHorInsetIn, int rightHorInsetIn, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, leftHorInsetIn, 5, rightHorInsetIn);
        c.ipadx = 0;
        c.ipady = 0;
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.weightx = weightxIn;
        c.weighty = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = anchor;
        return c;
    }
}

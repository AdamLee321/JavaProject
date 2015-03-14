package gui.member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 07/03/2015)
*/

public class MemberMain {

    private JDialog memberMain;
    private JButton addButton, editButton, deleteButton, searchButton, viewOrdersButton, backButton;
    private JTextField searchField;
    private JPanel northPanel, managePanel, searchPanel, resultsPanel, southPanel;

    public MemberMain(JFrame parent) {

        // setup the frame

        memberMain = new JDialog(parent, true);
        memberMain.setTitle("Manage Members");
        memberMain.setLayout(new BorderLayout());
        memberMain.setSize(1200, 650);
        memberMain.setLocationRelativeTo(null);
        memberMain.setResizable(false);
        //memberMain.getContentPane().setBackground(new Color(98, 169, 221));

        // north panel

        northPanel = new JPanel(new GridBagLayout());
        northPanel.setBackground(new Color(98, 169, 221));

        // manage members panel

        managePanel = new JPanel(new FlowLayout());
        managePanel.setBackground(new Color(98, 169, 221));
        managePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Manage Members")); // set anonymous titled, etched border

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

        northPanel.add(managePanel, getConstraints(0, 0, 1, 1, 0, 0, 0, GridBagConstraints.CENTER));

        // search members panel

        searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.setBackground(new Color(98, 169, 221));
        searchPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Members")); // set anonymous titled, etched border

        searchField = new JTextField(20);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 26));
        searchButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        searchPanel.add(searchButton);

        northPanel.add(searchPanel, getConstraints(1, 0, 1, 1, 0, 0, 0, GridBagConstraints.CENTER));

        // add the above to the frame

        memberMain.add(northPanel, BorderLayout.NORTH);

        // results panel
/////////////////////////////////////////////////////////////////////////////////////

// south panel

        southPanel = new JPanel(new GridBagLayout());
        southPanel.setBackground(new Color(98, 169, 221));

        // bottom buttons

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(150, 26));
        backButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        southPanel.add(backButton, getConstraints(0, 0, 1, 1, 0, 15, 15, GridBagConstraints.WEST));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberMain.setVisible(false);
            }
        });

        viewOrdersButton = new JButton("View Orders");
        viewOrdersButton.setPreferredSize(new Dimension(150, 26));
        viewOrdersButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        southPanel.add(viewOrdersButton, getConstraints(1, 0, 1, 1, 0, 15, 15, GridBagConstraints.EAST));

        memberMain.add(southPanel, BorderLayout.SOUTH);
    }

    public JDialog getMemberMain(){
        return memberMain;
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
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = anchor;
        return c;
    }
}

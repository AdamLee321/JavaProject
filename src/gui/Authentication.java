package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 07/03/2015.
 */

public class Authentication extends JDialog {

    // implements ActionListener

    private JButton cancelButton;
    private JButton okButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel imageLabel;
    private JPanel userPassPanel;
    private JDialog authentication;
    private JTextField usernameField;
    private JPasswordField passwordField;

    GridBagConstraints gridBagConstraints;

    public Authentication (JFrame parent) {

        authentication = new JDialog(parent, true);

        userPassPanel = new JPanel();
        usernameLabel = new JLabel();
        passwordLabel = new JLabel();
        passwordField = new JPasswordField();
        usernameField = new JTextField();
        imageLabel = new JLabel();
        cancelButton = new JButton();
        okButton = new JButton();

        authentication.setLayout(new GridBagLayout());
        authentication.setSize(500,500);

        imageLabel.setBackground(new Color(98, 169, 221));
        imageLabel.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\64\\user.png"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -4;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(11, 0, 0, 0);
        authentication.add(imageLabel, gridBagConstraints);

        userPassPanel.setBackground(new Color(98, 169, 221));
        userPassPanel.setLayout(new GridBagLayout());

        usernameLabel.setText("Username");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(14, 10, 0, 0);
        userPassPanel.add(usernameLabel, gridBagConstraints);

        passwordLabel.setText("Password");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(9, 10, 0, 0);
        userPassPanel.add(passwordLabel, gridBagConstraints);

        passwordField.setText("");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 192;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 10, 0, 10);
        userPassPanel.add(passwordField, gridBagConstraints);

        usernameField.setText("");
        usernameField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
              //  usernameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 192;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(11, 10, 0, 10);
        userPassPanel.add(usernameField, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
             //   cancelButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 68, 5, 0);
        userPassPanel.add(cancelButton, gridBagConstraints);

        okButton.setText("OK");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(6, 6, 5, 10);
        userPassPanel.add(okButton, gridBagConstraints);

        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -90;
        gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new Insets(0, 4, 0, 0);
        authentication.add(userPassPanel, gridBagConstraints);

        authentication.setVisible(true);
    }
}

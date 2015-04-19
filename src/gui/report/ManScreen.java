package gui.report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adam Lee on 01/04/2015.
 */
public class ManScreen extends JFrame implements ActionListener{

    private JFrame re;
    private JPanel top, button, north, center, south;
    private JLabel logo;
    private JButton sales, reports, logout;

    public ManScreen() {

        re = new JFrame();
        re.setTitle("Reports");
        re.setLayout(new BorderLayout());
        re.setSize(1000, 650);
        re.setLocationRelativeTo(null); //Sets the screen to appear in the center
        re.setResizable(true);

        //TOP PANEL FOR LOGO
        top = new JPanel();
        top.setBackground(Color.BLACK);
        top.setPreferredSize(new Dimension(100,150));

        //JLabel for Logo
        logo = new JLabel("LOGO");
        top.add(logo);

        //BUTTON PANEL
        button = new JPanel(new BorderLayout());
        button.setBackground(new Color(98, 169, 221));

        //North Button Panel
        north = new JPanel(new FlowLayout());
        north.setBackground(new Color(98, 169, 221));
        button.add(north, BorderLayout.NORTH);

        //SALES Button
        sales = new JButton("SALES");
        sales.setPreferredSize(new Dimension(130, 100));
        north.add(sales);
        sales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                new ManSales()
                ;
            }
        });

        //Center Panel
        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));
        button.add(center, BorderLayout.CENTER);

        //REPORTS Button
        reports = new JButton("REPORTS");
        reports.setPreferredSize(new Dimension(130,100));
        center.add(reports);
        reports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportEmployee();
            }
        });

        //South Panel
        south = new JPanel(new FlowLayout(FlowLayout.LEFT));
        south.setBackground(new Color(98, 169, 221));
        button.add(south, BorderLayout.SOUTH);

        //LOGOUT Button
        logout = new JButton("LOGOUT");
        logout.setPreferredSize(new Dimension(150,100));
        south.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you wish to logout?", "Logout", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });

        re.add(top, BorderLayout.NORTH);
        re.add(button, BorderLayout.CENTER);
        re.setVisible(true);

    }

    public static void main(String[] args) {
        ManScreen ma = new ManScreen();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

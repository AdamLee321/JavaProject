package gui.report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adam Lee on 13/03/2015.
 */
public class ReportMonthYear {

    private JDialog jd2;
    private JComboBox month, year;
    private JButton okButton;
    private JPanel center;

    public ReportMonthYear() {

        jd2 = new JDialog();
        jd2.setLayout(new BorderLayout());
        jd2.setTitle("Please select Month and Year");
        jd2.setSize(100, 2002);
        jd2.setLocationRelativeTo(null);

        //JPanel initialisation
        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));

        //Combo box creation
        month = new JComboBox();
        center.add(month);
        year.addItem("January");
        year.addItem("February");
        year.addItem("March");
        year.addItem("April");
        year.addItem("May");
        year.addItem("June");
        year.addItem("July");
        year.addItem("August");
        year.addItem("September");
        year.addItem("October");
        year.addItem("November");
        year.addItem("December");
        year.setEditable(true);
        System.out.println("Week=" + year.getItemCount());

        year.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + year.getSelectedIndex()
                        + " Selected week=" + year.getSelectedItem());
            }
        });

        year = new JComboBox();
        center.add(year);
        year.addItem("2015");
        year.addItem("2014");
        year.addItem("2013");
        year.setEditable(true);
        System.out.println("Year=" + year.getItemCount());

        year.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + year.getSelectedIndex()
                        + " Selected year=" + year.getSelectedItem());
            }
        });

        //OK Button
        okButton = new JButton("Ok");
        center.add(okButton);

        jd2.add(center, BorderLayout.CENTER);
        jd2.setVisible(true);
    }
}

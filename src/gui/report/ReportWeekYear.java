package gui.report;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adam Lee on 13/03/2015.
 */
public class ReportWeekYear{

    private JDialog jd1;
    private JComboBox week, year;
    private JButton okButton;
    private JPanel center;

    public ReportWeekYear(){

        jd1 = new JDialog();
        jd1.setLayout(new BorderLayout());
        jd1.setTitle("Please select the Week and Year");
        jd1.setSize(300, 100);
        jd1.setLocationRelativeTo(null);

        //JPanel initialisation
        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));

        //Combo box creation
        week = new JComboBox();
        center.add(week);
        week.addItem("1");
        week.addItem("2");
        week.addItem("3");
        week.setEditable(true);
        System.out.println("Week=" + week.getItemCount());

        week.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selected index=" + week.getSelectedIndex()
                        + " Selected week=" + week.getSelectedItem());
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

        jd1.add(center, BorderLayout.CENTER);
        jd1.setVisible(true);
    }
}

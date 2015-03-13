package gui;

import javafx.scene.control.ComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Adam Lee on 13/03/2015.
 */
public class ReportYear {
    private JDialog jd3;
    private JPanel center;
    private JComboBox year;
    private JButton okButton;

    public ReportYear() {

        jd3 = new JDialog();
        jd3.setLayout(new BorderLayout());
        jd3.setTitle("Please select the year");
        jd3.setSize(300, 100);
        jd3.setLocationRelativeTo(null);

        center = new JPanel(new FlowLayout());
        center.setBackground(new Color(98, 169, 221));

        //Year Combobox
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

        jd3.add(center, BorderLayout.CENTER);
        jd3.setVisible(true);
    }
}


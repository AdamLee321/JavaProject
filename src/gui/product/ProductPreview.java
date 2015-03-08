package gui.product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by User on 08/03/2015.
 */

public class ProductPreview {

    private JDialog prodPreview;
    private JLabel prodPictureLabel, prodIdLabel, prodMakeModel, prodSalePriceLabel, prodCostPriceLabel;
    private JLabel prodDescLabel, prodQTYLabel, prodTypeLabel, prodCPULabel, prodRAMLabel, prodOSLabel, prodStorageLabel, prodScreenLabel;
    private JButton backButton, printButton;
    private JPanel detailsPanel, topPanel, buttonsPanel;
    private Border paddingBorder;

    //
/*
    String prodDescription = "Dell Laptop, really great. Buy it! No caveats here.";
    String html1 = "<html><body style='width: ";
    String html2 = "px'>";

   // JOptionPane.showMessageDialog(null, new JLabel(html1+"200"+html2+prodDescription));
   // JOptionPane.showMessageDialog(null, new JLabel(html1+"300"+html2+s));
*/
    public ProductPreview(JFrame parent){

    // setup the JDialog

        prodPreview = new JDialog(parent, true);
        prodPreview.setTitle("Product");
        prodPreview.setLayout(new BorderLayout());
        prodPreview.setSize(450, 700);
        prodPreview.setResizable(false);
        prodPreview.setLocationRelativeTo(null);

    // setup top panel, which will hold the profile picture + all the details panel (grid) with a titled, etched border surrounding them

        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(new Color(98, 169, 221));
        topPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Product Preview",2,2)); // set anonymous titled, etched border, centered title

        // profile picture
        prodPictureLabel = new JLabel(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\128\\user.png"));
        topPanel.add(prodPictureLabel);

        // details panel, Grid
        detailsPanel = new JPanel(new GridLayout(12,1,0,10)); // rows, cols, hgap, vgap
        paddingBorder = BorderFactory.createEmptyBorder(0,20,0,20);  // set the border inside the grid to move details away from the edges
        detailsPanel.setBorder(paddingBorder);
        detailsPanel.setBackground(new Color(98, 169, 221));

        prodIdLabel = new JLabel("765671");
        detailsPanel.add(prodIdLabel);

        prodMakeModel = new JLabel("Dell Insprion 5150");
        detailsPanel.add(prodMakeModel);

        prodTypeLabel = new JLabel("Laptop");
        detailsPanel.add(prodTypeLabel);

        prodDescLabel = new JLabel("Dell Laptop, really great. Buy it! No caveats here.");
        detailsPanel.add(prodDescLabel);

        prodCPULabel = new JLabel("Intel Core i5");
        detailsPanel.add(prodCPULabel);

        prodRAMLabel = new JLabel("4GB");
        detailsPanel.add(prodRAMLabel);

        prodOSLabel = new JLabel("Windows 8");
        detailsPanel.add(prodOSLabel);

        prodStorageLabel = new JLabel("500GB HDD");
        detailsPanel.add(prodStorageLabel);

        prodScreenLabel = new JLabel("15,4'");
        detailsPanel.add(prodScreenLabel);

        prodSalePriceLabel = new JLabel("650");
        detailsPanel.add(prodSalePriceLabel);

        prodCostPriceLabel = new JLabel("580");
        detailsPanel.add(prodCostPriceLabel);

        prodQTYLabel = new JLabel("2 in Stock");
        detailsPanel.add(prodQTYLabel);

        topPanel.add(detailsPanel);

        // add to main dialog
        prodPreview.add(topPanel, BorderLayout.CENTER);

    // setup the buttons panel, which will be on the SOUTH of the prodPreview's BorderLayout (below the etched border). Buttons panel will have a simple centered flow layout

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setBackground(new Color(98, 169, 221));

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 26));
        backButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prodPreview.setVisible(false);
            }
        });
        buttonsPanel.add(backButton);

        printButton = new JButton("Print");
        printButton.setPreferredSize(new Dimension(100, 26));
        printButton.setIcon(new ImageIcon("D:\\Dropbox\\Shares\\ITT Adam.David\\Part 2\\Icons\\UI Elements\\16\\save.png"));
        buttonsPanel.add(printButton);

        // add to main dialog
        prodPreview.add(buttonsPanel, BorderLayout.SOUTH);

        prodPreview.setVisible(true);
    }
}


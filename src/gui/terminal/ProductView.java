package gui.terminal;

import gui.DataProcessor;
import gui.Griddy;
import gui.UIElements;
import model.Product;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

public class ProductView {


    private JTextArea descriptionTF;
    JLabel productPicture;

    public JPanel getProductView(Product p){

        JTextField idTf = new JTextField();
        setTextBoxDefaults(idTf);
        idTf.setText(Integer.toString(p.getProdId()));

        JTextField makeTf = new JTextField();
        setTextBoxDefaults(makeTf);
        makeTf.setText(p.getProdMake());

        JTextField modelTf = new JTextField();
        setTextBoxDefaults(modelTf);
        modelTf.setText(p.getProdModel());

        JTextField priceTf = new JTextField();
        setTextBoxDefaults(priceTf);
        priceTf.setText("€" + Double.toString(p.getProdSalePrice()));

        JTextField qtyTf = new JTextField();
        setTextBoxDefaults(qtyTf);
        qtyTf.setText(Integer.toString(p.getprodQTY()));

        JTextField cpuTf = new JTextField();
        setTextBoxDefaults(cpuTf);
        cpuTf.setText(p.getCpu());

        JTextField ramTf = new JTextField();
        setTextBoxDefaults(ramTf);
        ramTf.setText(p.getRam());

        JTextField osTf = new JTextField();
        setTextBoxDefaults(osTf);
        osTf.setText(p.getOS());

        JTextField hddTf = new JTextField();
        setTextBoxDefaults(hddTf);
        hddTf.setText(p.getStorage());

        JTextField screenTf = new JTextField();
        setTextBoxDefaults(screenTf);
        screenTf.setText(p.getScreen());


        LineBorder lineBorder = new LineBorder(Color.BLACK);

        descriptionTF  = new JTextArea();
        descriptionTF.setLineWrap(true);
        descriptionTF.setWrapStyleWord(true);
        descriptionTF.setSize(580, 60);//Size(580, 60);
        descriptionTF.setText(p.getProdDesc());
        descriptionTF.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(descriptionTF);
        scrollPane.setPreferredSize(new Dimension(600,65));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        TitledBorder descriptionTitleBorder = new TitledBorder("Description");
        descriptionTitleBorder.setBorder(lineBorder);
        JPanel description = new JPanel(new GridLayout());
        description.setBorder(descriptionTitleBorder);
        description.add(scrollPane);


        try {
            productPicture = new JLabel(new ImageIcon(DataProcessor.fitImageByte(p.getProdPic(), 280, 280)));
        }catch (IOException ioe){

        }
        JPanel picturePanel = new JPanel(new GridLayout());
        TitledBorder titledBorder = new TitledBorder(p.getProdMake() + " " + p.getProdModel());
        titledBorder.setBorder(lineBorder);
        picturePanel.setBorder(titledBorder);
        picturePanel.add(productPicture, BorderLayout.CENTER);


        TitledBorder detailsTitleBorder = new TitledBorder("Details");
        detailsTitleBorder.setBorder(lineBorder);
        JPanel details = new JPanel(new GridBagLayout());
        details.setBorder(detailsTitleBorder);

        details.add(new JLabel("Product ID"), Griddy.getConstraints(0,0,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        details.add(idTf, Griddy.getConstraints(1, 0, 1, 1, 10, 10, 0, 0, 10, 0, 0, 0, 0, GridBagConstraints.CENTER));

        details.add(new JLabel("Make"), Griddy.getConstraints(0,1,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        details.add(makeTf, Griddy.getConstraints(1,1,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        details.add(new JLabel("Model"), Griddy.getConstraints(0,2,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.EAST));
        details.add(modelTf, Griddy.getConstraints(1,2,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        details.add(new JLabel("Price"), Griddy.getConstraints(0,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        details.add(priceTf, Griddy.getConstraints(1,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        details.add(new JLabel("Quantity in Stock"), Griddy.getConstraints(0,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        details.add(qtyTf, Griddy.getConstraints(1,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        TitledBorder specificationsTitleBorder = new TitledBorder("Specifications");
        specificationsTitleBorder.setBorder(lineBorder);
        JPanel specifications = new JPanel(new GridBagLayout());
        specifications.setBorder(specificationsTitleBorder);

        specifications.add(new JLabel("CPU"), Griddy.getConstraints(0,0,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.FIRST_LINE_END));
        specifications.add(cpuTf, Griddy.getConstraints(1, 0, 1, 1, 10, 10, 0, 0, 10, 0, 0, 0, 0, GridBagConstraints.FIRST_LINE_START));

        specifications.add(new JLabel("RAM"), Griddy.getConstraints(0,1,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.FIRST_LINE_END));
        specifications.add(ramTf, Griddy.getConstraints(1,1,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        specifications.add(new JLabel("Operating System"), Griddy.getConstraints(0,2,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_END));
        specifications.add(osTf, Griddy.getConstraints(1,2,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        specifications.add(new JLabel("HDD"), Griddy.getConstraints(0,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_END));
        specifications.add(hddTf, Griddy.getConstraints(1,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        specifications.add(new JLabel("Screen"), Griddy.getConstraints(0,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_END));
        specifications.add(screenTf, Griddy.getConstraints(1,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        JPanel productDetails = new JPanel(new GridBagLayout());
        productDetails.setBorder(BorderFactory.createLineBorder(UIElements.getColour(), 20));

        productDetails.add(picturePanel, Griddy.getConstraints(0,0,1,4,10,10,0,0,0,0,0,0,0,GridBagConstraints.WEST));
        productDetails.add(details, Griddy.getConstraints(1, 0, 1, 1, 10, 10, 0, 0, 0, 0, 0, 0, 0, GridBagConstraints.CENTER));
        productDetails.add(specifications, Griddy.getConstraints(2,0,1,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.EAST));
        productDetails.add(description, Griddy.getConstraints(1,1,2,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.CENTER));

        return productDetails;
    }

    public void setTextBoxDefaults(JTextField tf){
        Dimension textboxSize = new Dimension(175,15);
        tf.setPreferredSize(textboxSize);
        tf.setEditable(false);
    }
}

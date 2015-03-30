package gui.terminal;

import gui.Griddy;
import model.Product;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by DL on 09/03/2015.
 */
public class ProductView {


    private JTextArea descriptionTF;


    public JPanel getProductView(Product p){
        Dimension textboxSize = new Dimension(150,10);

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
        priceTf.setText("€" +Double.toString(p.getProdCostPrice()));

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

        JScrollPane scrollPane = new JScrollPane(descriptionTF);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        LineBorder lineBorder = new LineBorder(new Color(0,0,128));

        descriptionTF  = new JTextArea();
        descriptionTF.setLineWrap(true);
        descriptionTF.setSize(600, 100);
        descriptionTF.setText(p.getProdDesc());
        descriptionTF.setEditable(false);

        TitledBorder descriptionTitleBorder = new TitledBorder("Description");
        descriptionTitleBorder.setBorder(lineBorder);
        JPanel description = new JPanel(new FlowLayout());
        description.setBorder(descriptionTitleBorder);
        description.add(descriptionTF);

        JLabel productPicture = new JLabel(new ImageIcon("src/res/images/Product Categories/AllInOnePC150.png"));


        TitledBorder detailsTitleBorder = new TitledBorder("Details");
        detailsTitleBorder.setBorder(lineBorder);
        JPanel details = new JPanel(new GridBagLayout());
        details.setBorder(detailsTitleBorder);

        //details.add(new JLabel("Product ID"), TerminalMode.getConstraints(0, 0, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(new JLabel("Product ID"), Griddy.getConstraints(0,0,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        //details.add(idTf, TerminalMode.getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));
        details.add(idTf, Griddy.getConstraints(1,0,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        //details.add(new JLabel("Make"), TerminalMode.getConstraints(0, 1, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(new JLabel("Make"), Griddy.getConstraints(0,1,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        //details.add(makeTf, TerminalMode.getConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));
        details.add(makeTf, Griddy.getConstraints(1,1,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        //details.add(new JLabel("Model"), TerminalMode.getConstraints(0, 2, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(new JLabel("Model"), Griddy.getConstraints(0,2,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.EAST));
        //details.add(modelTf, TerminalMode.getConstraints(1, 2, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));
        details.add(modelTf, Griddy.getConstraints(1,2,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        //details.add(new JLabel("Price"), TerminalMode.getConstraints(0, 3, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(new JLabel("Price"), Griddy.getConstraints(0,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        //details.add(priceTf, TerminalMode.getConstraints(1, 3, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));
        details.add(priceTf, Griddy.getConstraints(1,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));

        //details.add(new JLabel("Quantity in Stock"), TerminalMode.getConstraints(0, 4, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(new JLabel("Quantity in Stock"), Griddy.getConstraints(0,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.EAST));
        //details.add(qtyTf, TerminalMode.getConstraints(1, 4, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));
        details.add(qtyTf, Griddy.getConstraints(1,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.CENTER));


        TitledBorder specificationsTitleBorder = new TitledBorder("Specifications");
        specificationsTitleBorder.setBorder(lineBorder);
        JPanel specifications = new JPanel(new GridBagLayout());
        specifications.setBorder(specificationsTitleBorder);

        //specifications.add(new JLabel("CPU"), TerminalMode.getConstraints(0, 0, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(new JLabel("CPU"), Griddy.getConstraints(0,0,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.FIRST_LINE_END));
        //specifications.add(cpuTf, TerminalMode.getConstraints(1, 0, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));
        specifications.add(cpuTf, Griddy.getConstraints(1,0,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.FIRST_LINE_START));

        //specifications.add(new JLabel("RAM"), TerminalMode.getConstraints(0, 1, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(new JLabel("RAM"), Griddy.getConstraints(0,1,1,1,10,10,0,0,10,0,0,0,0, GridBagConstraints.FIRST_LINE_END));
        //specifications.add(ramTf, TerminalMode.getConstraints(1, 1, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));
        specifications.add(ramTf, Griddy.getConstraints(1,1,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        //specifications.add(new JLabel("Operating System"), TerminalMode.getConstraints(0, 2, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(new JLabel("Operating System"), Griddy.getConstraints(0,2,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_END));
        //specifications.add(osTf, TerminalMode.getConstraints(1, 2, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));
        specifications.add(osTf, Griddy.getConstraints(1,2,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));


        //specifications.add(new JLabel("HDD"), TerminalMode.getConstraints(0, 3, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(new JLabel("HDD"), Griddy.getConstraints(0,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_END));
        //specifications.add(hddTf, TerminalMode.getConstraints(1, 3, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));
        specifications.add(hddTf, Griddy.getConstraints(1,3,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        //specifications.add(new JLabel("Screen"), TerminalMode.getConstraints(0, 4, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(new JLabel("Screen"), Griddy.getConstraints(0,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_END));
        //specifications.add(screenTf, TerminalMode.getConstraints(1, 4, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));
        specifications.add(screenTf, Griddy.getConstraints(1,4,1,1,10,10,0,0,10,0,0,0,0,GridBagConstraints.FIRST_LINE_START));

        JPanel productDetails = new JPanel(new GridBagLayout());
        productDetails.setBorder(BorderFactory.createLineBorder(new Color(98, 169, 221), 20));

        //productDetails.add(productPicture, TerminalMode.getConstraints(0, 0, 1, 1, GridBagConstraints.WEST, 0, 0, 0, 0));
        productDetails.add(productPicture, Griddy.getConstraints(0,0,1,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.WEST));
        //productDetails.add(details, TerminalMode.getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, 0, 0, 0, 0));
        productDetails.add(details, Griddy.getConstraints(1,0,1,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.CENTER));
        //productDetails.add(specifications, TerminalMode.getConstraints(2, 0, 1, 1, GridBagConstraints.EAST, 0, 0, 0, 0));
        productDetails.add(specifications, Griddy.getConstraints(2,0,1,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.EAST));
        //productDetails.add(description, TerminalMode.getConstraints(1, 1, 2, 1, GridBagConstraints.CENTER, 0, 0, 0, 0));
        productDetails.add(description, Griddy.getConstraints(1,1,2,1,10,10,0,0,0,0,0,0,0,GridBagConstraints.CENTER));


        return productDetails;
    }

    public void setTextBoxDefaults(JTextField tf){
        Dimension textboxSize = new Dimension(175,10);
        tf.setPreferredSize(textboxSize);
        tf.setEditable(false);

    }
}

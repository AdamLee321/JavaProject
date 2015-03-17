package gui.terminal;

import model.Product;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
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
        priceTf.setText(Double.toString(p.getProdCostPrice()));

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

        details.add(new JLabel("Product ID"), MainFrame.getConstraints(0, 0, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(idTf, MainFrame.getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Make"), MainFrame.getConstraints(0, 1, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(makeTf, MainFrame.getConstraints(1, 1, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Model"), MainFrame.getConstraints(0, 2, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(modelTf, MainFrame.getConstraints(1, 2, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Price"), MainFrame.getConstraints(0, 3, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(priceTf, MainFrame.getConstraints(1, 3, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Quantity in Stock"), MainFrame.getConstraints(0, 4, 1, 1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(qtyTf, MainFrame.getConstraints(1, 4, 1, 1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        TitledBorder specificationsTitleBorder = new TitledBorder("Specifications");
        specificationsTitleBorder.setBorder(lineBorder);
        JPanel specifications = new JPanel(new GridBagLayout());
        specifications.setBorder(specificationsTitleBorder);

        specifications.add(new JLabel("CPU"), MainFrame.getConstraints(0, 0, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(cpuTf, MainFrame.getConstraints(1, 0, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("RAM"), MainFrame.getConstraints(0, 1, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(ramTf, MainFrame.getConstraints(1, 1, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("Operating System"), MainFrame.getConstraints(0, 2, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(osTf, MainFrame.getConstraints(1, 2, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("HDD"), MainFrame.getConstraints(0, 3, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(hddTf, MainFrame.getConstraints(1, 3, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("Screen"), MainFrame.getConstraints(0, 4, 1, 1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(screenTf, MainFrame.getConstraints(1, 4, 1, 1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        JPanel productDetails = new JPanel(new GridBagLayout());
        productDetails.setBorder(BorderFactory.createLineBorder(new Color(98, 169, 221), 20));

        productDetails.add(productPicture, MainFrame.getConstraints(0, 0, 1, 1, GridBagConstraints.WEST, 0, 0, 0, 0));
        productDetails.add(details, MainFrame.getConstraints(1, 0, 1, 1, GridBagConstraints.CENTER, 0, 0, 0, 0));
        productDetails.add(specifications, MainFrame.getConstraints(2, 0, 1, 1, GridBagConstraints.EAST, 0, 0, 0, 0));
        productDetails.add(description, MainFrame.getConstraints(1, 1, 2, 1, GridBagConstraints.CENTER, 0, 0, 0, 0));


        return productDetails;
    }

    public void setTextBoxDefaults(JTextField tf){
        Dimension textboxSize = new Dimension(175,10);
        tf.setPreferredSize(textboxSize);
        tf.setEditable(false);

    }
}

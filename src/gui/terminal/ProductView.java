package gui.terminal;

import model.Product;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by DL on 09/03/2015.
 */
public class ProductView {
    MainFrame mf;

    private JPanel productDetails, details, specifications, description;
    private JLabel productPicture;
    private JTextField idTf, makeTf, modelTf, priceTf, qtyTf, cpuTf, ramTf, osTf, hddTf, screenTf;
    private JTextField descriptionTF;

    public ProductView(MainFrame mf){
        this.mf = mf;
    }

    public JPanel getProductView(Product p){
        idTf = new JTextField();
        idTf.setPreferredSize(new Dimension(200,10));

        makeTf = new JTextField();
        makeTf.setPreferredSize(new Dimension(200,10));

        modelTf = new JTextField();
        modelTf.setPreferredSize(new Dimension(200,10));

        priceTf = new JTextField();
        priceTf.setPreferredSize(new Dimension(200,10));

        qtyTf = new JTextField();
        qtyTf.setPreferredSize(new Dimension(200,10));

        cpuTf = new JTextField();
        cpuTf.setPreferredSize(new Dimension(200,10));

        ramTf = new JTextField();
        ramTf.setPreferredSize(new Dimension(200,10));

        osTf = new JTextField();
        osTf.setPreferredSize(new Dimension(200,10));

        hddTf = new JTextField();
        hddTf.setPreferredSize(new Dimension(200,10));

        screenTf = new JTextField();
        screenTf.setPreferredSize(new Dimension(200,10));


        //description = new JPanel(new FlowLayout());
        //description.setBorder(new TitledBorder("Description"));
        descriptionTF  = new JTextField();
        //JScrollPane scrollPane = new JScrollPane(descriptionTF);
        //descriptionTF.setText("The affordable Lenovo H500s desktop uniquely combines a slim space-saving\" +\n" +
        //       "design with the latest processor technology and plenty of storage space for everyday\" +\n" +
        //        "home computing.");
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //description.add(scrollPane);

        productPicture = new JLabel(new ImageIcon("src/res/images/Product Categories/AllInOnePC150.png"));

        details = new JPanel(new GridBagLayout());
        details.setBorder(new TitledBorder("Details"));

        details.add(new JLabel("Product ID"), MainFrame.getConstraints(0,0,1,1, GridBagConstraints.EAST, 10,0 ,0 , 0));
        details.add(idTf, MainFrame.getConstraints(1,0,1,1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Make"), MainFrame.getConstraints(0,1,1,1, GridBagConstraints.EAST, 10,0 ,0 , 0));
        details.add(makeTf, MainFrame.getConstraints(1,1,1,1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Model"), MainFrame.getConstraints(0,2,1,1, GridBagConstraints.EAST, 10,0 ,0 , 0));
        details.add(modelTf, MainFrame.getConstraints(1,2,1,1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Price"), MainFrame.getConstraints(0,3,1,1, GridBagConstraints.EAST, 10,0 ,0 , 0));
        details.add(priceTf, MainFrame.getConstraints(1,3,1,1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        details.add(new JLabel("Quantity in Stock"), MainFrame.getConstraints(0,4,1,1, GridBagConstraints.EAST, 10, 0, 0, 0));
        details.add(qtyTf, MainFrame.getConstraints(1,4,1,1, GridBagConstraints.CENTER, 10, 0, 0, 0));

        specifications = new JPanel(new GridBagLayout());
        specifications.setBorder(new TitledBorder("Specifications"));

        specifications.add(new JLabel("CPU"), MainFrame.getConstraints(0,0,1,1, GridBagConstraints.FIRST_LINE_END, 10,0 ,0 , 0));
        specifications.add(cpuTf, MainFrame.getConstraints(1,0,1,1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("RAM"), MainFrame.getConstraints(0,1,1,1, GridBagConstraints.FIRST_LINE_END, 10,0 ,0 , 0));
        specifications.add(ramTf, MainFrame.getConstraints(1,1,1,1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("Operating System"), MainFrame.getConstraints(0,2,1,1, GridBagConstraints.FIRST_LINE_END, 10,0 ,0 , 0));
        specifications.add(osTf, MainFrame.getConstraints(1,2,1,1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("HDD"), MainFrame.getConstraints(0,3,1,1, GridBagConstraints.FIRST_LINE_END, 10,0 ,0 , 0));
        specifications.add(hddTf, MainFrame.getConstraints(1,3,1,1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));

        specifications.add(new JLabel("Screen"), MainFrame.getConstraints(0,4,1,1, GridBagConstraints.FIRST_LINE_END, 10, 0, 0, 0));
        specifications.add(screenTf, MainFrame.getConstraints(1,4,1,1, GridBagConstraints.FIRST_LINE_START, 10, 0, 0, 0));






        productDetails = new JPanel(new GridBagLayout());
        productDetails.setBorder(BorderFactory.createLineBorder(new Color(98, 169, 221), 20));

        //productDetails.add(productPicture, MainFrame.getConstraints(0,0,1,1, GridBagConstraints.WEST, 0, 0, 0, 0));
        //productDetails.add(details, MainFrame.getConstraints(1,0,1,1, GridBagConstraints.CENTER, 0, 0, 0, 0));
        //productDetails.add(specifications, MainFrame.getConstraints(2,0,1,1, GridBagConstraints.EAST, 0, 0, 0, 0));
        productDetails.add(descriptionTF, MainFrame.getConstraints(0,1,3,1, GridBagConstraints.WEST, 0, 0, 0, 0));

        return productDetails;
    }

}

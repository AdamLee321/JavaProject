package gui.product;

import gui.terminal.TerminalProductRow;

/**
 * Created by DL on 04/04/2015.
 */
public class AdminProductRow extends TerminalProductRow{

    private double costPrice;
    private String productType;

    public AdminProductRow(){
        super();
        costPrice = 0;
        productType = "";
    }

    public AdminProductRow(int productID, String make, String model, double price, double costPrice,
                           int quantity, String productType){
        super(productID, make, model, price, quantity);
        this.costPrice = costPrice;
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public double getCostPrice() {
        return costPrice;
    }
}

package gui.product;

import gui.terminal.TerminalProductTableRow;

/**
 * David 05/04/2015
 */
public class AdminProductTableTableRow extends TerminalProductTableRow {

    private double costPrice;
    private String productType;

    public AdminProductTableTableRow(){
        super();
        costPrice = 0;
        productType = "";
    }

    public AdminProductTableTableRow(int productID, String make, String model, double price, double costPrice,
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

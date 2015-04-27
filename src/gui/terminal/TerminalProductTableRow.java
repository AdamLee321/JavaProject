package gui.terminal;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

public class TerminalProductTableRow {

    private int productID;
    private String make;
    private String model;
    private double price;
    private int quantity;

    public TerminalProductTableRow() {
        this.productID = 0;
        this.make = "";
        this.model = "";
        this.price = 0;
        this.quantity = 0;
    }

    public TerminalProductTableRow(int productID, String make, String model, double price, int quantity) {
        this.productID = productID;
        this.make = make;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductID() {
        return productID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

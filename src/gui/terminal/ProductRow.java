package gui.terminal;

/*
 * David Lawlor X00107563
 * Date 30/03/2015
 */

public class ProductRow {

    int productID;
    String make;
    String model;
    double price;
    int quantity;

    public ProductRow() {
        this.productID = 0;
        this.make = new String();
        this.model = new String();
        this.price = 0;
        this.quantity = 0;
    }

    public ProductRow(int productID, String make, String model, double price, int quantity) {
        this.productID = productID;
        this.make = make;
        this.model = model;
        this.price = price;
        this.quantity = quantity;
    }
}

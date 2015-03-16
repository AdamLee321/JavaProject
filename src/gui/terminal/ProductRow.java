package gui.terminal;

public class ProductRow {

    int Id;

    int productID;
    String make;
    String model;
    double price;
    int quantity;

    final static int INSERTED = -1;

    public ProductRow() {
        this.Id = INSERTED;
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

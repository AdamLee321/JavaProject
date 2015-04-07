package gui.sale;/*2ndYearProject
  gui.sale
  Created by David
  George
  13:05   01/04/2015
  Software Development 3
*/

public class SaleRow {

  private int productCode;
  private String prodMake;
  private String prodModel;
  private int qty;
  private double price;

  public SaleRow(){
    this.productCode = 0;
    this.prodMake = "";
    this.prodModel = "";
    this.qty = 0;
    this.price = 0;
  }

  public SaleRow(int productCode, String prodMake, String prodModel, int qty, double price){
    this.productCode = productCode;
    this.prodMake = prodMake;
    this.prodModel = prodModel;
    this.qty = qty;
    this.price = price;
  }

  public int getQty() {
    return qty;
  }

  public void setQty(int qtyIn) {
    qty = qtyIn;
  }

  public String getProdModel() {
    return prodModel;
  }

  public String getProdMake() {
    return prodMake;
  }

  public int getProductCode() {
    return productCode;
  }

  public double getPrice() {
    return price;
  }
}

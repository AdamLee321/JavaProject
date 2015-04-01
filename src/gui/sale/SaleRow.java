package gui.sale;/*2ndYearProject
  gui.sale
  Created by David
  George
  13:05   01/04/2015
  Software Development 3
*/

public class SaleRow {

  int productCode;
  String prodMake;
  String prodModel;
  int qty;
  double price;

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
}

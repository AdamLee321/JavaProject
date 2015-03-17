package model;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import oracle.sql.BLOB;

import javax.swing.*;
import java.sql.Blob;

public class Product {
  private int prodId;
  private String prodMake;
  private String prodModel;
  private double prodSalePrice;
  private double prodCostPrice;
  private int prodQTY;
  //private Blob prodPic;
  private String prodType;
  private String cpu;
  private String ram;
  private String OS;
  private String storage;
  private String screen;
  private String prodDesc;

  public Product() {
    this.prodId = 0;
    this.prodMake = "";
    this.prodModel = "";
    this.prodSalePrice = 0;
    this.prodCostPrice = 0;
    this.prodQTY = 0;
    //this.prodPic = null;
    this.prodType = "";
    this.cpu = "";
    this.ram = "";
    this.OS = "";
    this.storage = "";
    this.screen = "";
	this.prodDesc = "";
  }

  public Product(int prodId, String prodMake, String prodModel, double prodSalePrice, double prodCostPrice, int prodQTY,
                // Blob prodPic,
                 String prodType, String cpu, String ram, String OS, String storage, String screen, String prodDesc){
    this.prodId = prodId;
    this.prodMake = prodMake;
    this.prodModel = prodModel;
    this.prodSalePrice = prodSalePrice;
    this.prodCostPrice = prodCostPrice;
    this.prodQTY = prodQTY;
    //this.prodPic = prodPic;
    this.prodType = prodType;
    this.cpu = cpu;
    this.ram = ram;
    this.OS = OS;
    this.storage = storage;
    this.screen = screen;
    this.prodDesc = prodDesc;
  }

//getters for all attributes

  //getter for id
  public int getProdId() {
    return prodId;
  }

  //getter for make
  public String getProdMake() {
    return prodMake;
  }

  //getter for model
  public String getProdModel() {
    return prodModel;
  }

  //getter for sale price
  public double getProdSalePrice() {
    return prodSalePrice;
  }

  //getter for cost price
  public double getProdCostPrice() {
    return prodCostPrice;
  }

  // getter for description
  public String getProdDesc() {
    return prodDesc;
  }

  //getter for quantity in stock
  public int getprodQTY() {
    return prodQTY;
  }

  //getter for cpu
  public String getCpu() {
    return cpu;
  }

  //getter for ram
  public String getRam() {
    return ram;
  }

  // getter of operating system
  public String getOS() {
    return OS;
  }

  //getter for storage type
  public String getStorage() {
    return storage;
  }

  // getter for screen type
  public String getScreen() {
    return screen;
  }

  //Setters for all attributes

  //setter for prduct id
  public void setProdId(int prodId) {
    this.prodId = prodId;
  }

  //setter for make
  public void setProdMake(String prodMake) {
    this.prodMake = prodMake;
  }

  //setter for model
  public void setProdModel(String prodModel) {
    this.prodModel = prodModel;
  }

  //setter for sale price
  public void setProdSalePrice(double prodSalePrice) {
    this.prodSalePrice = prodSalePrice;
  }

  //setter for cost price
  public void setProdCostPrice(double prodCostPrice) {
    this.prodCostPrice = prodCostPrice;
  }

  //setter for description
  public void setProdDesc(String prodDesc) {
    this.prodDesc = prodDesc;
  }

  //setter for quantity in stock
  public void setProdQTY(int prodQTY) {
    this.prodQTY = prodQTY;
  }

  //setter for cpu
  public void setCpu(String cpu) {
    this.cpu = cpu;
  }

  //setter for ram
  public void setRam(String ram) {
    this.ram = ram;
  }

  //setter for os
  public void setOS(String OS) {
    this.OS = OS;
  }

  //setter for storage
  public void setStorage(String storage) {
    this.storage = storage;
  }

  //setter for screen
  public void setScreen(String screen) {
    this.screen = screen;
  }
}

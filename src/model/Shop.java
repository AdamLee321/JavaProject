package model;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

import java.util.ArrayList;

public class Shop {

  private int shopId;
  private String name;
  private String street;
  private String city;
  private String county;
  private String phoneNum;
  private ArrayList<Department> departmentsArrayList;

  public Shop(String name, String street, String city, String county, String phoneNum){
      this.shopId = shopId;
      this.name = name;
      this.street = street;
      this.city = city;
      this.county = county;
      this.phoneNum = phoneNum;
  }
  
  //GETTERS
  public int getShopId() {
      return shopId;
  }
  
  public String getName() {
      return name;
  }
  
  public String getStreet() {
      return street;
  }
  
  public String getCity() {
      return city;
  }
  
  public String getPhoneNum() {
      return phoneNum;
  }
  
  //SETTERS
  public void setShopId(int shopId) {
      this.shopId = shopId;
  }
  
  public void setName(String name) {
      this.name = name;
  }
  
  public void setStreet(String street) {
      this.street = street;
  }
  
  public void setCity(String city) {
      this.city = city;
  }
  
  public void setCounty(String county) {
      this.county = county;
  }
  
  public void setPhoneNum(String phoneNum) {
      this.phoneNum = phoneNum;
  }
}

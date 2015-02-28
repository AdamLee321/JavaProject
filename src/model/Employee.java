package model;/*2ndYearProject
  model
  Created by David
  18:37   25/02/2015
  Software Development 3
*/

public class Employee {
  private int empId;
  private String empFName;
  private String empLName;
  private String empUsername;
  private String empPassword;
  private String position;
  private String empStreet;
  private String empCity;
  private String empCounty;
  private String empDOB;
  private String empEmail;
  private double salary;
  //private ???? empPic BLOB


  public Employee() {
    this.empFName = "";
    this.empLName = "";
    this.empUsername = "";
    this.empPassword = "";
    this.position = "";
    this.empStreet = "";
    this.empCounty = "";
    this.empCity = "";
    this.empDOB = "";
    this.empEmail = "";
    this.salary = 0;
  }

  public Employee(String empFName, String empLName, String empUsername, String empPassword,
                  String position, String empStreet, String empCounty, String empCity,
                  String empDOB, String empEmail, double salary) {
    this.empFName = empFName;
    this.empLName = empLName;
    this.empUsername = generateUsername();
    this.empPassword = generatePassword();
    this.position = position;
    this.empStreet = empStreet;
    this.empCounty = empCounty;
    this.empCity = empCity;
    this.empDOB = empDOB;
    this.empEmail = empEmail;
    this.salary = salary;
  }


  //getters for all attributes

  //getter for ID
  public int getEmpId() {
    return empId;
  }

  //getter for first name
  public String getEmpFName() {
    return empFName;
  }

  //getter for last name
  public String getEmpLName() {
    return empLName;
  }

  //getter for username
  public String getEmpUsername() {
    return empUsername;
  }

  //getter for password
  public String getEmpPassword() {
    return empPassword;
  }

  //getter for position
  public String getPosition() {
    return position;
  }

  //getter for street
  public String getEmpStreet() {
    return empStreet;
  }

  //getter for city
  public String getEmpCity() {
    return empCity;
  }

  //getter for county
  public String getEmpCounty() {
    return empCounty;
  }

  //getter for dob
  public String getEmpDOB() {
    return empDOB;
  }

  //getter for email
  public String getEmpEmail() {
    return empEmail;
  }

  //getter for salary
  public double getSalary() {
    return salary;
  }

  // Setters for all attributes

  // setter for id
  public void setEmpId(int empId) {
    this.empId = empId;
  }

  // setter for salary
  public void setSalary(double salary) {
    this.salary = salary;
  }

  // setter for email
  public void setEmpEmail(String empEmail) {
    this.empEmail = empEmail;
  }

  //setter for DOB
  public void setEmpDOB(String empDOB) {
    this.empDOB = empDOB;
  }

  //setter for county
  public void setEmpCounty(String empCounty) {
    this.empCounty = empCounty;
  }

  //setter for city
  public void setEmpCity(String empCity) {
    this.empCity = empCity;
  }

  //setter for position
  public void setPosition(String position) {
    this.position = position;
  }

  //setter for street
  public void setEmpStreet(String empStreet) {
    this.empStreet = empStreet;
  }

  //setter for password
  public void setEmpPassword(String empPassword) {
    this.empPassword = empPassword;
  }

  //setter for username
  public void setEmpUsername(String empUsername) {
    this.empUsername = empUsername;
  }

  // setter for last name
  public void setEmpLName(String empLName) {
    this.empLName = empLName;
  }

  //setter for first name
  public void setEmpFName(String empFName) {
    this.empFName = empFName;
  }

  public String generatePassword() {
    String pass = "";
    return pass;
  }

  public String generateUsername() {
    String user = "";
    return user;
  }
}

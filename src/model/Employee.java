package model;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class Employee {

    private int empId;
    private int empDeptId;
    private String empFName;
    private String empLName;
    private String position;
    private String empStreet;
    private String empCity;
    private String empCounty;
    private String empDOBd;
    private String empDOBm;
    private String empDOBy;
    private String empEmail;
    private double salary;
    private String empUsername;
    private String empPassword;
    private byte[] empPic;

// overloaded constructor
    public Employee(int empId, int empDeptId, String empFName, String empLName, String position, String empStreet,
                    String empCity, String empCounty, String empDOBd, String empDOBm, String empDOBy, String empEmail,
                    double salary, String empUsername, String empPassword, byte[] empPic) {
        this.empId = empId;
        this.empDeptId = empDeptId;
        this.empFName = empFName;
        this.empLName = empLName;
        this.position = position;
        this.empStreet = empStreet;
        this.empCity = empCity;
        this.empCounty = empCounty;
        this.empDOBd = empDOBd;
        this.empDOBm = empDOBm;
        this.empDOBy = empDOBy;
        this.empEmail = empEmail;
        this.salary = salary;
        this.empUsername = empUsername;
        this.empPassword = empPassword;
        this.empPic = empPic;
    }

// getters

    public int getEmpId() {
        return empId;
    }

    public int getEmpDeptId() {
        return empDeptId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public String getPosition() {
        return position;
    }

    public String getEmpStreet() {
        return empStreet;
    }

    public String getEmpCity() {
        return empCity;
    }

    public String getEmpCounty() {
        return empCounty;
    }

    public String getEmpDOBd() {
        return empDOBd;
    }

    public String getEmpDOBm() {
        return empDOBm;
    }

    public String getEmpDOBy() {
        return empDOBy;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmpUsername() {
        return empUsername;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public byte[] getEmpPic() {
        return empPic;
    }

// setters

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmpStreet(String empStreet) {
        this.empStreet = empStreet;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }

    public void setEmpCounty(String empCounty) {
        this.empCounty = empCounty;
    }

    public void setEmpDOBd(String empDOBd) {
        this.empDOBd = empDOBd;
    }

    public void setEmpDOBm(String empDOBm) {
        this.empDOBm = empDOBm;
    }

    public void setEmpDOBy(String empDOBy) {
        this.empDOBy = empDOBy;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmpUsername(String empUsername) {
        this.empUsername = empUsername;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public void setEmpPic(byte[] empPic) {
        this.empPic = empPic;
    }
}

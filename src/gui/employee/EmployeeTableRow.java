package gui.employee;

import model.Employee;

/**
 * Created by DL on 05/04/2015.
 */
public class EmployeeTableRow {

    private int id;
    private String fName;
    private String lName;
    private String position;
    private int department;
    private String street;
    private String city;
    private String county;
    private String dob;
    private String email;

    public EmployeeTableRow(){
        this.id = 0;
        this.fName = "";
        this.lName = "";
        this.position = "";
        this.department = 0;
        this.street = "";
        this.city = "";
        this.county = "";
        this.dob = "";
        this.email = "";
    }

    public EmployeeTableRow(int id, String fName, String lName, String position, int department, String street,
            String city, String county, String dob, String email){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.position = position;
        this.department = department;
        this.street = street;
        this.city = city;
        this.county = county;
        this.dob = dob;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPosition() {
        return position;
    }

    public int getDepartment() {
        return department;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }
}

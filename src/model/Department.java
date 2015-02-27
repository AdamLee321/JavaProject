package model;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17
*/

public class Department {

// instance variables

    private int deptId;
    private String deptName;


// default constructor
    public Department(){

        deptId = 0;
        deptName = "";
    }

// overloaded constructor
    public Department(String deptNameIn){  // also pass database sequence id

        deptId = 0; // sequence in
        deptName = deptNameIn;
    }

    // get department id
    public int getDeptId(){

        return this.deptId;
    }

    // get department name
    public String getDeptName(){

        return this.deptName;
    }
    // set department id
    public void setDeptId(int deptIdIn){

        deptId = deptIdIn;
    }

    // set department name
    public void setDeptName(String deptNameIn){

        deptName = deptNameIn;
    }
}

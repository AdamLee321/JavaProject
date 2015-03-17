package gui.employee;
/*
import database.operations.EmployeeOperations;
import model.Employee;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
IT Tallaght - 2015, S2
Computing - Year 2, Project
Group 17 (George - 15/03/2015)
*/
/*
import java.sql.SQLException;

public class EmployeeTableModel extends AbstractTableModel {

    EmployeeOperations eo;
    Employee e;

    // populate employees
    public void addEmployees(ResultSet rset){
        try {
            rset = eo.getEmployees();
            while (rset.next()) {
                int empId = rset.getInt(1);
                int empDeptId = rset.getInt(2);
                String empFName = rset.getString(3);
                String empLName = rset.getString(4);
                String position = rset.getString(5);
                String empStreet = rset.getString(6);
                String empCity = rset.getString(7);
                String empCounty = rset.getString(8);
                int empDOBd = rset.getInt(9);
                String empDOBm = rset.getString(10);
                int empDOBy = rset.getInt(11);
                String empEmail = rset.getString(12);
                double salary  = rset.getDouble(13);
                String empUsername = rset.getString(14);
                String empPassword = rset.getString(15);
                String empPic = rset.getString(16);

                e = new Employee(empId, empDeptId, empFName,empLName, position, empStreet, empCity, empCounty, empDOBd, empDOBm, empDOBy, empEmail, salary, empUsername, empPassword, empPic);

            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
*/
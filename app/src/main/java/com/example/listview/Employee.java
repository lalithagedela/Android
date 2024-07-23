package com.example.listview;

import java.io.Serializable;

public class Employee implements Serializable {

    public  int EmployeeID;

    public String EmployeeName;
    public int  emp_profile;

    public int  getEmp_profile() {
        return emp_profile;
    }

    public void setEmp_profile(int  emp_profile) {
        this.emp_profile = emp_profile;
    }



    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeename() {
        return EmployeeName;
    }

    public void setEmployeename(String employeename) {
        EmployeeName = EmployeeName;
    }


}


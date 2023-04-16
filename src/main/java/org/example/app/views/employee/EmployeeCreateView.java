package org.example.app.views.employee;

import org.example.app.entities.Employee;

import java.sql.Date;

import static org.example.app.utils.GetDataScanner.getDataScanner;

public class EmployeeCreateView {

    public Employee getData() {

        Employee employee = new Employee();
        String exceptionMsg = "";
        employee.setFirstName(getDataScanner("Enter employee firstname: "));
        employee.setLastName(getDataScanner("Enter employee lastname: "));
        employee.setPhone(getDataScanner("Enter employee telephone number: "));
        do {
            try {
                exceptionMsg = "Wrong date format! Enter year-month-day";
                employee.setBirthDate(Date.valueOf(getDataScanner("Enter employee birth date: ")));
                exceptionMsg = "Wrong id format! Enter number";
                employee.setPositionId(Integer.parseInt(getDataScanner("Enter employee PositionId: ")));
                exceptionMsg = "Wrong salary format! Enter number like xxxxxxxxx.xx";
                employee.setSalary(Double.parseDouble(getDataScanner("Enter employee salary: ")));
                return employee;
            }
            catch (IllegalArgumentException e){
                System.out.println(exceptionMsg);
            }
        } while (true);
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}

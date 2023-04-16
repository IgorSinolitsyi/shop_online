package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeCreateRepository {

    public String createEmployee(Employee employee) {
        String sql = "INSERT INTO " + Constants.TABLE_EMPLOYEES + "(" +
                "firstname, lastname, birthdate, phone, positionId, salary) VALUES(?,?,?,?,?,?)";
        try (PreparedStatement pstmt = DBConn.connect().prepareStatement(sql)) {
            pstmt.setString(1, employee.getFirstName());
            pstmt.setString(2, employee.getLastName());
            pstmt.setDate(3, employee.getBirthDate());
            pstmt.setString(4, employee.getPhone());
            pstmt.setInt(5, employee.getPositionId());
            pstmt.setDouble(6, employee.getSalary());

            pstmt.executeUpdate();
            return Constants.DATA_INSERT_MSG;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}

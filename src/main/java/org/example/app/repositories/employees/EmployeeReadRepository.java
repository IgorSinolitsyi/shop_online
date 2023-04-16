package org.example.app.repositories.employees;

import org.example.app.database.DBConn;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeReadRepository {

    List<Employee> list;

    public List<Employee> readEmployee() {

        try (Statement stmt = DBConn.connect().createStatement()) {

            list = new ArrayList<>();

            String sql = "SELECT * From "+ Constants.TABLE_EMPLOYEES +" e INNER JOIN "+ Constants.TABLE_POSITIONS +" p ON e.positionId = p.id";

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getDate("birthDate"),
                        rs.getString("phone"),
                        rs.getString("name"),
                        rs.getDouble("salary")
                        )
                );
            }
            // Возвращаем коллекцию данных
            return list;
        } catch (SQLException e) {
            // Если ошибка - возвращаем пустую коллекцию
            return Collections.emptyList();
        }
    }
}

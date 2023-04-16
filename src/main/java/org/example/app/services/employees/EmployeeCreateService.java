package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.entities.Position;
import org.example.app.exceptions.EmployeeCreateException;
import org.example.app.exceptions.PositionCreateException;
import org.example.app.repositories.employees.EmployeeCreateRepository;
import org.example.app.repositories.positions.PositionCreateRepository;
import org.example.app.utils.*;

import java.util.HashMap;
import java.util.Map;

import static org.example.app.utils.PositionIdChecker.isIdExists;

public class EmployeeCreateService {

    EmployeeCreateRepository repository;

    public EmployeeCreateService(EmployeeCreateRepository repository) {
        this.repository = repository;
    }

    public String createEmployee(Employee employee) {

        // Map для сбора ошибок
        Map<String, String> errors = new HashMap<>();

        if  (!NameValidator.isValid(employee.getFirstName()))
            errors.put("firstname", Constants.INPUT_REQ_MSG);
        if  (!NameValidator.isValid(employee.getLastName()))
            errors.put("lastName", Constants.INPUT_REQ_MSG);
        if (!DateValidator.isValid(employee.getBirthDate()))
            errors.put("birthDate", Constants.INPUT_REQ_MSG);
        if  (!PhoneValidator.isValid(employee.getPhone()))
            errors.put("phone", Constants.INPUT_REQ_MSG);
        if (!isIdExists(employee.getPositionId()))
            errors.put("positionId", Constants.INPUT_REQ_MSG);
        if (!SalaryValidator.isValid(employee.getSalary()))
            errors.put("salary", Constants.INPUT_REQ_MSG);

        if (errors.size() > 0) {
            try {
                throw new EmployeeCreateException("Check inputs", errors);
            } catch (EmployeeCreateException e) {
                return e.getErrors(errors);
            }
        }

        return repository.createEmployee(employee);
    }
}

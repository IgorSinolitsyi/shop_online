package org.example.app.services.employees;

import org.example.app.entities.Employee;
import org.example.app.repositories.employees.EmployeeReadRepository;
import org.example.app.utils.Constants;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeReadService {

    EmployeeReadRepository repository;

    public EmployeeReadService(EmployeeReadRepository repository) {
        this.repository = repository;
    }

    public String readEmployee() {

        // Получаем данные в коллекцию.
        List<Employee> list = repository.readEmployee();

        // Если коллекция не null, формируем вывод.
        // Иначе уведомление об отсутствии данных.
        if (list != null) {
            // Если коллекция не пуста, формируем вывод.
            // Иначе уведомление об отсутствии данных.
            if (!list.isEmpty()) {

                NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.CHINA);
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((prop) ->
                            stringBuilder.append(count.incrementAndGet())
                                    .append(") id: ")
                                    .append(prop.getId())
                                    .append(", ")
                                    .append(prop.getFirstName())
                                    .append(", ")
                                    .append(prop.getLastName())
                                    .append(", ")
                                    .append(prop.getBirthDate())
                                    .append(", ")
                                    .append(prop.getPhone())
                                    .append(", ")
                                    .append(prop.getPositionName())
                                    .append(", ")
                                    .append(formatter.format(prop.getSalary()))
                                    .append("\n")
                );
                return stringBuilder.toString();
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}

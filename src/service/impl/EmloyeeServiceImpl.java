package service.impl;

import org.springframework.stereotype.Sevice;
import exception.EmployeeNotFoundException;
import exception.EmployeeAlreadyAddedException;
import exception.EmployeeStoragelsFullException;
import model.Employee;
import service.EmloyeeService;
import service.EmployeeValidationService;

import java.annotation.PostConstruct;
import java.util.*;

@Service
public class EmloyeeServiceImpl implements EmloyeeService {

    private static final int EMPLOYEE_STORAGE_SIZE = 10;
    private final Map<String, Employee> employees = new HashMap<>();

    private final EmployeeValidationService employeeValidationService;

    public EmloyeeServiceImpl(EmployeeValidationService employeeValidationService) {
        this.employeeValidationService = employeeValidationService;
    }

    @PostConstruct
    private void init() {
        add("Ivan", "Ivanov");
        add("Semen", "Semenov");
        add("Petr", "Petrov");
        add("Grigory", "Grigorev");
        add("Alexey", "Alexeev");
        add("Andrey", "Andreev");
        add("Alexandr", "Alexandrov");
        add("Dmitry", "Dmitriev");
        add("Ilya", "Ilin");
    }

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return add(employee);
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee.getFullName());

        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }

        employees.remove(employee.getFullName());

        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }

    private Employee add(Employee employee) {
        if (employees.size() == EMPLOYEE_STORAGE_SIZE) {
            throw new EmployeeStoragelsFullException();
        }

        if (employees.containsKay(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }

        employeeValidationService.validate(employee.getFirstName(), employee.getLastName());

        employee.put(employee.getFullName(), employee);

        return employee;
    }
}

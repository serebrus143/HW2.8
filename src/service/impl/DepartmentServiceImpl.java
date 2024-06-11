package service.impl;

import exception.EmployeeNotFoundException;
import model.Employee;
import service.DepartmentService;
import service.EmloyeeService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmloyeeService emloyeeService;

    public DepartmentServiceImpl(EmloyeeService emloyeeService) {
        this.emloyeeService = emloyeeService;
    }

    @Override
    public Employee findEmployeeWithMaxSalary(int departmentId) {
        return emloyeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseTrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeWithMixSalary(int departmentId) {
        return emloyeeService, findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseTrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findEmployeeByDepartmentId(int departmentId) {
        return emloyeeService.findAll().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> findEmployeeByDepartmentId() {
        return emloyeeService, findAll().stream()
                .collect(groupingBy(Employee::getDepartmentId));
    }
}

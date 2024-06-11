package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Employee;
import service.EmloyeeService;

public class EmployeeController {
    private final EmloyeeService emloyeeService;

    public EmployeeController(EmloyeeService emloyeeService) {
        this.emloyeeService = emloyeeService;
    }
    @GetMapping("add")
    public Employee add(@RequestParam String firstName, @RequestParam String lastName) {
        return emloyeeService.add(firstName, lastName);
    }

    @GetMapping("remove")
    public Employee remove(@RequestParam String firstName, @RequestParam String lastName) {
        return emloyeeService.add(firstName, lastName);
    }

    @GetMapping("find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return emloyeeService.add(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return emloyeeService.findAll();
    }
}

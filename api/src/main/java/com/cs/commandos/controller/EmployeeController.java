package com.cs.commandos.controller;

import com.cs.commandos.model.Booking;
import com.cs.commandos.model.Employee;
import com.cs.commandos.service.EmployeeService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = { "/employee/{id}" })
    public Employee getEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.getEmployee(id);
        return employee;
    }

}

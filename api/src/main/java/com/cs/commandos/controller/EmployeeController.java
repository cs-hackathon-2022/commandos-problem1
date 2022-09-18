package com.cs.commandos.controller;

import java.util.List;

import com.cs.commandos.dto.EmployeeDto;
import com.cs.commandos.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs.commandos.model.Employee;
import com.cs.commandos.service.EmployeeService;

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

    @PutMapping(path = {"/register"})
    public boolean registerEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.registerService(employee);
    }

    @PostMapping(path = {"/login"})
    public Employee loginEmployee(@RequestBody LoginDto employeeLogin) {
        return employeeService.employeeLogin(employeeLogin);
    }


}

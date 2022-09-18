package com.cs.commandos.controller;

import java.util.List;

import com.cs.commandos.dto.ApplicableEmployeeResponse;
import com.cs.commandos.dto.EmployeeApplicableSpaceDto;
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

    @PostMapping(path = {"/register"})
    public boolean registerEmployee(@RequestBody EmployeeDto employee) {
        return employeeService.registerService(employee);
    }

    @PostMapping(path = {"/login"})
    public Employee loginEmployee(@RequestBody LoginDto employeeLogin) {
        return employeeService.employeeLogin(employeeLogin);
    }

    @GetMapping(path = {"/applicableEmployees/{mgrId}"})
    public ApplicableEmployeeResponse fetchApplicableEmployee(@PathVariable("mgrId") String mgrId) {
        return employeeService.fetchApplicableEmployees(mgrId);
    }

    @GetMapping(path = {"/spaceOwners"})
    public ApplicableEmployeeResponse fetchSpaceOwners() {
        return employeeService.fetchSpaceOwners();
    }

    /* Find the empId's manager available space area and return free/allocated spaces from the allocated range. */
    @GetMapping(path = {"/availableSpaces/{empId}"})
    public EmployeeApplicableSpaceDto getAvailableSpaces(@PathVariable Long empId) {
        return employeeService.getApplicableSpaces(empId);
    }

}

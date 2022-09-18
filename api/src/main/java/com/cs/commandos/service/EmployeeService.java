package com.cs.commandos.service;

import com.cs.commandos.dto.EmployeeDto;
import com.cs.commandos.dto.LoginDto;
import com.cs.commandos.model.Employee;
import com.cs.commandos.model.Roles;
import com.cs.commandos.repository.EmployeeRepository;
import com.cs.commandos.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id) {
        Employee response = Optional.ofNullable(employeeRepository.findById(id)).get().orElse(null);
		return response;
    }

    public boolean registerService(EmployeeDto employee) {
        Employee emp = new Employee();
        long roleId = 3;
        emp.setFname(employee.getFname());
        emp.setLname(employee.getLname());
        emp.setEmail(employee.getEmail());
        emp.setMobile(employee.getMobile());
        emp.setPassword(employee.getPassword());
        emp.setManagerId(employee.getManagerId());
        Roles role = Optional.ofNullable(roleRepository.findById(roleId)).get().orElse(null);
        if(role != null) {
            emp.setRole(role);
            employeeRepository.save(emp);
            return true;
        }
        else
            return false;
    }

    public Employee employeeLogin(LoginDto employeeLogin) {
       return  Optional.ofNullable(employeeRepository.findByEmail(employeeLogin.getEmailId())).get();
    }
}

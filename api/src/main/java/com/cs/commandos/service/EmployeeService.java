package com.cs.commandos.service;

import com.cs.commandos.dto.*;
import com.cs.commandos.model.Employee;
import com.cs.commandos.model.Roles;
import com.cs.commandos.model.SpaceOwner;
import com.cs.commandos.repository.EmployeeRepository;
import com.cs.commandos.repository.RoleRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	@Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SpaceMasterService spaceMasterService;

    @Autowired
    private SpaceOwnerService spaceOwnerService;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(long id) {
        Employee response = Optional.ofNullable(employeeRepository.findById(id)).get().orElse(null);
		return response;
    }

    public boolean registerService(EmployeeDto employee) {
        Employee userExists = Optional.ofNullable(employeeRepository.findByEmail(employee.getEmail())).orElse(null);
        if(userExists != null) {
            return false;
        }
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
        try {
            return Optional.ofNullable(employeeRepository.findByEmail(employeeLogin.getEmailId())).get();
        } catch (Exception e) {
            return null;
        }
    }

    public ApplicableEmployeeResponse fetchApplicableEmployees(String mgrId) {
        try {
            List<Employee> emp = Optional.ofNullable(employeeRepository.findByManagerId(mgrId)).get();
            return getApplicableEmployeeResponse(emp);
        } catch(Exception e) {
            return null;
        }
    }

    public ApplicableEmployeeResponse fetchSpaceOwners() {
        try {
            ArrayList<Long> role = new ArrayList<>(Arrays.asList(1L,2L));
            List<Employee> emp = Optional.ofNullable(employeeRepository.findAllByRoleIdIn(role)).get();
            return getApplicableEmployeeResponse(emp);
        } catch (Exception e) {
            return null;
        }

    }

    private ApplicableEmployeeResponse getApplicableEmployeeResponse(List<Employee> emp) {
        List<ApplicableEmployees> result = emp.stream().map(
                resultmap -> {
                    ApplicableEmployees appEmp = new ApplicableEmployees();
                    appEmp.setEmpID(resultmap.getId());
                    appEmp.setRoleCode(resultmap.getRole().getRoleCode());
                    appEmp.setFname(resultmap.getFname());
                    appEmp.setLname(resultmap.getLname());
                    return appEmp;
                }).collect(Collectors.toList());
        ApplicableEmployeeResponse response = new ApplicableEmployeeResponse();
        response.setApplicableEmployees(result);
        return response;
    }

    public EmployeeApplicableSpaceDto getApplicableSpaces(Long empId) {
        try {
            Employee employee = employeeRepository.findById(empId).get();
            SpaceOwner spaceOwner = spaceOwnerService.getSpaceOwner(employee.getManagerId());
            if (spaceOwner != null) {
                EmployeeApplicableSpaceDto employeeApplicableSpaceDto = spaceMasterService.getSpaceDetails(spaceOwner.getSeatStart(), spaceOwner.getSeatEnd());
                return employeeApplicableSpaceDto;
            }

        }catch(Exception e) {
            e.printStackTrace();

        }

        return new EmployeeApplicableSpaceDto();
    }
}

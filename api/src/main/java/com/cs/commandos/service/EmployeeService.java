package com.cs.commandos.service;

import com.cs.commandos.dto.*;
import com.cs.commandos.model.Employee;
import com.cs.commandos.model.Roles;
import com.cs.commandos.model.SpaceMaster;
import com.cs.commandos.model.SpaceOwner;
import com.cs.commandos.repository.EmployeeRepository;
import com.cs.commandos.repository.RoleRepository;
import com.cs.commandos.repository.SpaceMasterRepository;
import com.cs.commandos.repository.SpaceOwnerRepository;
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
    private SpaceOwnerRepository spaceOwnerRepository;

    @Autowired
    private SpaceMasterRepository spaceMasterRepository;

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

    public boolean assignSeats(Long empId, int totalSeats) {
        try {
            EmployeeApplicableSpaceDto availableSeats = getApplicableSpaces(empId);
            int seatStart;
            int seatEnd;
            SpaceOwner spaceOwner;
            try {
                spaceOwner  = Optional.ofNullable(spaceOwnerRepository.findByEmployeeId(empId)).orElse(null);
                if(spaceOwner != null) {
                    seatStart = spaceOwner.getSeatStart();
                    seatEnd = spaceOwner.getSeatEnd() + totalSeats;
                } else {
                    spaceOwner = new SpaceOwner();
                    seatStart = Math.toIntExact(availableSeats.getAvailableSeats().get(0).getSeatId());
                    seatEnd = seatStart + totalSeats - 1;
                }
            } catch(Exception e ) {
                spaceOwner = new SpaceOwner();
                seatStart = Math.toIntExact(availableSeats.getAvailableSeats().get(0).getSeatId());
                seatEnd = seatStart + totalSeats - 1;
            }
            Employee user = Optional.ofNullable(employeeRepository.findById(empId).get()).orElse(null);

            if(user != null) {
                spaceOwner.setEmployee(user);
                spaceOwner.setSeatEnd(seatEnd);
                spaceOwner.setSeatStart(seatStart);
                spaceOwnerRepository.save(spaceOwner);
                for(int i = 0 ; i <totalSeats; i++) {
                    SpaceMaster seat = spaceMasterRepository.findById(availableSeats.getAvailableSeats().get(i).getSeatId()).get();
                    seat.setAvailabilityStatus("ALLOCATED");
                    spaceMasterRepository.save(seat);
                }
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
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

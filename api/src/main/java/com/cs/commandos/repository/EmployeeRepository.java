package com.cs.commandos.repository;

import com.cs.commandos.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByEmail(String emailId);
	List<Employee> findByManagerId(String mgrId);
	List<Employee> findAllByIdIn(List<Long> roles);
}


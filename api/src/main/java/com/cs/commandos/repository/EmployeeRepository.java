package com.cs.commandos.repository;

import com.cs.commandos.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Employee findByEmail(String emailId);
}


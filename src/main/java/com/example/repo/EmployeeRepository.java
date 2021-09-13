package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	

}

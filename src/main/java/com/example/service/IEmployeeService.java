package com.example.service;

import java.util.List;

import com.example.Employee;

public interface IEmployeeService {
	
	public Integer saveEmploy(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getOneEmployee(Integer id);
	
	void updateEmployee(Employee e);
	
	void deleteEmployee(Integer id);

}

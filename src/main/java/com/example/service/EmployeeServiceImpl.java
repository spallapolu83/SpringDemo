package com.example.service;

import com.example.Employee;
import com.example.repo.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private EmployeeRepository repo;

	@Override
	public Integer saveEmploy(Employee employee) {
		
		Employee emp = repo.save(employee);
		return emp.getId();
	}
	
	public List<Employee> getAllEmployees() {
		List<Employee> list = repo.findAll();
		return list;
	}
	
	public void deleteEmployee(Integer id) {
		  repo.deleteById(id);
		}
	
	public Employee getOneEmployee(Integer id) {
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			Employee e = opt.get();
			return e;
		}
		// TODO : else throw exception Employee not found
		return null;
	}
	
	public void updateEmployee(Employee e) {
		repo.save(e);
	}
}

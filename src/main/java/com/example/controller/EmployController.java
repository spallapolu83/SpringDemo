package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Employee;
import com.example.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployController {
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/register")
	public String showRegister() {
		return "employeeRegister";
	}
	
	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute(value = "employee") Employee employee, 
			Model model) {
		int id = service.saveEmploy(employee);
		model.addAttribute("msg", "Employ "+ id + " created");
		
		return "employeeRegister";
		                          
		
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(
			@RequestParam Integer id,
			Model model
			) 
	{
		//call service
		service.deleteEmployee(id);
		//one success message
		String message = "Employee '"+id+"' Deleted";
		model.addAttribute("message", message);
		
		//get latest data
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/all")
	public String viewAllEmployees(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/edit")
	public String showEmployeeEdit(
			@RequestParam Integer id,
			Model model
			) 
	{
		//load object from DB
		Employee employee = service.getOneEmployee(id);
		//send object to UI
		model.addAttribute("employee", employee);
		//return to View page
		return "EmployeeEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(
			@ModelAttribute Employee employee
			) 
	{
		service.updateEmployee(employee);
		return "redirect:all";
	}

}
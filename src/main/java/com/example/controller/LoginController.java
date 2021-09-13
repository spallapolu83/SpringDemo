package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.User;
import com.example.service.LoginServiceImpl;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private LoginServiceImpl servImpl;
	
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	  @PostMapping("/login") 
	  public String login(@ModelAttribute(value = "user") User user, Model
	  model) { 
		  boolean flag = servImpl.logingEmployee(user);
		  if(flag) {
			  //return new ModelAndView("redirect:/employee/all");
			  return "redirect:/employee/all";
		  } 
	  
	  model.addAttribute("userFailure", " Invalid Login details"); 
	  //return new ModelAndView("redirect:/user/login");
	  return "redirect:/user/login";
	  
	  }
	  
	@GetMapping("/register")
	public String showRegister() {
		return "UserRegister";
	}
	 	
	@PostMapping("/userRegister")
	public String userRegister(@ModelAttribute User user, Model model) {
		Integer id = servImpl.saveUser(user);
		model.addAttribute("UserAdded", "User Added "+ id +"sucessfully.");
		return "UserRegister";
	}

}

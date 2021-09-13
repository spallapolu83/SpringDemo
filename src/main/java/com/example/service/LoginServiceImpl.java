package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User;
import com.example.repo.LoginInterface;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private LoginInterface loginService;
	
	@Override
	public boolean logingEmployee(User user) {
		
		List<User> userObj = loginService.findAll();
		if(userObj.get(0).getUserName().equalsIgnoreCase(user.getUserName()) 
				&& userObj.get(0).getPassword().equalsIgnoreCase(user.getPassword())) {
			return true;
		}
		
		return false;		
		
		
	}

	@Override
	public Integer saveUser(User user) {
		user = loginService.save(user);
		return user.getUserId();
	}

}

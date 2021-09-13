package com.example.service;

import java.util.Optional;

import com.example.User;

public interface ILoginService {
	
	public boolean logingEmployee(User user);
	
	public Integer saveUser(User user);

}

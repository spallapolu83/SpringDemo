package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.User;

public interface LoginInterface extends JpaRepository<User, Integer> {
	

	@Query("select u from User u where u.userId=1")
	public User findActiveUser();
}

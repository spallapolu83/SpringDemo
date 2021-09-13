package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "usertab")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name = "userId")
	private Integer userId;
	
	@Column(name = "userfName")
	private String userfName;
	
	@Column(name = "userlName")
	private String userlName;
	
	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "userAddr")
	private String userAddr;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name = "password")
	private String password;

}

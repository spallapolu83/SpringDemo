package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "emptab")
public class Employee {
	
	@Id
	@GeneratedValue
	@Column(name = "eid")
	private Integer id;
	
	@Column(name = "ename")
	private String empName;
	
	@Column(name = "eemail", unique = true)
	private String empEmail;
	
	@Column(name = "esal")
	private Double empSal;
	
	@Column(name = "edept")
	private String empDept;
	
	@Column(name = "eaddr")
	private String empAddr;

}
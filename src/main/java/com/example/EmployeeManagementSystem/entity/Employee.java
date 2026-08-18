package com.example.EmployeeManagementSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Table(name = "emplyee")
@Data
public class Employee {
	@Id
  @NotBlank(message="email cannot be null,empty,space")
	@Email(message="enter the valid email id")
	private String email;
	@NotBlank(message="name cannot be null,empty,space")
	private String name;
	
	@Positive(message="salary should >=0")
	private String salary;
	@NotBlank(message="dept cannot be null,empty,space")
	private String department;
	
}

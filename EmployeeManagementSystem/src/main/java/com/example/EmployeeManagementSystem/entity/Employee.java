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
	private String id;
	@NotBlank
	private String name;
	@NotBlank
	@Email
	private String email;
	@Positive
	private String salary;
	@NotBlank
	private String department;
	
}

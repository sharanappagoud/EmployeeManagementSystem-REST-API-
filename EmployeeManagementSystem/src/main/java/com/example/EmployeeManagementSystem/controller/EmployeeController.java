package com.example.EmployeeManagementSystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.service.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	
	@PostMapping
	public String createEmp(@RequestBody Employee employee) {
		return employeeService.createEmp(employee);
		
	}
	
	@GetMapping("/{id}")
	public Object fetchByIdEmp(@PathVariable String id){
	return employeeService.fetchByIdEmp(id);
	}
	@GetMapping
	public List<Employee> feathAll(){
		return employeeService.feathAll();
		
	}
	@DeleteMapping("/{id}")
	public Object deleteByIdEmp(@PathVariable String id) {
		return employeeService.deleteByIdEmp(id);
	}
	@DeleteMapping
	public String deleteAll() {
		return employeeService.deleteAll();
	}
	
//	@PutMapping("/{email}")
//	public String update() {
//		return employeeService.update();
//	}
	
}

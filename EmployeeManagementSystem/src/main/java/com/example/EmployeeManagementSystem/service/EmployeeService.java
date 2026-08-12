package com.example.EmployeeManagementSystem.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;

@Service
public class EmployeeService {

	private EmployeeRepo emplyeeRepo;

	public EmployeeService(EmployeeRepo emplyeeRepo) {
		this.emplyeeRepo = emplyeeRepo;
	}
	
	
	public String createEmp(Employee employee) {
		emplyeeRepo.save(employee);
		return"employee data inserted";
		
	}
	
	public Object fetchByIdEmp(String id) {
		 Optional<Employee> op=emplyeeRepo.findById(id);
		 if(op.isPresent()) {
		return op.get();	 
		 }
		 else {
			 return "no data found withid"+id;
		 }
		
	}
	
	
	public java.util.List<Employee>  feathAll(){
		return emplyeeRepo.findAll();
	}
	
	
	public Object deleteByIdEmp(String id) {
		emplyeeRepo.deleteById(id);
		return"data delete by id";	
	}
	
	public String deleteAll() {
		emplyeeRepo.deleteAll();
		return "data delete";
	}
	
	public String update(Employee employee) {
		emplyeeRepo.save(employee);
		return"data is update";
		
	}
}

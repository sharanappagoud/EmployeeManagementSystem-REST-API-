package com.example.EmployeeManagementSystem.service;

import java.awt.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.entity.Employee;
import com.example.EmployeeManagementSystem.exception.UserNotFoundException;
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
			throw new UserNotFoundException("no data found withid"+id);
		 }
		
	}
	
	
	public java.util.List<Employee>  feathAll(){
		return emplyeeRepo.findAll();
	}
	
	
	 public String deleteByIdEmp(String id) {

	        if (!emplyeeRepo.existsById(id)) {

	            throw new UserNotFoundException(
	                    "No employee found with id: " + id
	            );
	        }

	        emplyeeRepo.deleteById(id);

	        return "Employee deleted successfully";
	    }
	
	public String deleteAll() {
		emplyeeRepo.deleteAll();
		return "data delete";
	}
	
//	public String update(Employee employee) {
//
//        if (!emplyeeRepo.ex(employee.getId())) {
//
//            throw new UserNotFoundException(
//                    "No employee found with id: " + employee.getId()
//            );
//        }
//
//        emplyeeRepo.save(employee);
//
//        return "Employee data updated";
//    }
}

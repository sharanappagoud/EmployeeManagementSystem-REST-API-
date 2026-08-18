package com.example.EmployeeManagementSystem.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> usernotfound(MethodArgumentNotValidException ex){
		
		Map<String,String> errors=new HashMap<String, String>();
		
		for(FieldError error:ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}

	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> usernotfound(UserNotFoundException userNotFoundException){
		return new ResponseEntity<String>(userNotFoundException.getMessage(),HttpStatus.NOT_FOUND);
	}
	

	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidotp(InvalidOtpException invalidOtpException){
		return new ResponseEntity<String>(invalidOtpException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<String> invalidotp(OtpExpiredException otpExpiredException){
		return new ResponseEntity<String>(otpExpiredException.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	
}

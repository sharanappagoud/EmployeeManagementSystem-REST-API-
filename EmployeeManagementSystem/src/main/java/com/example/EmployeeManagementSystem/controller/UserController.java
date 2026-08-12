package com.example.EmployeeManagementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.dto.RegisterRequest;
import com.example.EmployeeManagementSystem.dto.VerifyOtpRequest;
import com.example.EmployeeManagementSystem.service.OtpService;
import com.example.EmployeeManagementSystem.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
 private UserService userService;
 private OtpService otpService;
 
 
 
 public UserController(UserService userService, OtpService otpService) {
	this.userService = userService;
	this.otpService = otpService;
}

 @PostMapping("/register")
 private String register(@RequestBody RegisterRequest registerRequest) {
	 return userService.register(registerRequest);
 }
 
 @PostMapping("/verify-otp")
 public Object VerfiyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest) {
	return otpService.verifyOtp(verifyOtpRequest);
	 
 }
}

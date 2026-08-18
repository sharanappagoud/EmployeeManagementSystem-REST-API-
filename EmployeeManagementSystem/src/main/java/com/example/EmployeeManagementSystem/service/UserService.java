package com.example.EmployeeManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.dto.RegisterRequest;
import com.example.EmployeeManagementSystem.entity.User;
import com.example.EmployeeManagementSystem.repository.UserRepository;
import com.example.EmployeeManagementSystem.util.OtpGenerate;

@Service
public class UserService {

	private UserRepository userRepository;
    private EmailService emailService;
    private PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, EmailService emailService, PasswordEncoder passwordEncoder) {
		
		this.userRepository = userRepository;
		this.emailService = emailService;
		this.passwordEncoder = passwordEncoder;
	}

public String register(RegisterRequest registerRequest) {
	Optional<User>	ou=userRepository.findByEmail(registerRequest.getEmail());
	if(ou.isPresent()) {
		return "email id already present";	
	}
	else {
		User user=new User();
		user.setName(registerRequest.getName());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		user.setRole("USER_ROLE");
		user.setVerified(false);
		String otp=OtpGenerate.generateOtp();
		user.setOtp(otp);
		user.setOtpexpirytime(LocalDateTime.now().plusMinutes(5));
		userRepository.save(user);
		
		emailService.sendotp(registerRequest.getEmail(), otp);
		return "please check your email for OTP";
		
	}
	}
	
}

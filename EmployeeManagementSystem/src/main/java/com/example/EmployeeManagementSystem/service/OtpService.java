package com.example.EmployeeManagementSystem.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.dto.VerifyOtpRequest;
import com.example.EmployeeManagementSystem.entity.User;
import com.example.EmployeeManagementSystem.repository.UserRepository;

@Service
public class OtpService {

	private UserRepository userRepository;

	public OtpService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	
	public String verifyOtp(VerifyOtpRequest verifyOtpRequest) {
	 Optional<User> optionaluser=userRepository.findByEmail(verifyOtpRequest.getEmail());
	 if(optionaluser.isPresent()) {
		 User user=optionaluser.get();
		 
		 if(!user.getOtp().equals(verifyOtpRequest.getOtp())) {
			return "invalid otp";
			}
		 if(LocalDateTime.now().isAfter(user.getOtpexpirytime())) {
			 return"otp expired";
		 }
		 else {
			 user.setVerified(true);
			 user.setOtp(null);
			 user.setOtpexpirytime(null);
			 userRepository.save(user);
			 return"otp verified succesully";
		 }
	 }else {
		 return"user not found";
	 }
		
	}
}

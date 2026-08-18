package com.example.EmployeeManagementSystem.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	private final JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	
	public void sendotp(String toEmail,String otp) {
		SimpleMailMessage smm= new SimpleMailMessage();
		smm.setTo(toEmail);
		smm.setSubject("OTP VERIFICATION");
		smm.setText("your otp is"+" "+otp);
		javaMailSender.send(smm);
	}
	
}

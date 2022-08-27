package com.loginAndRegister.LoginAndRegister.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

	// private EmailSender

	@Autowired
	private JavaMailSender mailSender;

	public void sendMail(String sendMailTo, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("ajay16oct@gmail.com");
		message.setTo(sendMailTo);
		message.setSubject(subject);
		message.setText(body);
	
		mailSender.send(message);

		System.out.println("Mail Sent!!");

	}
}

package com.loginAndRegister.LoginAndRegister.Listener;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Entity.ValidationToken;
import com.loginAndRegister.LoginAndRegister.Service.EmailSenderService;
import com.loginAndRegister.LoginAndRegister.Service.ValidationTokenService;

import event.RegistrationCompleteEvent;

@Component
public class RegistrationEventCompleteListener implements ApplicationListener<RegistrationCompleteEvent> {

	@Autowired
	private ValidationTokenService validationServcie;

	@Autowired
	private EmailSenderService mailSender;

	@Override
	public void onApplicationEvent(RegistrationCompleteEvent event) {
		// TODO Auto-generated method stub

		User user = event.getUser();
		String applicationUrl = event.getUrl();
		sendMailToUser(user, applicationUrl);

	}

	public void sendMailToUser(User user, String applicationUrl) {
		// TODO Auto-generated method stub

		String token = UUID.randomUUID().toString();
		ValidationToken validationToken = new ValidationToken(token, user);
		validationServcie.saveToken(validationToken, user);
		applicationUrl = applicationUrl + token;
		String text = "Please click on the following link to get your account verified" + "\n" + applicationUrl;
		String subject = "Spring::User account verification";
		mailSender.sendMail(user.getUserEmailId(), subject, text);

	}

}

package com.loginAndRegister.LoginAndRegister.Listener;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Service.EmailSenderService;

import event.PasswordChangedEvent;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PasswordChangeEventListener implements ApplicationListener<PasswordChangedEvent> {

	@Autowired
	private EmailSenderService mailSender;

	@Override
	public void onApplicationEvent(PasswordChangedEvent event) {

		User user = event.getUser();
		sendMailToUser(user.getUserEmailId());

	}

	public void sendMailToUser(String userEmailId) {
		// TODO Auto-generated method stub

		String subject = "Password Changed Successfully";
		String body = "Your account password has been changed successfully ."
				+ " If this is not done by you , please report immediately!!";
		log.info("Sending mail to " + userEmailId);
		mailSender.sendMail(userEmailId, subject, body);

	}

}

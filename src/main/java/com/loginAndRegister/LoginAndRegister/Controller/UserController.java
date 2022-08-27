package com.loginAndRegister.LoginAndRegister.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Entity.ValidationToken;
import com.loginAndRegister.LoginAndRegister.Service.UserService;
import com.loginAndRegister.LoginAndRegister.Service.ValidationTokenService;

import event.PasswordChangedEvent;
import event.RegistrationCompleteEvent;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private ValidationTokenService validationTokenService;
	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping("/user")
	public User saveUser(@RequestBody User user, HttpServletRequest request) {
		userService.saveUser(user);
		publisher.publishEvent(new RegistrationCompleteEvent(user, generateUrl(request)));
		return user;
	}

	@GetMapping("/verifyUserRegistration")
	public String veriyUserRegistration(@RequestParam("token") String token) {

		ValidationToken validationToken = validationTokenService.findByToken(token);
		if (validationToken != null && validationToken.getUser() != null) {

			User user = validationToken.getUser();
			user.setEnabled(true);
			userService.updateUser(user);
			return "User Registration Successfull";
		} else
			return "Invalid User";

	}

	@PostMapping("/changePassword")
	public String changePassword(@RequestBody User userFromInput) {

		User userFromDB = userService.findByUserEmailId(userFromInput);
		if (userFromDB != null && userFromDB.isEnabled()) {

			if (userService.validatePassword(userFromInput.getOldPassWord(), userFromDB.getPassword())) {
				userFromDB.setOldPassWord(userFromDB.getPassword());
				userFromDB.setPassword(userFromInput.getPassword());
				userService.saveUser(userFromDB);
				publisher.publishEvent(new PasswordChangedEvent(userFromInput, userFromDB));
				return "Password Changed Successfully";
			} else {
				return "Password Incorrect";
			}

		} else if (userFromDB != null && !userFromDB.isEnabled()) {
			return "Please verify the account first to change the password";
		} else {
			return "No user found !!";
		}

	}

	public String generateUrl(HttpServletRequest request) {

		String url = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()
				+ "/verifyUserRegistration?token=";

		return url;
	}

}

package com.loginAndRegister.LoginAndRegister.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2A);

	@Override
	public User saveUser(User user) {

		String encryptedPassword = passwordEncoder.encode(user.getPassword());
		System.out.println(encryptedPassword);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return user;
	}

	@Override
	public User findByUserEmailId(User user) {

		User tempUser = userRepository.findByUserEmailId(user.getUserEmailId());

		return tempUser;
	}

	@Override
	public boolean validatePassword(String newPassword, String oldPassword) {

		return passwordEncoder.matches(newPassword, oldPassword);
	}

	@Override
	public void updateUser(User user) {
		
		userRepository.save(user);
		
	}

}

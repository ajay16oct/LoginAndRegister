package com.loginAndRegister.LoginAndRegister.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Entity.ValidationToken;
import com.loginAndRegister.LoginAndRegister.Repository.ValidationTokenRepository;

@Service
public class ValidationTokenServcieImpl implements ValidationTokenService {

	@Autowired
	private ValidationTokenRepository validationTokenRepository;

	@Override
	public void saveToken(ValidationToken validationToken, User user) {

		validationTokenRepository.save(validationToken);
	}

	@Override
	public ValidationToken findByToken(String token) {

		ValidationToken validationToken = validationTokenRepository.findByToken(token);
		return validationToken;
	}

}

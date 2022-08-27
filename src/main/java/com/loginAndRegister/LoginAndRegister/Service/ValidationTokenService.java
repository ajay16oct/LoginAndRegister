package com.loginAndRegister.LoginAndRegister.Service;

import com.loginAndRegister.LoginAndRegister.Entity.User;
import com.loginAndRegister.LoginAndRegister.Entity.ValidationToken;

public interface ValidationTokenService {

	public void saveToken(ValidationToken validationToken, User user);

	public ValidationToken findByToken(String token);

}

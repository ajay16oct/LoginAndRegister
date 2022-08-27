package com.loginAndRegister.LoginAndRegister.Service;

import com.loginAndRegister.LoginAndRegister.Entity.User;

public interface UserService {

	public User saveUser(User user);

	public User findByUserEmailId(User user);

	public boolean validatePassword(String newPassword, String oldPassword);

	public void updateUser(User user);
	
	

}

package com.loginAndRegister.LoginAndRegister.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginAndRegister.LoginAndRegister.Entity.ValidationToken;

@Repository
public interface ValidationTokenRepository extends JpaRepository<ValidationToken, Long> {

	
	public ValidationToken findByToken(String token);

}

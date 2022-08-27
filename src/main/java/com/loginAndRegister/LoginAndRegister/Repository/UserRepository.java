package com.loginAndRegister.LoginAndRegister.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loginAndRegister.LoginAndRegister.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findByUserEmailId(String userEmailId);

}

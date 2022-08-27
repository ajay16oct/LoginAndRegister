package com.loginAndRegister.LoginAndRegister.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	@Column(nullable = false)
	private String userName;
	@Column(nullable = false, length = 60)

	private String userEmailId;
	private String password;
	private String oldPassWord;
	private boolean isEnabled = false;
}

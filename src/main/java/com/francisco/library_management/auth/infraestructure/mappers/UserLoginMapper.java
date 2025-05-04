package com.francisco.library_management.auth.infraestructure.mappers;

import com.francisco.library_management.auth.domain.model.UserLogin;

public class UserLoginMapper {

	public static UserLogin userLoginRecivetoUserLogin(UserLogin userLoginRecive) {
		return UserLogin.builder()
				.username(userLoginRecive.getUsername())
				.password(userLoginRecive.getPassword())
				.role(userLoginRecive.getRole())
				.build();
	}
	
}

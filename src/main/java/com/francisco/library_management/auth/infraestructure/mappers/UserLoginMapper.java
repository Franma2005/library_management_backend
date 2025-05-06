package com.francisco.library_management.auth.infraestructure.mappers;

import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.infraestructure.recive.UserLoginRecive;

public class UserLoginMapper {

	public static UserLogin userLoginRecivetoUserLogin(UserLoginRecive userLoginRecive) {
		return UserLogin.builder()
				.username(userLoginRecive.getUsername())
				.password(userLoginRecive.getPassword())
				.build();
	}
	
}

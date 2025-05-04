package com.francisco.library_management.auth.infraestructure.mappers;

import com.francisco.library_management.auth.domain.model.Role;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.recive.UserRegisterRecive;

public class UserRegisterMapper {

	public static UserRegister userRegisterRecivetoUserRegister(UserRegisterRecive userRegisterRecive) {
		return UserRegister.builder()
				.username(userRegisterRecive.getUsername())
				.password(userRegisterRecive.getPassword())
				.firstName(userRegisterRecive.getFirstName())
				.lastName(userRegisterRecive.getLastName())
				.country(userRegisterRecive.getCountry())
				.role(Role.USER)
				.build();
	}
	
}

package com.francisco.library_management.auth.infraestructure.out.database;

import com.francisco.library_management.auth.application.services.ports.LoginPort;
import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.infraestructure.mappers.UserEntityMapper;

public class LoginPortImpl implements LoginPort {

	@Override
	public UserLogin login(UserLogin userLogin) {
		return null;
	}

}

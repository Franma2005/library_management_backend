package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.application.services.ports.LoginPort;
import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.infraestructure.mappers.UserEntityMapper;

@Repository
public class LoginPortImpl implements LoginPort {

	@Override
	public UserLogin login(UserLogin userLogin) {
		return null;
	}

}

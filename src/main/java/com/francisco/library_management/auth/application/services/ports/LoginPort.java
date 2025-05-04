package com.francisco.library_management.auth.application.services.ports;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.domain.model.UserLogin;

@Repository
public interface LoginPort {

	public UserLogin login(UserLogin userLogin);
	
}

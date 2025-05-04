package com.francisco.library_management.auth.application.services.ports;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.domain.model.UserRegister;

@Repository
public interface RegisterPort {
	
	public UserRegister register(UserRegister userRegister);
	
}

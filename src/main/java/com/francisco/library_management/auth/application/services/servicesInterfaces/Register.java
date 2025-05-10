package com.francisco.library_management.auth.application.services.servicesInterfaces;

import org.springframework.stereotype.Service;

import com.francisco.library_management.auth.domain.model.User;

@Service
public interface Register {

	public User register(User userRegister);
	
}

package com.francisco.library_management.auth.application.ports;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.domain.model.User;

@Repository
public interface RegisterPort {
	
	public User register(User userRegister);
	
}

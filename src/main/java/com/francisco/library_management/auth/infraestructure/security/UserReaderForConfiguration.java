package com.francisco.library_management.auth.infraestructure.security;

import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.application.services.servicesInterfaces.UserReader;
import com.francisco.library_management.auth.domain.model.AuthUser;

@Component
public class UserReaderForConfiguration {

	private UserReader userReader;
	
	public UserReaderForConfiguration(UserReader userReader) {
		this.userReader = userReader;
	}
	
	public UserDetailsImpl findUserDetailsImpl(String username) {
		AuthUser userLogin = userReader.findByUsername(username);
		return new UserDetailsImpl(
				userLogin.getUsername(),
				userLogin.getPassword(), 
				userLogin.getRole()
		);
	}
	
}

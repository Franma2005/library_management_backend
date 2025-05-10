package com.francisco.library_management.auth.infraestructure.security;

import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.application.services.ports.UserReaderPort;
import com.francisco.library_management.auth.domain.model.AuthUser;

@Component
public class UserReaderForConfiguration {

	private UserReaderPort userReaderPort;
	
	public UserReaderForConfiguration(UserReaderPort userReaderPort) {
		this.userReaderPort = userReaderPort;
	}
	
	public UserDetailsImpl findUserDetailsImpl(String username) {
		AuthUser userLogin = userReaderPort.findByUsername(username);
		return new UserDetailsImpl(
				userLogin.getUsername(),
				userLogin.getPassword(), 
				userLogin.getRole()
		);
	}
	
}

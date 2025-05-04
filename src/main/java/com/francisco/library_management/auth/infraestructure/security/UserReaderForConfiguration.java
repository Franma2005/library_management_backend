package com.francisco.library_management.auth.infraestructure.security;

import com.francisco.library_management.auth.application.services.ports.UserReaderPort;
import com.francisco.library_management.auth.domain.model.UserRegister;

public class UserReaderForConfiguration {

	private UserReaderPort userReaderPort;
	
	public UserReaderForConfiguration(UserReaderPort userReaderPort) {
		this.userReaderPort = userReaderPort;
	}
	
	public UserDetailsImpl findUserDetailsImpl(String username) {
		UserRegister userRegister = userReaderPort.findByUsername(username);
		return new UserDetailsImpl(userRegister.getUsername(), userRegister.getPassword(), userRegister.getRole());
	}
	
}

package com.francisco.library_management.auth.infraestructure.security;

import org.springframework.stereotype.Component;

import com.francisco.library_management.auth.application.services.ports.UserReaderPort;
import com.francisco.library_management.auth.domain.model.UserLogin;
import com.francisco.library_management.auth.domain.model.UserRegister;

@Component
public class UserReaderForConfiguration {

	private UserReaderPort userReaderPort;
	
	public UserReaderForConfiguration(UserReaderPort userReaderPort) {
		this.userReaderPort = userReaderPort;
	}
	
	public UserDetailsImpl findUserDetailsImpl(String username) {
		UserLogin userLogin = userReaderPort.findByUsername(username);
		System.out.println("Debbugging" + userLogin.toString());
		return new UserDetailsImpl(userLogin.getUsername(), userLogin.getPassword(), userLogin.getRole());
	}
	
}

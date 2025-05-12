package com.francisco.library_management.auth.application.services;

import org.springframework.stereotype.Service;

import com.francisco.library_management.auth.application.ports.UserReaderPort;
import com.francisco.library_management.auth.application.services.servicesInterfaces.UserReader;
import com.francisco.library_management.auth.domain.model.AuthUser;

@Service
public class UserReaderImpl implements UserReader {

	private UserReaderPort userReaderPort;
	
	public UserReaderImpl(UserReaderPort userReaderPort) {
		this.userReaderPort = userReaderPort;
	}
	
	@Override
	public AuthUser findByUsername(String username) {
		return userReaderPort.findByUsername(username);
	}
}

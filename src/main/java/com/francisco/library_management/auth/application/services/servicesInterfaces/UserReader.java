package com.francisco.library_management.auth.application.services.servicesInterfaces;

import org.springframework.stereotype.Service;

import com.francisco.library_management.auth.domain.model.AuthUser;

@Service
public interface UserReader {

	public AuthUser findByUsername(String username);
	
}

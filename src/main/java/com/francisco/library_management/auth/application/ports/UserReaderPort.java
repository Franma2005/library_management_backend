package com.francisco.library_management.auth.application.ports;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.auth.domain.model.AuthUser;

@Repository
public interface UserReaderPort {

	public AuthUser findByUsername(String username);
	
}

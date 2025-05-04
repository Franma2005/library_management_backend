package com.francisco.library_management.auth.usecase;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.auth.application.services.servicesInterfaces.Login;
import com.francisco.library_management.auth.infraestructure.AuthToken;

public class LoginUseCase {

	private Login login;
	
	public LoginUseCase(Login login) {
		this.login = login;
	}
	
	public ResponseEntity<AuthToken> login() {
		login.login(null);
		return ResponseEntity.ok(null);
	}
	
}

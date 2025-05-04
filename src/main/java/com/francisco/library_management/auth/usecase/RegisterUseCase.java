package com.francisco.library_management.auth.usecase;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.auth.application.services.servicesInterfaces.Register;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.AuthToken;

public class RegisterUseCase {

	private Register register;
	
	public RegisterUseCase(Register register) {
		this.register = register;
	}

	public ResponseEntity<AuthToken> register(UserRegister userRegister) {
		register.register(userRegister);
		return ResponseEntity.ok(null);
	}
	
}

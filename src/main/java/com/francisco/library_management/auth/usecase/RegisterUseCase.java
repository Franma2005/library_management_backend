package com.francisco.library_management.auth.usecase;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.auth.application.services.servicesInterfaces.Register;
import com.francisco.library_management.auth.domain.model.UserRegister;
import com.francisco.library_management.auth.infraestructure.AuthToken;
import com.francisco.library_management.auth.infraestructure.JwtUtils;
import com.francisco.library_management.auth.infraestructure.mappers.UserRegisterMapper;
import com.francisco.library_management.auth.infraestructure.recive.UserRegisterRecive;
import com.francisco.library_management.auth.infraestructure.security.UserDetailsImpl;

public class RegisterUseCase {

	private Register register;
	private JwtUtils jwtUtils;
	
	public RegisterUseCase(Register register, JwtUtils jwtUtils) {
		this.register = register;
		this.jwtUtils = jwtUtils;
	}

	public ResponseEntity<AuthToken> register(UserRegisterRecive userRegisterRecive) {
		UserRegister userRegister = UserRegisterMapper.userRegisterRecivetoUserRegister(userRegisterRecive);
		register.register(userRegister);
		return ResponseEntity.ok(
				AuthToken.builder()
				.token(
						jwtUtils.getToken(
								new UserDetailsImpl(userRegister.getUsername(), userRegister.getPassword(), userRegister.getRole())
						)
				)
				.build()
		);
	}
	
}

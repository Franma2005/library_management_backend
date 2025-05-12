package com.francisco.library_management.auth.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.auth.infraestructure.recive.AuthUserRecive;
import com.francisco.library_management.auth.infraestructure.recive.UserRecive;
import com.francisco.library_management.auth.infraestructure.security.jwt.AuthToken;
import com.francisco.library_management.auth.usecase.LoginUseCase;
import com.francisco.library_management.auth.usecase.RegisterUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {

	private LoginUseCase loginUseCase;
	private RegisterUseCase registerUseCase;
	
	public UserController(LoginUseCase loginUseCase, RegisterUseCase registerUseCase) {
		this.loginUseCase = loginUseCase;
		this.registerUseCase = registerUseCase;
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<AuthToken> login(
			@Valid @RequestBody AuthUserRecive userLoginRecive
	) {
		return ResponseEntity.ok(loginUseCase.login(userLoginRecive));
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<AuthToken> register(
			@Valid @RequestBody UserRecive userRegisterRecive
	) {
		return ResponseEntity.ok(registerUseCase.register(userRegisterRecive));
	}
	
}

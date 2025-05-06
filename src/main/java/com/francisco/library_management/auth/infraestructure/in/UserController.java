package com.francisco.library_management.auth.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.auth.infraestructure.AuthToken;
import com.francisco.library_management.auth.infraestructure.recive.UserLoginRecive;
import com.francisco.library_management.auth.infraestructure.recive.UserRegisterRecive;
import com.francisco.library_management.auth.usecase.LoginUseCase;
import com.francisco.library_management.auth.usecase.RegisterUseCase;

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
			@RequestBody UserLoginRecive userLoginRecive
	) {
		System.out.println("Hola 1");
		return loginUseCase.login(userLoginRecive);
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<AuthToken> register(
			@RequestBody UserRegisterRecive userRegisterRecive
	) {
		return registerUseCase.register(userRegisterRecive);
	}
}

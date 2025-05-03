package com.francisco.library_management.auth.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.auth.domain.model.AuthToken;

@RestController
@RequestMapping("/auth")
public class UserController {

	@PostMapping(value = "/login")
	public ResponseEntity<AuthToken> login() {
		return 
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<AuthToken> register() {
		return 
	}
}

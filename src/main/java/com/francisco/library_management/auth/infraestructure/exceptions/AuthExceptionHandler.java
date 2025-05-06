package com.francisco.library_management.auth.infraestructure.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.LoginException;

@RestControllerAdvice
public class AuthExceptionHandler {

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<String> loginExceptionHandle(LoginException loginException) {
		return ResponseEntity.badRequest().body(loginException.getMessage());
	}
	
}

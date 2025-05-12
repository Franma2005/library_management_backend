package com.francisco.library_management.auth.infraestructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francisco.library_management.auth.middleware.exceptions.AuthenticationTokenException;

@RestControllerAdvice
public class AuthenticationTokenExceptionHandler {

	@ExceptionHandler(AuthenticationTokenException.class)
	public ResponseEntity<String> AuthenticationTokenException(AuthenticationTokenException authenticationTokenException) {
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationTokenException.getMessage());
	}
	
}

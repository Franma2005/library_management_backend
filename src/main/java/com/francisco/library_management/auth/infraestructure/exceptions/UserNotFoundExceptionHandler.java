package com.francisco.library_management.auth.infraestructure.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.UserNotFoundException;

@RestControllerAdvice
public class UserNotFoundExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundExceptionHandle(UserNotFoundException userNotFoundException) {
		return ResponseEntity.badRequest().body(userNotFoundException.getMessage());
	}
	
}

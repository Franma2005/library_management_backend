package com.francisco.library_management.auth.infraestructure.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francisco.library_management.auth.infraestructure.exceptions.customExceptions.UserAlreadyRegisterException;

@RestControllerAdvice
public class UserAlreadyExitsHandler {

	@ExceptionHandler(UserAlreadyRegisterException.class)
	public ResponseEntity<String> userAlreadyExitsHandle(UserAlreadyRegisterException userAlreadyRegisterException) {
		return ResponseEntity.badRequest().body(userAlreadyRegisterException.getMessage());
	}
}

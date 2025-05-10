package com.francisco.library_management.auth.infraestructure.exceptions.customExceptions;


public class UserAlreadyRegisterException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserAlreadyRegisterException(String username) {
		super("The username " + username + " is already in use");
	}
	
}

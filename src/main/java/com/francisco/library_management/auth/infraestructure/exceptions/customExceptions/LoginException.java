package com.francisco.library_management.auth.infraestructure.exceptions.customExceptions;

public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LoginException() {
		super("Incorrect user credentials");
	}
	
}

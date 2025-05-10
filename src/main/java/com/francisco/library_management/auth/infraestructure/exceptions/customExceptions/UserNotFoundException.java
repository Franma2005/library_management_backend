package com.francisco.library_management.auth.infraestructure.exceptions.customExceptions;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String user) {
		super("The user " + user + " does not exist");
	}
}

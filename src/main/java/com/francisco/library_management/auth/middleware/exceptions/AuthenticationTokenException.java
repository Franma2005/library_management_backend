package com.francisco.library_management.auth.middleware.exceptions;

public class AuthenticationTokenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthenticationTokenException() {
		super("The token is not in the correct format");
	}
	
}

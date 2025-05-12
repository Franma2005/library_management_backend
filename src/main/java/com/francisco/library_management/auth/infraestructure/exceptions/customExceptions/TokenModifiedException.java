package com.francisco.library_management.auth.infraestructure.exceptions.customExceptions;

import org.springframework.stereotype.Component;

@Component
public class TokenModifiedException extends Exception {

	private static final long serialVersionUID = 1L;

	public TokenModifiedException() {
		super("The token has been manipulated");
	}
	
}

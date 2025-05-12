package com.francisco.library_management.infraestructure.exceptions.customExceptions;

public class CommandNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public CommandNotFoundException() {
		super("We cannot find the filter that has been selected for the search.");
	}
	
}

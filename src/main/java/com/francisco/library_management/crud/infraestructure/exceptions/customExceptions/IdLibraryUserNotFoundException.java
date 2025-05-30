package com.francisco.library_management.crud.infraestructure.exceptions.customExceptions;

public class IdLibraryUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdLibraryUserNotFoundException() {
		super("The loan library user is not a real library user");
	}
}

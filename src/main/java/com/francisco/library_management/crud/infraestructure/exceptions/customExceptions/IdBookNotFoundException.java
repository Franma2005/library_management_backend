package com.francisco.library_management.crud.infraestructure.exceptions.customExceptions;

public class IdBookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdBookNotFoundException() {
		super("The loan book is not a real book");
	}
}

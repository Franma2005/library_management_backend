package com.francisco.library_management.crud.infraestructure.exceptions.customExceptions;

public class IdCategoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdCategoryNotFoundException() {
		super("The book category is not a real category");
	}
	
}

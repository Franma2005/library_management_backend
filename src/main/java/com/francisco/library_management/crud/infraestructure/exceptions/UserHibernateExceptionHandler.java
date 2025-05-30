package com.francisco.library_management.crud.infraestructure.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdBookNotFoundException;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdCategoryNotFoundException;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdLibraryUserNotFoundException;

@RestControllerAdvice
public class UserHibernateExceptionHandler {

	@ExceptionHandler(IdCategoryNotFoundException.class)
	public ResponseEntity<String> idCategoryNotFoundExceptionHandle(IdCategoryNotFoundException idNotFoundException) {
		return ResponseEntity.badRequest().body(idNotFoundException.getMessage());
	}
	
	@ExceptionHandler(IdBookNotFoundException.class)
	public ResponseEntity<String> idBookNotFoundException(IdBookNotFoundException idBookNotFoundException) {
		return ResponseEntity.badRequest().body(idBookNotFoundException.getMessage());
	}
	
	@ExceptionHandler(IdLibraryUserNotFoundException.class)
	public ResponseEntity<String> idLibraryUserNotFoundException(IdLibraryUserNotFoundException idLibraryUserNotFoundException) {
		return ResponseEntity.badRequest().body(idLibraryUserNotFoundException.getMessage());
	}
	
}

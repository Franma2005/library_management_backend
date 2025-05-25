package com.francisco.library_management.crud.infraestructure.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdCategoryNotFoundException;

@RestControllerAdvice
public class UserHibernateExceptionHandler {

	@ExceptionHandler(IdCategoryNotFoundException.class)
	public ResponseEntity<String> idNotFoundExceptionHandle(IdCategoryNotFoundException idNotFoundException) {
		return ResponseEntity.badRequest().body(idNotFoundException.getMessage());
	}
	
}

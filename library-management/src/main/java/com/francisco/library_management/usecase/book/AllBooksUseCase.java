package com.francisco.library_management.usecase.book;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.book.AllBookImpl;
import com.francisco.library_management.application.services.servicesInterfaces.book.BookByCriteria;
import com.francisco.library_management.infraestructure.dto.BookDto;

public class AllBooksUseCase {

	private AllBookImpl allBookImpl;
	private BookByCriteria bookByCriteria;
	
	public ResponseEntity<List<BookDto>> findAllBook(
			Long id,
			String name,
			String author,
			String editorial,
			Long category
	) {
		return null;
	}
	
}

package com.francisco.library_management.infraestructure.in;

import java.awt.print.Book;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

	public ResponseEntity<List<Book>> getAllBooks(
			@RequestParam(required = false) long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) String editorial,
			@RequestParam(required = false) long category
	) {
		return null;
	}
	
	public ResponseEntity<Book> createBook() {
		return null;
	}
	
	public ResponseEntity<Book> updateBook() {
		return null;
	}
	
	public ResponseEntity<Book> deleteBook() {
		return null;
	}
	
}

package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.recive.BookRecive;
import com.francisco.library_management.usecase.book.AllBooksUseCase;
import com.francisco.library_management.usecase.book.CreateBookUseCase;

@RestController
@RequestMapping("/book")
public class BookController {

	private AllBooksUseCase allBooksUseCase;
	private CreateBookUseCase createBookUseCase;
	
	public BookController(AllBooksUseCase allBooksUseCase, CreateBookUseCase createBookUseCase) {
		this.allBooksUseCase = allBooksUseCase;
		this.createBookUseCase = createBookUseCase;
	}
	
	public ResponseEntity<List<BookDto>> getAllBooks(
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) String editorial,
			@RequestParam(required = false) Long category
	) {
		return allBooksUseCase.findAllBook(
				id,
				name,
				author,
				editorial,
				category
		);
	}
	
	public ResponseEntity<BookDto> createBook(
			@RequestBody BookRecive bookRecive
	) {
		return createBookUseCase.createBook(bookRecive);
	}
	
	public ResponseEntity<BookDto> updateBook() {
		return null;
	}
	
	public ResponseEntity<BookDto> deleteBook() {
		return null;
	}
	
}

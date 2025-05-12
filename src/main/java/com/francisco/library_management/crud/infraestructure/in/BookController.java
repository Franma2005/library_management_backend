package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.recive.BookRecive;
import com.francisco.library_management.usecase.book.AllBooksUseCase;
import com.francisco.library_management.usecase.book.CreateBookUseCase;
import com.francisco.library_management.usecase.book.DeleteBookUseCase;
import com.francisco.library_management.usecase.book.UpdateBookUseCase;

@RestController
@RequestMapping("/book")
public class BookController {

	private AllBooksUseCase allBooksUseCase;
	private CreateBookUseCase createBookUseCase;
	private UpdateBookUseCase updateBookUseCase;
	private DeleteBookUseCase deleteBookUseCase;
	
	public BookController(AllBooksUseCase allBooksUseCase, CreateBookUseCase createBookUseCase,
			UpdateBookUseCase updateBookUseCase, DeleteBookUseCase deleteBookUseCase) {
		this.allBooksUseCase = allBooksUseCase;
		this.createBookUseCase = createBookUseCase;
		this.updateBookUseCase = updateBookUseCase;
		this.deleteBookUseCase = deleteBookUseCase;
	}
	
	@GetMapping("/")
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
	
	@PostMapping("/")
	public ResponseEntity<BookDto> createBook(
			@RequestBody BookRecive bookRecive
	) {
		return createBookUseCase.createBook(bookRecive);
	}
	
	@PutMapping("/")
	public ResponseEntity<BookDto> updateBook(
			@RequestBody BookRecive bookRecive		
	) {
		return updateBookUseCase.uploadBook(bookRecive);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<BookDto> deleteBook(
			@RequestParam Long id
	) {
		return deleteBookUseCase.deleteBook(id);
	}
	
}

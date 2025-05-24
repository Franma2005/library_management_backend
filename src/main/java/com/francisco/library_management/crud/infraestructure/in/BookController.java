package com.francisco.library_management.crud.infraestructure.in;

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

import com.francisco.library_management.crud.infraestructure.dto.BookDto;
import com.francisco.library_management.crud.infraestructure.recive.BookRecive;
import com.francisco.library_management.crud.usecase.book.AllBooksUseCase;
import com.francisco.library_management.crud.usecase.book.CreateBookUseCase;
import com.francisco.library_management.crud.usecase.book.DeleteBookUseCase;
import com.francisco.library_management.crud.usecase.book.UpdateBookUseCase;

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
		return ResponseEntity.ok(
			allBooksUseCase.findAllBook(
				id,
				name,
				author,
				editorial,
				category
		));
	}
	
	@PostMapping("/")
	public ResponseEntity<BookDto> createBook(
			@RequestBody BookRecive bookRecive
	) {
		return ResponseEntity.ok(
				createBookUseCase.createBook(bookRecive)
		);
	}
	
	@PutMapping("/")
	public ResponseEntity<BookDto> updateBook(
			@RequestBody BookRecive bookRecive		
	) {
		return ResponseEntity.ok(
				updateBookUseCase.uploadBook(bookRecive)
		);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<BookDto> deleteBook(
			@RequestParam Long id
	) {
		return ResponseEntity.ok(
				deleteBookUseCase.deleteBook(id)
		);
	}
	
}

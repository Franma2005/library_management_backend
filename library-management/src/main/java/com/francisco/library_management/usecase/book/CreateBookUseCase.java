package com.francisco.library_management.usecase.book;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.book.CreateBookImpl;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.mapper.BookMapper;
import com.francisco.library_management.infraestructure.recive.BookRecive;

public class CreateBookUseCase {
	
	private CreateBookImpl createBookImpl;
	
	public CreateBookUseCase(CreateBookImpl createBookImpl) {
		this.createBookImpl = createBookImpl;
	}

	public ResponseEntity<BookDto> createBook(BookRecive bookRecive) {
		Book book = BookMapper.bookReciveToBook(bookRecive);
		createBookImpl.createBook(book);
		BookDto bookDto = BookMapper.bookToBookDto(book);
		return ResponseEntity.ok(bookDto);
	}
	
}

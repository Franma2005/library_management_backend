package com.francisco.library_management.usecase.book;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.ports.book.UpdateBookRepository;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.mapper.BookMapper;
import com.francisco.library_management.infraestructure.recive.BookRecive;

@Component
public class UpdateBookUseCase {

	private UpdateBookRepository uploadBookRepository;
	
	public UpdateBookUseCase(UpdateBookRepository uploadBookRepository) {
		this.uploadBookRepository = uploadBookRepository;
	}
	
	public ResponseEntity<BookDto> uploadBook(BookRecive bookRecive) {
		Book book = BookMapper.bookReciveToBook(bookRecive);
		uploadBookRepository.updateBook(book);
		BookDto bookDto = BookMapper.bookToBookDto(book);
		return ResponseEntity.ok(bookDto);
	}
}

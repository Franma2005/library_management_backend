package com.francisco.library_management.usecase.book;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.ports.book.UploadBookRepository;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.mapper.BookMapper;
import com.francisco.library_management.infraestructure.recive.BookRecive;

public class UploadBookUseCase {

	private UploadBookRepository uploadBookRepository;
	
	public UploadBookUseCase(UploadBookRepository uploadBookRepository) {
		this.uploadBookRepository = uploadBookRepository;
	}
	
	public ResponseEntity<BookDto> uploadBook(BookRecive bookRecive) {
		Book book = BookMapper.bookReciveToBook(bookRecive);
		
		uploadBookRepository.uploadBook(book);
		
		BookDto bookDto = BookMapper.bookToBookDto(book);
		
		return ResponseEntity.ok(bookDto);
	}
}

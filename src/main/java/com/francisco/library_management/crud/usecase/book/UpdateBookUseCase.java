package com.francisco.library_management.crud.usecase.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.ports.book.UpdateBookRepository;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.dto.BookDto;
import com.francisco.library_management.crud.infraestructure.mapper.BookMapper;
import com.francisco.library_management.crud.infraestructure.recive.BookRecive;

@Component
public class UpdateBookUseCase {

	private UpdateBookRepository uploadBookRepository;
	
	public UpdateBookUseCase(UpdateBookRepository uploadBookRepository) {
		this.uploadBookRepository = uploadBookRepository;
	}
	
	public BookDto uploadBook(BookRecive bookRecive) {
		Book book = BookMapper.bookReciveToBook(bookRecive);
		Book bookResponse = uploadBookRepository.updateBook(book);
		BookDto bookDto = BookMapper.bookToBookDto(bookResponse);
		return bookDto;
	}
}

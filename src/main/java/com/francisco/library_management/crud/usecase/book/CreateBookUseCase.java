package com.francisco.library_management.crud.usecase.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.book.CreateBookImpl;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.dto.BookDto;
import com.francisco.library_management.crud.infraestructure.mapper.BookMapper;
import com.francisco.library_management.crud.infraestructure.recive.BookRecive;

@Component
public class CreateBookUseCase {
	
	private CreateBookImpl createBookImpl;
	
	public CreateBookUseCase(CreateBookImpl createBookImpl) {
		this.createBookImpl = createBookImpl;
	}

	public BookDto createBook(BookRecive bookRecive) {
		Book book = BookMapper.bookReciveToBook(bookRecive);
		Book bookResponse = createBookImpl.createBook(book);
		BookDto bookDto = BookMapper.bookToBookDto(bookResponse);
		return bookDto;
	}
	
}

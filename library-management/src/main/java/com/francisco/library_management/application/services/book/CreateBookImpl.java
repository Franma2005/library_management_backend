package com.francisco.library_management.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.CreateBookRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.CreateBook;
import com.francisco.library_management.domain.models.Book;

@Service
public class CreateBookImpl implements CreateBook {

	private CreateBookRepository createBookRepository;
	
	public CreateBookImpl(CreateBookRepository createBookRepository) {
		this.createBookRepository = createBookRepository;
	}
	
	@Override
	public void createBook(Book book) {
		createBookRepository.createBook(book);
	}
	
}

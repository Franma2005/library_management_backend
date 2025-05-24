package com.francisco.library_management.crud.application.services.book;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Book;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.AllBooksRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.AllBooks;

@Service
public class AllBookImpl implements AllBooks {

	private AllBooksRepository allBooksRepository;
	
	public AllBookImpl(AllBooksRepository allBooksRepository) {
		this.allBooksRepository = allBooksRepository;
	}
	
	@Override
	public List<Book> getAllBooks() {
		return allBooksRepository.getAllBooks();
	}

}

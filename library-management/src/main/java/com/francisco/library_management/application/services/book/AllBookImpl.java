package com.francisco.library_management.application.services.book;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.AllBooksRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.AllBooks;
import com.francisco.library_management.domain.models.Book;

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

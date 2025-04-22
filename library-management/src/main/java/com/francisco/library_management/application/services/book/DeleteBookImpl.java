package com.francisco.library_management.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.DeleteBook;

@Service
public class DeleteBookImpl implements DeleteBook {

	private DeleteBookRepository deleteBookRepository;
	
	public DeleteBookImpl(DeleteBookRepository deleteBookRepository) {
		this.deleteBookRepository = deleteBookRepository;
	}
	
	@Override
	public void deleteBook(long id) {
		deleteBookRepository.deleteBook(id);
	}

	
}

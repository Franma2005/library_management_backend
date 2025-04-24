package com.francisco.library_management.usecase.book;

import com.francisco.library_management.application.services.book.DeleteBookImpl;
import com.francisco.library_management.infraestructure.dto.BookDto;

public class DeleteBookUseCase {

	private DeleteBookImpl deleteBookImpl;
	
	public DeleteBookUseCase(DeleteBookImpl deleteBookImpl) {
		this.deleteBookImpl = deleteBookImpl;
	}
	
	public BookDto deleteBook(long id) {
		deleteBookImpl.deleteBook(id);
		
		return null;
	}
	
}

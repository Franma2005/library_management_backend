package com.francisco.library_management.infraestructure.out.database.book;

import com.francisco.library_management.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.infraestructure.out.database.repositories.BookRepositoryDatabase;

public class DeleteBookRepositoryImpl implements DeleteBookRepository {

	private BookRepositoryDatabase bookRepositoryDatabase;
	
	public DeleteBookRepositoryImpl(BookRepositoryDatabase bookRepositoryDatabase) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
	}

	@Override
	public boolean deleteBook(long id) {
		
		bookRepositoryDatabase.delete(null);
		return false;
	}
	
}

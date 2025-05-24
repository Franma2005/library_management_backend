package com.francisco.library_management.crud.application.ports.book;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteBookRepository {
	
	public boolean deleteBook(long id);
	
}

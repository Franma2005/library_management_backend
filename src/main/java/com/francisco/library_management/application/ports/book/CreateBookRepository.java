package com.francisco.library_management.application.ports.book;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Book;

@Repository
public interface CreateBookRepository {
	
	public boolean createBook(Book book);
	
}

package com.francisco.library_management.crud.application.ports.book;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.models.Book;

@Repository
public interface UpdateBookRepository {
	
	public Book updateBook(Book book);
	
}

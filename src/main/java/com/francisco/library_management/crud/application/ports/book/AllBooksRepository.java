package com.francisco.library_management.application.ports.book;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Book;

@Repository
public interface AllBooksRepository {
	
	public List<Book> getAllBooks();
	
}

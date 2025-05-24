package com.francisco.library_management.crud.application.ports.book;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface AllBooksRepository {
	
	public List<Book> getAllBooks();
	
}

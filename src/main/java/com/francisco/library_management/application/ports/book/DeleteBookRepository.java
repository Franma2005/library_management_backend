package com.francisco.library_management.application.ports.book;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteBookRepository {
	boolean deleteBook(long id);
}

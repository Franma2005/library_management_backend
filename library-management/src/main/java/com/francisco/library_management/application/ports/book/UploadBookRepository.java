package com.francisco.library_management.application.ports.book;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Book;

@Repository
public interface UploadBookRepository {
	boolean uploadBook(Book book);
}

package com.francisco.library_management.infraestructure.out.database.book;

import com.francisco.library_management.application.ports.book.CreateBookRepository;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.mapper.BookMapper;
import com.francisco.library_management.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.BookRepositoryDatabase;

public class CreateBookRepositoryImpl implements CreateBookRepository {

	private BookRepositoryDatabase bookRepositoryDatabase;
	
	public CreateBookRepositoryImpl(BookRepositoryDatabase bookRepositoryDatabase) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
	}

	@Override
	public boolean createBook(Book book) {
		BookEntity bookEntity = mapToBookEntity(book);
		bookRepositoryDatabase.save(bookEntity);
		return true;
	}
	
	private BookEntity mapToBookEntity(Book book) {
		return BookMapper.bookToBookEntity(book);
	}
}

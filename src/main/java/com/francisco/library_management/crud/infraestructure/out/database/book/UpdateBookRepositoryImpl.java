package com.francisco.library_management.infraestructure.out.database.book;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.book.UpdateBookRepository;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.mapper.BookMapper;
import com.francisco.library_management.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.BookRepositoryDatabase;

@Repository
public class UpdateBookRepositoryImpl implements UpdateBookRepository {

	private BookRepositoryDatabase bookRepositoryDatabase;
	
	public UpdateBookRepositoryImpl(BookRepositoryDatabase bookRepositoryDatabase) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
	}

	@Override
	public boolean updateBook(Book book) {
		BookEntity bookEntity = mapToBookEntity(book);
		bookRepositoryDatabase.save(bookEntity);
		return false;
	}
	
	private BookEntity mapToBookEntity(Book book) {
		return BookMapper.bookToBookEntity(book);
	}
	
}

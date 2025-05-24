package com.francisco.library_management.crud.infraestructure.out.database.book;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.book.CreateBookRepository;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.mapper.BookMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;

@Repository
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

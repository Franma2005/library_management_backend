package com.francisco.library_management.crud.infraestructure.out.database.book;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.book.AllBooksRepository;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.mapper.BookGroupMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;

@Repository
public class AllBooksRepositoryImpl implements AllBooksRepository {

	private BookRepositoryDatabase bookRepositoryDatabase;
	
	public AllBooksRepositoryImpl(BookRepositoryDatabase bookRepositoryDatabase) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
	}
	
	@Override
	public List<Book> getAllBooks() {
		List<BookEntity> bookEntityGroup = bookRepositoryDatabase.findAll();
		List<Book> bookGroup = mapToBookGroup(bookEntityGroup);
		return bookGroup;
	}
	
	private List<Book> mapToBookGroup(List<BookEntity> bookEntityGroup) {
		return BookGroupMapper.bookEntityGrouptoBookEntity(bookEntityGroup);
	}

}

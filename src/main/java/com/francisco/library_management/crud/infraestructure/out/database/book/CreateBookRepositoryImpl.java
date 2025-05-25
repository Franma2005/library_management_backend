package com.francisco.library_management.crud.infraestructure.out.database.book;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.book.CreateBookRepository;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdCategoryNotFoundException;
import com.francisco.library_management.crud.infraestructure.mapper.BookMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

@Repository
public class CreateBookRepositoryImpl implements CreateBookRepository {

	private final BookRepositoryDatabase bookRepositoryDatabase;
	private final CategoryRepositoryDatabase categoryRepositoryDatabase;
	
	public CreateBookRepositoryImpl(
			BookRepositoryDatabase bookRepositoryDatabase,
			CategoryRepositoryDatabase categoryRepositoryDatabase
	) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
	}

	@Override
	public Book createBook(Book book) {
		BookEntity bookEntity = mapToBookEntity(book);
		bookRepositoryDatabase.save(bookEntity);
		return mapToBook(bookEntity);
	}
	
	private BookEntity mapToBookEntity(Book book) {
		Optional<CategoryEntity> categoryEntity =
				categoryRepositoryDatabase.findById(book.getCategoryId());
		
		if(categoryEntity.isEmpty()) throw new IdCategoryNotFoundException();
		System.out.println(categoryEntity.toString());
		return BookMapper.bookToBookEntity(book, categoryEntity.get());
	}
	
	private Book mapToBook(BookEntity bookEntity) {
		return BookMapper.bookEntityToBook(bookEntity);
	}
	
}

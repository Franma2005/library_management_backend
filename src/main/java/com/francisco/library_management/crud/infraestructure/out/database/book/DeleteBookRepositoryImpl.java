package com.francisco.library_management.crud.infraestructure.out.database.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdCategoryNotFoundException;
import com.francisco.library_management.crud.infraestructure.mapper.BookMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.CategoryRepositoryDatabase;

@Repository
public class DeleteBookRepositoryImpl implements DeleteBookRepository {

	private final BookRepositoryDatabase bookRepositoryDatabase;
	private final BookByCriteriaRepositoryImpl bookByCriteriaRepositoryImpl;
	private final CategoryRepositoryDatabase categoryRepositoryDatabase;
	
	public DeleteBookRepositoryImpl(
			BookRepositoryDatabase bookRepositoryDatabase,
			BookByCriteriaRepositoryImpl bookByCriteriaRepositoryImpl,
			CategoryRepositoryDatabase categoryRepositoryDatabase
	) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.bookByCriteriaRepositoryImpl = bookByCriteriaRepositoryImpl;
		this.categoryRepositoryDatabase = categoryRepositoryDatabase;
	}

	@Override
	public boolean deleteBook(long id) {
		Book book = getBookForDelete(id);
		BookEntity bookEntity = mapToBookEntity(book);
		bookRepositoryDatabase.delete(bookEntity);
		return false;
	}
	
	private BookEntity mapToBookEntity(Book book) {
		Optional<CategoryEntity> categoryEntity =
				categoryRepositoryDatabase.findById(book.getCategoryId());
		
		if(categoryEntity.isEmpty()) throw new IdCategoryNotFoundException();
		return BookMapper.bookToBookEntity(book, categoryEntity.get());
	}
	
	private Book getBookForDelete(long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.of(id))
				.build();
		List<Book> book =
				bookByCriteriaRepositoryImpl.findBookByCriteria(criteria);
		return book.get(0);
	}
	
}

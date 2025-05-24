package com.francisco.library_management.crud.infraestructure.out.database.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.mapper.BookMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;

@Repository
public class DeleteBookRepositoryImpl implements DeleteBookRepository {

	private BookRepositoryDatabase bookRepositoryDatabase;
	private BookByCriteriaRepositoryImpl bookByCriteriaRepositoryImpl;
	
	public DeleteBookRepositoryImpl(BookRepositoryDatabase bookRepositoryDatabase,
			BookByCriteriaRepositoryImpl bookByCriteriaRepositoryImpl) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.bookByCriteriaRepositoryImpl = bookByCriteriaRepositoryImpl;
	}

	@Override
	public boolean deleteBook(long id) {
		Book book = getBookForDelete(id);
		BookEntity bookEntity = mapToBookEntity(book);
		bookRepositoryDatabase.delete(bookEntity);
		return false;
	}
	
	private BookEntity mapToBookEntity(Book book) {
		return BookMapper.bookToBookEntity(book);
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

package com.francisco.library_management.infraestructure.out.database.book;

import java.util.List;
import java.util.Optional;

import com.francisco.library_management.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.mapper.BookMapper;
import com.francisco.library_management.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.BookRepositoryDatabase;

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

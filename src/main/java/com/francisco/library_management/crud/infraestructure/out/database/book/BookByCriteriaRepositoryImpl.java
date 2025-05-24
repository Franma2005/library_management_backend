package com.francisco.library_management.crud.infraestructure.out.database.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.book.BookByCriteriaRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.Filter;
import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.filters.command.registry.BookFilterCommandRegistry;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyBookCommand;
import com.francisco.library_management.crud.infraestructure.mapper.BookGroupMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;

@Repository
public class BookByCriteriaRepositoryImpl implements BookByCriteriaRepository {

	private BookRepositoryDatabase bookRepositoryDatabase;
	private BookFilterCommandRegistry bookFilterCommandRegistry;
	
	public BookByCriteriaRepositoryImpl(BookRepositoryDatabase bookRepositoryDatabase,
			BookFilterCommandRegistry bookFilterCommandRegistry) {
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.bookFilterCommandRegistry = bookFilterCommandRegistry;
	}

	@Override
	public List<Book> findBookByCriteria(Criteria criteria) {
		List<BookEntity> bookEntityGroup = bookRepositoryDatabase.findAll();
		List<Book> bookGroup = mapToBookGroup(bookEntityGroup);
		
		if(!criteria.getFilter().isEmpty())
			bookGroup = filter(bookGroup, criteria);
		
		return bookGroup;
	}
	
	private List<Book> mapToBookGroup(List<BookEntity> bookEntityGroup) {
		return BookGroupMapper.bookEntityGrouptoBookEntity(bookEntityGroup);
	}
	
	private List<Book> filter(List<Book> bookGroup, Criteria criteria) {
		List<Book> bookGroupFilter = new ArrayList<Book>();
		for (Book book : bookGroup) {
			if(matchesCriteria(book, criteria.getFilter()))
				bookGroupFilter.add(book);
		}
		
		return bookGroupFilter;
	}
	
	private boolean matchesCriteria(Book book, List<Filter<?>> filters) {
		boolean allFiltersComplete = true;
		
		for (Filter<?> filter : filters) {
			if(!matchesFilter(book, filter))
				allFiltersComplete = false;
		}
		
		return allFiltersComplete;
	}
	
	private boolean matchesFilter(Book book, Filter<?> filter) {
		String field = filter.getField();
		Object value = filter.getValue();
		
		MyBookCommand myBookCommand = bookFilterCommandRegistry.getCommand(field);
		return myBookCommand.execute(book, value);
	}
	
}

package com.francisco.library_management.crud.application.services.book;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Book;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.BookByCriteriaRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.BookByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;

@Service
public class BookByCriteriaImpl implements BookByCriteria {

	private BookByCriteriaRepository bookByCriteriaRepository;
	
	public BookByCriteriaImpl(BookByCriteriaRepository bookByCriteriaRepository) {
		this.bookByCriteriaRepository = bookByCriteriaRepository;
	}
	
	@Override
	public List<Book> getBookByCriteria(Criteria criteria) {
		return bookByCriteriaRepository.findBookByCriteria(criteria);
	}

}

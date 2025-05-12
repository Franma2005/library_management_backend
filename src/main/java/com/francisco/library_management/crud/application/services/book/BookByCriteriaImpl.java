package com.francisco.library_management.application.services.book;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.BookByCriteriaRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.BookByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Book;

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

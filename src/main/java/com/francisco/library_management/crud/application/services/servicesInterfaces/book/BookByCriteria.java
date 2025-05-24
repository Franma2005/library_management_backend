package com.francisco.library_management.crud.application.services.servicesInterfaces.book;

import java.util.List;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.models.Book;

public interface BookByCriteria {
	
	public List<Book> getBookByCriteria(Criteria criteria);
	
}

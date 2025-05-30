package com.francisco.library_management.crud.application.ports.book;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.models.Book;

@Repository
public interface BookByCriteriaRepository {

	public List<Book> findBookByCriteria(Criteria criteria);
	
}

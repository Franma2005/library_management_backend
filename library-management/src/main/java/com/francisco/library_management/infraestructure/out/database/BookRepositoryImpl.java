package com.francisco.library_management.infraestructure.out.database;

import java.util.List;

import com.francisco.library_management.application.ports.book.BookRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Book;

public class BookRepositoryImpl implements BookRepository {

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> findBookByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteBook(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

package com.francisco.library_management.usecase.book;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.francisco.library_management.application.services.book.AllBookImpl;
import com.francisco.library_management.application.services.servicesInterfaces.book.BookByCriteria;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.mapper.BookGroupMapper;

public class AllBooksUseCase {

	private AllBookImpl allBookImpl;
	private BookByCriteria bookByCriteria;
	
	public AllBooksUseCase(AllBookImpl allBookImpl, BookByCriteria bookByCriteria) {
		this.allBookImpl = allBookImpl;
		this.bookByCriteria = bookByCriteria;
	}
	
	public ResponseEntity<List<BookDto>> findAllBook(
			Long id,
			String name,
			String author,
			String editorial,
			Long category
	) {
		
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		
		List<Book> book = criteria.getFilter().isEmpty() ?
				allBookImpl.getAllBooks()
				:
				bookByCriteria.getBookByCriteria(criteria);
		
		List<BookDto> bookDto = BookGroupMapper.bookGrouptoBookGroupDto(book);
		
		return ResponseEntity.ok(bookDto);
	}
	
}

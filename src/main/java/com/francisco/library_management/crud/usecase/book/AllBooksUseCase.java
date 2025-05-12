package com.francisco.library_management.usecase.book;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.book.AllBookImpl;
import com.francisco.library_management.application.services.book.BookByCriteriaImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.mapper.BookGroupMapper;

@Component
public class AllBooksUseCase {

	private AllBookImpl allBookImpl;
	private BookByCriteriaImpl bookByCriteriaImpl;
	
	public AllBooksUseCase(AllBookImpl allBookImpl, BookByCriteriaImpl bookByCriteriaImpl) {
		this.allBookImpl = allBookImpl;
		this.bookByCriteriaImpl = bookByCriteriaImpl;
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
				bookByCriteriaImpl.getBookByCriteria(criteria);
		
		return ResponseEntity.ok(
				BookGroupMapper.bookGrouptoBookGroupDto(book)
			);
	}
	
}

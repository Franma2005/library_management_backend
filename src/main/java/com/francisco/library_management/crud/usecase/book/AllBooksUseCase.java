package com.francisco.library_management.crud.usecase.book;

import java.util.List;
import java.util.Optional;

import com.francisco.library_management.crud.domain.models.Book;
import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.book.AllBookImpl;
import com.francisco.library_management.crud.application.services.book.BookByCriteriaImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.infraestructure.dto.BookDto;
import com.francisco.library_management.crud.infraestructure.mapper.BookGroupMapper;

@Component
public class AllBooksUseCase {

	private AllBookImpl allBookImpl;
	private BookByCriteriaImpl bookByCriteriaImpl;
	
	public AllBooksUseCase(AllBookImpl allBookImpl, BookByCriteriaImpl bookByCriteriaImpl) {
		this.allBookImpl = allBookImpl;
		this.bookByCriteriaImpl = bookByCriteriaImpl;
	}
	
	public List<BookDto> findAllBook(
			Long id,
			String name,
			String author,
			String editorial,
			Long category
	) {
		
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.addFilterIfPresent("name", Optional.ofNullable(name))
				.addFilterIfPresent("author", Optional.ofNullable(author))
				.addFilterIfPresent("editorial", Optional.ofNullable(editorial))
				.addFilterIfPresent("category", Optional.ofNullable(category))
				.build();
		
		List<Book> book = criteria.getFilter().isEmpty() ?
				allBookImpl.getAllBooks()
				:
				bookByCriteriaImpl.getBookByCriteria(criteria);
		
		return BookGroupMapper.bookGrouptoBookGroupDto(book);
	}
	
}

package com.francisco.library_management.usecase.book;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.book.BookByCriteriaImpl;
import com.francisco.library_management.application.services.book.DeleteBookImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.mapper.BookMapper;

@Component
public class DeleteBookUseCase {

	private DeleteBookImpl deleteBookImpl;
	private BookByCriteriaImpl bookByCriteriaImpl;
	
	public DeleteBookUseCase(DeleteBookImpl deleteBookImpl,
			BookByCriteriaImpl bookByCriteriaImpl) {
		this.deleteBookImpl = deleteBookImpl;
		this.bookByCriteriaImpl = bookByCriteriaImpl;
	}
	
	public ResponseEntity<BookDto> deleteBook(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<Book> bookGroup = bookByCriteriaImpl.getBookByCriteria(criteria);
		deleteBookImpl.deleteBook(id);
		return ResponseEntity.ok(
				BookMapper.bookToBookDto(bookGroup.get(0))
		);
	}
	
}

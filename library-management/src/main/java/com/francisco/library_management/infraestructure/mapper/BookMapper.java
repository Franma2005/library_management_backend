package com.francisco.library_management.infraestructure.mapper;


import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.recive.BookRecive;

public class BookMapper {

	public static Book bookReciveToBook(BookRecive bookRecive) {
		return Book.builder()
				.id(bookRecive.getId())
				.name(bookRecive.getName())
				.author(bookRecive.getAuthor())
				.editorial(bookRecive.getEditorial())
				.category(bookRecive.getCategory())
				.build();
	}
	
	public static BookDto bookReciveToBookDto(Book book) {
		return BookDto.builder()
				.id(book.getId())
				.name(book.getName())
				.author(book.getAuthor())
				.editorial(book.getEditorial())
				.category(book.getCategory())
				.build();
	}
	
}

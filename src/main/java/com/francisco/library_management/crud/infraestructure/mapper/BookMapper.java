package com.francisco.library_management.crud.infraestructure.mapper;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.dto.BookDto;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.recive.BookRecive;

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
	
	public static Book bookEntityToBook(BookEntity bookEntity) {
		return Book.builder()
				.id(0)
				.name(bookEntity.getName())
				.author(bookEntity.getAuthor())
				.editorial(bookEntity.getEditorial())
				.category(bookEntity.getCategory())
				.build();
	}
	
	public static BookDto bookToBookDto(Book book) {
		return BookDto.builder()
				.id(book.getId())
				.name(book.getName())
				.author(book.getAuthor())
				.editorial(book.getEditorial())
				.category(book.getCategory())
				.build();
	}
	
	public static BookEntity bookToBookEntity(Book book) {
		return BookEntity.builder()
				.id(book.getId())
				.name(book.getName())
				.author(book.getAuthor())
				.editorial(book.getEditorial())
				.category(book.getCategory())
				.build();
	}
	
}

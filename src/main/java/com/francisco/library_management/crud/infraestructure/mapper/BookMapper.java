package com.francisco.library_management.crud.infraestructure.mapper;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.dto.BookDto;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.CategoryEntity;
import com.francisco.library_management.crud.infraestructure.recive.BookRecive;

public class BookMapper {

	public static Book bookReciveToBook(BookRecive bookRecive) {
		return Book.builder()
				.id(bookRecive.getId())
				.name(bookRecive.getName())
				.author(bookRecive.getAuthor())
				.editorial(bookRecive.getEditorial())
				.categoryId(bookRecive.getCategory())
				.build();
	}
	
	public static Book bookEntityToBook(BookEntity bookEntity) {
		return Book.builder()
				.id(bookEntity.getId())
				.name(bookEntity.getName())
				.author(bookEntity.getAuthor())
				.editorial(bookEntity.getEditorial())
				.categoryId(bookEntity.getCategory().getId())
				.category(CategoryMapper.categoryEntitytoCategory(bookEntity.getCategory()))
				.build();
	}
	
	public static BookDto bookToBookDto(Book book) {
		return BookDto.builder()
				.id(book.getId())
				.name(book.getName())
				.author(book.getAuthor())
				.editorial(book.getEditorial())
				.category(CategoryMapper.categorytoCategoryDto(book.getCategory()))
				.build();
	}
	
	public static BookEntity bookToBookEntity(Book book, CategoryEntity categoryEntity) {
		return BookEntity.builder()
				.id(book.getId())
				.name(book.getName())
				.author(book.getAuthor())
				.editorial(book.getEditorial())
				.category(categoryEntity)
				.build();
	}
	
}

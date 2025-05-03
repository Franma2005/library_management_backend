package com.francisco.library_management.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.dto.BookDto;
import com.francisco.library_management.infraestructure.recive.BookRecive;

public class BookGroupMapper {

	public static List<Book> bookGroupRecivetoBookGroup(List<BookRecive> bookGroupRecive) {
		List<Book> bookGroup = new ArrayList<Book>();
		
		for (BookRecive bookRecive : bookGroupRecive) {
			bookGroup.add(
					BookMapper.bookReciveToBook(bookRecive)
			);
		}
		
		return bookGroup;
	}
	
	public static List<BookDto> bookGrouptoBookGroupDto(List<Book> bookGroup) {
		List<BookDto> bookDtoGroup = new ArrayList<BookDto>();
		
		for (Book book : bookGroup) {
			bookDtoGroup.add(
					BookMapper.bookToBookDto(book)
			);
		}
		
		return bookDtoGroup;
	}
	
}

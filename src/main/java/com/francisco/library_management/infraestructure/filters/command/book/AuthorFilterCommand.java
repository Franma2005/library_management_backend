package com.francisco.library_management.infraestructure.filters.command.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.filters.interfaces.MyBookCommand;

@Component
public class AuthorFilterCommand implements MyBookCommand {

	public AuthorFilterCommand() {}
	
	@Override
	public boolean execute(Book book, Object value) {
		boolean isAuthorValid = false;
		
		if(value instanceof String) {
			String valueCast = (String) value;
			isAuthorValid = (valueCast.equals(book.getAuthor()));
		}
			
		return isAuthorValid;
	}
	
	

}

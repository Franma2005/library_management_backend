package com.francisco.library_management.crud.infraestructure.filters.command.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyBookCommand;

@Component("idFilterCommandBook")
public class IdFilterCommand implements MyBookCommand {

	public IdFilterCommand() {}
	
	@Override
	public boolean execute(Book book, Object value) {
		boolean isIdMatches = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdMatches = (book.getId() == valueCast);
		}
		
		return isIdMatches;
	}

	
}

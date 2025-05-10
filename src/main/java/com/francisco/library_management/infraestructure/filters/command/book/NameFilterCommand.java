package com.francisco.library_management.infraestructure.filters.command.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.domain.models.Book;
import com.francisco.library_management.infraestructure.filters.interfaces.MyBookCommand;

@Component
public class NameFilterCommand implements MyBookCommand {

	public NameFilterCommand() {}
	
	@Override
	public boolean execute(Book book, Object value) {
		boolean isNameValid = false;
		
		if(value instanceof String) {
			String valueCast = (String) value;
			isNameValid = (valueCast.equals(book.getName()));
		}
		
		return isNameValid;
	}

}

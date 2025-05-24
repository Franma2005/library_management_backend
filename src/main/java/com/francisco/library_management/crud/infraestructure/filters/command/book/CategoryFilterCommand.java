package com.francisco.library_management.crud.infraestructure.filters.command.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyBookCommand;

@Component("categoryFilterCommandBook")
public class CategoryFilterCommand implements MyBookCommand {

	public CategoryFilterCommand() {}
	
	@Override
	public boolean execute(Book book, Object value) {
		boolean isCategoryValid = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isCategoryValid = (book.getCategory() == valueCast);
		}
		
		return isCategoryValid;
	}

}

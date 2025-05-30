package com.francisco.library_management.crud.infraestructure.filters.command.book;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyBookCommand;

@Component
public class EditorialFilterCommand implements MyBookCommand {

	public EditorialFilterCommand() {}
	
	@Override
	public boolean execute(Book book, Object value) {
		boolean isEditorialValid = false;
		
		if(value instanceof String) {
			String valueCast = (String) value;
			isEditorialValid = (book.getEditorial().equals(valueCast));
		}
		
		return isEditorialValid;
	}

}

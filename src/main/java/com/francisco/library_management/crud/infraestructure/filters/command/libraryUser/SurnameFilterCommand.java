package com.francisco.library_management.crud.infraestructure.filters.command.libraryUser;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLibraryUserCommand;

@Component
public class SurnameFilterCommand implements MyLibraryUserCommand {

	public SurnameFilterCommand() {}

	@Override
	public boolean execute(LibraryUser entity, Object value) {
		boolean isSurnameValid = false;
		
		if(value instanceof String) {
			String valueCast = (String) value;
			isSurnameValid = (entity.getSurname().equals(valueCast));
		}
			
		return isSurnameValid;
	}
	
}

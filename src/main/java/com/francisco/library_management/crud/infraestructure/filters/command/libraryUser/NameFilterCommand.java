package com.francisco.library_management.crud.infraestructure.filters.command.libraryUser;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLibraryUserCommand;

@Component("nameFilterCommandCategory")
public class NameFilterCommand implements MyLibraryUserCommand {

	public NameFilterCommand() {}

	@Override
	public boolean execute(LibraryUser entity, Object value) {
		boolean isNameValid = false;
		
		if(value instanceof String) {
			String valueCast = (String) value;
			isNameValid = (valueCast.equals(entity.getName()));
		}
		
		return isNameValid;
	}
	
}

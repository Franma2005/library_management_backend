package com.francisco.library_management.crud.infraestructure.filters.command.libraryUser;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.LibraryUser;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLibraryUserCommand;

@Component("idFilterCommandLibraryUser")
public class IdFilterCommand implements MyLibraryUserCommand {

	public IdFilterCommand() {}

	@Override
	public boolean execute(LibraryUser entity, Object value) {
		boolean isIdValid = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdValid = (valueCast == entity.getId());
		}
		
		return isIdValid;
	}
	
}

package com.francisco.library_management.infraestructure.filters.command.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.francisco.library_management.infraestructure.exceptions.customExceptions.CommandNotFoundException;
import com.francisco.library_management.infraestructure.filters.command.libraryUser.IdFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.libraryUser.NameFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.libraryUser.SurnameFilterCommand;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLibraryUserCommand;

import jakarta.annotation.PostConstruct;

@Component
public class LibraryUserFilterCommandRegistry {

	private Map<String, MyLibraryUserCommand> filterLibraryUserCommands;
	
	public LibraryUserFilterCommandRegistry() {
		filterLibraryUserCommands = new HashMap<String, MyLibraryUserCommand>();
	}
	
	@PostConstruct
	public void init(
			IdFilterCommand idFilterCommand,
			NameFilterCommand nameFilterCommand,
			SurnameFilterCommand surnameFilterCommand
	) {
		filterLibraryUserCommands.put("id", idFilterCommand);	
		filterLibraryUserCommands.put("name", nameFilterCommand);	
		filterLibraryUserCommands.put("surname", surnameFilterCommand);	
	}
	
	public MyLibraryUserCommand getCommand(String field) {
		MyLibraryUserCommand myLibraryUserCommand = filterLibraryUserCommands.get(field);
		if(myLibraryUserCommand == null)
			throw new CommandNotFoundException();
		return myLibraryUserCommand;
	}
	
}

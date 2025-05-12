package com.francisco.library_management.infraestructure.filters.command.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.francisco.library_management.infraestructure.exceptions.customExceptions.CommandNotFoundException;
import com.francisco.library_management.infraestructure.filters.command.book.AuthorFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.book.CategoryFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.book.EditorialFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.book.IdFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.book.NameFilterCommand;
import com.francisco.library_management.infraestructure.filters.interfaces.MyBookCommand;

@Component
public class BookFilterCommandRegistry {

	private Map<String, MyBookCommand> filterBookCommands;
	
	public BookFilterCommandRegistry(
			IdFilterCommand idFilterCommand,
			NameFilterCommand nameFilterCommand,
			AuthorFilterCommand authorFilterCommand,
			EditorialFilterCommand editorialFilterCommand,
			CategoryFilterCommand categoryFilterCommand
	) {
		filterBookCommands = new HashMap<>(Map.of(
		        "id", idFilterCommand,
		        "name", nameFilterCommand,
		        "author", authorFilterCommand,
		        "editorial", editorialFilterCommand,
		        "category", categoryFilterCommand
		));
	}
	
	public MyBookCommand getCommand(String field) {
		MyBookCommand command = filterBookCommands.get(field);
		if(command == null)
			throw new CommandNotFoundException();
		return command;
	}
	
}

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

import jakarta.annotation.PostConstruct;

@Component
public class BookFilterCommandRegistry {

	private Map<String, MyBookCommand> filterBookCommands;
	
	public BookFilterCommandRegistry() {
		filterBookCommands = new HashMap<String, MyBookCommand>();
	}
	
	@PostConstruct
	public void init(
			IdFilterCommand idFilterCommand,
			NameFilterCommand nameFilterCommand,
			AuthorFilterCommand authorFilterCommand,
			EditorialFilterCommand editorialFilterCommand,
			CategoryFilterCommand categoryFilterCommand
	) {
		filterBookCommands.put("id", idFilterCommand);
		filterBookCommands.put("name", nameFilterCommand);
		filterBookCommands.put("author", authorFilterCommand);
		filterBookCommands.put("editorial", editorialFilterCommand);
		filterBookCommands.put("category", categoryFilterCommand);
	}
	
	public MyBookCommand getCommand(String field) {
		MyBookCommand command = filterBookCommands.get(field);
		if(command == null)
			throw new CommandNotFoundException();
		return command;
	}
	
}

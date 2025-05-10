package com.francisco.library_management.infraestructure.filters.command.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.francisco.library_management.infraestructure.exceptions.customExceptions.CommandNotFoundException;
import com.francisco.library_management.infraestructure.filters.command.category.CategoryFilterCommand;
import com.francisco.library_management.infraestructure.filters.command.category.IdFilterCommand;
import com.francisco.library_management.infraestructure.filters.interfaces.MyCategoryCommand;

import jakarta.annotation.PostConstruct;

@Component
public class CategoryFilterCommandRegistry {

	private Map<String, MyCategoryCommand> filterCategoryCommands;
	
	public CategoryFilterCommandRegistry() {
		filterCategoryCommands = new HashMap<String, MyCategoryCommand>();
	}
	
	@PostConstruct
	public void init(
			IdFilterCommand idFilterCommand,
			CategoryFilterCommand categoryFilterCommand
	) {
		filterCategoryCommands.put("id", idFilterCommand);
		filterCategoryCommands.put("category", categoryFilterCommand);
	}
	
	public MyCategoryCommand getCommand(String field) {
		MyCategoryCommand myCategoryCommand = filterCategoryCommands.get(field);
		if(myCategoryCommand == null)
			throw new CommandNotFoundException();
		return myCategoryCommand;
	}
	
}

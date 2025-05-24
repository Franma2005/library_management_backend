package com.francisco.library_management.crud.infraestructure.filters.command.registry;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.CommandNotFoundException;
import com.francisco.library_management.crud.infraestructure.filters.command.category.CategoryFilterCommand;
import com.francisco.library_management.crud.infraestructure.filters.command.category.IdFilterCommand;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyCategoryCommand;

@Component
public class CategoryFilterCommandRegistry {

	private Map<String, MyCategoryCommand> filterCategoryCommands;
	
	public CategoryFilterCommandRegistry(
			IdFilterCommand idFilterCommand,
			CategoryFilterCommand categoryFilterCommand		
	) {
		filterCategoryCommands = new HashMap<>(
		        Map.of(
		            "id", idFilterCommand,
		            "category", categoryFilterCommand
		        )
		);
	}
	
	public MyCategoryCommand getCommand(String field) {
		MyCategoryCommand myCategoryCommand = filterCategoryCommands.get(field);
		if(myCategoryCommand == null)
			throw new CommandNotFoundException();
		return myCategoryCommand;
	}
	
}

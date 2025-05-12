package com.francisco.library_management.infraestructure.filters.command.category;

import org.springframework.stereotype.Component;

import com.francisco.library_management.domain.models.Category;
import com.francisco.library_management.infraestructure.filters.interfaces.MyCategoryCommand;

@Component("categoryFilterCommandCategory")
public class CategoryFilterCommand implements MyCategoryCommand {

	public CategoryFilterCommand() {}
	
	@Override
	public boolean execute(Category entity, Object value) {
		boolean isCategoryValid = false;
		
		if(value instanceof String) {
			String valueCast = (String) value;
			isCategoryValid = (valueCast.equals(entity.getCategory()));
		}
		
		return isCategoryValid;
	}

}

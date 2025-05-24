package com.francisco.library_management.crud.infraestructure.filters.command.category;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Category;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyCategoryCommand;

@Component("idFilterCommandCategory")
public class IdFilterCommand implements MyCategoryCommand {

	public IdFilterCommand() {}

	@Override
	public boolean execute(Category entity, Object value) {
		boolean isIdValid = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdValid = (valueCast == entity.getId());
 		}
		
		return isIdValid;
	}
	
}

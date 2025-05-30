package com.francisco.library_management.crud.infraestructure.filters.command.loan;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLoanCommand;

@Component
public class IdLibraryUserFilterCommand implements MyLoanCommand {

	public IdLibraryUserFilterCommand() {}

	@Override
	public boolean execute(Loan entity, Object value) {
		boolean isIdLibraryUserValid = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdLibraryUserValid = (valueCast == entity.getLibraryUser().getId());
		}
		
		return isIdLibraryUserValid;
	}
	
}

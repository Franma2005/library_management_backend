package com.francisco.library_management.infraestructure.filters.command.loan;

import org.springframework.stereotype.Component;

import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLoanCommand;

@Component
public class IdLibraryUserFilterCommand implements MyLoanCommand {

	public IdLibraryUserFilterCommand() {}

	@Override
	public boolean execute(Loan entity, Object value) {
		boolean isIdLibraryUserValid = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdLibraryUserValid = (valueCast == entity.getIdLibraryUser());
		}
		
		return isIdLibraryUserValid;
	}
	
}

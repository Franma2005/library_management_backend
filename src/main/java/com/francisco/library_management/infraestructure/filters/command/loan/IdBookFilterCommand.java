package com.francisco.library_management.infraestructure.filters.command.loan;

import org.springframework.stereotype.Component;

import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLoanCommand;

@Component
public class IdBookFilterCommand implements MyLoanCommand {

	public IdBookFilterCommand() {}

	@Override
	public boolean execute(Loan entity, Object value) {
		boolean isIdBookValid = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdBookValid = (valueCast == entity.getIdBook());
		}
		
		return isIdBookValid;
	}
	
}

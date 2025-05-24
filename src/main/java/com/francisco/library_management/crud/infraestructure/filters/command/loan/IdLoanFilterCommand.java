package com.francisco.library_management.crud.infraestructure.filters.command.loan;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLoanCommand;

@Component
public class IdLoanFilterCommand implements MyLoanCommand {

	public IdLoanFilterCommand() {}

	@Override
	public boolean execute(Loan entity, Object value) {
		boolean isIdLoan = false;
		
		if(value instanceof Long) {
			Long valueCast = (Long) value;
			isIdLoan = (valueCast == entity.getIdLoan());
		}
		
		return isIdLoan;
	}
	
}

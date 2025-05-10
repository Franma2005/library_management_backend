package com.francisco.library_management.infraestructure.filters.command.loan;

import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLoanCommand;

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

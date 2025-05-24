package com.francisco.library_management.crud.infraestructure.filters.command.loan;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.filters.interfaces.MyLoanCommand;

@Component
public class TimeFilterCommand implements MyLoanCommand {

	public TimeFilterCommand() {}

	@Override
	public boolean execute(Loan entity, Object value) {
		boolean isTimeValid = false;
		
		if(value instanceof LocalDateTime) {
			LocalDateTime valueCast = (LocalDateTime) value;
			isTimeValid = (valueCast.equals(entity.getTime()));
		}
		
		return isTimeValid;
	}
	
}

package com.francisco.library_management.crud.usecase.loan;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.loan.UpdateLoanImpl;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.dto.LoanDto;
import com.francisco.library_management.crud.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.crud.infraestructure.recive.LoanRecive;

@Component
public class UpdateLoanUseCase {

	private UpdateLoanImpl updateLoanImpl;
	
	public UpdateLoanUseCase(UpdateLoanImpl updateLoanImpl) {
		this.updateLoanImpl = updateLoanImpl;
	}
	
	public LoanDto updateLoan(LoanRecive loanRecive) {
		Loan loan = LoanMapper.loanRecivetoLoan(loanRecive);
		updateLoanImpl.updateLoan(loan);
		LoanDto loanDto = LoanMapper.loantoLoanDto(loan);
		return loanDto;
	}
	
}

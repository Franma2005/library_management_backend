package com.francisco.library_management.crud.usecase.loan;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.loan.CreateLoanImpl;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.dto.LoanDto;
import com.francisco.library_management.crud.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.crud.infraestructure.recive.LoanRecive;

@Component
public class CreateLoanUseCase {

	private CreateLoanImpl createLoanImpl;
	
	public CreateLoanUseCase(CreateLoanImpl createLoanImpl) {
		this.createLoanImpl = createLoanImpl;
	}
	
	public LoanDto createLoan(LoanRecive loanRecive) {
		Loan loan = LoanMapper.loanRecivetoLoan(loanRecive);
		createLoanImpl.createLoan(loan);
		LoanDto loanDto = LoanMapper.loantoLoanDto(loan);
		return loanDto;
	}
}

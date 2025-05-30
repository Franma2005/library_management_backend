package com.francisco.library_management.crud.usecase.loan;

import java.time.LocalDateTime;

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
		loanRecive.setTime(LocalDateTime.now());
		Loan loan = LoanMapper.loanRecivetoLoan(loanRecive);
		Loan loanResponse = createLoanImpl.createLoan(loan);
		LoanDto loanDto = LoanMapper.loantoLoanDto(loanResponse);
		return loanDto;
	}
}

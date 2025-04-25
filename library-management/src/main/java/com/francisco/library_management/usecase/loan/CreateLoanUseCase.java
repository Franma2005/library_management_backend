package com.francisco.library_management.usecase.loan;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.loan.CreateLoanImpl;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.infraestructure.recive.LoanRecive;

@Component
public class CreateLoanUseCase {

	private CreateLoanImpl createLoanImpl;
	
	public CreateLoanUseCase(CreateLoanImpl createLoanImpl) {
		this.createLoanImpl = createLoanImpl;
	}
	
	public ResponseEntity<LoanDto> createLoan(LoanRecive loanRecive) {
		Loan loan = LoanMapper.loanRecivetoLoan(loanRecive);
		createLoanImpl.createLoan(loan);
		LoanDto loanDto = LoanMapper.loantoLoanDto(loan);
		return ResponseEntity.ok(loanDto);
	}
}

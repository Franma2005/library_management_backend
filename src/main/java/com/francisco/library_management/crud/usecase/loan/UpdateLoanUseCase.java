package com.francisco.library_management.usecase.loan;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.loan.UpdateLoanImpl;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.infraestructure.recive.LoanRecive;

@Component
public class UpdateLoanUseCase {

	private UpdateLoanImpl updateLoanImpl;
	
	public UpdateLoanUseCase(UpdateLoanImpl updateLoanImpl) {
		this.updateLoanImpl = updateLoanImpl;
	}
	
	public ResponseEntity<LoanDto> updateLoan(LoanRecive loanRecive) {
		Loan loan = LoanMapper.loanRecivetoLoan(loanRecive);
		updateLoanImpl.updateLoan(loan);
		LoanDto loanDto = LoanMapper.loantoLoanDto(loan);
		return ResponseEntity.ok(loanDto);
	}
	
}

package com.francisco.library_management.crud.application.ports.loan;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.models.Loan;

@Repository
public interface CreateLoanRepository {
	
	public Loan createLoan(Loan loan);
	
}

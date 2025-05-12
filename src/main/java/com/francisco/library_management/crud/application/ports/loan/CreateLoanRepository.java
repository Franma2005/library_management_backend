package com.francisco.library_management.application.ports.loan;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.domain.models.Loan;

@Repository
public interface CreateLoanRepository {
	boolean createLoan(Loan loan);
}

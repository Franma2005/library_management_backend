package com.francisco.library_management.application.ports.loan;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteLoanRepository {
	boolean deleteLoan(long id);
}

package com.francisco.library_management.crud.application.ports.loan;

import org.springframework.stereotype.Repository;

@Repository
public interface DeleteLoanRepository {
	
	public boolean deleteLoan(long id);
	
}

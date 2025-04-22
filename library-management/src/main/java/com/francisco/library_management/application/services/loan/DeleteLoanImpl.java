package com.francisco.library_management.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.DeleteLoanRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.DeleteLoan;

@Service
public class DeleteLoanImpl implements DeleteLoan {

	private DeleteLoanRepository deleteLoanRepository;
	
	public DeleteLoanImpl(DeleteLoanRepository deleteLoanRepository) {
		this.deleteLoanRepository = deleteLoanRepository;
	}

	@Override
	public void deleteLoan(long id) {
		deleteLoanRepository.deleteLoan(id);
	}
	
}

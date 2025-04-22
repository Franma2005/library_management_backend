package com.francisco.library_management.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.CreateLoanRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.CreateLoan;
import com.francisco.library_management.domain.models.Loan;

@Service
public class CreateLoanImpl implements CreateLoan {

	private CreateLoanRepository createLoanRepository;
	
	public CreateLoanImpl(CreateLoanRepository createLoanRepository) {
		this.createLoanRepository = createLoanRepository;
	}
	
	@Override
	public void createLoan(Loan loan) {
		createLoanRepository.createLoan(loan);
	}
	
}

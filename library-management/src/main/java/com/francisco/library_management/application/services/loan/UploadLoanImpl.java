package com.francisco.library_management.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.UploadLoanRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.UploadLoan;
import com.francisco.library_management.domain.models.Loan;

@Service
public class UploadLoanImpl implements UploadLoan {

	private UploadLoanRepository uploadLoanRepository;
	
	public UploadLoanImpl(UploadLoanRepository uploadLoanRepository) {
		this.uploadLoanRepository = uploadLoanRepository;
	}

	@Override
	public void uploadLoan(Loan loan) {
		uploadLoanRepository.uploadLoan(loan);
	}
	
	
}

package com.francisco.library_management.crud.application.services.loan;

import com.francisco.library_management.crud.domain.models.Loan;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.CreateLoanRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.CreateLoan;

@Service
public class CreateLoanImpl implements CreateLoan {

	private CreateLoanRepository createLoanRepository;
	private NotificationLoanPort notificationRepository;
	
	public CreateLoanImpl(CreateLoanRepository createLoanRepository) {
		this.createLoanRepository = createLoanRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void createLoan(Loan loan) {
		createLoanRepository.createLoan(loan);
		notificationRepository.notifyLoanChanges();
	}
	
}

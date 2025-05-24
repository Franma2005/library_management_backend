package com.francisco.library_management.crud.application.services.loan;

import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.CreateLoanRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.CreateLoan;

@Service
public class CreateLoanImpl implements CreateLoan {

	private CreateLoanRepository createLoanRepository;
	private NotificationPort notificationPort;
	
	public CreateLoanImpl(
			CreateLoanRepository createLoanRepository,
			NotificationPort notificationPort			
	) {
		this.createLoanRepository = createLoanRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public void createLoan(Loan loan) {
		createLoanRepository.createLoan(loan);
		notificationPort.sendNotification(NotificationType.LOANRELOAD);
	}
	
}

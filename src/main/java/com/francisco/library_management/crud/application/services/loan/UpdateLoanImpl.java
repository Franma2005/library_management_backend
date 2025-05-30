package com.francisco.library_management.crud.application.services.loan;

import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.UpdateLoanRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.UpdateLoan;

@Service
public class UpdateLoanImpl implements UpdateLoan {

	private UpdateLoanRepository updateLoanRepository;
	private NotificationPort notificationPort;
	
	public UpdateLoanImpl(
			UpdateLoanRepository updateLoanRepository,
			NotificationPort notificationPort
	) {
		this.updateLoanRepository = updateLoanRepository;
		this.notificationPort = notificationPort;
	}

	@Override
	public Loan updateLoan(Loan loan) {
		Loan loanResponse = updateLoanRepository.updateLoan(loan);
		notificationPort.sendNotification(NotificationType.LOANRELOAD);
		return loanResponse;
	}
	
}

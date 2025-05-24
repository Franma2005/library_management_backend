package com.francisco.library_management.crud.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.DeleteLoanRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.DeleteLoan;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

@Service
public class DeleteLoanImpl implements DeleteLoan {

	private DeleteLoanRepository deleteLoanRepository;
	private NotificationPort notificationPort;
	
	public DeleteLoanImpl(
			DeleteLoanRepository deleteLoanRepository,
			NotificationPort notificationPort
	) {
		this.deleteLoanRepository = deleteLoanRepository;
		this.notificationPort = notificationPort;
	}

	@Override
	public void deleteLoan(Long id) {
		deleteLoanRepository.deleteLoan(id);
		notificationPort.sendNotification(NotificationType.LOANRELOAD);
	}
	
}

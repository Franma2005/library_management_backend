package com.francisco.library_management.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.DeleteLoanRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.DeleteLoan;

@Service
public class DeleteLoanImpl implements DeleteLoan {

	private DeleteLoanRepository deleteLoanRepository;
	//private NotificationLoanPort notificationRepository;
	
	public DeleteLoanImpl(DeleteLoanRepository deleteLoanRepository) {
		this.deleteLoanRepository = deleteLoanRepository;
		//this.notificationRepository = notificationRepository;
	}

	@Override
	public void deleteLoan(Long id) {
		deleteLoanRepository.deleteLoan(id);
		//notificationRepository.notifyLoanChanges();
	}
	
}

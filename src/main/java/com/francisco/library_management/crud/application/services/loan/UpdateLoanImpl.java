package com.francisco.library_management.crud.application.services.loan;

import com.francisco.library_management.crud.domain.models.Loan;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.UpdateLoanRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.UpdateLoan;

@Service
public class UpdateLoanImpl implements UpdateLoan {

	private UpdateLoanRepository updateLoanRepository;
	private NotificationLoanPort notificationRepository;
	
	public UpdateLoanImpl(UpdateLoanRepository updateLoanRepository) {
		this.updateLoanRepository = updateLoanRepository;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void updateLoan(Loan loan) {
		updateLoanRepository.updateLoan(loan);
		notificationRepository.notifyLoanChanges();
	}
	
	
}

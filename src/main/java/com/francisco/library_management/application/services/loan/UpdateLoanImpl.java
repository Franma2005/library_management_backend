package com.francisco.library_management.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.UpdateLoanRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.UpdateLoan;
import com.francisco.library_management.domain.models.Loan;

@Service
public class UpdateLoanImpl implements UpdateLoan {

	private UpdateLoanRepository updateLoanRepository;
	//private NotificationLoanPort notificationRepository;
	
	public UpdateLoanImpl(UpdateLoanRepository updateLoanRepository) {
		this.updateLoanRepository = updateLoanRepository;
		//this.notificationRepository = notificationRepository;
	}

	@Override
	public void updateLoan(Loan loan) {
		updateLoanRepository.updateLoan(loan);
		//notificationRepository.notifyLoanChanges();
	}
	
	
}

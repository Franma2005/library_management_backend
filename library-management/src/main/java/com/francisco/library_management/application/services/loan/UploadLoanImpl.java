package com.francisco.library_management.application.services.loan;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.UploadLoanRepository;
import com.francisco.library_management.application.ports.notification.NotificationLoanPort;
import com.francisco.library_management.application.services.servicesInterfaces.loan.UploadLoan;
import com.francisco.library_management.domain.models.Loan;

@Service
public class UploadLoanImpl implements UploadLoan {

	private UploadLoanRepository uploadLoanRepository;
	private NotificationLoanPort notificationRepository;
	
	public UploadLoanImpl(UploadLoanRepository uploadLoanRepository, NotificationLoanPort notificationRepository) {
		this.uploadLoanRepository = uploadLoanRepository;
		this.notificationRepository = notificationRepository;
	}

	@Override
	public void uploadLoan(Loan loan) {
		uploadLoanRepository.uploadLoan(loan);
		notificationRepository.notifyLoanChanges();
	}
	
	
}

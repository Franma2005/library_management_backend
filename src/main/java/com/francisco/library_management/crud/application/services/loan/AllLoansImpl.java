package com.francisco.library_management.application.services.loan;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.AllLoansRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.AllLoans;
import com.francisco.library_management.domain.models.Loan;

@Service
public class AllLoansImpl implements AllLoans {

	private AllLoansRepository allLoansRepository;
	
	public AllLoansImpl(AllLoansRepository allLoansRepository) {
		this.allLoansRepository = allLoansRepository;
	}
	
	@Override
	public List<Loan> getAllLoan() {
		return allLoansRepository.getAllLoan();
	}
	
}

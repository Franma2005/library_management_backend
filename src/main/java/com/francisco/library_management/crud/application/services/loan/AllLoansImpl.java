package com.francisco.library_management.crud.application.services.loan;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Loan;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.AllLoansRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.AllLoans;

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

package com.francisco.library_management.application.services.loan;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.loan.LoanByCriteriaRepository;
import com.francisco.library_management.application.services.servicesInterfaces.loan.LoanByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Loan;

@Service
public class LoanByCriteriaImpl implements LoanByCriteria {

	private LoanByCriteriaRepository loanByCriteriaRepository;
	
	public LoanByCriteriaImpl(LoanByCriteriaRepository loanByCriteriaRepository) {
		this.loanByCriteriaRepository = loanByCriteriaRepository;
	}

	@Override
	public List<Loan> getLoanByCriteria(Criteria criteria) {
		return loanByCriteriaRepository.findLoanByCriteria(criteria);
	}
	
}

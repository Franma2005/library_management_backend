package com.francisco.library_management.crud.application.services.loan;

import java.util.List;

import com.francisco.library_management.crud.domain.models.Loan;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.loan.LoanByCriteriaRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.loan.LoanByCriteria;
import com.francisco.library_management.crud.domain.filter.Criteria;

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

package com.francisco.library_management.crud.application.ports.loan;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.models.Loan;

@Repository
public interface LoanByCriteriaRepository {

	public List<Loan> findLoanByCriteria(Criteria criteria);
	
}

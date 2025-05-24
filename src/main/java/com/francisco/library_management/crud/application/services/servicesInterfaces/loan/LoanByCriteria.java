package com.francisco.library_management.crud.application.services.servicesInterfaces.loan;

import java.util.List;

import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.models.Loan;

public interface LoanByCriteria {

	public List<Loan> getLoanByCriteria(Criteria criteria);
	
}

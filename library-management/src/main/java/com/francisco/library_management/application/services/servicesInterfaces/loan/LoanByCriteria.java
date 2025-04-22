package com.francisco.library_management.application.services.servicesInterfaces.loan;

import java.util.List;

import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Loan;

public interface LoanByCriteria {

	public List<Loan> getLoanByCriteria(Criteria criteria);
}

package com.francisco.library_management.infraestructure.out.database;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.loan.LoanRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.models.Loan;

@Repository
public class LoanRepositoryImpl implements LoanRepository {

	@Override
	public List<Loan> getAllLoan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> findLoanByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createLoan(Loan loan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateLoan(Loan loan) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteLoan(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}

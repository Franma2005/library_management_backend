package com.francisco.library_management.infraestructure.out.database.loan;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.loan.UpdateLoanRepository;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class UpdateLoanRepositoryImpl implements UpdateLoanRepository {

	private LoanRepositoryDatabase loanRepositoryDatabase;
	
	public UpdateLoanRepositoryImpl(LoanRepositoryDatabase loanRepositoryDatabase) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
	}

	@Override
	public boolean updateLoan(Loan loan) {
		LoanEntity loanEntity = mapToLoanEntity(loan);
		loanRepositoryDatabase.save(loanEntity);
		return true;
	}
	
	private LoanEntity mapToLoanEntity(Loan loan) {
		return LoanMapper.loantoLoanEntity(loan);
	}
	
}

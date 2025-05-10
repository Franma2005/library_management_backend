package com.francisco.library_management.infraestructure.out.database.loan;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.loan.CreateLoanRepository;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class CreateLoanRepositoryImpl implements CreateLoanRepository {

	private LoanRepositoryDatabase loanRepositoryDatabase;
	
	public CreateLoanRepositoryImpl(LoanRepositoryDatabase loanRepositoryDatabase) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
	}

	@Override
	public boolean createLoan(Loan loan) {
		LoanEntity loanEntity = mapToLoanEntity(loan);
		loanRepositoryDatabase.save(loanEntity);
		return true;
	}
	
	private LoanEntity mapToLoanEntity(Loan loan) {
		return LoanMapper.loantoLoanEntity(loan);
	}
}

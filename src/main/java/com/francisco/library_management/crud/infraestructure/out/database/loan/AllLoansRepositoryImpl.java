package com.francisco.library_management.infraestructure.out.database.loan;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.loan.AllLoansRepository;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.mapper.LoanGroupMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class AllLoansRepositoryImpl implements AllLoansRepository {

	private LoanRepositoryDatabase loanRepositoryDatabase;
	
	public AllLoansRepositoryImpl(LoanRepositoryDatabase loanRepositoryDatabase) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
	}

	@Override
	public List<Loan> getAllLoan() {
		List<LoanEntity> loanEntityGroup = loanRepositoryDatabase.findAll();
		List<Loan> loanGroup = mapToLoan(loanEntityGroup);
		return loanGroup;
	}
	
	private List<Loan> mapToLoan(List<LoanEntity> loanEntityGroup) {
		return LoanGroupMapper.loanEntityGrouptoLoanGroup(loanEntityGroup);
	}
	
}

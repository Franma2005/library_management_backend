package com.francisco.library_management.crud.infraestructure.out.database.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.loan.DeleteLoanRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class DeleteLoanRepositoryImpl implements DeleteLoanRepository {

	private LoanRepositoryDatabase loanRepositoryDatabase;
	private LoanByCriteriaRepositoryImpl loanByCriteriaRepositoryImpl;
	
	public DeleteLoanRepositoryImpl(LoanRepositoryDatabase loanRepositoryDatabase,
			LoanByCriteriaRepositoryImpl loanByCriteriaRepositoryImpl) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
		this.loanByCriteriaRepositoryImpl = loanByCriteriaRepositoryImpl;
	}

	@Override
	public boolean deleteLoan(long id) {
		Loan loan = getLoanForDelete(id);
		LoanEntity loanEntity = mapToLoanEntity(loan);
		loanRepositoryDatabase.delete(loanEntity);
		return true;
	}
	
	private LoanEntity mapToLoanEntity(Loan loan) {
		return LoanMapper.loantoLoanEntity(loan);
	}
	
	private Loan getLoanForDelete(long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("idLoan", Optional.of(id))
				.build();
		List<Loan> loanEntityGroup =
				loanByCriteriaRepositoryImpl.findLoanByCriteria(criteria);
		return loanEntityGroup.get(0);	
	}
	
}

package com.francisco.library_management.crud.usecase.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.loan.AllLoansImpl;
import com.francisco.library_management.crud.application.services.loan.LoanByCriteriaImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.dto.LoanDto;
import com.francisco.library_management.crud.infraestructure.mapper.LoanGroupMapper;

@Component
public class AllLoansUseCase {

	private AllLoansImpl allLoansImpl;
	private LoanByCriteriaImpl loanByCriteriaImpl;
	
	public AllLoansUseCase(AllLoansImpl allLoansImpl, LoanByCriteriaImpl loanByCriteriaImpl) {
		this.allLoansImpl = allLoansImpl;
		this.loanByCriteriaImpl = loanByCriteriaImpl;
	}
	
	public List<LoanDto> findAllLoan(
			Long idLoan,
			Long idBook,
			Long idLibraryUser
	) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("idLoan", Optional.ofNullable(idLoan))
				.addFilterIfPresent("idBook", Optional.ofNullable(idBook))
				.addFilterIfPresent("idLibraryUser", Optional.ofNullable(idLibraryUser))
				.build();
		
		List<Loan> loanGroup = criteria.getFilter().isEmpty() ?
				allLoansImpl.getAllLoan()
				:
				loanByCriteriaImpl.getLoanByCriteria(criteria);
		
		return LoanGroupMapper.loanGrouptoLoanDtoGroup(loanGroup);
	}
}

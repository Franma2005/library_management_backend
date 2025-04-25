package com.francisco.library_management.usecase.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.loan.AllLoansImpl;
import com.francisco.library_management.application.services.loan.LoanByCriteriaImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.infraestructure.mapper.LoanGroupMapper;

@Component
public class AllLoansUseCase {

	private AllLoansImpl allLoansImpl;
	private LoanByCriteriaImpl loanByCriteriaImpl;
	
	public AllLoansUseCase(AllLoansImpl allLoansImpl, LoanByCriteriaImpl loanByCriteriaImpl) {
		this.allLoansImpl = allLoansImpl;
		this.loanByCriteriaImpl = loanByCriteriaImpl;
	}
	
	public ResponseEntity<List<LoanDto>> findAllLoan(
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
		
		return ResponseEntity.ok(LoanGroupMapper.loanGrouptoLoanDtoGroup(loanGroup));
	}
}

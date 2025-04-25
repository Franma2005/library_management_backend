package com.francisco.library_management.usecase.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.francisco.library_management.application.services.loan.DeleteLoanImpl;
import com.francisco.library_management.application.services.loan.LoanByCriteriaImpl;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.CriteriaBuilder;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.infraestructure.mapper.LoanMapper;

@Component
public class DeleteLoanUseCase {

	private DeleteLoanImpl deleteLoanImpl;
	private LoanByCriteriaImpl loanByCriteriaImpl;
	
	public DeleteLoanUseCase(DeleteLoanImpl deleteLoanImpl, LoanByCriteriaImpl loanByCriteriaImpl) {
		this.deleteLoanImpl = deleteLoanImpl;
		this.loanByCriteriaImpl = loanByCriteriaImpl;
	}
	
	public ResponseEntity<LoanDto> deleteLoan(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<Loan> loanGroup = loanByCriteriaImpl.getLoanByCriteria(criteria);
		deleteLoanImpl.deleteLoan(id);
		return ResponseEntity.ok(
				LoanMapper.loantoLoanDto(loanGroup.get(0))
		);
	}
	
}

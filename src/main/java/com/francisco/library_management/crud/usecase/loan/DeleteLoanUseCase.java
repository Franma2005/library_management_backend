package com.francisco.library_management.crud.usecase.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.francisco.library_management.crud.application.services.loan.DeleteLoanImpl;
import com.francisco.library_management.crud.application.services.loan.LoanByCriteriaImpl;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.dto.LoanDto;
import com.francisco.library_management.crud.infraestructure.mapper.LoanMapper;

@Component
public class DeleteLoanUseCase {

	private DeleteLoanImpl deleteLoanImpl;
	private LoanByCriteriaImpl loanByCriteriaImpl;
	
	public DeleteLoanUseCase(DeleteLoanImpl deleteLoanImpl,
			LoanByCriteriaImpl loanByCriteriaImpl) {
		this.deleteLoanImpl = deleteLoanImpl;
		this.loanByCriteriaImpl = loanByCriteriaImpl;
	}
	
	public LoanDto deleteLoan(Long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("id", Optional.ofNullable(id))
				.build();
		List<Loan> loanGroup = loanByCriteriaImpl.getLoanByCriteria(criteria);
		deleteLoanImpl.deleteLoan(id);
		return LoanMapper.loantoLoanDto(loanGroup.get(0));
	}
	
}

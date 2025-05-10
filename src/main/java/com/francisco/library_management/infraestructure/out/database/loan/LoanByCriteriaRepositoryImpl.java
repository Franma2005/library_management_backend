package com.francisco.library_management.infraestructure.out.database.loan;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.application.ports.loan.LoanByCriteriaRepository;
import com.francisco.library_management.domain.filter.Criteria;
import com.francisco.library_management.domain.filter.Filter;
import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.filters.command.registry.LoanFilterCommandRegistry;
import com.francisco.library_management.infraestructure.filters.interfaces.MyLoanCommand;
import com.francisco.library_management.infraestructure.mapper.LoanGroupMapper;
import com.francisco.library_management.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class LoanByCriteriaRepositoryImpl implements LoanByCriteriaRepository {

	private LoanRepositoryDatabase loanRepositoryDatabase;
	private LoanFilterCommandRegistry loanFilterCommandRegistry;
	
	public LoanByCriteriaRepositoryImpl(LoanRepositoryDatabase loanRepositoryDatabase,
			LoanFilterCommandRegistry loanFilterCommandRegistry) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
		this.loanFilterCommandRegistry = loanFilterCommandRegistry;
	}

	@Override
	public List<Loan> findLoanByCriteria(Criteria criteria) {
		List<LoanEntity> loanEntityGroup = loanRepositoryDatabase.findAll();
		List<Loan> loanGroup = mapToLoan(loanEntityGroup);
		
		if(criteria == null)
			loanGroup = filter(loanGroup, criteria);
			
		return null;
	}
	
	private List<Loan> mapToLoan(List<LoanEntity> loanEntityGroup) {
		return LoanGroupMapper.loanEntityGrouptoLoanGroup(loanEntityGroup);
	}
	
	private List<Loan> filter(List<Loan> loanGroup, Criteria criteria) {
		List<Loan> loanGroupFilter = new ArrayList<Loan>();
		
		for (Loan loan : loanGroup) {
			if(matchesCriteria(loan, criteria.getFilter()))
				loanGroupFilter.add(loan);
		}
		
		return loanGroupFilter;
	}
	
	private boolean matchesCriteria(Loan loan, List<Filter<?>> filters) {
		boolean allFiltersComplete = true;
		
		for (Filter<?> filter : filters) {
			if(matchesFilter(loan, filter))
				allFiltersComplete = false;
				
		}
		
		return allFiltersComplete;
	}
	
	private boolean matchesFilter(Loan loan, Filter<?> filter) {
		String field = filter.getField();
		Object value = filter.getValue();
		
		MyLoanCommand myLoanCommand = loanFilterCommandRegistry.getCommand(field);
		return myLoanCommand.execute(loan, value);
	}
	
}

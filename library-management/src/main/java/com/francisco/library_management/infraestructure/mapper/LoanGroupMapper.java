package com.francisco.library_management.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.infraestructure.recive.LoanRecive;

public class LoanGroupMapper {

	public static List<Loan> loanReciveGrouptoLoanGroup(List<LoanRecive> loanReciveGroup) {
		List<Loan> loanGroup = new ArrayList<Loan>();
		
		for (LoanRecive loanRecive : loanReciveGroup) {
			loanGroup.add(
					LoanMapper.loanRecivetoLoan(loanRecive)
			);
		}
		
		return loanGroup;
	}
	
	public static List<LoanDto> loanGrouptoLoanDtoGroup(List<Loan> loanGroup) {
		List<LoanDto> loanDtoGroup = new ArrayList<LoanDto>();
		
		for (Loan loan : loanGroup) {
			loanDtoGroup.add(
					LoanMapper.loantoLoanDto(loan)
			);
		}
		
		return loanDtoGroup;
	}
	
}

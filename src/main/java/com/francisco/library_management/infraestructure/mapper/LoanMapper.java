package com.francisco.library_management.infraestructure.mapper;

import com.francisco.library_management.domain.models.Loan;
import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.infraestructure.recive.LoanRecive;

public class LoanMapper {

	public static Loan loanRecivetoLoan(LoanRecive loanRecive) {
		return Loan.builder()
				.idLoan(loanRecive.getIdLoan())
				.idBook(loanRecive.getIdBook())
				.idLibraryUser(loanRecive.getIdLibraryUser())
				.time(loanRecive.getTime())
				.build();
	}
	
	public static LoanDto loantoLoanDto(Loan loan) {
		return LoanDto.builder()
				.idLoan(loan.getIdLoan())
				.idBook(loan.getIdBook())
				.idLibraryUser(loan.getIdLibraryUser())
				.time(loan.getTime())
				.build();
	}
}

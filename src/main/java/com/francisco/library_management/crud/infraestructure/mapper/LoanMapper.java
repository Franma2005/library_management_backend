package com.francisco.library_management.crud.infraestructure.mapper;

import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.dto.LoanDto;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.crud.infraestructure.recive.LoanRecive;

public class LoanMapper {

	public static Loan loanRecivetoLoan(LoanRecive loanRecive) {
		return Loan.builder()
				.idLoan(loanRecive.getIdLoan())
				.idBook(loanRecive.getIdBook())
				.idLibraryUser(loanRecive.getIdLibraryUser())
				.time(loanRecive.getTime())
				.build();
	}
	
	public static Loan loanEntitytoLoan(LoanEntity loanEntity) {
		return Loan.builder()
				.idLoan(loanEntity.getIdLoan())
				.idBook(loanEntity.getBook().getId())
				.book(BookMapper.bookEntityToBook(loanEntity.getBook()))
				.idLibraryUser(loanEntity.getLibraryUser().getId())
				.libraryUser(LibraryUserMapper.libraryUserEntitytoLibraryUser(loanEntity.getLibraryUser()))
				.time(loanEntity.getTime())
				.build();
	}
	
	public static LoanDto loantoLoanDto(Loan loan) {
		return LoanDto.builder()
				.idLoan(loan.getIdLoan())
				.book(BookMapper.bookToBookDto(loan.getBook()))
				.libraryUser(LibraryUserMapper.libraryUsertoLibraryUserDto(loan.getLibraryUser()))
				.time(loan.getTime())
				.build();
	}
	
	public static LoanEntity loantoLoanEntity(Loan loan, BookEntity bookEntity, LibraryUserEntity libraryUserEntity) {
		return LoanEntity.builder()
				.idLoan(loan.getIdLoan())
				.book(bookEntity)
				.libraryUser(libraryUserEntity)
				.time(loan.getTime())
				.build();
	}
	
}

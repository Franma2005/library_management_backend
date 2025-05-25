package com.francisco.library_management.crud.infraestructure.out.database.loan;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.loan.CreateLoanRepository;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdBookNotFoundException;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdCategoryNotFoundException;
import com.francisco.library_management.crud.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class CreateLoanRepositoryImpl implements CreateLoanRepository {

	private final LoanRepositoryDatabase loanRepositoryDatabase;
	private final BookRepositoryDatabase bookRepositoryDatabase;
	private final LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	
	public CreateLoanRepositoryImpl(
			LoanRepositoryDatabase loanRepositoryDatabase,
			BookRepositoryDatabase bookRepositoryDatabase,
			LibraryUserRepositoryDatabase libraryUserRepositoryDatabase
	) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
	}

	@Override
	public boolean createLoan(Loan loan) {
		LoanEntity loanEntity = mapToLoanEntity(loan);
		loanRepositoryDatabase.save(loanEntity);
		return true;
	}
	
	private LoanEntity mapToLoanEntity(Loan loan) {
		Optional<BookEntity> temporalBookEntity =
				bookRepositoryDatabase.findById(loan.getIdBook());
		
		Optional<LibraryUserEntity> temporalLibraryUserEntity =
				libraryUserRepositoryDatabase.findById(loan.getIdLibraryUser());
		
		if(temporalBookEntity.isEmpty() || temporalLibraryUserEntity.isEmpty())
			throwIdsException();
		
		return LoanMapper.loantoLoanEntity(loan);
	}
	
	private void throwIdsException(
			Optional<BookEntity> temporalBookEntity,
			Optional<LibraryUserEntity> temporalLibraryUserEntity
	) {
		if(temporalBookEntity.isEmpty()) throw new IdBookNotFoundException();
	}
	
}

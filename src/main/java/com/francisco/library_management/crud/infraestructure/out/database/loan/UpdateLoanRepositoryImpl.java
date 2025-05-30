package com.francisco.library_management.crud.infraestructure.out.database.loan;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.loan.UpdateLoanRepository;
import com.francisco.library_management.crud.domain.models.Loan;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdBookNotFoundException;
import com.francisco.library_management.crud.infraestructure.exceptions.customExceptions.IdLibraryUserNotFoundException;
import com.francisco.library_management.crud.infraestructure.mapper.LoanMapper;
import com.francisco.library_management.crud.infraestructure.out.database.entities.BookEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LibraryUserEntity;
import com.francisco.library_management.crud.infraestructure.out.database.entities.LoanEntity;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.BookRepositoryDatabase;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LibraryUserRepositoryDatabase;
import com.francisco.library_management.crud.infraestructure.out.database.repositories.LoanRepositoryDatabase;

@Repository
public class UpdateLoanRepositoryImpl implements UpdateLoanRepository {

	private final LoanRepositoryDatabase loanRepositoryDatabase;
	private final BookRepositoryDatabase bookRepositoryDatabase;
	private final LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	
	public UpdateLoanRepositoryImpl(
			LoanRepositoryDatabase loanRepositoryDatabase,
			BookRepositoryDatabase bookRepositoryDatabase,
			LibraryUserRepositoryDatabase libraryUserRepositoryDatabase
	) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
	}

	@Override
	public Loan updateLoan(Loan loan) {
		LoanEntity loanEntity = mapToLoanEntity(loan);
		loanRepositoryDatabase.save(loanEntity);
		return mapToLoan(loanEntity);
	}
	
	private Loan mapToLoan(LoanEntity loanEntity) {
		return LoanMapper.loanEntitytoLoan(loanEntity);
	}
	
	private LoanEntity mapToLoanEntity(Loan loan) {
		Optional<BookEntity> temporalBookEntity =
				bookRepositoryDatabase.findById(loan.getIdBook());
		
		Optional<LibraryUserEntity> temporalLibraryUserEntity =
				libraryUserRepositoryDatabase.findById(loan.getIdLibraryUser());
		
		if(temporalBookEntity.isEmpty() || temporalLibraryUserEntity.isEmpty())
			throwIdsException(temporalBookEntity, temporalLibraryUserEntity);

		
		return LoanMapper.loantoLoanEntity(loan, temporalBookEntity.get(), temporalLibraryUserEntity.get());
	}
	
	private void throwIdsException(
			Optional<BookEntity> temporalBookEntity,
			Optional<LibraryUserEntity> temporalLibraryUserEntity
	) {
		if(temporalBookEntity.isEmpty())
			throw new IdBookNotFoundException();
		
		if(temporalLibraryUserEntity.isEmpty())
			throw new IdLibraryUserNotFoundException();
	}
	
}

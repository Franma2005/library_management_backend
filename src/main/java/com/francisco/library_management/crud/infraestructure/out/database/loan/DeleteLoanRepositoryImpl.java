package com.francisco.library_management.crud.infraestructure.out.database.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.crud.application.ports.loan.DeleteLoanRepository;
import com.francisco.library_management.crud.domain.filter.Criteria;
import com.francisco.library_management.crud.domain.filter.CriteriaBuilder;
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
public class DeleteLoanRepositoryImpl implements DeleteLoanRepository {

	private final LoanRepositoryDatabase loanRepositoryDatabase;
	private final LoanByCriteriaRepositoryImpl loanByCriteriaRepositoryImpl;
	private final BookRepositoryDatabase bookRepositoryDatabase;
	private final LibraryUserRepositoryDatabase libraryUserRepositoryDatabase;
	
	public DeleteLoanRepositoryImpl(
			LoanRepositoryDatabase loanRepositoryDatabase,
			LoanByCriteriaRepositoryImpl loanByCriteriaRepositoryImpl,
			BookRepositoryDatabase bookRepositoryDatabase,
			LibraryUserRepositoryDatabase libraryUserRepositoryDatabase
	) {
		this.loanRepositoryDatabase = loanRepositoryDatabase;
		this.loanByCriteriaRepositoryImpl = loanByCriteriaRepositoryImpl;
		this.bookRepositoryDatabase = bookRepositoryDatabase;
		this.libraryUserRepositoryDatabase = libraryUserRepositoryDatabase;
	}

	@Override
	public boolean deleteLoan(long id) {
		Loan loan = getLoanForDelete(id);
		LoanEntity loanEntity = mapToLoanEntity(loan);
		loanRepositoryDatabase.delete(loanEntity);
		return true;
	}
	
	private Loan getLoanForDelete(long id) {
		Criteria criteria = new CriteriaBuilder()
				.addFilterIfPresent("idLoan", Optional.of(id))
				.build();
		List<Loan> loanEntityGroup =
				loanByCriteriaRepositoryImpl.findLoanByCriteria(criteria);
		return loanEntityGroup.get(0);	
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

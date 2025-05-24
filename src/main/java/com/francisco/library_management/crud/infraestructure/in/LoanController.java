package com.francisco.library_management.crud.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.crud.infraestructure.dto.LoanDto;
import com.francisco.library_management.crud.infraestructure.recive.LoanRecive;
import com.francisco.library_management.crud.usecase.loan.AllLoansUseCase;
import com.francisco.library_management.crud.usecase.loan.CreateLoanUseCase;
import com.francisco.library_management.crud.usecase.loan.DeleteLoanUseCase;
import com.francisco.library_management.crud.usecase.loan.UpdateLoanUseCase;

@RestController
@RequestMapping("/loan")
public class LoanController {

	private AllLoansUseCase allLoansUseCase;
	private CreateLoanUseCase createLoanUseCase;
	private UpdateLoanUseCase updateLoanUseCase;
	private DeleteLoanUseCase deleteLoanUseCase;
	
	public LoanController(AllLoansUseCase allLoansUseCase, CreateLoanUseCase createLoanUseCase, UpdateLoanUseCase updateLoanUseCase, DeleteLoanUseCase deleteLoanUseCase) {
		this.allLoansUseCase = allLoansUseCase;
		this.createLoanUseCase = createLoanUseCase;
		this.updateLoanUseCase = updateLoanUseCase;
		this.deleteLoanUseCase = deleteLoanUseCase;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<LoanDto>> getAllLoan(
			@RequestParam(required = false) Long idLoan,
			@RequestParam(required = false) Long idBook,
			@RequestParam(required = false) Long idLibraryUser
 	) {
		return ResponseEntity.ok(
				allLoansUseCase.findAllLoan(
						idLoan,
						idBook, 
						idLibraryUser
				)
		);
	}
	
	@PostMapping("/")
	public ResponseEntity<LoanDto> createLoan(
			@RequestBody LoanRecive loanRecive
	) {
		return ResponseEntity.ok(
				createLoanUseCase.createLoan(loanRecive)
		);
	}
	
	@PutMapping("/")
	public ResponseEntity<LoanDto> updateLoan(
			@RequestBody LoanRecive loanRecive
	) {
		return ResponseEntity.ok(
				updateLoanUseCase.updateLoan(loanRecive)
		);
	}
	
	@DeleteMapping("/")
	public ResponseEntity<LoanDto> deleteLoan(
			@RequestParam Long id
	) {
		return ResponseEntity.ok(
				deleteLoanUseCase.deleteLoan(id)
		);
	}
	
}

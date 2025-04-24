package com.francisco.library_management.infraestructure.in;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.infraestructure.dto.LoanDto;
import com.francisco.library_management.usecase.loan.AllLoansUseCase;

@RestController
@RequestMapping("/loan")
public class LoanController {

	private AllLoansUseCase allLoansUseCase;
	
	public LoanController(AllLoansUseCase allLoansUseCase) {
		this.allLoansUseCase = allLoansUseCase;
	}
	
	public ResponseEntity<List<LoanDto>> getAllLoan(
			@RequestParam(required = false) Long idLoan,
			@RequestParam(required = false) Long idBook,
			@RequestParam(required = false) Long idLibraryUser
 	) {
		return allLoansUseCase.findAllLoan(
				idLoan,
				idBook, 
				idLibraryUser
		);
	}
	
	public ResponseEntity<LoanDto> createLoan() {
		return null;
	}
	
	public ResponseEntity<LoanDto> updateLoan() {
		return null;
	}
	
	public ResponseEntity<LoanDto> deleteLoan() {
		return null;
	}
	
}

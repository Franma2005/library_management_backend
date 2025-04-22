package com.francisco.library_management.infraestructure.in;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.library_management.domain.models.Loan;

@RestController
@RequestMapping("/loan")
public class LoanController {

	public ResponseEntity<Loan> getAllLoan(
			@RequestParam(required = false) long idLoan,
			@RequestParam(required = false) long idBook,
			@RequestParam(required = false) long idLibraryUser
 	) {
		return null;
	}
	
	public ResponseEntity<Loan> createLoan() {
		return null;
	}
	
	public ResponseEntity<Loan> updateLoan() {
		return null;
	}
	
	public ResponseEntity<Loan> deleteLoan() {
		return null;
	}
	
}

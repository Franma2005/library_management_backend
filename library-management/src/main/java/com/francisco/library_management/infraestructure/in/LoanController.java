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
			@RequestParam long idLoan,
			@RequestParam long idBook,
			@RequestParam long idLibraryUser
 	) {
		return null;
	}
	
}

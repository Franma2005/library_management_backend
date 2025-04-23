package com.francisco.library_management.infraestructure.out.database.entities;

import java.time.LocalDateTime;

public class LoanEntity {
	private long idLoan;
	private long idBook;
	private long idLibraryUser;
	private LocalDateTime time;
}

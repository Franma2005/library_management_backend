package com.francisco.library_management.infraestructure.recive;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoanRecive {
	private long idLoan;
	private long idBook;
	private long idLibraryUser;
	private LocalDateTime time;
}

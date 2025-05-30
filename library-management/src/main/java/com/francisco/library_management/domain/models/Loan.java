package com.francisco.library_management.domain.models;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Loan {
	private long idLoan;
	private long idBook;
	private long idLibraryUser;
	private LocalDateTime time;
}

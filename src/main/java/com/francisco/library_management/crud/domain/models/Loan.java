package com.francisco.library_management.crud.domain.models;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Loan {
	private Long idLoan;
	private Long idBook;
	private Book book;
	private Long idLibraryUser;
	private LibraryUser libraryUser;
	private LocalDateTime time;
}

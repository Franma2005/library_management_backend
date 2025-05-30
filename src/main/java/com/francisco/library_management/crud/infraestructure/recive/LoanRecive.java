package com.francisco.library_management.crud.infraestructure.recive;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class LoanRecive {
	private Long idLoan;
	private Long idBook;
	private Long idLibraryUser;
	private LocalDateTime time;
}

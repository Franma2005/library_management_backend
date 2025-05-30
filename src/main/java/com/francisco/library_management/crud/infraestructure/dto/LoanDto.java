package com.francisco.library_management.crud.infraestructure.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class LoanDto {
	private Long idLoan;
	private BookDto book;
	private LibraryUserDto libraryUser;
	private LocalDateTime time;
}

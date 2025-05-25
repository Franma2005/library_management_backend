package com.francisco.library_management.crud.infraestructure.out.database.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loan")
public class LoanEntity {
	@Id
	private Long idLoan;
	@ManyToOne
	@JoinColumn(name = "book")
	private BookEntity book;
	@ManyToOne
	@JoinColumn(name = "libraryUser")
	private LibraryUserEntity libraryUser;
	private LocalDateTime time;
}

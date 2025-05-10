package com.francisco.library_management.infraestructure.out.database.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "loan")
public class LoanEntity {
	@Id
	private long idLoan;
	private long idBook;
	private long idLibraryUser;
	private LocalDateTime time;
}

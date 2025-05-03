package com.francisco.library_management.infraestructure.out.database.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Entity
@Table(name = "loan")
public class LoanEntity {
	@Id
	@Column(name = "idLoan")
	private long idLoan;
	@Column(name = "idBook")
	private long idBook;
	@Column(name = "idLibraryUser")
	private long idLibraryUser;
	@Column(name = "time")
	private LocalDateTime time;
}

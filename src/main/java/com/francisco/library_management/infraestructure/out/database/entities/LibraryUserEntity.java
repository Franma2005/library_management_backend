package com.francisco.library_management.infraestructure.out.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "libraryUser")
public class LibraryUserEntity {
	@Id
	private long id;
	private String name;
	private String surname;
}

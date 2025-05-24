package com.francisco.library_management.crud.infraestructure.out.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "libraryUser")
public class LibraryUserEntity {
	@Id
	private long id;
	private String name;
	private String surname;
}

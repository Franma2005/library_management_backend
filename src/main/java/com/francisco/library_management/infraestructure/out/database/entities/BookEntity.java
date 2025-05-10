package com.francisco.library_management.infraestructure.out.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "book")
public class BookEntity {
	@Id
	private Long id;
	private String name;
	private String author;
	private String editorial;
	private Long category;
}

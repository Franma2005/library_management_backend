package com.francisco.library_management.infraestructure.out.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BookEntity {
	@Id
	private long id;
	private String name;
	private String author;
	private String editorial;
	private long category;
}

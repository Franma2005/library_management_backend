package com.francisco.library_management.crud.infraestructure.out.database.entities;

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
@Table(name = "book")
public class BookEntity {
	@Id
	private Long id;
	private String name;
	private String author;
	private String editorial;
	@ManyToOne
	@JoinColumn(name = "category")
	private CategoryEntity category;
}

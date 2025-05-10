package com.francisco.library_management.infraestructure.out.database.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
	private Long id;
	private String category;
}

package com.francisco.library_management.infraestructure.out.database.entities;

import jakarta.persistence.Column;
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
	@Column(name = "id")
	private long id;
	@Column(name = "category")
	private String category;
}

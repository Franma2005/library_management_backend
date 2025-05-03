package com.francisco.library_management.infraestructure.out.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.library_management.infraestructure.out.database.entities.CategoryEntity;

public interface CategoryRepositoryDatabase extends JpaRepository<CategoryEntity, Long> {

}

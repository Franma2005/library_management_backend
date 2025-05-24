package com.francisco.library_management.crud.infraestructure.out.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.library_management.crud.infraestructure.out.database.entities.LibraryUserEntity;

public interface LibraryUserRepositoryDatabase extends JpaRepository<LibraryUserEntity, Long> {

}

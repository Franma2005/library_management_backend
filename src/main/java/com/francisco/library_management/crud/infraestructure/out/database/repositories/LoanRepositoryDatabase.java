package com.francisco.library_management.crud.infraestructure.out.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.library_management.crud.infraestructure.out.database.entities.LoanEntity;

public interface LoanRepositoryDatabase extends JpaRepository<LoanEntity, Long> {

}

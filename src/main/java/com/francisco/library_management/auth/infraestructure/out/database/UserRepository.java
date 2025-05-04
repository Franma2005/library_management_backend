package com.francisco.library_management.auth.infraestructure.out.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.francisco.library_management.auth.infraestructure.out.database.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

package com.francisco.library_management.application.ports.libraryUser;

import org.springframework.stereotype.Repository;

@Repository
public interface LibraryUserRepository extends AllLibraryUsersRepository, LibraryUserByCriteriaRepository, CreateLibraryUserRepository, UpdateLibraryUserRepository, DeleteLibraryUserRepository {

}

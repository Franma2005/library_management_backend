package com.francisco.library_management.application.ports.book;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends AllBooksRepository, BookByCriteriaRepository, CreateBookRepository, UpdateBookRepository, DeleteBookRepository {

}

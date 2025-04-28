package com.francisco.library_management.application.ports.book;

public interface BookRepository extends AllBooksRepository, BookByCriteriaRepository, CreateBookRepository, UpdateBookRepository, DeleteBookRepository {

}

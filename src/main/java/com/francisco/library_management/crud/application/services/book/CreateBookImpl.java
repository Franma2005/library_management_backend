package com.francisco.library_management.crud.application.services.book;

import com.francisco.library_management.crud.domain.models.Book;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.CreateBookRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.CreateBook;

@Service
public class CreateBookImpl implements CreateBook {

	private CreateBookRepository createBookRepository;
	private NotificationBookPort notificationRepository;
	
	public CreateBookImpl(CreateBookRepository createBookRepository) {
		this.createBookRepository = createBookRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void createBook(Book book) {
		createBookRepository.createBook(book);
		notificationRepository.notifyBooksChanges();
	}
	
}

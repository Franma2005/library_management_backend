package com.francisco.library_management.crud.application.services.book;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.CreateBookRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.CreateBook;

@Service
public class CreateBookImpl implements CreateBook {

	private CreateBookRepository createBookRepository;
	private NotificationPort notificationPort;
	
	public CreateBookImpl(
			CreateBookRepository createBookRepository,
			NotificationPort notificationPort
	) {
		this.createBookRepository = createBookRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public void createBook(Book book) {
		createBookRepository.createBook(book);
		notificationPort.sendNotification(NotificationType.BOOKRELOAD);
	}
	
}

package com.francisco.library_management.crud.application.services.book;

import com.francisco.library_management.crud.domain.models.Book;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.UpdateBookRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.UpdateBook;


@Service
public class UpdateBookImpl implements UpdateBook {

	private UpdateBookRepository updateBookRepository;
	private NotificationPort notificationPort;
	
	public UpdateBookImpl(
			UpdateBookRepository updateBookRepository,
			NotificationPort notificationPort
	) {
		this.updateBookRepository = updateBookRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public Book updateBook(Book book) {
		Book bookResponse = updateBookRepository.updateBook(book);
		notificationPort.sendNotification(NotificationType.BOOKRELOAD);
		return bookResponse;
	}

}

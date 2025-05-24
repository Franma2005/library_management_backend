package com.francisco.library_management.crud.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.DeleteBook;
import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

@Service
public class DeleteBookImpl implements DeleteBook {

	private DeleteBookRepository deleteBookRepository;
	private NotificationPort notificationPort;
	
	public DeleteBookImpl(
			DeleteBookRepository deleteBookRepository,
			NotificationPort notificationPort
	) {
		this.deleteBookRepository = deleteBookRepository;
		this.notificationPort = notificationPort;
	}
	
	@Override
	public void deleteBook(Long id) {
		deleteBookRepository.deleteBook(id);
		notificationPort.sendNotification(NotificationType.BOOKRELOAD);
	}
	
}

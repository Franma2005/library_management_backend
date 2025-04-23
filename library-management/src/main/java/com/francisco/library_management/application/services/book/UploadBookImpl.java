package com.francisco.library_management.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.UploadBookRepository;
import com.francisco.library_management.application.ports.notification.NotificationBookPort;
import com.francisco.library_management.application.services.servicesInterfaces.book.UploadBook;
import com.francisco.library_management.domain.models.Book;

@Service
public class UploadBookImpl implements UploadBook {

	private UploadBookRepository uploadBookRepository;
	private NotificationBookPort notificationRepository;
	
	public UploadBookImpl(UploadBookRepository uploadBookRepository, NotificationBookPort notificationRepository) {
		this.uploadBookRepository = uploadBookRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void uploadBook(Book book) {
		uploadBookRepository.uploadBook(book);
		notificationRepository.notifyBooksChanges();
	}

}

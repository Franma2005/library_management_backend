package com.francisco.library_management.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.UpdateBookRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.UpdateBook;
import com.francisco.library_management.domain.models.Book;

@Service
public class UpdateBookImpl implements UpdateBook {

	private UpdateBookRepository updateBookRepository;
	//private NotificationBookPort notificationRepository;
	
	public UpdateBookImpl(UpdateBookRepository updateBookRepository) {
		this.updateBookRepository = updateBookRepository;
		//this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void updateBook(Book book) {
		updateBookRepository.updateBook(book);
		//notificationRepository.notifyBooksChanges();
	}

}

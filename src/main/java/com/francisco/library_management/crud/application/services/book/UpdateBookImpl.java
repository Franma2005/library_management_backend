package com.francisco.library_management.crud.application.services.book;

import com.francisco.library_management.crud.domain.models.Book;
import org.springframework.stereotype.Service;

import com.francisco.library_management.crud.application.ports.book.UpdateBookRepository;
import com.francisco.library_management.crud.application.services.servicesInterfaces.book.UpdateBook;


@Service
public class UpdateBookImpl implements UpdateBook {

	private UpdateBookRepository updateBookRepository;
	private NotificationBookPort notificationRepository;
	
	public UpdateBookImpl(UpdateBookRepository updateBookRepository) {
		this.updateBookRepository = updateBookRepository;
		this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void updateBook(Book book) {
		updateBookRepository.updateBook(book);
		notificationRepository.notifyBooksChanges();
	}

}

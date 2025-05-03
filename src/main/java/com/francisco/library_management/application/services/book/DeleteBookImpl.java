package com.francisco.library_management.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.DeleteBookRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.DeleteBook;

@Service
public class DeleteBookImpl implements DeleteBook {

	private DeleteBookRepository deleteBookRepository;
	//private NotificationBookPort notificationRepository;
	
	public DeleteBookImpl(DeleteBookRepository deleteBookRepository) {
		this.deleteBookRepository = deleteBookRepository;
		//this.notificationRepository = notificationRepository;
	}
	
	@Override
	public void deleteBook(Long id) {
		deleteBookRepository.deleteBook(id);
		//notificationRepository.notifyBooksChanges();
	}
	
}

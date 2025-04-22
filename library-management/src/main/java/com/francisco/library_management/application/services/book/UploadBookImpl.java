package com.francisco.library_management.application.services.book;

import org.springframework.stereotype.Service;

import com.francisco.library_management.application.ports.book.UploadBookRepository;
import com.francisco.library_management.application.services.servicesInterfaces.book.UploadBook;
import com.francisco.library_management.domain.models.Book;

@Service
public class UploadBookImpl implements UploadBook {

	private UploadBookRepository uploadBookRepository;
	
	public UploadBookImpl(UploadBookRepository uploadBookRepository) {
		this.uploadBookRepository = uploadBookRepository;
	}
	
	@Override
	public void uploadBook(Book book) {
		uploadBookRepository.uploadBook(book);
	}

}

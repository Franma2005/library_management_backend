package com.francisco.library_management.notificationAdapter.infraestructure.ws;

import com.francisco.library_management.notificationAdapter.useCase.BookNotificationUseCase;
import com.francisco.library_management.notificationAdapter.useCase.CategoryNotificationUseCase;
import com.francisco.library_management.notificationAdapter.useCase.LibraryUserNotificationUseCase;
import com.francisco.library_management.notificationAdapter.useCase.LoanNotificationUseCase;

public class NotificationController {

	private BookNotificationUseCase bookNotificationUseCase;
	private CategoryNotificationUseCase categoryNotificationUseCase;
	private LibraryUserNotificationUseCase libraryUserNotificationUseCase;
	private LoanNotificationUseCase loanNotificationUseCase;
	
	public NotificationController(
			BookNotificationUseCase bookNotificationUseCase,
			CategoryNotificationUseCase categoryNotificationUseCase,
			LibraryUserNotificationUseCase libraryUserNotificationUseCase,
			LoanNotificationUseCase loanNotificationUseCase
	) {
		this.bookNotificationUseCase = bookNotificationUseCase;
		this.categoryNotificationUseCase = categoryNotificationUseCase;
		this.libraryUserNotificationUseCase = libraryUserNotificationUseCase;
		this.loanNotificationUseCase = loanNotificationUseCase;
	}
	
	
	
}

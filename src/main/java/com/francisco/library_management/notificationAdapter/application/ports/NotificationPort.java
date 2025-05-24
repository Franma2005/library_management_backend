package com.francisco.library_management.notificationAdapter.application.ports;

import org.springframework.stereotype.Repository;

import com.francisco.library_management.notificationAdapter.model.NotificationType;

@Repository
public interface NotificationPort {
	
	public void sendNotification(NotificationType notificationTye);
	
}

package com.francisco.library_management.notificationAdapter.infraestructure.ws;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.francisco.library_management.notificationAdapter.application.ports.NotificationPort;
import com.francisco.library_management.notificationAdapter.model.NotificationMessage;
import com.francisco.library_management.notificationAdapter.model.NotificationType;

@Controller
public class NotificationController implements NotificationPort {

	private final SimpMessagingTemplate simpMessagingTemplate;
	
	public NotificationController(
			SimpMessagingTemplate simpMessagingTemplate
	) {
		this.simpMessagingTemplate = simpMessagingTemplate;
	}

	@Override
	public void sendNotification(NotificationType notificationType) {
		NotificationMessage notificationMessage = new NotificationMessage();
		simpMessagingTemplate.convertAndSend("alert/notifications", notificationMessage);
	}

	
}

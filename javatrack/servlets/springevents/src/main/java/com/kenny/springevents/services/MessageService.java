package com.kenny.springevents.services;


import org.springframework.stereotype.Service;

import com.kenny.springevents.models.Message;
import com.kenny.springevents.repositories.MessageRepository;

@Service
public class MessageService {
	private MessageRepository messageRepo;
	
	public MessageService(MessageRepository messageRepo)     {
        this.messageRepo = messageRepo;
    }

	public void saveMessage(Message newMessage) {
		messageRepo.save(newMessage);
	}
	
}

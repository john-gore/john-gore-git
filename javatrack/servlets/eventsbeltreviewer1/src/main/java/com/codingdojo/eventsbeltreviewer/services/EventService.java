package com.codingdojo.eventsbeltreviewer.services;

import org.springframework.stereotype.Service;

import com.codingdojo.eventsbeltreviewer.models.Event;
import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.repositories.EventRepo;
import com.codingdojo.eventsbeltreviewer.repositories.UserRepo;

@Service
public class EventService {
	private UserRepo uRepo;
	private EventRepo eRepo;
	
	public EventService(UserRepo uRepo, EventRepo eRepo) {
		this.uRepo = uRepo;
		this.eRepo = eRepo;
	}
	public void saveEvent(Event event) {
        eRepo.save(event);
    }
	
}

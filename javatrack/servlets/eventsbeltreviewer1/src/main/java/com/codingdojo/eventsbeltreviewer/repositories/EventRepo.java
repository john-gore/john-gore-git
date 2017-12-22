package com.codingdojo.eventsbeltreviewer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.eventsbeltreviewer.models.Event;


public interface EventRepo extends CrudRepository<Event, Long> {
	
}

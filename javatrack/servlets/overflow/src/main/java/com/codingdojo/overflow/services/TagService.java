package com.codingdojo.overflow.services;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.repositories.TagRepository;

@Service
public class TagService {
	private final TagRepository tagRepo;
	
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}

	public Tag findOrCreateTag(String subject) {
		Tag tagByName = tagRepo.findBySubject(subject); 
		if(tagByName == null) {
			Tag tag = new Tag();
			tag.setSubject(subject);
			return tagRepo.save(tag);
		} else {
			return tagByName;
		}
	}

}

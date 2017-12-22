package com.codingdojo.jpa.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.jpa.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
	List<Language> findAll();
	
	
}

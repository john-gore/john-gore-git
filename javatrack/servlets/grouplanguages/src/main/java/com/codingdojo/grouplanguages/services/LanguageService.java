package com.codingdojo.grouplanguages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.grouplanguages.models.Language;
import com.codingdojo.grouplanguages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private LanguageRepository languageRepo;
	
	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> getLanguages() {
		return languageRepo.findAll();
	}
	
	public void addLanguage(Language lang) {
		languageRepo.save(lang);
	}
	
	public Language getLanguage(Long id) {
		return languageRepo.findOne(id);
	}
	
	public void updateLanguage(Language lang) {
		languageRepo.save(lang);
	}
	
	public void deleteLanguage(Long id) {
		languageRepo.delete(id);
	}	
}

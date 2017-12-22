package com.codingdojo.overflow.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.repositories.QuestionRepository;
@Service
public class QuestionService {
	private QuestionRepository questionRepo;
	
	public QuestionService(QuestionRepository questionRepo) {
		this.questionRepo = questionRepo;
	}
	public List<Question> getAllQuestions() {
		return questionRepo.findAll();
	}
	public void createQuestion(Question question) {
		questionRepo.save(question);
		
	}
	public Object findOne(Long id) {
		return questionRepo.findOne(id);
	}
}

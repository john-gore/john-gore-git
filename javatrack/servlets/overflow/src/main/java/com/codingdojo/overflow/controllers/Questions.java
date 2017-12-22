package com.codingdojo.overflow.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.overflow.models.Answer;
import com.codingdojo.overflow.models.Question;
import com.codingdojo.overflow.models.Tag;
import com.codingdojo.overflow.services.QuestionService;
import com.codingdojo.overflow.services.TagService;



@Controller
public class Questions {
	private final QuestionService qService;
	private final TagService tService;
	
	public Questions(QuestionService qService, TagService tService) {
		this.qService = qService;
		this.tService = tService;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(List.class, "tags", new CustomCollectionEditor(List.class) {                
	                  
	        public void setAsText(String element) {
	        	// information coming from the form
	        	String[] listOfTagString = element.split(", ");
	        	List<Tag> listOfTags = new ArrayList<Tag>();
	        	
	        	int maxLength = listOfTagString.length > 2 ? 3 : listOfTagString.length;
	        	
	        	for(int i = 0; i < maxLength; i++) {
	        		listOfTags.add(tService.findOrCreateTag(listOfTagString[i]));
	        	}
	        	
	        	// set the value of the element to be a list of tags
	        	setValue(listOfTags);
	        }
        }); 
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("questions", qService.getAllQuestions());
		return "/questions/index.jsp";
	}
	
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("questionModel") Question question) {
		return "/questions/new.jsp";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("questionModel") Question question, BindingResult result, @RequestParam("tags") String tags) {
		if(result.hasErrors()) {
			System.out.println(question);
			return "/questions/new.jsp";	
		} else {
			System.out.println(question);
			qService.createQuestion(question);
			return "redirect:/";
		}
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, @ModelAttribute("answerModel") Answer answer, Model model) {
		model.addAttribute("question", qService.findOne(id));
		return "/questions/show.jsp";
	}
}

package com.codingdojo.learningplatform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
    public String index() {
            return "index.jsp";}
    

	@RequestMapping("/m/{chapter}/0483/{assignmentNumber}")
    public String assignment(@PathVariable("assignmentNumber") String assignmentNumber, Model model){
		String goal;
		if(assignmentNumber.equals("0345")) {
			goal = "The goal of the assignment is to comlete it!";
		} else {
			goal = "We are going into binary";
		}
		
		model.addAttribute("goal", goal);
		return "assignment.jsp";
	}
	
	@RequestMapping("/m/{chapter}/0553/{lessonNumber}")
    public String lesson(@PathVariable("lessonNumber") String lessonNumber, Model model){
		String goal;
		
		if(lessonNumber.equals("0733")) {
			goal = "Setting up your servers";
		} 
		else if(lessonNumber.equals("0342")) {
			goal = "We are going into binary";
		}
		else {
			goal = "Fortran to Binary";
		}
		
		model.addAttribute("goal", goal);
		return "lesson.jsp";
	}
}


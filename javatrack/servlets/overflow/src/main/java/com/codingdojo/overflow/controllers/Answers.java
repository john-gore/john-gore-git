package com.codingdojo.overflow.controllers;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class Answers {

	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

}

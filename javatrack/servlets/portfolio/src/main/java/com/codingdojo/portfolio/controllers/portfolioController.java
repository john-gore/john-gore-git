package com.codingdojo.portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class portfolioController {
	@RequestMapping("/")
	public String index() {
		return "forward:/index.html";
	}
	@RequestMapping("/projects")
	public String projects() {
		return "forward:/project.html";
	}
	@RequestMapping("/me")
	public String aboutme() {
		return "forward:/aboutMePage.html";
	}
}

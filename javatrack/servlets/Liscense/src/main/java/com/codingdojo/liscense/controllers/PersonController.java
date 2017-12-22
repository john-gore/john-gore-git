package com.codingdojo.liscense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.liscense.models.License;
import com.codingdojo.liscense.models.Person;
import com.codingdojo.liscense.services.DriversService;

@Controller
public class PersonController {
	private final DriversService dService;

	public PersonController(DriversService dService) {
		this.dService = dService;
	}
	@RequestMapping("/")
		public String index(Model model) {
		//get all people
		List<Person> people = dService.getPeople();
		System.out.println(people);
		model.addAttribute("people", people);
		return "index.jsp";
	}
	
	
	@RequestMapping("/persons/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "new.jsp";
    }
	
	
	@PostMapping("/persons")
	public String addPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} 
		//send person to the service
		dService.addPerson(person);
		return "redirect:/";
	}
	
	
	@RequestMapping("/licenses/new")
	public String newlicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("people", dService.getPeople());
		return "license.jsp";
	}
	@PostMapping("/licenses")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
		System.out.println(license.getPerson());
		if(result.hasErrors()) {
			model.addAttribute("people", dService.getPeople());
			return "license.jsp";
		}
		// go the service
		dService.addLicense(license);
		return "redirect:/";
	}
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable Long id, Model model) {
		model.addAttribute("person", dService.findOne(id));
		return "profile.jsp";
	}
}








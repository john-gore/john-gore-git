package com.codingdojo.eventsbeltreviewer.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.eventsbeltreviewer.models.Event;
import com.codingdojo.eventsbeltreviewer.models.User;
import com.codingdojo.eventsbeltreviewer.services.UserService;
import com.codingdojo.eventsbeltreviewer.validator.UserValidator;




@Controller
public class UserController {
	private UserService uService;
	private UserValidator userValidator;
	
	public UserController(UserService uService, UserValidator userValidator) {
        this.uService = uService;
        this.userValidator = userValidator;
    }
	
	
	@RequestMapping("/login")
	public String registerForm(@Valid @ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
		return "login.jsp";
	}
	
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "login.jsp";
        }
        
        uService.saveUser(user);
        return "redirect:/login";
    }
	
	@RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model, @Valid @ModelAttribute("event") Event event) {
        // 1
        String email = principal.getName();
        System.out.println(email);
        model.addAttribute("currentUser", uService.findByEmail(email));
        return "dashboard.jsp";
    }
	@RequestMapping("/logout")
    public String logout() {
        return "redirect:/login";
	}
	
}

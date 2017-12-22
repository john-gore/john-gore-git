package com.codingdojo.login_reg.controllers;

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

import com.codingdojo.login_reg.models.User;
import com.codingdojo.login_reg.services.UserService;
import com.codingdojo.login_reg.validator.UserValidator;

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
        return "index.jsp";
    }
	
	@PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
        
        uService.saveWithUserRole(user);
        return "redirect:/login";
    }
	
	@RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("currentUser", uService.findByEmail(email));
        return "adminPage.jsp";
    }
	
	@RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
        // 1
        String email = principal.getName();
        System.out.println(email);
        model.addAttribute("currentUser", uService.findByEmail(email));
        return "dashboard.jsp";
    }
}

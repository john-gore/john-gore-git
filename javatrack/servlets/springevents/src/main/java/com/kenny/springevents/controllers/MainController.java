package com.kenny.springevents.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kenny.springevents.models.GetTogether;
import com.kenny.springevents.models.Message;
import com.kenny.springevents.models.User;
import com.kenny.springevents.services.GetTogetherService;
import com.kenny.springevents.services.MessageService;
import com.kenny.springevents.services.UserService;
import com.kenny.springevents.utilities.StateList;
import com.kenny.springevents.validators.UserValidator;

@Controller
public class MainController {
    private UserService userService;
    private UserValidator userValidator;
    private GetTogetherService getTogetherService;
    private MessageService messageService;
    
    public MainController(UserService userService, UserValidator userValidator, GetTogetherService getTogetherService, MessageService messageService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.getTogetherService = getTogetherService;
        this.messageService = messageService;
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result,
    		Model model, HttpSession session, RedirectAttributes redirectAttributes, HttpServletRequest request) throws ServletException {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            model.addAttribute("stateMap", StateList.STATE_MAP);
            return "loginreg.jsp";
        }
    	String oldPass = user.getPassword();
    	userService.saveWithUserRole(user);
        request.login(user.getEmail(), oldPass);
        System.out.println(request.getUserPrincipal().getName());
        return "redirect:/events";
    }

    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error,
    		@RequestParam(value="logout", required=false) String logout, 
    		@ModelAttribute("regMessage") String regMessage,
    		Model model, Principal principal, @ModelAttribute("user") User user) {
	    	if (principal != null) {
	    		return "redirect:/events";
	    	}
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        model.addAttribute("stateMap", StateList.STATE_MAP);
//        if(regsuccess != null) {
//        	model.addAttribute("regMessage", "Registration Successful please login");
//        }
        return "loginreg.jsp";
    }
    
    @RequestMapping("/events")
    public String home(Principal principal, Model model, @ModelAttribute("getTogether") GetTogether getTogether) {
        String email = principal.getName();
        User loggedUser = userService.findByEmail(email);
        model.addAttribute("currentUser", loggedUser);
        model.addAttribute("stateMap", StateList.STATE_MAP);
        model.addAttribute("inStateGetTogethers", getTogetherService.findByStateLike(loggedUser.getState()));
        model.addAttribute("outStateGetTogethers", getTogetherService.findByStateNotLike(loggedUser.getState()));
        return "dashboard.jsp";
    }
    
    @PostMapping("/events/create")
    public String createEvent(@Valid @ModelAttribute("getTogether") GetTogether getTogether, BindingResult result,
    		Principal principal, Model model) {
    	String email = principal.getName();
    	User loggedUser = userService.findByEmail(email);
    	if(result.hasErrors()) {
            model.addAttribute("currentUser", loggedUser);
            model.addAttribute("stateMap", StateList.STATE_MAP);
            model.addAttribute("inStateGetTogethers", getTogetherService.findByStateLike(loggedUser.getState()));
            model.addAttribute("outStateGetTogethers", getTogetherService.findByStateNotLike(loggedUser.getState()));
            return "dashboard.jsp";
    	}
	    	getTogether.setCreatedByUser(loggedUser);
	    	getTogetherService.save(getTogether);
	    	return "redirect:/events";
    }
    
    @RequestMapping("events/{id}/edit")
    public String getEditForm(Principal principal, @PathVariable("id") Long id,  Model model) {
    	String email = principal.getName();
    	User loggedUser = userService.findByEmail(email);
    	GetTogether getTogether = getTogetherService.findOne(id);
    
    	model.addAttribute("stateMap", StateList.STATE_MAP);
    	model.addAttribute("getTogether", getTogether);
    	if(getTogether.getCreatedByUser() != loggedUser) {
    		return "redirect:/events";
    	}
    	model.addAttribute("stateMap", StateList.STATE_MAP);
    	model.addAttribute("getTogether", getTogether);
    		return "editevent.jsp";
    }
    
    @RequestMapping("events/{id}/delete")
    public String getEditForm(Principal principal, @PathVariable("id") Long id) {
    	String email = principal.getName();
    	User loggedUser = userService.findByEmail(email);
    	GetTogether currEvent = getTogetherService.findOne(id);
    	if(currEvent.getCreatedByUser() == loggedUser) {
    		getTogetherService.delete(currEvent);
    	}
    		return "redirect:/events";
    }
    
    @RequestMapping("events/{id}")
    public String showEvent(Model model, @PathVariable("id") Long id, @ModelAttribute("newMessage") Message newMessage) {
	    	GetTogether currEvent = getTogetherService.findOne(id);
	    	model.addAttribute("currEvent", currEvent);
	    	return "showevent.jsp";
    }

    
    @RequestMapping("events/{id}/join")
    public String joinEvent(Principal principal, @PathVariable("id") Long id) {
	    	String email = principal.getName();
	    	User loggedUser = userService.findByEmail(email);
	    	GetTogether currEvent = getTogetherService.findOne(id);
	    	List<User> attendees = currEvent.getAttendingUsers();
	    	attendees.add(loggedUser);
	    	currEvent.setAttendingUsers(attendees);
	    	getTogetherService.save(currEvent);
	    	return "redirect:/events";
    }
    
    @RequestMapping("events/{id}/cancel")
    public String cancelEvent(Principal principal, @PathVariable("id") Long id) {
	    	String email = principal.getName();
	    	User loggedUser = userService.findByEmail(email);
	    	GetTogether currEvent = getTogetherService.findOne(id);
	    	List<User> attendees = currEvent.getAttendingUsers();
	    	attendees.remove(loggedUser);
	    	currEvent.setAttendingUsers(attendees);
	    	getTogetherService.save(currEvent);
	    	return "redirect:/events";
    }
    
    
    
    @PostMapping("events/{get_id}/messages/add")
    public String addMessage (@PathVariable("get_id") Long get_id, Model model, @Valid @ModelAttribute("newMessage") Message newMessage, 
    		BindingResult result, Principal principal) {
    		System.out.println("Made it into the Messages Service!!!!!");
    		GetTogether currEvent = getTogetherService.findOne(get_id);
	    	if(result.hasErrors()) {
	    		model.addAttribute("currEvent", currEvent);
	    		return "showevent.jsp";
	    	}
	    	String email = principal.getName();
	    	User loggedUser = userService.findByEmail(email);
	    	newMessage.setPoster(loggedUser);
	    	newMessage.setGetTogether(currEvent);
	    messageService.saveMessage(newMessage);
	    	return "redirect:/events/"+ get_id;
    }
    
    
    
    
}

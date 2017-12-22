package com.codingdojo.code.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeController {
//	@RequestMapping("/")
//    public String index(@ModelAttribute("errors") String errors) {
//        System.out.println(errors);
//        return "index.jsp";
//    }
//
//    @RequestMapping(path = "/code", method=RequestMethod.POST)
//    public String errors(RedirectAttributes redirectAttributes, @RequestParam(value="code") String code){
//    		System.out.println(code);
//    		if(code.equals("bushido")) {
//	        redirectAttributes.addFlashAttribute("errors", "You must train harder!");
//	        return "redirect:/";
//	    } else {
//	    		return "code.jsp";
//	    }
//    }
	@RequestMapping("/")
	public String index(HttpSession session) {
		Boolean isIncorrect = (Boolean) session.getAttribute("isIncorrect");
		
		if(isIncorrect == null) {
			session.setAttribute("isIncorrect", false);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping(value="processCode", method=RequestMethod.POST)
	public String process(@RequestParam("code") String code, HttpSession session) {
		if(code.equals("bushido")) {
			session.setAttribute("isIncorrect", false);
			return "redirect:/code";
		} else {
			session.setAttribute("isIncorrect", true);
			return "redirect:/";	
		}
	}
	
	@RequestMapping("/code")
	public String code(HttpSession session) {
		Boolean isIncorrect = (Boolean) session.getAttribute("isIncorrect");

		// only allow users to see the code page if they got the password
		if(isIncorrect) {
			return "redirect:/";
		} else {
			return "code.jsp";	
		}
	}
}

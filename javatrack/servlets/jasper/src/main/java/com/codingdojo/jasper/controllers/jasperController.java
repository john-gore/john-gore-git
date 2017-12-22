package com.codingdojo.jasper.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class jasperController {
	Date date = new java.util.Date();
	private static SimpleDateFormat formatter;
	
	
	@RequestMapping("/")
	public String index(Model model) {
        return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		formatter = new SimpleDateFormat("EEEE, 'the ' d 'of' MMMM, yyyy");
		String formattedDate = formatter.format(date);
        model.addAttribute("date", formattedDate);
        return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		formatter = new SimpleDateFormat("hh:mm aa");
		String formattedDate = formatter.format(date);
        model.addAttribute("date", formattedDate);
        return "time.jsp";
	}
	
	
}

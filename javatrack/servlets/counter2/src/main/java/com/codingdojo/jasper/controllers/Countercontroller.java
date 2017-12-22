package com.codingdojo.jasper.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Countercontroller {
	
	
	
	
	@RequestMapping("/")
    public String index(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		
		if(count == null) {
			session.setAttribute("count", 0);
		} else {
			Integer currentCount = count + 1;
			session.setAttribute("count", currentCount);
		}
        return "index.jsp";
    }
	@RequestMapping("/count")
    public String index() {
		return "counter.jsp";
	}
	@RequestMapping("/add20")
    public String add20(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
			Integer currentCount = count + 20;
			session.setAttribute("count", currentCount);
        return "counter.jsp";
    }
	@RequestMapping("/sub14")
	public String sub14(HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
			Integer currentCount = count - 14;
			session.setAttribute("count", currentCount);
        return "counter.jsp";
    }
	@RequestMapping("/restart")
    public String restart(HttpSession session) {
		session.invalidate();
        return "counter.jsp";
    }
}

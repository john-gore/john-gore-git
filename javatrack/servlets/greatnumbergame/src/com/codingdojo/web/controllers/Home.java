package com.codingdojo.web.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Random num = new Random();
		Integer answer = (Integer) session.getAttribute("answer");
		String result = (String) session.getAttribute("result");
		
		if(answer == null) {
			Integer randomNumber = num.nextInt(100) + 1;
			session.setAttribute("answer", randomNumber);
		}
		
		if(result == null) {
			session.setAttribute("result", "");
		}
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String restart = (String) request.getParameter("restart");
		
		if(restart != null) {
			session.setAttribute("answer", null);
			session.setAttribute("result", null);

		} else {
			Integer guess = Integer.parseInt(request.getParameter("guess"));
			Integer answer = (Integer) session.getAttribute("answer");
			
			if (guess > answer) {
				session.setAttribute("result", "Too High!");
			} else if (guess < answer) {
				session.setAttribute("result", "Too Low!");
			} else {
				session.setAttribute("result", "Correct");
			}
		}
		response.sendRedirect("/greatnumbergame/Home");
	}
	
}

package com.codingdojo.web.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		Integer counter = (Integer) session.getAttribute("counter");
		String generate = request.getParameter("generate");
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String randomWord = "";
		int alphabetLength = alphabet.length();

		if(generate == null) {
			randomWord = "Click the generate button for a random word";
		    session.setAttribute("counter", 0);
		} else {
			Random rand = new Random();
		    for(int i = 0; i < 10; i++) {
		    	int randomNum = rand.nextInt(alphabetLength);
		    	String randomString = String.valueOf(alphabet.charAt(randomNum));
		    	randomWord = randomWord.concat(randomString);
		    }
		    counter++;
		    
		    Date currentDate = new Date();
	        SimpleDateFormat format = new SimpleDateFormat("MMMM d, yyyy - H:m a");
	        String date = format.format(currentDate);
	        session.setAttribute("lastGenerated", date);
		    session.setAttribute("counter", counter);		    
		}
	    request.setAttribute("randomWord", randomWord);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.CalculatorModel;

/**
 * Servlet implementation class Calculator
 */
@WebServlet("/calculate")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calculator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
//      session.invalidate();
      String sessionInput = (String) session.getAttribute("sessionInput");
      String results = (String) session.getAttribute("results");
      CalculatorModel calculator = (CalculatorModel) session.getAttribute("calculator");
      
      if(sessionInput == null) {
      	session.setAttribute("sessionInput", "");
      }

      if(calculator == null) {
      	session.setAttribute("calculator", new CalculatorModel());
      }
      
      if(results == null) {
      	session.setAttribute("results", "");
      }
      
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        CalculatorModel calculator = (CalculatorModel) session.getAttribute("calculator");
        String results = (String) session.getAttribute("results");
        String userInput = request.getParameter("userInput");
        String sessionInput = (String) session.getAttribute("sessionInput");
        String character = (String) request.getParameter("character");
        String currentInput;
                
        if(character.equals("equal")) {
		// splits the user input into an array of numbers and characters
        	String[] inputs = userInput.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        	
        	for(String c : inputs) {
            	if(c.equals("*") || c.equals("/") || c.equals("+") || c.equals("-")) {
                	calculator.performOperation(c);
            	} else {
                	Double currentDigitAsDouble = Double.parseDouble(c);
            		calculator.performOperation(currentDigitAsDouble);
            	}
        	}
        	
    		String newResults;
    		if(results.equals("")) {
    			newResults = results.concat(Double.toString(calculator.getResults()));
    		} else {
    			newResults = results.concat(",").concat(Double.toString(calculator.getResults()));
    		}
  
        	session.setAttribute("results", newResults);
        	session.setAttribute("calculator", null);
        	currentInput = "";
        } else {
        	currentInput = sessionInput.concat(character);
        }

        session.setAttribute("sessionInput", currentInput);
		response.sendRedirect("/Calculator/calculate");
	}

}

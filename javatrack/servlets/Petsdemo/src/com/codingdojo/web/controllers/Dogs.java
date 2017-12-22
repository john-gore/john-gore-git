package com.codingdojo.web.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.codingdojo.web.models.Dog;

/**
 * Servlet implementation class Dogs
 */
@WebServlet("/dogs")
public class Dogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dogs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in the dogs controller");
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		double weight = Double.parseDouble(request.getParameter("weight"));
		
		System.out.println("name: " + name);
		System.out.println("breed: " + breed);
		System.out.println("weight: " + weight);
		
		Dog dog = new Dog(name, breed, weight);
		
		request.setAttribute("dog", dog);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/dog.jsp");
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

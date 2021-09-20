package com.adel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adel.model.InsertData;
import com.adel.model.Memebers;
import com.adel.model.SelectCountry;

@WebServlet("/ServletInsert")
public class ServletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		SelectCountry select = new SelectCountry();
		InsertData data = new  InsertData();
		
	     
		//Here we get parameters from JSP to be able to insert information
		String name = request.getParameter("room");
		Integer countryId = Integer.valueOf(request.getParameter("country"));
		 
		Memebers memebers = new Memebers(name  , countryId);   
		
		try {
			
			data.insertNewMebers(memebers);
			
			List<Memebers> list = select.selectCountry();
			request.setAttribute("countries", list);
			
			RequestDispatcher  dispatcher = request.getRequestDispatcher("room.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			 
			e.printStackTrace();
		} 	
	}

}

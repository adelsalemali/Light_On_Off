package com.adel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adel.model.Memebers;
import com.adel.model.SelectCountry;

@WebServlet("/ServletStart")
public class ServletStart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		//Here just we need to show the list of countries when our webAppliction Starts,
		//so we do not need to come from  list page form to display counties on selection tag,
		//if we do not have this servlet we will not see countries on selection tag
		SelectCountry select = new SelectCountry();
		try {
			List<Memebers> list = select.selectCountry();
			request.setAttribute("countries", list);			
			RequestDispatcher  dispatcher = request.getRequestDispatcher("room.jsp");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			 
			e.printStackTrace();
		}
		
	}
}

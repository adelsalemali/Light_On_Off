package com.adel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adel.model.ListData;
import com.adel.model.Memebers;

@WebServlet("/ServletList")
public class ServletList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		      ListData listData = new ListData(); 
		try {
			 //Here we just display a list by (listData class) 
			 List<Memebers> listmemebers = listData.getCountry();
			 request.setAttribute("abady", listmemebers); 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			 dispatcher.forward(request, response);
		     	
		}catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Message" + e.getMessage());
		}
		
	}
}

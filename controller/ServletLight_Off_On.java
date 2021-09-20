package com.adel.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adel.model.Light_Off_On;

@WebServlet("/ServletLight_Off_On")
public class ServletLight_Off_On extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		Integer roomId = Integer.valueOf(request.getParameter("roomid"));
		boolean status = request.getParameter("turn") != null;
		Light_Off_On light = new Light_Off_On();
		Boolean state;
		if(status) {
			state = light.switchLight(roomId); 
		} else {
			state = light.getLight(roomId);
		}
		if(state != null) {
			response.setContentType("text/plain");
			response.getWriter().printf("%b", state);
		} else {
			response.sendError(404);
		}
    }
 }

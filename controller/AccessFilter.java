package com.adel.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.adel.model.ListData;
import com.adel.model.Memebers;

@WebFilter("/page.jsp")
public class AccessFilter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain) 
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		try { 
			Integer id = Integer.parseInt(request.getParameter("id"));
			ListData listData = new ListData(); 
			try {
				 Memebers memebers = listData.getRoom(id);
				 if(memebers != null) {
					   
					 System.out.println("FILTER WORK, id = " + id +" ROOM" + memebers.getRoom_name() +
							            " country = " + memebers.getCountry_name());
					 
					 System.out.println("ADDR = " + req.getRemoteAddr() + ", HOST = " + req.getRemoteHost());
					 // detection of country by user IP [req.getRemoteAddr()] using http:\\api.iplocation.net 
					 //is impossible because of IP is local address
					 String userCountry = "Canada"; 
					 if(userCountry.equals(memebers.getCountry_name())) {
						 chain.doFilter(request, response);
					 } else {
						 resp.sendError(403);
					 }
				 } else {
					 resp.sendError(404);
				 } 
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Message" + e.getMessage());
				resp.sendError(500);
			}
		} catch(NumberFormatException e) { 
			resp.sendError(400);
		}
	}
}

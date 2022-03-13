package com.dev.web;

import java.io.IOException;

import com.dev.web.dao.AlienDao;
import com.dev.web.model.Alien;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	public class GetAlienController extends HttpServlet{


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int aid = Integer.parseInt(request.getParameter("aid"));
		AlienDao dao = null;
		try {
			dao = new AlienDao();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alien a1 = dao.getAlien(aid);
		
		request.setAttribute("alien", a1);
		RequestDispatcher rd= request.getRequestDispatcher("showAlien.jsp");
		rd.forward(request, response);
		//response.sendRedirect("showAlien.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int aid = Integer.parseInt(request.getParameter("aid"));
		String name = request.getParameter("name");
		String tech = request.getParameter("tech");
		
		AlienDao dao = null;
		try
		{
			dao = new AlienDao();
			int res = dao.postAlien(aid,name,tech);
			if(res != 0) {
				RequestDispatcher rd= request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
			} else {
				System.out.println("failed to insert");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		}
	}
	

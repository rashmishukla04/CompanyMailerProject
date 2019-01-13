package com.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtil.LoginUserDTO;

public class LoginServlet extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String email=request.getParameter("Email");
		String password =request.getParameter("password");
		PrintWriter out=response.getWriter();
		boolean status;
		LoginUserDTO lu=new LoginUserDTO();		
		status=lu.validate(email, password);
		if(status)
		{
			request.getSession().setAttribute("login", "true");
			request.getSession().setAttribute("email", email);
			response.sendRedirect("InboxServlet");
		}
		else
		{
			out.println("<p>Sorry Login fails ! Please retry it</p>");
			request.getRequestDispatcher("index.jsp").include(request,response);
		}
			
	}
	

}

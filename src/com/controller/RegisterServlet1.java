package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUtil.RegisterUserDTO;
import com.beans.User;

/**
 * Servlet implementation class RegisterServlet1
 */
//@WebServlet("/RegisterServlet1")
public class RegisterServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		System.out.println("In do");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String DOB=request.getParameter("dob");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		int contact=Integer.parseInt(request.getParameter("contact"));
		
		User u=new User(name,email+"@cmailer.com",password,gender,DOB,address,city,state,country,contact);
		
		try {
			int status=	RegisterUserDTO.save(u);
			if(status>0)
			{
				out.println("You are successfully registerd");
			}
			else
			{
				out.print("Sorry registration fails");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

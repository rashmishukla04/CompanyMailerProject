package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.DBUtil.ComposeMailDAO;
import com.beans.ComposeMailBean;
import java.io.*;


/**
 * Servlet implementation class ComposeServletProcess
 */
@WebServlet("/ComposeServletProcess")
public class ComposeServletProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComposeServletProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("/Header.jsp").include(request, response);
		
		String receiver=request.getParameter("to");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		message=message.replaceAll("\n","<br/>");
		String email=(String)request.getSession(false).getAttribute("email");
		ComposeMailBean b=new ComposeMailBean(receiver,subject,message,email);
		int i=ComposeMailDAO.save(b);
		if(i>0)
		{
			request.setAttribute("msg", "message successfully sent");
			out.print("<span style='float:left'> Messgae successfully sent</span>");
			request.getRequestDispatcher("ComposeServlet").forward(request, response);
		}
		
		request.getRequestDispatcher("/Footer.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

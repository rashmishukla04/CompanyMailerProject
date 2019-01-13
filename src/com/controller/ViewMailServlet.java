package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import com.DBUtil.ConnectionClass;


public class ViewMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("Header.jsp").include(request, response);
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			response.sendRedirect("index.jsp");
		}
		else
		{
			String email=(String)session.getAttribute("email");
			out.print("<span style='color:red;float:right'>Hi ,"+email+"</span>");
			out.print("<h1>Inbox</h1>");
			int id=Integer.parseInt(request.getParameter("id"));
	
		Connection con=ConnectionClass.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select * from company_mailer_message where id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				out.println("<h2>"+rs.getString("subject")+ "</h2></hr>");
				out.println("<p><b>Message:</b>"+rs.getString("message")+"</p>");
				out.print("<p><a href='DeleteMailServlet?id="+rs.getString(1)+"'>Delete Mail</a></p>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

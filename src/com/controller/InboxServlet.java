package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtil.ConnectionClass;


public class InboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=request.getRequestDispatcher("Header.jsp");
		rd.include(request, response);
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
	
		    Connection con=ConnectionClass.getConnection();
		    try {
			PreparedStatement pr=con.prepareStatement("select * from company_mailer_message where receiver=? and trash='no' order by messagedate desc");
			pr.setString(1,email);
			ResultSet rs=pr.executeQuery();
			out.print("<table border=1 style='width:800px;'>");
			out.print("<tr style='background-color:grey;color:white'><td>Sender</td><td>Subject</td></tr>");
			while(rs.next())
			{
			int id=rs.getInt("id");
			System.out.println(id);
			//request.setAttribute("id", id);
			
			out.print("<tr><td>"+rs.getString("sender") +"</td> <td><a href='ViewMailServlet?id="+id+"'>"+rs.getString("subject")+"'</a></td></tr>");
			}
			out.print("</table>");
			con.close();
			}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		request.getRequestDispatcher("Footer.jsp").include(request, response);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

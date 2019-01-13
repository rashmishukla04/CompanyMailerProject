package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBUtil.ConnectionClass;

/**
 * Servlet implementation class DeleteMailServlet
 */
@WebServlet("/DeleteMailServlet")
public class DeleteMailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
			PreparedStatement ps=con.prepareStatement("update company_mailer_message set trash=? where id=?");
			ps.setString(1, "yes");
			ps.setInt(2,id);
			int i=ps.executeUpdate();
			if(i>0)
			{
				request.setAttribute("msg","Mail successfuly deleted");
				request.getRequestDispatcher("InboxServlet").forward(request, response);
				
			}
			con.close();
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

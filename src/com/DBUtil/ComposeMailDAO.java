package com.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.beans.ComposeMailBean;

public class ComposeMailDAO 
{
 public static int save(ComposeMailBean b)
 {
	 java.util.Date utilDate = new java.util.Date(); //get the current date
	  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // covert the date to sql format
	  int i=0;
	 Connection con=ConnectionClass.getConnection();
	 try {
		PreparedStatement ps=con.prepareStatement("insert into company_mailer_message(sender,receiver,subject,message,trash,messagedate) values(?,?,?,?,?,?)" );
		ps.setString(1, b.getEmail());
		ps.setString(2, b.getReceiver());
		ps.setString(3, b.getSubject());
		ps.setString(4, b.getMessage());
		ps.setString(5,"No");
		ps.setDate(6,sqlDate);
		
		i=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return i;
 }
}

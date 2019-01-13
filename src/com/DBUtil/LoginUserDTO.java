package com.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginUserDTO 
{
   public boolean validate(String email, String password)
   {
	   Connection con=ConnectionClass.getConnection();
	   boolean status=false;
	  // User u=new User();
	   try {
	   PreparedStatement ps=con.prepareStatement("select * from company_mailer_user where EMAIL=? and PASSWORD=?");
	   ps.setString(1,email);
	   ps.setString(2,password);
	   ResultSet rs= ps.executeQuery();	
	   System.out.println(rs);
	   if(rs.next())
	   {
		   status=true;
	   }
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
	   return status;
   }
	
}

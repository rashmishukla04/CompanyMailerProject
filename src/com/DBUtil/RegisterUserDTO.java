package com.DBUtil;
import java.sql.*;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.beans.User;


public class RegisterUserDTO 
{

  public static int save(User u) throws ParseException
  {
	  int status=0;
	  String s=u.getDOB();
	  System.out.println(s);
	  
	  
	//for getting current date code
	  java.util.Date utilDate = new java.util.Date(); //get the current date
	  
	  java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime()); // covert the date to sql format
	 
  // for getting DOB code
	  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      java.util.Date date = formatter.parse(u.getDOB());
      java.sql.Date sqlDOB = new java.sql.Date(date.getTime());
	  Connection con=ConnectionClass.getConnection();
	  try {
	  PreparedStatement ps=con.prepareStatement("insert into company_mailer_user (name,email,password,gender,dob,addresLine,city,state,country,contact,registereddate,authorized) values(?,?,?,?,?,?,?,?,?,?,?,?)");
	  ps.setString(1,u.getName());
	  ps.setString(2, u.getEmail());
	  ps.setString(3, u.getPassword());
	  ps.setString(4, u.getGender());
	  ps.setDate(5, sqlDOB);
	  ps.setString(6, u.getAddress());
	  ps.setString(7, u.getCity());
	  ps.setString(8, u.getState());
	  ps.setString(9, u.getCountry());
	  ps.setInt(10, u.getContract());
	  ps.setDate(11,sqlDate);
	  ps.setString(12, "yes ");
	  
	  status=ps.executeUpdate();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return status;  
  }

	
}

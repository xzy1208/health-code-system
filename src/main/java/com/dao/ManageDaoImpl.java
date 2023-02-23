package com.dao;

import java.sql.*;
import java.util.ArrayList;

import model.manage;

public class ManageDaoImpl implements ManageDao{
    
      public boolean addmanage(manage manage) 
              throws DaoException{  	  
    	  String sql="insert into manage values(?,?)";
   	   try(
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql))
   	   { 
	    pstmt.setString(1,manage.getJobnumber());
	    pstmt.setString(2,manage.getPassword());
	    pstmt.executeUpdate();
   	     return true;
   	   }catch(SQLException se){
   		System.out.println(se);
   		  return false;
   	   }
   } 
   public manage findById(String number) throws DaoException{ 
	      String sql = "SELECT * FROM manage WHERE jobnumber =?";
      manage  manage = new manage();
      try(
    	   Connection conn = getConnection();
    	   PreparedStatement pstmt = conn.prepareStatement(sql)){ 
   	   pstmt.setString(1,number);
   	   try(ResultSet rst = pstmt.executeQuery()){
   	     if(rst.next()){
			manage.setJobnumber(rst.getString("jobnumber"));
			manage.setPassword(rst.getString("password"));
   	     }
   	     else return null;
   	    }
      }catch(SQLException se){
   	  	return null;
   	  }
   	  return manage;
   }
   public ArrayList<manage> findAllmanage()throws DaoException{  	  
   	  
   	  ArrayList<manage> custList = new ArrayList<manage>();
   	  String sql = "SELECT * FROM manage";
   	  try( 
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql);
   		 ResultSet rst = pstmt.executeQuery()){  		 
   	      while(rst.next()){
   	    	manage  manage = new manage();
			manage.setJobnumber(rst.getString("jobnumber"));
			manage.setPassword(rst.getString("password"));
   	        custList.add(manage);	
   	    }	     
   	     return custList;
   	  }catch(SQLException e){
   	      e.printStackTrace();
   		 return null;
   	  }
   }
@Override
public boolean delmanage(manage manage) throws DaoException {
	String sql = "DELETE FROM manage WHERE jobnumber =?";
    try {
  	   Connection conn = getConnection();
  	   PreparedStatement pstmt = conn.prepareStatement(sql); 
 	   pstmt.setString(1,manage.getJobnumber());
 	  pstmt.executeUpdate();
	     return true;
 	   
    }catch(SQLException se){
    	System.out.println(se);
 	  	return false;
 	  }
}
}

package com.dao;

import java.sql.*;
import java.util.ArrayList;

import model.acsucl;

public class AcsuclDaoImpl implements AcsuclDao{
    
      public boolean addacsucl(acsucl acsucl)throws DaoException{  	  
    	  String sql="insert into acsucl values(?,?,?)";
   	   try(
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql))
   	   { 
	    
	    pstmt.setString(1,acsucl.getAcademy());
	    pstmt.setString(2,acsucl.getSubject());
	    pstmt.setString(3,acsucl.getClass1());
	    pstmt.executeUpdate();
   	     return true;
   	   }catch(SQLException se){
   		System.out.println(se);
   		  return false;
   	   }
   } 
   public acsucl findById(String number) throws DaoException{ 
	      String sql = "SELECT * FROM acsucl WHERE class =?";
      acsucl  acsucl = new acsucl();
      try(
    	   Connection conn = getConnection();
    	   PreparedStatement pstmt = conn.prepareStatement(sql)){ 
   	   pstmt.setString(1,number);
   	   try(ResultSet rst = pstmt.executeQuery()){
   	     if(rst.next()){
			acsucl.setAcademy(rst.getString("academy"));
			acsucl.setSubject(rst.getString("subject"));
			acsucl.setClass1(rst.getString("class"));
   	     }
   	     else return null;
   	    }
      }catch(SQLException se){
   	  	return null;
   	  }
   	  return acsucl;
   }
@Override
public boolean delacsual(acsucl acsucl) throws DaoException {
	String sql = "DELETE FROM acsucl WHERE class=?";
    try {
  	   Connection conn = getConnection();
  	   PreparedStatement pstmt = conn.prepareStatement(sql); 
 	   pstmt.setString(1,acsucl.getClass1());
 	  pstmt.executeUpdate();
	     return true;
 	   
    }catch(SQLException se){
    	System.out.println(se);
 	  	return false;
 	  }
    
}
@Override
public ArrayList<acsucl> findAllacsual() throws DaoException {
	 ArrayList<acsucl> custList = new ArrayList<acsucl>();
  	  String sql = "SELECT * FROM acsucl";
  	  try( 
  		 Connection conn = getConnection();
  		 PreparedStatement pstmt = conn.prepareStatement(sql);
  		 ResultSet rst = pstmt.executeQuery()){  		 
  	      while(rst.next()){
  	    	acsucl  acsucl = new acsucl();
			acsucl.setAcademy(rst.getString("academy"));
			acsucl.setSubject(rst.getString("subject"));
			acsucl.setClass1(rst.getString("class"));
  	        custList.add(acsucl);	
  	    }	     
  	     return custList;
  	  }catch(SQLException e){
  	      e.printStackTrace();
  		 return null;
  	  
}
}
}

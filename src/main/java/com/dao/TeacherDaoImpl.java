package com.dao;

import java.sql.*;
import java.util.ArrayList;

import model.teacher;

public class TeacherDaoImpl implements TeacherDao{
    
      public boolean addteacher(teacher teacher) 
              throws DaoException{  	  
    	  String sql="insert into teacher values(?,?,?,?,?,'')";
   	   try(
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql))
   	   { 
	    pstmt.setString(3,teacher.getJobnumber());
	    pstmt.setString(1,teacher.getName());
	    pstmt.setString(2,teacher.getId());
	    pstmt.setString(4,teacher.getAcademy());
	    pstmt.setString(5,teacher.getRole());
	    pstmt.executeUpdate();
   	     return true;
   	   }catch(SQLException se){
   		System.out.println(se);
   		  return false;
   	   }
   } 
   public teacher findById(String number) throws DaoException{ 
	      String sql = "SELECT * FROM teacher WHERE jobnumber =?";
      teacher  teacher = new teacher();
      try(
    	   Connection conn = getConnection();
    	   PreparedStatement pstmt = conn.prepareStatement(sql)){ 
   	   pstmt.setString(1,number);
   	   try(ResultSet rst = pstmt.executeQuery()){
   	     if(rst.next()){
			teacher.setName(rst.getString("name"));
			teacher.setJobnumber(rst.getString("jobnumber"));
			teacher.setId(rst.getString("id"));
			teacher.setAcademy(rst.getString("academy"));
			teacher.setRole(rst.getString("role"));	
   	     }
   	     else return null;
   	    }
      }catch(SQLException se){
   	  	return null;
   	  }
   	  return teacher;
   }
   public ArrayList<teacher> findAllteacher()throws DaoException{  	  
   	  
   	  ArrayList<teacher> custList = new ArrayList<teacher>();
   	  String sql = "SELECT * FROM teacher";
   	  try( 
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql);
   		 ResultSet rst = pstmt.executeQuery()){  		 
   	      while(rst.next()){
   	    	teacher  teacher = new teacher();
  			teacher.setName(rst.getString("name"));
  			teacher.setJobnumber(rst.getString("jobnumber"));
  			teacher.setId(rst.getString("id"));
  			teacher.setAcademy(rst.getString("academy"));
  			teacher.setRole(rst.getString("role"));	
   	        custList.add(teacher);	
   	    }	     
   	     return custList;
   	  }catch(SQLException e){
   	      e.printStackTrace();
   		 return null;
   	  }
   }
@Override
public boolean delteacher(teacher teacher) throws DaoException {
	String sql = "DELETE FROM teacher WHERE jobnumber =?";
    try {
  	   Connection conn = getConnection();
  	   PreparedStatement pstmt = conn.prepareStatement(sql); 
 	   pstmt.setString(1,teacher.getJobnumber());
 	  pstmt.executeUpdate();
	     return true;
 	   
    }catch(SQLException se){
    	System.out.println(se);
 	  	return false;
 	  }
}
}

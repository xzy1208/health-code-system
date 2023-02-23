package com.dao;

import java.sql.*;
import java.util.ArrayList;

import model.student;

public class StudentDaoImpl implements StudentDao{
    
      public boolean addstudent(student student) 
              throws DaoException{ 
    	  String sql="insert into student values(?,?,?,?,?,?,'')";
   	   try(
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql))
   	   { 
   		   pstmt.setString(3,student.getStudentnumber());
   		   pstmt.setString(1,student.getName());
			pstmt.setString(2,student.getId());
			pstmt.setString(4,student.getAcademy());
			pstmt.setString(5,student.getSubject());
			pstmt.setString(6,student.getClass1());
			pstmt.executeUpdate();
   	     return true;
   	   }catch(SQLException se){
   		System.out.println(se);
   		  return false;
   	   }
   } 
   public student findById(String number) throws DaoException{ 
	      String sql = "SELECT * FROM student WHERE studentnumber =?";
      student  student = new student();
      try(
    	   Connection conn = getConnection();
    	   PreparedStatement pstmt = conn.prepareStatement(sql)){ 
   	   pstmt.setString(1,number);
   	   try(ResultSet rst = pstmt.executeQuery()){
   	     if(rst.next()){
			student.setName(rst.getString("name"));
			student.setStudentnumber(rst.getString("studentnumber"));
			student.setId(rst.getString("id"));
			student.setAcademy(rst.getString("academy"));
			student.setSubject(rst.getString("subject"));
			student.setClass1(rst.getString("role"));	
   	     }
   	     else return null;
   	    }
      }catch(SQLException se){
   	  	return null;
   	  }
   	  return student;
   }
   public ArrayList<student> findAllstudent()throws DaoException{  	  
   	  
   	  ArrayList<student> custList = new ArrayList<student>();
   	  String sql = "SELECT * FROM student";
   	  try( 
   		 Connection conn = getConnection();
   		 PreparedStatement pstmt = conn.prepareStatement(sql);
   		 ResultSet rst = pstmt.executeQuery()){  		 
   	      while(rst.next()){
   	    	student  student = new student();
   	    	student.setName(rst.getString("name"));
			student.setStudentnumber(rst.getString("studentnumber"));
			student.setId(rst.getString("id"));
			student.setAcademy(rst.getString("academy"));
			student.setSubject(rst.getString("subject"));
			student.setClass1(rst.getString("role"));	
   	        custList.add(student);	
   	    }	     
   	     return custList;
   	  }catch(SQLException e){
   	      e.printStackTrace();
   		 return null;
   	  }
   }
@Override
public boolean delstudent(student student) throws DaoException {
	String sql = "DELETE FROM student WHERE studentnumber =?";
    try {
  	   Connection conn = getConnection();
  	   PreparedStatement pstmt = conn.prepareStatement(sql); 
 	   pstmt.setString(1,student.getStudentnumber());
 	  pstmt.executeUpdate();
	     return true;
 	   
    }catch(SQLException se){
    	System.out.println(se);
 	  	return false;
 	  }
}
}

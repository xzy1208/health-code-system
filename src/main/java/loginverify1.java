import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

import model.student;
import model.teacher;

@WebServlet(name="loginverify1",urlPatterns= {"/login1.action"})
public class loginverify1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DataSource datasource=null;
	Connection conn=null;
    public void init() {
    	try {
			Context context=new InitialContext();
			datasource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
			conn=datasource.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public loginverify1() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		String number=request.getParameter("num1");
		String name=new String(request.getParameter("name1").getBytes("iso-8859-1"), "utf-8");
		String id=request.getParameter("id1");
		String loginresult="false";
		if(number.length()==8)
		{String sql="SELECT*FROM teacher WHERE jobnumber=?";
		try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,number);
				ResultSet rs=pstmt.executeQuery();
				teacher t=new teacher();
				if(rs.next())
				{
					t.setName(rs.getString("name"));
					t.setJobnumber(rs.getString("jobnumber"));
					t.setId(rs.getString("id"));
					t.setAcademy(rs.getString("academy"));
					t.setRole(rs.getString("role"));	
					
					
					if(t.getName().equals(name))
					{
						if(t.getId().substring(10).equals(id))
						{
							request.setAttribute("name", name);
							request.setAttribute("identity", t.getId());
							request.setAttribute("number", number);
							
							loginresult="true";

							//登陆成功
						}
						else 
						{
							out.print("<script language='javascript'>alert('身份证后八位错误!!!');window.location.href='login.jsp';</script>"); 
							//身份证后八位错误
						}
					}
					else 
					{
						out.print("<script language='javascript'>alert('姓名错误!!!');window.location.href='login.jsp';</script>"); 
						//姓名错误
					}
				}
				else 
				{
					out.print("<script language='javascript'>alert('工号/学号错误!!!');window.location.href='login.jsp';</script>"); 
					//工号/学号错误
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else 
		{
			String sql="SELECT*FROM student WHERE studentnumber=?";
			try {
					PreparedStatement pstmt=conn.prepareStatement(sql);
					pstmt.setString(1,number);
					ResultSet rs=pstmt.executeQuery();
					student s=new student();
					if(rs.next())
					{
						s.setName(rs.getString("name"));
						s.setStudentnumber(rs.getString("studentnumber"));
						s.setId(rs.getString("id"));
						s.setAcademy(rs.getString("academy"));
						s.setSubject(rs.getString("subject"));
						if(s.getName().equals(name))
						{
							if(s.getId().substring(10).equals(id))
							{
								request.setAttribute("name", name);
								request.setAttribute("identity", s.getId());
								request.setAttribute("number", number);
								loginresult="true";
								//登陆成功
							}
							else 
							{
								out.print("<script language='javascript'>alert('身份证后八位错误!!!');window.location.href='login.jsp';</script>"); 
								//身份证后八位错误}
							}
						}
						else 
						{
							out.print("<script language='javascript'>alert('姓名错误!!!');window.location.href='login.jsp';</script>"); 
							//姓名错误
						}
					}
					else 
					{
						out.print("<script language='javascript'>alert('工号/学号错误!!!');window.location.href='login.jsp';</script>"); 
						//工号/学号错误
					}
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

		if(loginresult.equals("true")){
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
			String time=sdf.format(date);
			try {
		         String sql="SELECT * FROM dayclock WHERE number=? AND date=?";
		         PreparedStatement pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1,number);
		         pstmt.setString(2,time);
		         ResultSet rst = pstmt.executeQuery();
		         if(rst.next()) {
		        	 String code=(String) rst.getString("code");
		        	 var t=number.length();
			    	 if(t==12) {
			             request.setAttribute("id", "学生");
			    	 }
			    	 else if(t==8) {
			    		 request.setAttribute("id", "教师");
			    	 }
			    	 String academy=(String) rst.getString("academy");
			 		 request.setAttribute("academy", academy);
			    	 if(code.equals("green")) {
			    		 getServletConfig().getServletContext().getRequestDispatcher("/green.jsp").forward(request, response);
			    	 }
			    	 else if(code.equals("yellow")) {
			    		 getServletConfig().getServletContext().getRequestDispatcher("/yellow.jsp").forward(request, response);
			    	 }
			    	 else {
			    		 getServletConfig().getServletContext().getRequestDispatcher("/red.jsp").forward(request, response);
			    	 }
		         }
		         else {
		        	 getServletConfig().getServletContext().getRequestDispatcher("/apply.jsp").forward(request, response);
		         }
			}catch(SQLException e){
		  	      e.printStackTrace();
		    }finally {
		          try {
		 	         conn.close();
		 	      }catch(Exception e){
		 		     e.printStackTrace();
		          }
		     }
		}
	}
}
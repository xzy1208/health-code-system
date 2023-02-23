

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.naming.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.*;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.acsucl;
import model.dayclock;
import model.teacher;
import model.student;

/**
 * Servlet implementation class information
 */
@WebServlet("/information2.do")
public class information2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource dataSource;
	Connection dbconn;
	Statement stmt;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public information2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String flag=request.getParameter("flag");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		String search=request.getParameter("search");
		System.out.println(search);
		String flag=(String) session.getAttribute("flag");
		String page=(String) request.getAttribute("page");
		System.out.println(page);
		if(flag==null)
			out.println("<script>alert(\"还未选择操作内容\");</script>");
		String tip=null;
		System.out.print(flag);
		ServletContext scontext=getServletContext();
		List<acsucl> list1 = new ArrayList<acsucl>();
		List<acsucl> list2 = new ArrayList<acsucl>();
		List<acsucl> list3 = new ArrayList<acsucl>();
		List<teacher> list4 = new ArrayList<teacher>();
		List<student> list5 = new ArrayList<student>();
		List<dayclock> list6 = new ArrayList<dayclock>();
		if(flag.equals("1"))
			{
				try {
					Context context = new InitialContext();
					dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
					dbconn=dataSource.getConnection();
					String sql="select distinct academy from acsucl ";
					if(search!="")
						sql+="where academy=?";
					PreparedStatement pstmt=dbconn.prepareStatement(sql);
					if(search!="")
					{
					pstmt.setString(1,search);
					}
					ResultSet rs=pstmt.executeQuery();
					request.setAttribute("sql",sql);
					while(rs.next())
					{
						acsucl a=new acsucl();
						a.setAcademy(rs.getString("academy"));
					    list1.add(a);
					    System.out.println(a.getAcademy());
		            }
					request.setAttribute("list1",list1);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				finally 
				{
					try {
					if (stmt != null)
					stmt.close();
					if (dbconn != null)
						dbconn.close();
					} 
					catch (SQLException e) 
					{}
				}
				
			}
		if(flag.equals("2"))
		{
		try {
			Context context = new InitialContext();
			 dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
			dbconn=dataSource.getConnection();
			String sql="select distinct academy,subject from acsucl  ";
			if(search!="")
				sql+=" where academy=? or subject=?";
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			if(search!="")
			{
			pstmt.setString(1,search);
			pstmt.setString(2,search);
			}
			ResultSet rs=pstmt.executeQuery();
			request.setAttribute("sql",sql);
			while(rs.next())
			{
				acsucl a=new acsucl();
				a.setAcademy(rs.getString("academy"));
				a.setSubject(rs.getString("subject"));
			    list2.add(a);
			    System.out.println(a.getAcademy());
            }
			request.setAttribute("list2",list2);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally 
			{
				try {
				if (stmt != null)
				stmt.close();
				if (dbconn != null)
					dbconn.close();
				} 
				catch (SQLException e) 
				{}
			}
		}
	else if(flag.equals("3"))
		{
	
			try {
				Context context = new InitialContext();
				dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
				dbconn=dataSource.getConnection();
				String sql="select * from acsucl";
				if(search!="")
					sql+=" where academy=? or subject=? or class=?";
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				if(search!="")
				{	
				pstmt.setString(1,search);
				pstmt.setString(2,search);
				pstmt.setString(3,search);
				}
				ResultSet rs=pstmt.executeQuery();
				request.setAttribute("sql",sql);
				while(rs.next())
				{
					acsucl a=new acsucl();
					a.setAcademy(rs.getString("academy"));
					a.setSubject(rs.getString("subject"));
					a.setClass1(rs.getString("class"));
				    list3.add(a);
				    System.out.println(a.getAcademy());
	            }
				request.setAttribute("list3",list3);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
					if (stmt != null)
					stmt.close();
					if (dbconn != null)
						dbconn.close();
					} 
					catch (SQLException e) 
					{}
				}
		}
	else if(flag.equals("4"))
		{

			try {
				Context context = new InitialContext();
				dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
				 dbconn=dataSource.getConnection();
				String sql="select * from teacher";
				if(search!="")
					sql+=" where name=? or id=? or academy=? or jobnumber=? or role=?";
				PreparedStatement pstmt=dbconn.prepareStatement(sql);
				if(search!="")
				{					
					pstmt.setString(1,search);
					pstmt.setString(2,search);
					pstmt.setString(3,search);
					pstmt.setString(4,search);
					pstmt.setString(5,search);
				}
				ResultSet rs=pstmt.executeQuery();
				request.setAttribute("sql",sql);
				while(rs.next())
				{
					teacher t=new teacher();
					t.setName(rs.getString("name"));
					t.setJobnumber(rs.getString("jobnumber"));
					t.setId(rs.getString("id"));
					t.setAcademy(rs.getString("academy"));
					t.setRole(rs.getString("role"));	
				    list4.add(t);
				    System.out.println(t.getAcademy());
	            }
				request.setAttribute("list4",list4);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}finally 
				{
					try {
					if (stmt != null)
					stmt.close();
					if (dbconn != null)
						dbconn.close();
					} 
					catch (SQLException e) 
					{}
				}

		}
	else if(flag.equals("5"))
		{
		try {
			Context context = new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
			dbconn=dataSource.getConnection();
			String sql="select * from student";
			if(search!="")
				sql+=" where  name=? or id=? or academy=? or studentnumber=? or subject=? or class=?";
			PreparedStatement pstmt=dbconn.prepareStatement(sql);
			if(search!="")
			{
			pstmt.setString(1,search);
			pstmt.setString(2,search);
			pstmt.setString(3,search);
			pstmt.setString(4,search);
			pstmt.setString(5,search);
			pstmt.setString(6,search);
			}
			ResultSet rs=pstmt.executeQuery();
			request.setAttribute("sql",sql);
			while(rs.next())
			{
				student s=new student();
				s.setName(rs.getString("name"));
				s.setStudentnumber(rs.getString("studentnumber"));
				s.setId(rs.getString("id"));
				s.setAcademy(rs.getString("academy"));
				s.setSubject(rs.getString("subject"));
				s.setClass1(rs.getString("class"));
				list5.add(s);
			}
			session.setAttribute("list5",list5);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}finally 
		{
			try {
			if (stmt != null)
			stmt.close();
			if (dbconn != null)
				dbconn.close();
			} 
			catch (SQLException e) 
			{}
		}
		}
	else if(flag.equals("6"))
	{
			try {
				Context context = new InitialContext();
				dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
				dbconn=dataSource.getConnection();
			}
			catch(Exception e)
			{
				
			}
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
			String time=sdf.format(date);
			String academy=(String)request.getSession().getAttribute("academy");
			request.setAttribute("academy", academy);
			System.out.println("academy");
			String sql1="select * from dayclock";
			if(search!="")
				sql1+=" where date=? or number=? or academy=? or result=?";
			PreparedStatement pstmt1;
			try {
				pstmt1 = dbconn.prepareStatement(sql1);
			
			if(search!="")
			{
			pstmt1.setString(1,search);
			pstmt1.setString(2,search);
			pstmt1.setString(3,search);
			pstmt1.setString(4,search);
			}
			ResultSet rs=pstmt1.executeQuery();
			request.setAttribute("sql",sql1);
			while(rs.next())
			{
				dayclock s=new dayclock();
				s.setDate(rs.getString("date"));
				s.setNumber(rs.getString("number"));
				s.setAcademy(rs.getString("academy"));
				s.setResult(rs.getString("result"));
				s.setCode(rs.getString("code"));
				list6.add(s);
			}
			} 
			catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			session.setAttribute("list6",list6);
		int green1=0,yellow1=0,red1=0,num=0,green2=0,yellow2=0,red2=0;
		try{
			String sql=null;
			PreparedStatement pstmt;
			if(academy==null) {
				sql="SELECT * FROM teacher";
		    	pstmt= dbconn.prepareStatement(sql);
			}
			else {
				sql="SELECT * FROM teacher WHERE academy=?";
		    	pstmt= dbconn.prepareStatement(sql);
		    	pstmt.setString(1, academy);
			}
	         ResultSet rst = pstmt.executeQuery();
	         while(rst.next()){
	        	 num++;
	        	 if(rst.getString("code").equals("green")) {
	  			     green1++;
	  		     }
	        	 else if(rst.getString("code").equals("yellow")) {
	  			     yellow1++;
	  		     }
	        	 else if(rst.getString("code").equals("red")) {
	  			     red1++;
	  		     }
	         }
	         
	         if(academy==null) {
					sql="SELECT * FROM student";
			    	pstmt= dbconn.prepareStatement(sql);
				}
				else {
					sql="SELECT * FROM student WHERE academy=?";
			    	pstmt= dbconn.prepareStatement(sql);
			    	pstmt.setString(1, academy);
				}
	         rst = pstmt.executeQuery();
	         while(rst.next()){
	        	 num++;
	        	 if(rst.getString("code").equals("green")) {
	  			     green1++;
	  		     }
	        	 else if(rst.getString("code").equals("yellow")) {
	  			     yellow1++;
	  		     }
	        	 else if(rst.getString("code").equals("red")) {
	  			     red1++;
	  		     }
	         }
	         
	         if(academy==null) {
					sql="SELECT * FROM dayclock WHERE date=?";
			    	pstmt= dbconn.prepareStatement(sql);
			    	pstmt.setString(1, time);
				}
				else {
					sql="SELECT * FROM dayclock WHERE date=? AND academy=?";
			    	pstmt= dbconn.prepareStatement(sql);
			    	pstmt.setString(1, time);
			    	pstmt.setString(2, academy);
				}
	         rst = pstmt.executeQuery();
	         while(rst.next()){
	        	 if(rst.getString("code").equals("green")) {
				         green2++;
			         }
	        	 else if(rst.getString("code").equals("yellow")) {
				         yellow2++;
			         }
	        	 else if(rst.getString("code").equals("red")) {
				         red2++;
			         }
	         }
	         
	      }catch(SQLException e){
	  	      e.printStackTrace();
	      }finally {
	          try {
		 	     dbconn.close();
		 	  }catch(Exception e){
		 		 e.printStackTrace();
		      }
		  }
	    request.setAttribute("green1", green1);
	    request.setAttribute("yellow1", yellow1);
	    request.setAttribute("red1", red1);
	    request.setAttribute("green2", green2);
	    request.setAttribute("yellow2", yellow2);
	    request.setAttribute("red2", red2);
	    request.setAttribute("wait", num-green2-yellow2-red2);
	    System.out.println("red:"+red1);
		}
		getServletConfig().getServletContext().getRequestDispatcher("/school.jsp").forward(request, response);
	
	}
}

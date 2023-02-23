

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.dao.AcsuclDao;
import com.dao.AcsuclDaoImpl;
import com.dao.DaoException;
import com.dao.ManageDao;
import com.dao.ManageDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.TeacherDao;
import com.dao.TeacherDaoImpl;

import model.acsucl;
import model.manage;
import model.student;
import model.teacher;

/**
 * Servlet implementation class change
 */
@WebServlet(name = "addServlet", urlPatterns = { "/add.do" })
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setContentType("text/xml;charset=UTF-8");
		   response.setHeader("Cache-Control","no-cache");
		   HttpSession session=request.getSession();
		    DataSource datasource;
			Connection conn=null;
		    try {
				Context context=new InitialContext();
				datasource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
				conn=datasource.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		    PrintWriter out=response.getWriter();
		    String message=null;
		String v=request.getParameter("m");
		System.out.println(v);
		if(v.equals("1"))
		{try {
				
				String sql="SELECT * FROM acsucl WHERE academy=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				String newname=request.getParameter("academyname1");
				pstmt.setString(1,newname);
				System.out.print(newname);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
					{
						message="该学院已存在";
					}
				else 
				{
					/*String sql2="insert into acsucl values(?,'','')";
					PreparedStatement pstmt2=conn.prepareStatement(sql2);
					pstmt2.setString(1,newname);
					int rsrow=pstmt2.executeUpdate();*/
					acsucl a=new acsucl();
					a.setAcademy(newname);
					a.setSubject("");
					a.setClass1("");
					AcsuclDao dao= new AcsuclDaoImpl();
					boolean success=false;
					try {
						success = dao.addacsucl(a);
					} catch (DaoException e) {
						e.printStackTrace();
					}
					if(success)
					message="添加成功";
				}
				
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	else if(v.equals("2"))
	{
		try {
			
			String sql="SELECT * FROM acsucl WHERE subject=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			String newname=request.getParameter("academyname2");
			String newsu=request.getParameter("subjectname2");
			pstmt.setString(1,newsu);
			System.out.print(newname);
			System.out.print(newsu);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				{
					message="该专业已存在";
					
				}
			else 
			{
				String sql2="SELECT * FROM acsucl WHERE academy=? ";
				PreparedStatement pstmt2=conn.prepareStatement(sql2);
				pstmt2.setString(1,newname);
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
					if(rs2.getString("subject").equals(""))
					{
						String sql3="update acsucl set subject=? where academy=? and subject=''";
						PreparedStatement pstmt3=conn.prepareStatement(sql3);
						pstmt3.setString(1,newsu);
						pstmt3.setString(2,newname);
						int rsrow=pstmt3.executeUpdate();
					}/*String sql3="insert into acsucl values(?,?,'')";
					PreparedStatement pstmt3=conn.prepareStatement(sql3);
					pstmt3.setString(1,newname);
					pstmt3.setString(2,newsu);
					int rsrow=pstmt3.executeUpdate();
						message="添加成功";*/
						else{acsucl a=new acsucl();
						a.setAcademy(newname);
						a.setSubject(newsu);
						a.setClass1("");
						AcsuclDao dao= new AcsuclDaoImpl();
						boolean success=false;
						try {
							success = dao.addacsucl(a);
						} catch (DaoException e) {
							e.printStackTrace();
						}
					}
					
					message="添加成功";
				}
				else message="该学院不存在";
			}
		}

	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(v.equals("3"))
	{
		try {
			
			String sql="SELECT * FROM acsucl WHERE class=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			String newname=request.getParameter("academyname3");
			String newsu=request.getParameter("subjectname3");
			String newcl=request.getParameter("classname3");
			pstmt.setString(1,newcl);
			System.out.print(newname);
			System.out.print(newsu);
			System.out.print(newcl);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				{
					message="该班级已存在";
					
				}
			else 
			{
				String sql2="SELECT * FROM acsucl WHERE academy=?";
				PreparedStatement pstmt2=conn.prepareStatement(sql2);
				pstmt2.setString(1,newname);
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
					String sql3="SELECT * FROM acsucl WHERE subject=?";
					PreparedStatement pstmt3=conn.prepareStatement(sql3);
					pstmt3.setString(1,newsu);
					ResultSet rs3=pstmt3.executeQuery();
					if(rs3.next())
					{
						if(rs3.getString("class").equals(""))
						{
							String sql4="update acsucl set class=? where subject=? and class=''";
							PreparedStatement pstmt4=conn.prepareStatement(sql4);
							pstmt4.setString(1,newcl);
							pstmt4.setString(2,newsu);
							int rsrow=pstmt4.executeUpdate();
						}
						/*String sql4="insert into acsucl values(?,?,?)";
						PreparedStatement pstmt4=conn.prepareStatement(sql4);
						pstmt4.setString(1,newname);
						pstmt4.setString(2,newsu);
						pstmt4.setString(3,newcl);
						int rsrow=pstmt4.executeUpdate();
						message="添加成功";*/
						else{
							acsucl a=new acsucl();
						a.setAcademy(newname);
						a.setSubject(newsu);
						a.setClass1(newcl);
						AcsuclDao dao= new AcsuclDaoImpl();
						boolean success=false;
						try {
							success = dao.addacsucl(a);
						} catch (DaoException e) {
							e.printStackTrace();
						}
						}
						message="添加成功";
					}
					else message="专业不存在";
				}
				else message="学院不存在";
				
			}
			}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    else if(v.equals("4"))
	{
		try {
			String sql="SELECT * FROM teacher WHERE jobnumber=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			 String jobnumber4 = request.getParameter("jobnumber4");
			  String name4 = request.getParameter("name4");
			  String id4 = request.getParameter("id4");
			  String academyname4 = request.getParameter("academyname4");
			  String role4 = request.getParameter("role4");
			  System.out.println(jobnumber4);
			  System.out.println(name4);
			  System.out.println(id4);
			  System.out.println(academyname4);
			  System.out.println(role4);
			pstmt.setString(1,jobnumber4);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
				{
					message="该工号已存在";
					
				}
			else 
			{
				String sql2="SELECT * FROM teacher WHERE id=?";
				PreparedStatement pstmt2=conn.prepareStatement(sql2);
				pstmt2.setString(1,id4);
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
					message="该身份证号重复";
				}
				else
				{
				    String sql3="SELECT * FROM acsucl WHERE academy=?";
				    PreparedStatement pstmt3=conn.prepareStatement(sql3);
				    pstmt3.setString(1,academyname4);
				    ResultSet rs3=pstmt3.executeQuery();
				    if(!rs3.next())
				    {
					    message="该学院不存在";
				    }
				    else 
				    {
					   /* String sql4="insert into teacher values(?,?,?,?,?,'')";
					    PreparedStatement pstmt4=conn.prepareStatement(sql4);
					    pstmt4.setString(3,jobnumber4);
					    pstmt4.setString(1,name4);
					    pstmt4.setString(2,id4);
					    pstmt4.setString(4,academyname4);
					    pstmt4.setString(5,role4);
					    int rsrow=pstmt4.executeUpdate();*/
				    	boolean success=false;
				    	teacher t=new teacher();
				    	t.setName(name4);
				    	t.setId(id4);
				    	t.setJobnumber(jobnumber4);
				    	t.setAcademy(academyname4);
				    	t.setRole(role4);
				    	TeacherDao dao= new TeacherDaoImpl();
						try {
							success = dao.addteacher(t);
						} catch (DaoException e) {
							e.printStackTrace();
						}
						if(success)
						message="添加成功";	
				    }
				}
			}
			}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	else if(v.equals("5"))
	{
		try {
			String sql="SELECT * FROM student WHERE studentnumber=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			String studentnumber5 = request.getParameter("studentnumber5");
		    String name5 = request.getParameter("name5");
		    String id5 = request.getParameter("id5");
		    String academyname5 = request.getParameter("academyname5");
		    String subject5 = request.getParameter("subject5");
		    String class5 = request.getParameter("class5");
			pstmt.setString(1,studentnumber5);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				message="该学号已存在";
				
			}
			else 
			{
				String sql2="SELECT * FROM student WHERE id=?";
				PreparedStatement pstmt2=conn.prepareStatement(sql2);
				pstmt2.setString(1,id5);
				ResultSet rs2=pstmt2.executeQuery();
				if(rs2.next())
				{
					message="该身份证号重复";
				}
				else 
				{
					String sql3="SELECT * FROM acsucl WHERE academy=?";
				    PreparedStatement pstmt3=conn.prepareStatement(sql3);
				    pstmt3.setString(1,academyname5);
				    ResultSet rs3=pstmt3.executeQuery();
				    if(!rs3.next())
				    {
					    message="该学院不存在";
				    }
					else
					{
						String sql4="SELECT * FROM acsucl WHERE subject=?";
				        PreparedStatement pstmt4=conn.prepareStatement(sql4);
				        pstmt4.setString(1,subject5);
				        ResultSet rs4=pstmt4.executeQuery();
				        if(!rs4.next())
				        {
					        message="该专业不存在";
				        }
				        else
				        {
				        	String sql5="SELECT * FROM acsucl WHERE class=?";
				            PreparedStatement pstmt5=conn.prepareStatement(sql5);
				            pstmt5.setString(1,class5);
				            ResultSet rs5=pstmt5.executeQuery();
				            if(!rs5.next())
				            {
					            message="该班级不存在";
				            }
				            else
				            {
				                /*String sql6="insert into student values(?,?,?,?,?,?,'')";
					            PreparedStatement pstmt6=conn.prepareStatement(sql6);
				            	pstmt6.setString(3,studentnumber5);
				            	pstmt6.setString(1,name5);
	            				pstmt6.setString(2,id5);
				            	pstmt6.setString(4,academyname5);
		            			pstmt6.setString(5,subject5);
	            				pstmt6.setString(6,class5);
		            			int rsrow=pstmt6.executeUpdate();
		            			message="添加成功";*/
				            	student t=new student();
						    	t.setName(name5);
						    	t.setId(id5);
						    	t.setStudentnumber(studentnumber5);
						    	t.setAcademy(academyname5);
						    	t.setSubject(subject5);
						    	t.setClass1(class5);
								StudentDao dao= new StudentDaoImpl();
								boolean success=false;
								try {
									success = dao.addstudent(t);
								} catch (DaoException e) {
									e.printStackTrace();
								}
								if(success)
								message="添加成功";	
				            }
				        }
				}
			}
		}
		
		}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		System.out.println(message);
		out.println("<response>");
	    out.println("<message>"+message+"</message>");
	    out.println("</response>");
		
		}
	}
		

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.*;

import model.manage;
import model.teacher;

@WebServlet(name="loginverify2",urlPatterns= {"/login2.action"})
public class loginverify2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource datasource;
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
    public loginverify2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String number=request.getParameter("num2");
		String password=request.getParameter("pw2");
		String sql="SELECT * FROM manage WHERE jobnumber=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,number);
			ResultSet rs=pstmt.executeQuery();
			manage m=new manage();
			if(rs.next())
			{
				m.setJobnumber(rs.getString("jobnumber"));
				m.setPassword(rs.getString("password"));
				System.out.println(m.getJobnumber());
				System.out.println(m.getPassword());
				if(m.getPassword().equals(password))
				{
					String sql2="SELECT * FROM teacher WHERE jobnumber=?";
					PreparedStatement pstmt2=conn.prepareStatement(sql2);
					pstmt2.setString(1,number);
					ResultSet rs2=pstmt2.executeQuery();
					rs2.next();
					String username=rs2.getString("name");
					String role=rs2.getString("role");
					String academy=rs2.getString("academy");
					System.out.println(username);
					System.out.println(role);
					System.out.println(academy);
					request.setAttribute("username",username);
					if(role.equals("系统管理员"))
					{
						response.sendRedirect("system.jsp");
					}
					else if(role.equals("校级管理员"))
					{
						response.sendRedirect("school.jsp");
					}
					else if(role.equals("院级管理员"))
					{
						session.setAttribute("useracademy",academy);
						response.sendRedirect("subject.jsp");
					}
				}
				else {
					 out.print("<script language='javascript'>alert('密码错误!!!');window.location.href='login.jsp';</script>"); 
					//response.sendRedirect("login.jsp?error=password");
					//提示密码错误
				}
			}
			else 
			{
				//out.write("工号错误！");
				out.print("<script language='javascript'>alert('工号错误!!!');window.location.href='login.jsp';</script>"); 
				//response.sendRedirect("login.jsp?error=name");
				//提示工号错误
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	/*
		out.println("<!DOCTYPE html>");
		out.println("<html><head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>"+"是2"+"</title></head>");
		out.println("</head>");
		out.println("<table>");
		out.println("<tr><td></td>");
		out.println("<td>"+number+"</td></tr>");
		out.println("<td>"+password+"</td></tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");*/
	}

}
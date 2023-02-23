

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.acsucl;
import model.student;
import model.teacher;

/**
 * Servlet implementation class select
 */
@WebServlet("/select1")
public class select1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public select1() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String flag=request.getParameter("option");
		session.setAttribute("flag", flag);
		String tip=null;
		if(flag.equals("1"))
		{
			
			tip="学院信息管理";
		}
	else if(flag.equals("2"))
		{
			
				tip="专业信息管理";

		}
	else if(flag.equals("3"))
		{
				tip="班级信息管理";
		}
	else if(flag.equals("4"))
		{

			tip="教师信息管理";
		}
	else if(flag.equals("5"))
		{
			tip="学生信息管理";
		}
	else 
		{tip="健康码和打卡统计";}
		
		System.out.println(tip);
		System.out.println(flag);
		session.setAttribute("tip", tip);
		response.sendRedirect("system.jsp");
		
		


	}
}

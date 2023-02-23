

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.dao.DaoException;
import com.dao.ManageDao;
import com.dao.ManageDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.TeacherDao;
import com.dao.TeacherDaoImpl;

import model.manage;
import model.student;
import model.teacher;

@WebServlet(name = "setServlet", urlPatterns = { "/set.do" })
public class set extends HttpServlet {
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
    public set() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control","no-cache");
		HttpSession session=request.getSession();
		String flag=(String) session.getAttribute("flag");
		String setitem=request.getParameter("hideid2");
		String newpassword=request.getParameter("newpassword");
		System.out.println(setitem);
		String []items=null;
		//String str=request.getParameter("str");
		//System.out.println(str);
		//String[] items=null;
		//if(str!=null)
			//{items=str.split(",");}
		String message = null;
		System.out.print(flag);
			try {
				ManageDao dao= new ManageDaoImpl();
				manage m=null;
				m=dao.findById(setitem);
				boolean success=false;
				int rs=0;
		    	if(m==null)
		    	{
		    	    m=new manage();
		    		m.setJobnumber(setitem);
		    		m.setPassword(newpassword);
		    		try {
		    			success = dao.addmanage(m);
					} catch (DaoException e) {
						e.printStackTrace();
					}
		    		System.out.println(success);
		    	}
		    	else
		    	{
		    	String sql="UPDATE manage set password =? WHERE jobnumber=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,newpassword);
				pstmt.setString(2,setitem);
				rs=pstmt.executeUpdate();
				}
				if(rs!=0||success)
				{
					message="设置成功";
				}
				else 
				{
					message="设置失败";
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			
		 System.out.print(message);
		 PrintWriter out = response.getWriter();
		 out.println("<response>");
		 out.println("<message>"+message+"</message>");
		 out.println("</response>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}

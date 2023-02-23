

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

@WebServlet(name = "subServlet", urlPatterns = { "/sub.do" })
public class sub extends HttpServlet {
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
    public sub() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml;charset=UTF-8");
		response.setHeader("Cache-Control","no-cache");
		HttpSession session=request.getSession();
		String flag=(String) session.getAttribute("flag");
		String delitem=request.getParameter("hideid");
		System.out.print("d"+delitem);
		String []items=null;
		//String str=request.getParameter("str");
		//System.out.println(str);
		//String[] items=null;
		//if(str!=null)
			//{items=str.split(",");}
		String message = null;
		System.out.print(flag);
		if(flag.equals("1"))
			{
			try {
				String sql="DELETE FROM acsucl WHERE academy=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,delitem);
				int rs=pstmt.executeUpdate();
				if(rs!=0)
					{
						message="删除成功";
					}
				else 
				{
					
					message="删除失败";
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			/*try {
				items=request.getParameterValues("cb1");
				System.out.print(items.length);
				if(items!=null)
					{for(int i=0;i<items.length;i++)
					{
						String sql="DELETE FROM acsucl WHERE academy=?";
						PreparedStatement pstmt=conn.prepareStatement(sql);
						pstmt.setString(1,items[i]);
						ResultSet rs=pstmt.executeQuery();
						System.out.print(items[i]);
					}
						message="删除成功";
					}
				else {message="未选择删除项";}*/

		}
		else if(flag.equals("2"))
		{
			try {
				String sql="DELETE FROM acsucl WHERE subject=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,delitem);
				int rs=pstmt.executeUpdate();
				if(rs!=0)
					{
						message="删除成功";
					}
				else 
				{
					
					message="删除失败";
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			//items=request.getParameterValues("cb2");
		}
		else if(flag.equals("3"))
		{
			try {
				String sql="DELETE FROM acsucl WHERE class=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,delitem);
				int rs=pstmt.executeUpdate();
				if(rs!=0)
					{
						message="删除成功";
					}
				else 
				{
					
					message="删除失败";
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			//items=request.getParameterValues("cb3");
		}
		else if(flag.equals("4"))
		{
			try {
				/*String sql="DELETE FROM teacher WHERE jobnumber=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,delitem);
				int rs=pstmt.executeUpdate();
				if(rs!=0)
					{
						message="删除成功";
					}*/
				teacher t=new teacher();
		    	t.setJobnumber(delitem);
				TeacherDao dao= new TeacherDaoImpl();
				boolean success=false;
				try {
					success = dao.delteacher(t);
				} catch (DaoException e) {
					e.printStackTrace();
				}
	    		ManageDao dao1= new ManageDaoImpl();
	    		manage m=null;
	    		m=dao1.findById(delitem);
	    		
	    		try {
	    			if(m!=null)
		    		{
		    			success=dao1.delmanage(m);
		    		}
				} catch (DaoException e) {
					e.printStackTrace();
				}
				if(success)
				message="删除成功";	
				else 
				{
					
					message="删除失败";
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			//items=request.getParameterValues("cb4");
		}
		else if(flag.equals("5"))
		{
			try {
				/*String sql="DELETE FROM student WHERE student=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,delitem);
				int rs=pstmt.executeUpdate();
				if(rs!=0)
					{
						message="删除成功";
					}*/
				student t=new student();
		    	t.setStudentnumber(delitem);
				StudentDao dao= new StudentDaoImpl();
				boolean success=false;
				try {
					success = dao.delstudent(t);
				} catch (DaoException e) {
					e.printStackTrace();
				}
				if(success)
				message="删除成功";	
				else 
				{
					
					message="删除失败";
				}
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			//items=request.getParameterValues("cb5");
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

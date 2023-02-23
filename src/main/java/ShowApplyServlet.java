import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/apply.do")
public class ShowApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 54L;
    public ShowApplyServlet() {
        super();
    }
    
    Connection dbconn=null;
    DataSource dataSource;
    public void init() {   
       try{
 	      Context context=new InitialContext();
 	      dataSource=(DataSource)context.lookup("java:comp/env/jdbc/connect");
 	      dbconn=dataSource.getConnection();
       }catch(NamingException ne)
       {
     	  System.out.println("Exception:"+ne);
       }catch(SQLException se)
       {
     	  System.out.println("Exception:"+se);
       }
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
		String time=sdf.format(date);
		String timei[]=new String[8];
		for(int i=1;i<=7;i++) {
			Calendar calendar=Calendar.getInstance();
			calendar.add(Calendar.DATE, -i);
			Date datei=calendar.getTime();
			SimpleDateFormat sdfi=new SimpleDateFormat("yyyy.MM.dd");
			timei[i]=sdfi.format(datei);
		}
		
		String x1=request.getParameter("epidemic");
		String x2=request.getParameter("abroad");
		String y1=request.getParameter("touch");
		String y2=request.getParameter("confirm");
		String y3=request.getParameter("safe");
		String z1=request.getParameter("condition1");
		String name=request.getParameter("name");
		String number=request.getParameter("number");
		request.setAttribute("name", name);
		request.setAttribute("number", number);
		
		int n=0;
		String result;
		if(z1.equals("abnormal")) {
			String[] z2=request.getParameterValues("condition");
			n=z2.length;
		}
	    if(y1.equals("yes")||y2.equals("yes")||(z1.equals("abnormal")&&n>1)){
	    	result="red";
	    }
	    else if(x1.equals("yes")||x2.equals("yes")||(z1.equals("abnormal")&&n==1)){
	    	result="yellow";
	    }
	    else{
	    	result="green";
	    }
	    
	    String resulti[]=new String[7];
	    for(int i=1;i<=6;i++){
	    	resulti[i]="";
	    }
	    String code1="",code7="";

	    try{
	         String sql="SELECT * FROM dayclock WHERE number=?";
	         PreparedStatement pstmt = dbconn.prepareStatement(sql);
	         pstmt.setString(1,number);
	         ResultSet rst = pstmt.executeQuery();
	         while(rst.next()){
	        	 if(timei[1].equals(rst.getString("date"))) {
       			     resulti[1]=rst.getString("result");
       			     code1=rst.getString("code");
       		     }
	         	 for(int i=2;i<=6;i++) {
	         		 if(timei[i].equals(rst.getString("date"))) {
	         			 resulti[i]=rst.getString("result");
	         		 }
	         	 }
	         	 if(timei[7].equals(rst.getString("date"))) {
      			     code7=rst.getString("code");
      		     }
	         }
	      }catch(SQLException e){
	  	      e.printStackTrace();
	      }

	    int f=0;
		for(int i=1;i<=6;i++) {
			if(resulti[i].equals("green")) {
				f++;
			}
		}
		String code;
		if(result.equals("red")) {code=result;}
		else if(result.equals("yellow")) {
			if(code1.equals("red")) {
				code="red";
			}
			else {
				code=result;
			}
		}
		else {
			if(code7.equals("red")&&f==6) {
				code="yellow";
			}
			else if(code7.equals("yellow")&&f==6) {
				code="green";
			}
			else if(!code1.equals("")){
				code=code1;
			}
			else {
				code=result;
			}
		}
	    
		String academy="";
	    try{
	    	 var t=number.length();
	         String sql=null;
	    	 if(t==12) {
	             request.setAttribute("id", "同学");
	    		 sql="SELECT academy FROM student WHERE studentnumber = ?";
	    	 }
	    	 else if(t==8) {
	    		 request.setAttribute("id", "老师");
	    		 sql="SELECT academy FROM teacher WHERE jobnumber = ?";
	    	 }
	         PreparedStatement pstmt = dbconn.prepareStatement(sql);
	         pstmt.setString(1,number);
	         ResultSet rst = pstmt.executeQuery();
	         if(rst.next()){
	        	 academy=rst.getString("academy");
	         	 request.setAttribute("academy", academy);
	         }
	         
	         if(t==12) {
	    		 sql="UPDATE student SET code = ? WHERE studentnumber = ?";
	    	 }
	    	 else if(t==8) {
	    		 sql="UPDATE teacher SET code = ? WHERE jobnumber = ?";
	    	 }
	         pstmt = dbconn.prepareStatement(sql);
	         pstmt.setString(1,code);
	         pstmt.setString(2,number);
	         int rst2 = pstmt.executeUpdate();
	      }catch(SQLException e){
	  	      e.printStackTrace();
	      }
	    
	      try {
	    	 String sql="INSERT INTO dayclock VALUES(?,?,?,?,?)";
	    	 PreparedStatement pstmt = dbconn.prepareStatement(sql);
	         pstmt.setString(1,time);
	         pstmt.setString(2,number);
	         pstmt.setString(3,academy);
	         pstmt.setString(4,result);
	         pstmt.setString(5,code);
	         int rst3 = pstmt.executeUpdate();
	      }catch(SQLException e){
	  	      e.printStackTrace();
	      }finally {
	          try {
	 	         dbconn.close();
	 	      }catch(Exception e){
	 		     e.printStackTrace();
	         }
	      }

	    if(code.equals("red")){
	    	getServletConfig().getServletContext().getRequestDispatcher("/red.jsp").forward(request, response);
	    }
	    else if(code.equals("yellow")){
	    	getServletConfig().getServletContext().getRequestDispatcher("/yellow.jsp").forward(request, response);
	    }
	    else{
	    	if(y3.equals("no")) {
	    		getServletConfig().getServletContext().getRequestDispatcher("/green.jsp").forward(request, response);
	    	}
	    	else {
	    		getServletConfig().getServletContext().getRequestDispatcher("/blue.jsp").forward(request, response);
	    	}
	    }
	}
}
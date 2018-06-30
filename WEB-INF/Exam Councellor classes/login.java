package lalith;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class login extends HttpServlet
{
	Connection con=null;
                    Statement st=null;
	ResultSet rs=null;
	String rvalue=null;
	
	public void init(ServletConfig sc)throws ServletException
	{
		super.init(sc);
	        	try
	                 {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");

                  	}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
	 	
		HttpSession sess=req.getSession(true);
		String usertype=(String)sess.getAttribute("usertype");
		System.out.println("usertype"+usertype);
		System.out.println("hello");
		String username=req.getParameter("username");
		System.out.println("username"+username);
		String password=req.getParameter("password");	
		System.out.println("password"+password);
		 System.out.println("after statement");
                                      
		try{
			String query="select  *  from login where usertype='"+usertype+"' and username='"+username+"' and password='"+password+"'";
                                                      	//select * from login where usertype='exam' and username='exam' and password='exam';
			System.out.println("executed select query");
			 st=con.createStatement();  
			 rs=st.executeQuery(query);
			if(rs.next())
			{
				System.out.println("resultset values");
				//String temp3=rs.getString("password");
				//System.out.println("password"+temp3);
				if(usertype.equals("exam"))
				{
					res.sendRedirect("./examresult.jsp");
				}	
				else 
				{
					res.sendRedirect("./districtresult.jsp");
					//pw.println("district-------------------");
                                                                           }
			 }
                                                       else
			{
                                           
					//res.sendRedirect("http://localhost:8080/online/invaliduser.jsp");
					RequestDispatcher dis=req.getRequestDispatcher("/login.jsp");
					dis.include(req,res);
					pw.println("<html><body>");
					pw.println("InvalidUser/Password</body></html>");
				
			}//endelse
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}//catch
	}//service
}//login
		
		
	


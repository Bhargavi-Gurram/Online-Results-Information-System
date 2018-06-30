package lalith;
import lalith.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class student extends HttpServlet
{
	public void init(ServletConfig sc)throws ServletException
	{
		super.init(sc);
		myconnection my=new myconnection();
		my.mycon();
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
			Statement st=con.createStatement();
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			//HttpSession sess=req.getSession(true);
			//String results=(String)sess.getAttribute("results");
			String hno1=req.getParameter("hno");
                                                      int hno=0;
                                                      if(hno1.equals(""))
                                                      {
                                                      	RequestDispatcher dis=req.getRequestDispatcher("/studentresult.jsp");
				dis.include(req,res);
				pw.println("<html><body>");
				pw.println("Enter Hall..No</body></html>");
                                                      }//if
			else
			{    
				hno=Integer.parseInt(hno1);
				System.out.println(hno);
				String query="";
				String results=req.getParameter("results");
				System.out.println("results="+results);
				if(results.equals("engg"))
				{
					query="select * from engg where hno="+hno;  
					System.out.println(query);
				}//engg if
				else if(results.equals("medico"))
				{
					query="select * from medico where hno="+hno;
					System.out.println(query);
				}//medico else if
				ResultSet rs=st.executeQuery(query);		
				if(rs.next())
				{
				pw.println("<html><body><center><br><h1>Student Result</h1><br><hr><table>");
				pw.println("<tr><td><b>HallTicketNo:</b></td><td>"+rs.getInt(2)+"</td></tr>");
				pw.println("<tr><td><b>StudentName:</b></td><td>"+rs.getString(3)+"</td></tr>");
				if(results.equals("engg"))
				{
					pw.println("<tr><td><b>maths:</b></td><td>"+rs.getInt(4)+"</td></tr>");
					pw.println("	<tr><td><b>Physics:</b></td><td>"+rs.getInt(5)+"</td></tr>");
					pw.println("	<tr><td><b>Chemistry:</b></td><td>"+rs.getInt(6)+"</td></tr>");
					pw.println("	<tr><td><b>Total:</b></td><td>"+rs.getInt(7)+"</td></tr>");
					pw.println("	<tr><td><b>Rank:</b></td><td>"+rs.getInt(8)+"</td></tr>");
				}//engg result
				else if(results.equals("medico"))
				{
					pw.println("<tr><td><b>Botony:</b></td><td>"+rs.getInt(4)+"</td></tr>");
					pw.println("	<tr><td><b>Zeology:</b></td><td>"+rs.getInt(5)+"</td></tr>");
					pw.println("	<tr><td><b>Physics:</b></td><td>"+rs.getInt(6)+"</td></tr>");
					pw.println("	<tr><td><b>Chemistry:</b></td><td>"+rs.getInt(7)+"</td></tr>");
					pw.println("	<tr><td><b>Total:</b></td><td>"+rs.getInt(8)+"</td></tr>");
					pw.println("	<tr><td><b>Rank:</b></td><td>"+rs.getInt(9)+"</td></tr>");
				}//medico result
				}//rs if
				else
                                                                        {
					System.out.println("rs1 block entered");
					RequestDispatcher dis=req.getRequestDispatcher("/studentresult.jsp");
					dis.include(req,res);
					pw.println("No Hall Ticket No Exists");
				}//no hall ticket else					
	  	              	}//else
			pw.println("</table>");	
			pw.println("<a href='studentresult.jsp'>back</a>");
			pw.println("</center></body></html>");
		}//try
		catch(SQLException s)
		{
			s.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

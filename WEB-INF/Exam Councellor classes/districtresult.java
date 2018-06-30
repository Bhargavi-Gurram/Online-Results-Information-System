package lalith;
import lalith.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class districtresult extends HttpServlet
{
	public void init(ServletConfig sc) throws ServletException
	{
		super.init(sc);
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try
		{
			//myconnection my=new myconnection();
			//my.mycon();
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:india","exam","exam");
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");


			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			String subject="";
			subject=req.getParameter("subject").toString();
			System.out.println("subject="+subject);
			String district=req.getParameter("district");
			System.out.println("district="+district);
			String query=null;
			if(subject.equals(""))
			{
				RequestDispatcher dis=req.getRequestDispatcher("/districtresult.jsp");
					dis.include(req,res);
					pw.println("<html><body>");
					pw.println("select any option</body></html>");
			}
			else if(subject.equals("engg"))
			{
				query="select * from engg where sno in (select sno from studentInfo where district='"+district+"')";
			}
			else if(subject.equals("medico"))
			{
				query="select * from medico where sno in (select sno from studentInfo where district='"+district+"')";
			}
			else  
			{
				RequestDispatcher dis=req.getRequestDispatcher("/districtresult.jsp");
					dis.include(req,res);
					pw.println("<html><body>");
					pw.println("select any option</body></html>");
				//res.sendRedirect("Select any option");
			}
			System.out.println(query);
			Statement st=con.createStatement();
			System.out.println("connected--------");
			ResultSet rs=st.executeQuery(query);
			pw.println("<html><body><center><table border='1'><tr>");
			pw.println("<th>HallTicketNo</th><th>studentname</th>");
			if(subject.equals("engg"))
			{
				pw.println("<th>maths</th>");
			}
			else if(subject.equals("medico"))
			{
				pw.println("<th>Botony</th><th>Zeology</th>");
			}
			pw.println("<th>physics</th><th>chemistry</th><th>total</th><th>rank</th></tr>");
			while(rs.next())
			{
				if(subject.equals("engg"))
				{
				pw.println("<tr><td>"+rs.getInt(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getInt(4)+"</td>");
				pw.println("<td>"+rs.getInt(5)+"</td>");
				pw.println("<td>"+rs.getInt(6)+"</td>");
				pw.println("<td>"+rs.getInt(7)+"</td>");
				pw.println("<td>"+rs.getInt(8)+"</td></tr>");
				}
				else if(subject.equals("medico"))
				{
				pw.println("<tr><td>"+rs.getInt(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td>"+rs.getInt(4)+"</td>");
				pw.println("<td>"+rs.getInt(5)+"</td>");
				pw.println("<td>"+rs.getInt(6)+"</td>");
				pw.println("<td>"+rs.getInt(7)+"</td>");
				pw.println("<td>"+rs.getInt(8)+"</td>");
				pw.println("<td>"+rs.getInt(9)+"</td></tr>");
				}
			}		
			pw.println("</table><br><br><br><a href='districtresult.jsp'>BACK</a></center></body></html>");
		}
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
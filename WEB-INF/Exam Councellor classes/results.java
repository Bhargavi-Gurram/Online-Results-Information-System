package lalith;
import lalith.*;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
//import javax.servlet.http.HttpServletResponse;
public class results extends HttpServlet
{
	public void init(ServletConfig sc)throws ServletException
	{
		Connection con=null;
		
		ResultSet rs=null;
		super.init(sc);
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");			res.setContentType("text/html");
			PrintWriter out=res.getWriter();
			//myconnection my=new myconnection();
			//my.mycon();
			String result=req.getParameter("result").toString();
			System.out.println("result value="+result);
			String query="";
			
			if(result.equals("me"))
			{
			                //query="select * from engineers where sno in(select sno from studentInfo where gender='male')";
				query="select * from engg where sno in (select sno from studentInfo where gender='male') order by rank";
			}//"me"
			else if(result.equals("fe"))
			{
			                 //query="select * from engineers where sno in(select sno from studentInfo where gender='female')";
				query="select * from engg where sno in (select sno from studentInfo where gender='female') order by rank";
				
			}//"fe"
			else if(result.equals("mm"))
			{
				query="select * from medico where sno in(select sno from studentInfo where gender='male') order by rank";
			}//"mm"
			else if(result.equals("fm"))	
			{
				query="select * from medico where sno in(select sno from studentInfo where gender='female') order by rank";
			}//"fm"
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			out.println("<html><body><center>");
			out.println("<table border=1><tr><th>Hno</th><th>studentname</th>");
			if((result.equals("mm"))||(result.equals("fm")))
			{
				out.println("<th>botony</th><th>zeology</th>");
			}
			else
			{
				out.println("<th>maths</th>");
			}
			out.println("<th>physics</th><th>chemistry</th><th>total</th>");
			out.println("<th>rank</th></tr>");
			while(rs.next())
			{
				System.out.println("resultset ");
				//System.out.println("studentno="+rs.getInt(2));
				out.println("<tr><td>"+rs.getInt(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				if((result.equals("mm"))||(result.equals("fm")))
				{
				//out.println("<td>"+rs.getInt(3)+"</td>");
				out.println("<td>"+rs.getInt(4)+"</td>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("<td>"+rs.getInt(6)+"</td>");
				out.println("<td>"+rs.getInt(7)+"</td>");
				out.println("<td>"+rs.getInt(8)+"</td>");
				out.println("<td>"+rs.getInt(9)+"</td>");
				}
				else
				{
				//out.println("<td>"+rs.getInt(3)+"</td>");
				out.println("<td>"+rs.getInt(4)+"</td>");
				out.println("<td>"+rs.getInt(5)+"</td>");
				out.println("<td>"+rs.getInt(6)+"</td>");
				out.println("<td>"+rs.getInt(7)+"</td>");
				out.println("<td>"+rs.getInt(8)+"</td>");
				}
			}//while
			out.println("</table>");
			out.println("<a href='examresult.jsp'>back</a>");
			out.println("</center></body></html>");
		}//try
		catch(SQLException s)
		{
			s.printStackTrace();
			System.out.println("sqlexception");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("exception");
		}
	}
}








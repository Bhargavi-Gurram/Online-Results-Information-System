package lalith;
import lalith.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class marksentry extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                                         Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
			PreparedStatement pst=con.prepareStatement("insert into engg values(?,?,?,?,?,?,?,?)");
			int sno=Integer.parseInt(req.getParameter("sno"));
			pst.setInt(1,Integer.parseInt(req.getParameter("sno")));
			int hno=Integer.parseInt(req.getParameter("hno"));
			pst.setInt(2,Integer.parseInt(req.getParameter("hno")));
			Statement st3=con.createStatement();
			ResultSet rs3=st3.executeQuery("select hno from engg where hno="+hno);
			if(rs3.next())
			{
				RequestDispatcher dis=req.getRequestDispatcher("/marksentryform.jsp");
				dis.include(req,res);
				pw.println("Hall Ticket Number Already Exists");
			}
			else
			{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select sno,sname from studentInfo where sno="+sno);
			rs.next();
			String sname=rs.getString(2);
			pst.setString(3,sname);
			int m=Integer.parseInt(req.getParameter("maths"));
			System.out.println(m);
			int p=Integer.parseInt(req.getParameter("physics"));
			System.out.println(p);
			int c=Integer.parseInt(req.getParameter("chemistry"));
			System.out.println(c);
			if((m<=0)||(m>100)||(p<=0)||(p>100)||(c<=0)||(c>100))
			{
				RequestDispatcher dis=req.getRequestDispatcher("/marksentryform.jsp");
				dis.include(req,res);
				pw.println("<html><body><center>Is not an valid marks</center></body></html>");
			}
			else
			{
			pst.setInt(4,Integer.parseInt(req.getParameter("maths")));
			pst.setInt(5,Integer.parseInt(req.getParameter("physics")));
			pst.setInt(6,Integer.parseInt(req.getParameter("chemistry")));
			int total=m+p+c;
			System.out.println("total="+total);
			pst.setInt(7,total);
			pst.setInt(8,0);
			pst.executeUpdate();
			
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			ResultSet rs1=st1.executeQuery("select * from engg order by total desc");
			int count=1,tot1=0,tot2=0,rank=1;
			while(rs1.next())
			{
				System.out.println("In while @@@@@");
                                                                               int h=rs1.getInt(2);

				if(count>1)
					tot1=tot2;
				tot2=rs1.getInt(7);
				if(tot1>tot2)
					rank=count;
				st2.executeUpdate("update engg set rank="+rank+" where hno="+h);
				count++;
			System.out.println("Rank="+rank);
			}
			pw.println("<html><body><center><b>successfully inserted</b><br><br><hr>");
			pw.println("<a href='./marksentryform.jsp'>BACK</a></center></body></html>");
			}
			}
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
			
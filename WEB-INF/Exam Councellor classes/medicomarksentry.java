package lalith;
import lalith.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class medicomarksentry extends HttpServlet
{
	public void service(HttpServletRequest req,HttpServletResponse res)
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
			PreparedStatement pst=con.prepareStatement("insert into medico values(?,?,?,?,?,?,?,?,?)");
			int sno=Integer.parseInt(req.getParameter("sno"));
			pst.setInt(1,Integer.parseInt(req.getParameter("sno")));
			int hno=Integer.parseInt(req.getParameter("hno"));
			pst.setInt(2,Integer.parseInt(req.getParameter("hno")));
			Statement st3=con.createStatement();
			ResultSet rs3=st3.executeQuery("select hno from medico where hno="+hno);
			if(rs3.next())
			{
				RequestDispatcher dis=req.getRequestDispatcher("/medicomarks.jsp");
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
			int b=Integer.parseInt(req.getParameter("botony"));
			int z=Integer.parseInt(req.getParameter("zeology"));
			int p=Integer.parseInt(req.getParameter("physics"));	
			int c=Integer.parseInt(req.getParameter("chemistry"));
			if((b<=0)||(b>100)||(z<=0)||(z>100)||(p<=0)||(p>100)||(c<=0)||(c>100))
			{
				RequestDispatcher dis=req.getRequestDispatcher("/medicomarks.jsp");
				dis.include(req,res);
				pw.println("<html><body><center>Is not an valid marks</center></body></html>");
			}
			else
			{
			pst.setInt(4,Integer.parseInt(req.getParameter("botony")));
			pst.setInt(5,Integer.parseInt(req.getParameter("zeology")));
			pst.setInt(6,Integer.parseInt(req.getParameter("physics")));
			pst.setInt(7,Integer.parseInt(req.getParameter("chemistry")));
			int total=b+z+p+c;
			System.out.println("total="+total);
			pst.setInt(8,total);
			pst.setInt(9,0);
			pst.executeUpdate();
			
			Statement st1=con.createStatement();
			Statement st2=con.createStatement();
			ResultSet rs1=st1.executeQuery("select * from medico order by total desc");
			int count=1,tot1=0,tot2=0,rank=1;
			while(rs1.next())
			{
				System.out.println("In while @@@@@");
                                                                               int h=rs1.getInt(2);

				if(count>1)
					tot1=tot2;
				tot2=rs1.getInt(8);
				if(tot1>tot2)
					rank=count;
				st2.executeUpdate("update medico set rank="+rank+" where hno="+h);
				count++;
			System.out.println("Rank="+rank);
			}
			pw.println("<html><body><center><b>successfully inserted</b><br><br><hr>");
			pw.println("<a href='medicomarks.jsp'>BACK</a></center></body></html>");
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
			
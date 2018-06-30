package lalith;
import lalith.*;
import java.io.*;
import java.sql.*;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class studentregistration extends HttpServlet
{
           Connection con=null;
            Statement st=null;
            PreparedStatement pst=null;
           ResultSet rs=null;
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
                                      res.setContentType("text/html");
			PrintWriter pw=res.getWriter();
			int sno=Integer.parseInt(req.getParameter("sno"));
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                                                           con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
		                      pst=con.prepareStatement("insert into studentInfo values(?,?,?,?,?,?,?)");
			
			//int sno=req.getParameter("sno");
			//int sno=Integer.parseInt(req.getParameter("sno"));
			String sname=req.getParameter("sname");
			String address=req.getParameter("address");
			String district=req.getParameter("district");
			String date=req.getParameter("date");
			//myconnection my=new myconnection();
			//my.mycon();
			//my.pst=my.con.prepareStatement("insert into studentInfo values(?,?,?,?,?,?,?)");
			
			
			if((sno<=0)||(sname.equals(""))||(address.equals(""))||(district.equals(""))||(date.equals("")))
			{
				RequestDispatcher dis=req.getRequestDispatcher("./studentregistration.jsp");
				dis.include(req,res);
				pw.println("enter valid data only");
			}
			else
			{
			 Statement st1=con.createStatement();
			ResultSet rs1=st1.executeQuery("select sno from studentInfo where sno="+sno);
			 if(rs1.next())
                                                         {
				RequestDispatcher dis=req.getRequestDispatcher("/studentregistration.jsp");
				dis.include(req,res);
				pw.println("<html><body><center>Student with same registration already exists</center></body></html>");
			}
			else
			{
			pst.setInt(1,sno);
			pst.setString(2,req.getParameter("sname"));
			pst.setString(3,req.getParameter("gender"));
			//date mydate=req.getParameter("date");
			pst.setString(4,req.getParameter("date"));
			pst.setString(5,req.getParameter("address"));
			pst.setString(6,req.getParameter("district"));
			pst.setString(7,req.getParameter("state"));
			pst.executeUpdate();
			System.out.println("student number="+req.getParameter("sno"));
			 System.out.println("successfully inserted");
			RequestDispatcher dis=req.getRequestDispatcher("/studentregistration.jsp");
			dis.include(req,res);
			pw.println("data inserted");
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

		
		
		
		

			
package lalith;
import lalith.myconnection;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class examregister extends HttpServlet
{
	public void init(ServletConfig sc) throws ServletException
	{
		super.init(sc);
		//myconnection my=new myconnection();
		//my.mycon();
	}
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		try{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		myconnection my=new myconnection();
		my.mycon();
		String username=req.getParameter("username");
		System.out.println("username"+username);
		String password=req.getParameter("password");
		System.out.println("password"+password);
		String confirmpwd=req.getParameter("confirmpwd");
		System.out.println("confirmpassword"+confirmpwd);
		int age=Integer.parseInt(req.getParameter("age"));
		System.out.println("age"+age);
		String gender=req.getParameter("gender");
		System.out.println("gender"+gender);
		String city=req.getParameter("city");
		System.out.println("city"+city);
		String state=req.getParameter("state");
		System.out.println("state"+state);
		int pincode=Integer.parseInt(req.getParameter("pincode"));
		System.out.println("pincode"+pincode);
		String nation=req.getParameter("nation");
		System.out.println("nation"+nation);
			my.pst=my.con.prepareStatement("insert into examregister values(?,?,?,?,?,?,?,?,?)");
			my.pst.setString(1,username);
			my.pst.setString(2,password);
			my.pst.setString(3,confirmpwd);
			my.pst.setInt(4,age);
			my.pst.setString(5,gender);
			my.pst.setString(6,city);
			my.pst.setString(7,state);
			my.pst.setInt(8,pincode);
			my.pst.setString(9,nation);
			my.pst.executeUpdate();
			System.out.println(" pst query executed");
			pw.println("data inserted");
			res.sendRedirect("./onlinehome.jsp");
		}//try
		catch(Exception e)
		{ 
		e.printStackTrace();
		}//catch 
	}//service
}//examregister
		
		

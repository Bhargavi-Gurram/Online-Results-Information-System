package lalith;
import java.io.*;
import java.sql.*;

 public class myconnection
{
	public Connection con=null;//con2=null;
	public Statement st=null,st2=null,st3=null;
	public PreparedStatement pst=null;
	public ResultSet rs=null,rs2=null,rs3=null;
	public void mycon()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
//con2=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:india","exam","exam");
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
		




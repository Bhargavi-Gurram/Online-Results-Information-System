package lalith;

import java.sql.*;
public class test
 {
   public static void main(String str[])
    {
       try 
       {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");

           Statement st=con.createStatement();
                     System.out.println("size "+st.getFetchSize());             
                
                
            ResultSet rs=st.executeQuery("select  *  from login");
System.out.println("size2 rs get  "+rs.getFetchSize());             
             st.setFetchSize(2);
                rs.setFetchSize(20); 
             while(rs.next())
                   {
                     System.out.println(rs.getString(1));
                    }
   System.out.println("size2 rs  "+rs.getFetchSize());             
   System.out.println("size2   "+st.getFetchSize());             
               rs.close();
                } catch(Exception e)
               {
                        System.out.println("exception raised");
               }
        }
}
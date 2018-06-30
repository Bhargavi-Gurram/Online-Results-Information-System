<%@ page  import="java.sql.*"  %>
<html>
<head>
<title>Engineering Results</title>

</head>
<body>
<center>
<table align="center" border="1">
<th>Hallticketno</th>
<th>Student Name</th>
<th>Maths</th>
<th>Physics</th>
<th>Chemistry</th>
<th>Total</th>
<th>Rank</th>
<%
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
System.out.println("connection--------------------------");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from engg order by total desc ");
while(rs.next())
{
%>
<tr>
<td align="center"><%=rs.getInt(2)%></td>
<td align="center"><%=rs.getString(3)%></td>
<td  align="center"><%=rs.getInt(4)%></td>
<td align="center"><%=rs.getInt(5)%></td>
<td align="center"><%=rs.getInt(6)%></td>
<td align="center"><%=rs.getInt(7)%></td>
<td align="center"><%=rs.getInt(8)%></td>
</tr>
<%	
}
%>
</table>
<a href="examresult.jsp">BACK</a>
</center>
</body>
</html>

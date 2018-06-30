<%@ page import="java.sql.*" %>
<html>
<head>
<title>Medicine Results</title>

</head>
<%
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select * from medico order by total desc");
%>
<body>
<center>
<table border=1>
<tr>
<th>HallTicketNo</th>
<th>StudentName</th>
<th>Botony</th>
<th>Zeology</th>
<th>Physics</th>
<th>Chemistry</th>
<th>Total</th>
<th>Rank</th>
</tr>
<% while(rs.next())
{
%>
<tr>
<td align="center"><%=rs.getInt(2)%></td>
<td align="center"><%=rs.getString(3)%></td>
<td align="center"><%=rs.getInt(4)%></td>
<td align="center"><%=rs.getInt(5)%></td>
<td align="center"><%=rs.getInt(6)%></td>
<td align="center"><%=rs.getInt(7)%></td>
<td align="center"><%=rs.getInt(8)%></td>
<td align="center"><%=rs.getInt(9)%></td>
<% } %>
</tr>
</table>
<a href="examresult.jsp">BACK</a>
</center>
</body>
</html>

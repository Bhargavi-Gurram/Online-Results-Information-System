<%@ page  import="java.sql.*"  %>
<html>
<head>
<title>OnlineForm</title>

</head>
<body>
<center>
<form >
<%! String rvalue; %>
<% rvalue=request.getParameter("online");%>
<%
if(rvalue.equals("student"))
{
response.sendRedirect("./studentresult.jsp");
} 
else 
{
response.sendRedirect("./login.jsp");
}
%>

<% session.setAttribute("usertype",rvalue); %>
</form>
</center>
</body>
</html>

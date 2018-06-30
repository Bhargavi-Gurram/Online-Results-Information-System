<%@ page  import="java.sql.*"  %>
<html>
<head>
<title>Welcome To Online Exam Results</title>

</head>
<body bgcolor="#FFFFD9">
<% System.out.print("usertype "+(String)session.getAttribute("usertype"));%>
<form action="./log" >
<br>
<center>
<h1><FONT color="#999999">ONLINE EXAM RESULTS</FONT></h1>
<hr>
<br><br><br>
<table>
 <tr>
<td><label><font color="#999999"><b>Login</b></font></label></td>
<td><input name="username" type="text" value=""></td>
</tr>
<tr>
<td><label><font color="#999999"><b>password</b></font></label></td>
<td><input name="password" type="password" value=""></td>
</tr>
<tr>
<td></td>
<td align="center">
<input name="submit" type="submit" value="submit">
<input name="cancel" type="reset">
</td>
<td><a href="./onlinehome.jsp"><font color="#999999"><b>LOGOUT</b></font></a></td>

</tr>
</table>
<br><br><br><br>

<hr>

</center>
</form>
</body>
</html>

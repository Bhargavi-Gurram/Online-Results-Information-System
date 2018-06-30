<%@ page import="java.sql.*"  %>
<html>
<head>
<title>Student Results</title>
</head>
<body bgcolor="#FFFFD9">
<script language="JavaScript">
function check1()
{
	var s=document.student.hno.value;
	if(isNaN(s))
	{
		alert("enter valid Hall Ticket Number");
		document.student.focus();
		document.student.hno.value="";
	}
}
</script>
<form action="./student" name="student">
<center>
<br>
<font color="#999999">
<h1>Student Result</h1>
</font>
<hr>
<br>
<table>
<tr>
	<td><font color="#999999"><b>Enter HallTicketNo</b></font></td>
	<td><input name="hno" type="text" onBlur="check1()"></td>
</tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr></tr>
<tr>
<td><lable><input name="results" type="radio" value="engg" checked>
<font color="#999999"><b>Engg Results</b></font></td>
<td><input name="results" type="radio" value="medico">
<font color="#999999"><b>Medicine Results</b></font></td>
</tr>
<tr>
	<td></td>
	<td></td>
	<td><input name="submit" type="submit" value="submit"></td>
	<td></td>
	<td><a href="onlinehome.jsp"><font color="#999999"><b>LOGOUT</b></font></a></td>
</tr>
</table>
<br>
<hr>
</center>
</form>
</body>
</html>

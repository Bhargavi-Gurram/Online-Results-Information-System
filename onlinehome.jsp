<%@ page import="java.sql.*"  %>
<html>
<head>
<title>Online Home</title>
</head>
<body bgcolor="#FFFFD9">
<center>
<form name="f1" action="./online.jsp">
<br>
<h1><font color="#999999">ONLINE EXAM RESULTS</font></h1>
  <hr><br>
    <strong><font face="Verdana, Arial, Helvetica, sans-serif" color="#999999">Login To Any One 
    Of The Modules</font></strong> 
    <table>
	  <tr>
  		<td><label>
		<input type="radio" name="online" value="exam" >
        <font color="#999999"><b>Exam Counceller</b></font></label></td>
  </tr>
  <br>
  <tr>
	  <td><label> 
	    <input type="radio" name="online" value="district">
  		<font color="#999999"><b>District controller</b></font></label></td>
	</tr>
  <br>
  <tr>
  	<td><label> 
	  <input type="radio" name="online" value="student" checked>
	  		<font color="#999999"><b>Student</b></font></label>
	  </td>
  </tr>
  <br>
</p>
</table>
  <p> 
    <input type="submit" name="Submit" value="submit">
  </p>
  <p><a href="./logout.jsp"><font color="#999999"><b>LOGOUT</b></font></a></p>
  <hr>
</form>
</center>
</body>
</html>

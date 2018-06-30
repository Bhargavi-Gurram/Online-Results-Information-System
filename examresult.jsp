<%@ page  import="java.sql.*"%>
<html>
<head>
<title>Counceller View</title>

</head>
<body bgcolor="#FFFFD9">
<center>
  <h2><font color="#999999"><b>Online Exam Counceller View</b></font></h2>
  <p><br>

  <form name="form1" action="./result">

<table width="100%">
  <tr> 
    <td><div align="center"><a href="engineerresult.jsp"><font color="#999999"><b>ENGG RESULTS</b></font></a>&nbsp;</div></td>
    <td><div align="center"><a href="medico.jsp"><font color="#999999"><b>MEDICINE RESULTS</b></font></a> &nbsp;</div></td>
	<td><div align="center"><a href="marksentryform.jsp"><font color="#999999"><b>ENGG MARKS ENTRY</b></font></a>&nbsp;</div></td>
	<td><div align="center"><a href="medicomarks.jsp"><font color="#999999"><b>MEDICO MARKS ENTRY</b></font></a></div></td>
	<td><div align="center"><a href="studentregistration.jsp"><font color="#999999"><b>STUDNET REGG</b></font></a></div></td>
 </tr>
</table>
<br><hr>

<table>
<tr>

</tr>
<tr><td>
<select name="result">
<option value="me">top 10 male Engineers</option>
<option value="mm">top 10 male Medico's</option>
<option value="fe">top 10 female Engineers</option>
<option value="fm">top 10 female Medico's</option>
</select>
</td></tr>
<tr>
<td></td>
<td><input name="submit" type="submit" value="submit"></td>
<td><div align="center"><a href="onlinehome.jsp"><font color="#999999"><b>LOGOUT</b></font></a>&nbsp;</div></td>

</tr>
</table>
</form>
</center>
</body>
</html>

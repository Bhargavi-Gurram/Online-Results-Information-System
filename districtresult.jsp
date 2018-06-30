<%@ page  import="java.sql.*" %>
<html>
<head>
<title>District Coordinater View</title>

</head>
<body bgcolor="#FFFFD9">
<form action="./district" name="sel">
<center>
<font color="#999999">
<h1>Online Results</h1>
<h2>Results By Area Wise</h2>
</font>
<hr>
<br><br>
<select name="district">
<option value="hyderabad">Hyderabad</option>
<option value="secunderabad">Secundrabad</option>
<option value="guntur">Guntur</option>
<option value="vijayawada">Vijayawada</option>
<option value="vishakapatnam">Vishakapatnam</option>
<option value="rajahmundry">Rajahmundry</option>
<option value="nellore">Nellore</option>
</select><br>
<br><br><br>
<label><input name="subject" type="radio" value="engg" checked><font color="#999999"><b>Engg Result</b></font></label>
<label><input name="subject" type="radio" value="medico"><font color="#999999"><b>Medicine Result</b></font></label>

<br><br><br>
<input name="submit" type="submit" value="Submit">
<a href="onlinehome.jsp">LOGOUT</a>
</center>
<br><br>
<hr>
</form>
</body>
</html>

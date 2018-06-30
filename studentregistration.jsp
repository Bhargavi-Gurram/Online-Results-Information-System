<%@ page  import="java.sql.*"  %>
<html>
<head>
<title>Untitled Document</title>
</head>
<%
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
     Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
     Statement st=con.createStatement();
 %>
<script language="javascript">
function check1()
{
	var no=document.reg.sno.value;
	if(isNaN(no))
	{
		alert("Enter valid Hall Ticket Number");
		document.reg.focus();
		document.reg.sno.value="";
	}
}
function check2()
{
	var name=document.reg.sname.value;
	if(!isNaN(name))
	{
		alert("Enter valid Student Name");
		document.reg.focus();
		document.reg.sname.value="";
	}
}
function check3()
{
	var add=document.reg.address.value;
	if(!isNaN(add))
	{
		alert("Enter valid Address");
		document.reg.focus();
		document.reg.address.value="";
	}
}
function check4()
{
	var dis=document.reg.district.value;
	if(!isNaN(dis))
	{
		alert("Enter valid District Name");
		document.reg.focus();
		document.reg.district.value="";
	}
}

</script>

<body bgcolor="#FFFFD9">
<form action="./stureg" name="reg">
<center>
<br>
<h1><font color="#999999"><b>Student Entry</b></font></h1>
<hr>
<br>
<table>
<tr>
<%
ResultSet rs2=st.executeQuery("select max(sno) from studentinfo");
rs2.next();
int sno=1;
int c=rs2.getInt(1);
System.out.println("c="+c);
if (c==0)
sno=1;
else 
sno=c+1;
System.out.println("sno="+sno);
%>
<td><label><font color="#999999"><b>Student No</b></font></label></td>
      <td><input type="text" name="sno" value="<%=sno%>" readonly="sno" onBlur="check1()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Student Name</b></font></label></td>
<td><input name="sname" type="text" onBlur="check2()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Gender</b></font></label></td><td><select name="gender">
<option value="male">Male</option>
<option value="female">Female</option>
</select></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Date of Birth</b></font></label></td>
<td><input type="text" name="date" onBlur="check5()"></td>
<td><label><font color="#9900FF"><b>[02-mar-79]</b></font></label></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Address</b></font></label></td>
<td><input type="text" name="address" onBlur="check3()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>District</b></font></label></td>
<td><input type="text" name="district" onBlur="check4()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>State</b></font></label></td>
<td><input type="text" name="state" value="AndhraPradesh" disabled></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="submit" name="submit" value="Submit">
<input type="reset" name="reset" value="Reset"></td>
<td><a href="./examresult.jsp"><font color="#999999"><b>LOGOUT</b></font></a></td>
</tr>
</table>
<br>
<hr>
</center>
</form>
</body>
</html>

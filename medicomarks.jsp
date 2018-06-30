<%@ page  import="java.sql.*"  %>
<html>
<head>
<title>Medico Marks Entry Form</title>
</head>
<body bgcolor="#FFFFD9">
<script language="javascript">
function check1()
{
	var h=document.medico.hno.value;
	if(isNaN(h))
		{
			alert("enter any Number");
			document.medico.hno.focus();
			document.medico.hno.value="";
		}
}
function check2()
{
	var b=document.medico.botony.value;
	if(isNaN(b))
		{
			alert("enter any Number");
			document.botony.focus();
			document.botony.value="";
		}
}
function check3()
{
	var z=document.medico.zeology.value;
	if(isNaN(z))
		{
			alert("enter any Number");
			document.medico.zeology.focus();
			document.medico.zeology.value="";
		}
}
function check4()
{
	var p=document.medico.physics.value;
	if(isNaN(p))
		{
			alert("enter any Number");
			document.medico.physics.focus();
			document.medico.physics.value="";
		}
}
function check5()
{
	var c=document.medico.chemistry.value;
	if(isNaN(c))
		{
			alert("enter any Number");
			document.medico.chemistry.focus();
			document.medico.chemistry.value="";
		}
}


function check6()
{
	var s=document.medico.hno.value;
	if(!isNaN(s))
		{
			alert("enter any String");
			document.medico.hno.focus();
			document.medico.hno.value="";
		}
}

</script>
<form action="./medico" name="medico">
<center>
<br>
<h1><font color="#999999">Medicine Marks Entry Form</font></h1>
<hr>
<br>
<% Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select sno from studentInfo where sno not in (select sno from medico where hno is not null) order by sno");
%>
<table>
<tr>
<td><label><font color="#999999"><b>Student No</b></font></label></td>
<td>
<select name="sno">
<%while(rs.next())
{%>
<option><%=rs.getInt(1)%></option>
<%}%>
</select></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Hall No</b></font></label></td>
<td><input type="text" name="hno" onBlur="check1()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Botony</b></font></label></td>
<td><input type="text" name="botony" onBlur="check2()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Zeology</b></font></label></td>
<td><input type="text" name="zeology" onBlur="check3()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Physics</b></font></label></td>
<td><input type="text" name="physics" onBlur="check4()"></td>
</tr>
<tr>
<td><label><font color="#999999"><b>Chemistry</b></font></label></td>
<td><input type="text" name="chemistry" onBlur="check5()"></td>
</tr>
<tr>
<td></td>
<td align="center"><input type="submit" value="submit">
<input type="reset" value="reset"></td>
<td><a href="./examresult.jsp"><font color="#999999"><b>LOGOUT</b></font></a></td>
</tr>
</table>
<br>
<hr>
</center>
</form>
</body>
</html>

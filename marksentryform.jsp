<%@ page  import="java.sql.*" %>
<%@ page import="java.io.*"%>
<html>
<head>
<title>Entry Form</title>

<script language="javascript">
function checkint1()
{
var m=document.marks.maths.value;
if(isNaN(m) || m=="")
	{
		alert("enter any number");
		document.marks.maths.focus();
		document.marks.maths.value="";
	}

}
function checkint2()
{
var p=document.marks.physics.value;
if(isNaN(p) || p=="")
	{
		alert("enter any number");
		document.marks.physics.focus();
		document.marks.physics.value="";
	}
}
function checkint3()
{
var c=document.marks.chemistry.value;
if(isNaN(c) || c=="")
	{
		alert("enter any number");
		document.marks.chemistry.focus();
		document.marks.chemistry.value="";
	}
}
function checkint4()
{
var h=document.marks.hno.value;
if(isNaN(h) || h=="")
	{
		alert("enter any number");
		document.marks.hno.focus();
		document.marks.hno.value="";
	}
}

</script>

</head>
<form action="./marksentry" name="marks"  method="post">

<body bgcolor="#FFFFD9">
<center>
<h1><font color="#999999" face="">Marks Entry Form</font></h1>
<hr>
<br>
<% Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con=DriverManager.getConnection("jdbc:odbc:exam","exam","exam");
System.out.println("connected=========================");
Statement st=con.createStatement();
ResultSet rs=st.executeQuery("select sno from studentinfo where sno not in(select sno from engg where hno is not null) order by sno");
%>
<table>
<tr>
	<td><font color="#999999"><b>Student Number</b></font></td>
	<td>
  <select name="sno" onChange="MM_jumpMenu('parent',this,0)">
  <% while(rs.next())
  	{%>
  		  <option><%=rs.getInt(1)%></option>
		     <% }%>
  </select>

</td>
</tr>
<tr>
	<td><font color="#999999"><b>Hall Ticket No</b></font></td>
	<td><input name="hno" type="text" onBlur="checkint4()"></td>
</tr>
<tr>
	<td><font color="#999999"><b>Maths</b></font></td>
	<td><input name="maths" type="text" onBlur="checkint1()"></td>
</tr>
<tr>
	<td><font color="#999999"><b>Physics</b></font></td>
	<td><input name="physics" type="text" onBlur="checkint2()"></td>
</tr>
<tr>
<td><font color="#999999"><b>Chemistry</b></font></td>
<td><input name="chemistry" type="text" onBlur="checkint3()"></td>
</tr>
<tr>
<td></td>
<td align="center"><input name="submit" type="submit" value="submit">
<input name="reset" type="reset">
<a href="examresult.jsp"><font color="#999999"><b>BACK</b></font></a>
</td>
</tr>
</table>
<br>
<hr>
</center>
</form>
</body>
</html>

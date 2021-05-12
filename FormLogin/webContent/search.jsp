<%@page import="usingServletJsp.com.database.StudentDao" %>
<%@page import="usingServletJsp.com.bean.Student" %>
<%@page import="java.util.List" %><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Student</title>
<link href="Search.css" rel="stylesheet" type="text/css">
<link href="InformationCss.css" rel="stylesheet" type="text/css">
</head>
<body>
<% 
String errorMsg = (String)request.getAttribute("errorMsg"); 
if(errorMsg == null || "".equals(errorMsg)){
	errorMsg ="";
}
%>
	<div>
		<div>
			<form action="/FormLogin/search" method="get">
		      	Age:<input type="text" name="age" class="search" placeholder="Search here!"><%=errorMsg %><br/>
		      	
		      	Name:<input type="text" name="name" class="search" placeholder="Search here!">
		      	StudentId:<input type="text" name="id" class="search" placeholder="Search here!">
		      	Address:<input type="text" name="address" class="search" placeholder="Search here!">
		      	Gender:<input type="text" name="gender" class="search" placeholder="Search here!">
		      	<input type="submit" name="submit" class="submit" value="Search">
		    </form>
		   
		</div>
		
			
		<div style="float:right" >
		      	<input type="button" class="submit" id="btnCreate" value="Insert" >
		    
		      	<input type="button" class="submit" value="Update">
		    
		      	<input type="button" class="submit" value="Delete">
		</div>
		
		<center>
		<div>
			<h1>Table Student</h1>
		    <table class="styled-table">
			  <tr >
			    <th>StudentId</th>
			    <th>Name</th>
			    <th>Age</th>
			    <th>Address</th>
			    <th>Gender</th>
			  </tr>
			  <%
			  	
			  List<Student> list1 = (List)request.getAttribute("list"); 
			  %>
			  <%
			  if(list1 != null) {
					for(Student student: list1) {
			 %>
						  <tr>
						    <td><%=student.getId() %></td>
						    <td><%=student.getName() %></td>
						    <td><%=student.getAge() %></td>
						    <td><%=student.getAddress() %></td>
						    <td><%=student.getGender() %></td>
						  </tr>
					
			<%
					}
			%>
			<%
			  }
			%>		
			
			
			</table>
		</div>
</body>

<script type="text/javascript">


function onCreate(){
	window.open("Insert.jsp", "", "toolbar=yes,menubar=no,resizable=yes,scrollbars=yes,width=400,height=400");
}
</script>
</html>
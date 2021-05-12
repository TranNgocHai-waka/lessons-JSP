<%@page import="usingServletJsp.com.database.StudentDao" %>
<%@page import="usingServletJsp.com.bean.Student" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Information</title>
<link href="InformationCss.css" rel="stylesheet" type="text/css">
</head>
<body>
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
	</table>
</body>
</html>
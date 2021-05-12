<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Student</title>
</head>
<body>
	<div>
		<form action="/FormLogin/insert" method="get">
		<table class="styled-table">
		<thead>
			<tr>
			<th colspan="2" style="text-align:center;">Insert Student</th>
			</tr>
		</thead>
			  <tr>
			    <td>StudentId</td>
			    <th><input type="text" name="id" class="search" ></th>
			  </tr>
			   <tr >
			    <td>Name</td>
			    <td><input type="text" name="name" class="search" ></td>
			  </tr>
			   <tr >
			    <td>Age</td>
			    <td><input type="text" name="age" class="search" ></td>
			  </tr>
			   <tr >
			    <td>Address</td>
			    <td><input type="text" name="address" class="search"></td>
			  </tr>
			   <tr >
			    <td>Gender</td>
			    <td><input type="text" name="gender" class="search"></td>
			  </tr>
		</table>
		<input type="submit" name="submit" class="submit" value="Insert">
	    </form>
		
	</div>
</body>
</html>
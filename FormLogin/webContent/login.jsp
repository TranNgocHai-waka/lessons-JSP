<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
	<h1>Login</h1>
	<form action="/FormLogin/check" method="post">
		Username: <input type="text" name="txtusername"/> <br> <br>
		Password: <input type="password" name="txtpassword"/> <br>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>
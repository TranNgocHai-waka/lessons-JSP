<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link href="login1Css.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-box">
  <h2>Login</h2>
  <form action="/FormLogin/check" method="post">
    <div class="user-box">
      <input type="text" name="txtusername" >
      <label>Username</label>
    </div>
    <div class="user-box">
      <input type="password" name="txtpassword" >
      <label>Password</label>
    </div>
    <center>
    <input class="example" type="submit" value="Login"/>
    </center>
  </form>
</div>
</body>
</html>
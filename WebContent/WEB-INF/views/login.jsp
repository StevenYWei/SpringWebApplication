<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1 align="center">Login Page</h1>
	<div align="center">
		<font color="red">${ErrMsg}</font>
	</div>
	<div align="center">
		<form action="login" method="post">
			Your Username:<br> <input type="text" name="userName" value="a1"><br>
			Password:<br> <input type="password" name="password" value="1"><br>
			<input value="Submit" type="submit">
		</form>
	</div>

	username: a1, pw:1
	<br> username: a2, pw:2
</body>
</html>

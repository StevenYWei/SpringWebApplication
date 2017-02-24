<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<html xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<h1 align="center">Login Page</h1>
	<div align="center">
	
		<c:if test="${param.error != null}">
			<div>
				<p>
					<font color="red">Invalid username or password.</font>
				</p>
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div>
				<p>
					<font color="blue">You have been logged out successfully.</font>
				</p>
			</div>
		</c:if>
		
		<form action="${loginUrl}" method="post">
			Your Username:<br> <input type="text" name="username" value="a1" id="username"><br>
			Password:<br> <input type="password" name="password" value="1" id="password"><br>
			<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
			<input value="Submit" type="submit">
		</form>
	</div>

	ADMIN - username: a1, pw:1 <br>
	ADMIN - username: a2, pw:2 <br>
	USER - username: 1, pw: 1
</body>
</html>

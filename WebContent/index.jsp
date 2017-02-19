<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*" %>
<html>
<head>
<title>Redirect Page</title>
</head>
<body>
<%
   // New location to be redirected
   String site = new String(request.getRequestURL() + "/getDeptEmpListAtMain");
   response.setStatus(response.SC_MOVED_TEMPORARILY);
   response.setHeader("Location", site); 
   System.out.println("In the redirect page");
%>
</body>
</html>
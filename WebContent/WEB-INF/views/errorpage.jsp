<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<title>Error Page</title>
<div><h1 align="center"><Strong><font color="red">This is Error Page<br>Something is Wrong!</font></Strong></h1></div>

<div><% exception.printStackTrace(response.getWriter()); %></div>
 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>

<title>Error Page</title>
<h1 align="center"><Strong><font color="red">Ah-ha! Something is Wrong!</font></Strong></h1>

<div><% exception.printStackTrace(response.getWriter()); %></div>

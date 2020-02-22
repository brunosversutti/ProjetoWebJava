<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isErrorPage="true" import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erro encontrado</title>
</head>
<body>

	<h1>Exception - Erro encontrado</h1>
	<br>
	<p>Ocorreu o seguinte erro:</p>
	<p>${errMsg} </p>
	<p><a href="/PROJETOFINAL/index.jsp">Login</a></p>
</body>
</html>
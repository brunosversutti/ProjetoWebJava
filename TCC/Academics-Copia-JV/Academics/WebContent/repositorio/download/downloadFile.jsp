<%@page import="java.io.OutputStream"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download de Arquivos</title>
</head>
<body>
	<form action="../../Servlets/ServletDownload">
	<%
	
	
	String fileName ="P1030211.JPG";
	String filePath ="E:\\UPLOAD\\";
	
	response.setContentType("APPLICATION/OCTET-STREAM");
	response.setHeader("Content-Disposition","attachment; fileName=\"" + fileName + "\"");
	
	java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filePath + fileName);
	
	int i;
	
	while((i=fileInputStream.read())!= -1){
		//out.write(i);
		OutputStream outStream = response.getOutputStream();
		outStream.write(i);
	
	}
	
	fileInputStream.close();
	
	%>
	
	</form>


</body>
</html>
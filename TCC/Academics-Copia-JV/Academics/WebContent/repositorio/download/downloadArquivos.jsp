<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Download Arquivos</title>
</head>
<body>
	
	
	<table>
		<thead>
			<tr>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>Descricao</b></th>
				<th align="center"><b>Arquivo</b></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="file" items="${items}"> 
				<td>${file.name}</td>
				<td><a href="download.do?id=${file.id}">Baixar</a></td>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
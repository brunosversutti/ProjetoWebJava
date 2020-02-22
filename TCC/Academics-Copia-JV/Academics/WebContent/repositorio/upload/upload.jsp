<%@page import="DTO.AlunoDTO"%>
<%@page import="DAO.AtividadeDAO"%>
<jsp:useBean id="alunoDTO" scope="request" class="DTO.AlunoDTO"></jsp:useBean>
<jsp:setProperty property="*" name="alunoDTO" />
<jsp:useBean id="atividadeDTO" scope="request" class="DTO.AtividadeDTO"></jsp:useBean>
<jsp:setProperty property="*" name="atividadeDTO" />



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enviar tarefa</title>
</head>
<body>

	<form method="post" action="../../Servlets/ServletUploadFile" enctype="multipart/form-data">
		
		<input type="hidden" name="aluno" readonly="readonly" value='<jsp:getProperty property="codigo" name="alunoDTO"/>'>
		<input type="hidden" name="codigoAtiv" readonly="readonly" value='<jsp:getProperty property="codigo" name="atividadeDTO"/>'>
		
		<input name="file" type="file"/>
		<input type="submit" value="enviar"/>
		
	</form>

</body>
</html>
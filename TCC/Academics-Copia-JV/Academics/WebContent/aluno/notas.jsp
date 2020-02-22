
<%@page import="DAO.CursoDAO"%>
<%@page import="DTO.CursoDTO"%>
<%@page import="DAO.SemestreDAO"%>
<%@page import="DTO.SemestreDTO"%>
<%@ page session = "false" %>
<%@ page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<title>ACADEMICS || Consulta de Notas e Presenca</title>
</head>
<body>
<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><a href="/Academics/professor/menu.jsp"><img src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">
<form class="col-md-5 col-md-offset-4">
<h2>Consultar Notas</h2>
Informe o Semestre:<BR>
<input type="submit" value="Consultar" class="btn btn-primary">
</div>
</div>
</form>
<footer>
  <div class="container">
  <div class="col-md-offset-4">
  Desenvolvido por ACADEMICS® - Todos os direitos reservados.
  </div>
  </div>
</footer>
</body>
</html>
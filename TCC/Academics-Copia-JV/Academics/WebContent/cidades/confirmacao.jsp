<%@page isErrorPage="true" import="java.io.*"%>
<%@page import="DTO.CidadeDTO"%>
<%@page import="DAO.CidadeDAO"%>
<%@page session = "false" %>
<%@page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
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

<title>Confirmacao</title>

</head>
<body>
<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><a href="/Academics/gerenciador/menu.jsp"><img src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li><a href="/Academics/gerenciador/menu.jsp">Home</a></li>
          <li><a href="/Academics/cidades/lista.jsp">Cidades</a></li>
          <li><a href='/Academics/cidades/cadastro.jsp'>Nova Cidade</li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
	
	<div class="container">
<% HttpSession sessao = request.getSession(false); %>
<%String novaCidade = (String)sessao.getAttribute("novaCidade");%>
<h2>A cidade de <%=novaCidade%> foi cadastrada com sucesso!</h2>

	<div class="row col-md-6 col-md-offset-2">			
			<fieldset>
			<a href='/Academics/cidades/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Nova Cidade</a><br>
			</fieldset>
	
		</div>
	</div>
<footer>
  <div class="container">
  <div class="col-md-offset-4">
  Desenvolvido por ACADEMICS® - Todos os direitos reservados.
  </div>
  </div>
</footer>	
	
</body>
</html>
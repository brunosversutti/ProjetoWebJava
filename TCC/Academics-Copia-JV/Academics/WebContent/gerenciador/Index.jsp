<%@page import="javax.xml.ws.RequestWrapper"%>
<%@ page import="DTO.PessoaDTO"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	PessoaDTO pessoaDTOLogin = (PessoaDTO) session
			.getAttribute("usuarioLogado");

	if (pessoaDTOLogin == null) {
		pessoaDTOLogin = new PessoaDTO();
		pessoaDTOLogin.setNome("administrador");
	}

	if (pessoaDTOLogin == null) {
%>
<jsp:forward page="/Index.jsp"></jsp:forward>
<%
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Bem Vindo</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<!-- Bootstrap core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="./css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="./js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
<script src="./js/jquery-latest.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/cssform.css">
</head>
<body>
<%=pessoaDTOLogin.getNome()%>

	<header id="header">
	<div class="container">
		<div class="col-md-4">
			<a href=""><img
				src="http://moodle.ifal.edu.br/theme/essential/pix/logo-moodle.png" /></a>
		</div>
		<nav class="col-md-4 col-md-offset-4" id="menu_principal">
		<ul>
			<li><a href="#">Início</a></li>
			<li><a href="#">Cadastrar</a></li>
			<li><a href="#">Consultar</a></li>
			<li><a href="#">Sair</a></li>
		</ul>
		</nav>
	</div>
	<link rel="stylesheet" type="text/css" href="../css/cssform.css">
	</header>
	<div class="container">
		<center>
			<h2>Seja bem vindo!</h2>
			<BR>
			<div class="col-md-6 col-md-offset-3">
				<fieldset>
					<legend>O que deseja fazer?</legend>
					<a href="/Academics/Curso/CadCurso.jsp" class="btn btn-primary" name="Cursos">Gerenciar Cursos</a><BR>
					<BR><a href="/Academics/Aluno/CadAluno.jsp" class="btn btn-primary" name="Alunos">Gerenciar Alunos</a><BR>
					<BR> <a href="/Academics/professor/cadprof.jsp" class="btn btn-primary" name="Professores">Gerenciar Professores</a><BR>
					<BR> <a href="/Academics/Admin/CadAdmin.jsp" class="btn btn-primary" name="Administradores"> Gerenciar
						Administrador</a><BR>
					<BR><a href="/Academics/Cidades/Cadastro.jsp" class="btn btn-primary" name="Cidades">Gerenciar Cidades</a><BR>
					<BR><a href="/Academics/Disciplina/disciplina.jsp" class="btn btn-primary" name="Disicplinas">Gerenciar Disciplina</a><BR>
					<BR><a href="/Academics/Semestre/Semestre.jsp" class="btn btn-primary" name="Semestres">Gerenciar Semestre</a><BR>
				</fieldset>
			</div>
	</div>
</body>
</html>
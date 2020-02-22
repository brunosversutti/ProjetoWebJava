<%@page import="DTO.CidadeDTO"%>
<%@page import="DAO.CidadeDAO"%>

<%@page import="DTO.ProfessorDTO" %>
<%@page import="DAO.ProfessorDAO" %>
<%@page import="DTO.SemestreDTO" %>
<%@page import="DAO.SemestreDAO" %>
<%@page import="VO.ProfessorVO" %>
<%@page import="VO.SemestreVO" %>

<%@ page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id="cidadeVO" class="VO.CidadeVO"></jsp:useBean>	
<jsp:useBean id="professorVO" class="VO.ProfessorVO"></jsp:useBean>	
<jsp:useBean id="semestreVO" class="VO.SemestreVO"></jsp:useBean>
<jsp:useBean id="semestreDTO" class="DTO.SemestreDTO"></jsp:useBean>
<jsp:useBean id="professorDTO" class="DTO.ProfessorDTO"></jsp:useBean>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<title>Cadastro de Professor</title>
</head>
<body>
	<header>
	<div id="header">
		<div class="container">
			<div class="col-lg-3 logo">
				<a href="/Academics/gerenciador/menu.jsp"><img
					src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a>
			</div>
			<div class="col-lg-9">
				<nav id="menuprincipal">
				<ul>
					<li><a href="/Academics/gerenciador/menu.jsp">Home</a></li>
					<li><a href="/Academics/professor/lista.jsp">Lista de Professores</a></li>
					<li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	</header>
	<div class="container">

		<h2>Cadastrar Professor</h2>
		
	<%
	
		ArrayList<ProfessorDTO> professores = (ArrayList) professorVO.getProfessor();
		ArrayList<SemestreDTO> semestres = (ArrayList) semestreVO.getSemestre(); 	
	
		if(request.getAttribute("professorSelecionado") == null)
				request.setAttribute("professorSelecionado", "0");
		String professorSelecionado = (String)request.getAttribute("professorSelecionado");
		
		if(request.getAttribute("semestreSelecionado") == null)
			request.setAttribute("semestreSelecionado", "0");
		String semestreSelecionado = (String)request.getAttribute("semestreSelecionado");
		
		ArrayList<CidadeDTO> cidades = (ArrayList) cidadeVO.getCidades();

		if(request.getAttribute("cidadeSelecionada") == null)
			request.setAttribute("cidadeSelecionada","0");
			String cidadeSelecionada = (String)request.getAttribute("cidadeSelecionada");
		
	
	%>	
		

		<form class="col-md-5 col-md-offset-4" name="frmaluno" action="../Servlets/ServletProfessor" method="post">
				<fieldset>
				<legend>Dados pessoais</legend>
				<label>Nome:</label><br>
				<input type="text" class="form-control" name="nome"> </input><br>
				<label>Data de Nascimento:</label><br>
				<input type="date" class="form-control" name="nascimento"> </input><br>
				<label>RG:</label><br>
				<input type="text" class="form-control" name="rg"> </input><br>
				<label>CPF:</label><br>
				<input type="text" size="12" class="form-control" name="cpf"> </input><br>
				<label>Telefone:</label><br>
				<input type="text" class="form-control" name="telefone"> </input><br>
			</fieldset>

			<fieldset>
				<legend>Endereço</legend>
				<label>Logradouro:</label><br>
				<input type="text" class="form-control" name="logradouro"> </input><br>
				<label>Número:</label><br>
				<input type="text" class="form-control" name="numero"> </input><br>
				<label>Bairro:</label><br>
				<input type="text" class="form-control" name="bairro"> </input><br>
				<label>Cidade:</label><br>
				<select class="form-control" name="cidade">
					<%
						for (int i = 0; i < cidades.size(); i++) {
					%>
						<option value= <%=cidades.get(i).getCidade()%> ><%=cidades.get(i).getCidade()%> -<%=cidades.get(i).getUf()%></option>
					<%
						}
					%>
				</select><br>
				<label>CEP:</label><br>
				<input type="text" class="form-control" name="cep"> </input><br>
			</fieldset> 
			</br>
			<fieldset>
				<legend>Dados administrativos</legend>
				<label>Título:</label><br>
				<select class="form-control" id="titulos" name="titulo">
					<option value="bacharel">Bacharel</option>
					<option value="pos">Pós graduado</option>
					<option value="mestre">Mestre</option>
					<option value="doutor">Doutor</option>
				</select>
				<label>Especialidade:</label><br>
				<input type="text" class="form-control" name="especialidade"> </input><br>
				<label>Login:</label><br>
				<input type="text" class="form-control" name="login"> </input><br>
				<label>Senha:</label><br>
				<input type="password" class="form-control" name="senha"> </input><br>
			</fieldset>
			</br>
			<input type="submit" name="inserirProfessor" value="Salvar" class="btn btn-lg btn-primary btn-block" onclick="VerificaCPF();">
			<input type="reset" name="limpaCampos" value="Limpar" class="btn btn-lg btn-default btn-block">
		</form>
	</div>
	<footer>
	<div class="container">
		<div class="col-md-offset-4">Desenvolvido por ACADEMICS® - Todos os direitos reservados.</div>
	</div>
	</footer>
</body>
</html>
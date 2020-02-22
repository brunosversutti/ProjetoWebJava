<%@page import="DTO.CursoDTO"%>
<%@page import="DAO.CursoDAO"%>
<%@page import="DTO.ProfessorDTO" %>
<%@page import="DAO.ProfessorDAO" %>
<%@page import ="DTO.ProfSemDTO" %>
<%@page import ="DAO.ProfSemDAO" %>
<%@page import ="DTO.CursoProfSemDTO" %>
<%@page import ="DAO.CursoProfSemDAO" %>
<%@page import="DTO.SemestreDTO" %>
<%@page import="DAO.SemestreDAO" %>
<%@page import="VO.ProfessorVO" %>
<%@page import="VO.SemestreVO" %>
<%@page import="VO.CursoVO" %>
<%@page import="VO.ProfSemVO" %>


<%@ page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<jsp:useBean id="professorVO" class="VO.ProfessorVO"></jsp:useBean>	
<jsp:useBean id="semestreVO" class="VO.SemestreVO"></jsp:useBean>
<jsp:useBean id="cursoVO" class="VO.CursoVO"></jsp:useBean>
<jsp:useBean id="semestreDTO" class="DTO.SemestreDTO"></jsp:useBean>
<jsp:useBean id="professorDTO" class="DTO.ProfessorDTO"></jsp:useBean>
<jsp:useBean id="cursoDTO" class="DTO.CursoDTO"></jsp:useBean>
<jsp:useBean id="profSemDTO" class="DTO.ProfSemDTO"></jsp:useBean>
<jsp:useBean id="profSemVO" class="VO.ProfSemVO"></jsp:useBean>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<title>ACADEMICS || Professores do Curso</title>
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
					<li><a href="/Academics/cidades/lista.jsp">Criar Lista de Cursos - Nao esquecer</a></li>
					<li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	</header>
	<div class="container">

		<h2>Professores do curso</h2>
		
	<%
	
		ArrayList<ProfessorDTO> professores = (ArrayList) professorVO.getProfessor();
		ArrayList<SemestreDTO> semestres = (ArrayList) semestreVO.getSemestre();
		ArrayList<CursoDTO> cursos = (ArrayList) cursoVO.getCursos();
		
		ArrayList<ProfSemDTO> professoresSemestre = (ArrayList) profSemVO.getProfSemestre();
	
		if(request.getAttribute("professorSelecionado") == null)
				request.setAttribute("professorSelecionado", "0");
		String professorSelecionado = (String)request.getAttribute("professorSelecionado");
		
		if(request.getAttribute("semestreSelecionado") == null)
			request.setAttribute("semestreSelecionado", "0");
		String semestreSelecionado = (String)request.getAttribute("semestreSelecionado");
		
		if(request.getAttribute("cursoSelecionado")== null)
			request.setAttribute("cursoSelecionado", "0");
		String cursoSelecionado = (String)request.getAttribute("cursoSelecionado");
		
		
		
		if(request.getAttribute("profSemestreSelecionado") == null)
			request.setAttribute("profSemestreSelecionado", "0");
	String profSemestre = (String)request.getAttribute("profSemestreSelecionado");
		
		
	
	%>	
		

		<form class="col-md-5 col-md-offset-4" name="frmaluno" action="../Servlets/ServletCursoProfSem" method="post" onsubmit="VerificaCPF();">
		
		<label> Semestre:</label><BR>
			 <select name="semestre" class="form-control">
				<%
						for (int i = 0; i < semestres.size(); i++) {
				%>
						<option value= <%=semestres.get(i).getCodigo()%>> <%=semestres.get(i).getPeriodo()%> - <%=semestres.get(i).getAno()%></option>
				<%
					}
				%>
			</select> <br> <br>
	
			
			Professor:<BR>
			 <select name="profSemestre" class="form-control">
				<%
						for (int i = 0; i <professoresSemestre.size(); i++) {
					%>
						<option value= <%=professoresSemestre.get(i).getCodigo()%>> <%=professoresSemestre.get(i).getProfessor().getPessoa().getNome()%> - <%= professoresSemestre.get(i).getProfessor().getEspecialidade() %> </option>
					<%
						}
				%>
			</select> <br> <br>
			 
			Curso:
				
				<select class="form-control" name="curso">
					<%
						for (int i = 0; i < cursos.size(); i++) {
					%>
						<option value= <%=cursos.get(i).getCodigo()%> ><%=cursos.get(i).getNome()%> - <%=cursos.get(i).getPeriodo()%></option>
					<%
						}
					%>
				</select>
				<br>
			 
			<input type="submit" name="inserirCurso" value="Salvar" class="btn btn-lg btn-primary btn-block" onclick="VerificaCPF();">
		</form>
	</div>
	<footer>
	<div class="container">
		<div class="col-md-offset-4">Desenvolvido por ACADEMICS® - Todos os direitos reservados.</div>
	</div>
	</footer>
</body>
</html>
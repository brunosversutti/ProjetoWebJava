<%@page import="DTO.SemestreDTO"%>
<%@page import="DTO.ProfessorDTO"%>
<%@page import="DAO.SemestreDAO"%>
<%@page import="DTO.PessoaDTO"%>
<%@page import="DTO.CidadeDTO"%>
<%@page session="true" %>
<%@ page import = "java.util.List" %>
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
<link href="../css/jquery.dataTables.min.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>

<script language="javascript">
$(document).ready( function () {
    $('#tabela').DataTable();
} );

</script>


<title>Lista de Semestres</title>

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
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
          
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
	
	<div class="container">

<h2>Semestres Cadastrados</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
				<legend>Novo Semestre</legend>
			<a href='/Academics/semestres/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Novo Semestre</a><br>
			</fieldset>	
			<fieldset>
				<legend>Vincular Professores</legend>
			<a href='/Academics/semestres/vinculo_professor.jsp'class="btn btn-lg btn-primary btn-block">Vincular Professores</a><br>
			</fieldset>
			<fieldset>
				<legend>Matricular Alunos</legend>
			<a href='/Academics/semestres/vinculo_aluno.jsp'class="btn btn-lg btn-primary btn-block">Matricular Alunos</a><br>
			</fieldset>
			
			
	<table id="tabela" class="display" border="5" align="center">
			<legend>Listagem de Semestres</legend>
	<thead>
	
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Ano</b></th>
				<th align="center"><b>Periodo</b></th>
				<th align="center"><b>Status</b></th>
				<th align="center"><b>Modificar</b></th>
			</tr>
		</thead>
	
	<%
	HttpSession sessao = request.getSession(true);
	//CidadeDAO cidDAO = new CidadeDAO();
	SemestreDAO semestreDAO = new SemestreDAO();
	
	ResultSet rs = semestreDAO.ListaSemestre();
	
	while (rs.next()){
		SemestreDTO semestreDTO = new SemestreDTO();
		semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
		semestreDTO.setAno(rs.getInt("ANO"));
		semestreDTO.setPeriodo(rs.getString("PERIODO"));
		semestreDTO.setStatus(rs.getString("STATUS"));
		
	%>			
		<tbody>
		
		<tr>
			<td align="center"><%= semestreDTO.getCodigo()%></td>
			<td align="center"><%= semestreDTO.getAno()%></td>
			<td align="center"><%= semestreDTO.getPeriodo()%></td>
			<td align="center"><%= semestreDTO.getStatus()%></td>
			<td align="center"><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%= semestreDTO.getCodigo()%>&ano=<%=semestreDTO.getAno()%>'> Editar <img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			
		</tr>
		
	<%
	sessao.setAttribute("semestreDTO", semestreDTO);
	}
	%>	
		</tbody>
	</table>
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
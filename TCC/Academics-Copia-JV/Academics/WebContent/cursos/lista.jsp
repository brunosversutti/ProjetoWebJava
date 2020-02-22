<%@page import="DTO.CursoDTO"%>
<%@page import="DAO.CursoDAO"%>
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
<link href="../css/dataTables.bootstrap.min.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.dataTables.min.js"></script>



<title>Cursos Cadastrados</title>

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
          <li><a href="/Academics/cursos/cadastro.jsp">Novo Curso</a></li>
          <li><a href="/Academics/cursos/curso_semes_professor.jsp">Vincular Professor</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
          
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
	
	<div class="container">

<h2>Cursos Cadastrados</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
			<legend>Novo Curso</legend>
			<a href='/Academics/cursos/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Novo Curso</a><br>
			</fieldset>
			<legend>Vincular Professor ao Curso</legend>
			<a href='/Academics/cursos/curso_semes_professor.jsp'class="btn btn-lg btn-primary btn-block">Vincular Professor</a><br>
			</fieldset>	
	<table id="tabela">
			<legend>Lista de Cursos</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>Duracao</b></th>
				<th align="center"><b>Titulo</b></th>
				<th align="center"><b>Periodo</b></th>
			</tr>
		</thead>
	
	<%
	HttpSession sessao = request.getSession(true);
	
	CursoDAO cursoDAO = new CursoDAO();
	ResultSet rs = cursoDAO.BuscarCursos();
	
	while (rs.next()){
		
		CursoDTO cursoDTO = new CursoDTO();
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		
		cursos = cursoDAO.Listar();
		
		cursoDTO = new CursoDTO();
		cursoDTO.setCodigo(rs.getLong("IDCURSO"));
		cursoDTO.setNome(rs.getString("NOMECURSO"));
		cursoDTO.setDuracao(rs.getInt("DURACAO"));
		cursoDTO.setTitulo(rs.getString("TITULO"));
		cursoDTO.setPeriodo(rs.getString("PERIODO"));
		
		cursos.add(cursoDTO);
		
		
	%>			
		<tbody>
		
		<tr>
			<td><%=cursoDTO.getCodigo()%></td>
			<td><%=cursoDTO.getNome()%></td>
			<td><%=cursoDTO.getDuracao() %></td>
			<td><%=cursoDTO.getTitulo() %></td>
			<td><%=cursoDTO.getPeriodo() %></td>
			<td><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%= cursoDTO.getCodigo()%>&nome=<%=cursoDTO.getNome()%>'>Editar<img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			
			
		</tr>
		
	<%
	sessao.setAttribute("cursoDTO", cursoDTO);
	}
	%>	
		</tbody>
		
		<tfoot>
			
		<tr>
				<td align="center"><b>Codigo</b></td>
				<td align="center"><b>Nome</b></td>
				<td align="center"><b>Duracao</b></td>
				<td align="center"><b>Titulo</b></td>
				<td align="center"><b>Periodo</b></td>
		</tr>
		</tfoot>
		
		
		
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

<script language="javascript">
$(document).ready( function () {
    $('#tabela').DataTable();
} );

</script>

</body>
</html>
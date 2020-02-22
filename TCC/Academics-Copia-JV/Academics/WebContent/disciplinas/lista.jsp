<%@page import="DTO.DisciplinaDTO"%>
<%@page import="DAO.DisciplinaDAO"%>
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



<title>Disciplinas Cadastradas</title>

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

<h2>Disciplinas Cadastradas</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
			<legend>Nova Disciplina</legend>
			<a href='/Academics/disciplinas/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Nova Disciplina</a><br>
			</fieldset>	
	<table id="tabela">
			<legend>Lista de Disciplinas</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>Duracao</b></th>
			</tr>
		</thead>
	
	<%
	HttpSession sessao = request.getSession(true);
	
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	ResultSet rs = disciplinaDAO.BuscarDisciplinas();
	
	while (rs.next()){
		
		DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
		List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
		
		
		disciplinas = disciplinaDAO.Listar();
		
		disciplinaDTO.setCodigo(rs.getLong("IDDISCIPLINA"));
		disciplinaDTO.setNome(rs.getString("NOMEDISCIPLINA"));
		disciplinaDTO.setDuracao(rs.getInt("DURACAO"));
		disciplinas.add(disciplinaDTO);
		
		
	%>			
		<tbody>
		
		<tr>
			<td><%= disciplinaDTO.getCodigo()%></td>
			<td><%=disciplinaDTO.getNome()%></td>
			<td><%=disciplinaDTO.getDuracao() %></td>
			<td><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%= disciplinaDTO.getCodigo()%>&cidade=<%=disciplinaDTO.getNome()%>'>Editar<img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			
			
		</tr>
		
	<%
	sessao.setAttribute("cidadeDTO", disciplinaDTO);
	}
	%>	
		</tbody>
		
		<tfoot>
			
		<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>Duracao</b></th>
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
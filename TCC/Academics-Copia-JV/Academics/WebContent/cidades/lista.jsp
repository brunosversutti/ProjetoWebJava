<%@page import="DTO.CidadeDTO"%>
<%@page import="DAO.CidadeDAO"%>
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



<title>Cidades Cadastradas</title>

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

<h2>Cidades Cadastradas</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
			<legend>Nova Cidade</legend>
			<a href='/Academics/cidades/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Nova Cidade</a><br>
			</fieldset>	
	<table id="tabela" class="table table-striped table-bordered" cellspacing="0" width="100%">
			<legend>Lista de Cidades</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Cidade</b></th>
				<th align="center"><b>Estado</b></th>
				<th align="center"><b>Editar</b></th>
				<th align="center"><b>Excluir</b></th>
			</tr>
		</thead>
	
	<%
	HttpSession sessao = request.getSession(true);
	CidadeDAO cidDAO = new CidadeDAO();
	
	ResultSet rs = cidDAO.BuscarCidade();
	
	while (rs.next()){
		
		CidadeDTO cidDTO = new CidadeDTO();
		List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();
		cidades = cidDAO.Listar();
		cidDTO.setCodigo(rs.getLong("IDCIDADE"));
		cidDTO.setCidade(rs.getString("NOMECIDADE"));
		cidDTO.setUf(rs.getString("UF"));
		cidades.add(cidDTO);
		
	%>			
		<tbody>
		
		<tr>
			<td><%= cidDTO.getCodigo()%></td>
			<td><%=cidDTO.getCidade()%></td>
			<td><%=cidDTO.getUf() %></td>
			<td><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%= cidDTO.getCodigo()%>&cidade=<%=cidDTO.getCidade()%>'>Editar<img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			<td>
			<a href='../Servlets.Atualizar/AtualizaCidades?acao=Excluir&codigo=<%= cidDTO.getCodigo()%>&cidade=<%=cidDTO.getCidade()%>'>Excluir<img 
			src="/Academics/content/imagens/apagar.png" border =0></a>
			</td>
			
		</tr>
		
	<%
	sessao.setAttribute("cidadeDTO", cidDTO);
	}
	%>	
		</tbody>
		
		<tfoot>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Cidade</b></th>
				<th align="center"><b>Estado</b></th>
				<th align="center"><b>Editar</b></th>
				<th align="center"><b>Excluir</b></th>
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
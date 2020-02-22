<%@page import="DTO.PessoaDTO"%>
<%@page import="DTO.AdministradorDTO"%>
<%@page import="DAO.AdministradorDAO"%>
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



<title>Lista de Adminisrradores</title>

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
          <li><a href="/Academics/gerenciador/cadastro.jsp">Novo Administrador</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
          
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
	
	<div class="container">

<h2>Administradores Cadastrados</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
			<legend>Novo Administrador</legend>
			<a href='/Academics/gerenciador/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Novo Administrador</a><br>
			</fieldset>	
	<table id="tabela">
			<legend>Lista de Administradores</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>Cargo</b></th>
				<th align="center"><b>Login</b></th>
				<th align="center"><b>Senha</b></th>
			</tr>
		</thead>
	
	<%
	HttpSession sessao = request.getSession(true);
	
	AdministradorDAO admDAO = new AdministradorDAO();
	ResultSet rs = admDAO.BuscarAdministrador();
	
	while (rs.next()){
		
		AdministradorDTO admDTO = new AdministradorDTO();
		PessoaDTO pessoaDTO = new PessoaDTO();
		List<AdministradorDTO> administradores = new ArrayList<AdministradorDTO>();
		
		administradores = admDAO.Listar();
		
		pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
		pessoaDTO.setNome(rs.getString("NOME"));
		pessoaDTO.setLogin(rs.getString("LOGIN"));
		pessoaDTO.setSenha(rs.getString("SENHA"));
		admDTO.setCodigo(rs.getLong("IDADMINISTRADOR"));
		admDTO.setCargo(rs.getString("CARGO"));
		admDTO.setPessoa(pessoaDTO);
		
		administradores.add(admDTO);
		
	%>			
		<tbody>
		
		<tr>
			<td><%= admDTO.getCodigo()%></td>
			<td><%=admDTO.getPessoa().getCodigo()%></td>
			<td><%=admDTO.getCargo() %></td>
			<td><%=pessoaDTO.getLogin() %></td>
			<td><%=pessoaDTO.getSenha() %></td>
			<td><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%=admDTO.getCodigo() %></td>%>&cidade=<%=admDTO.getNome() %>'>Editar<img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			
			
		</tr>
		
	<%
	sessao.setAttribute("administradorDTO", admDTO);
	sessao.setAttribute("pessoaDTO", pessoaDTO);
	
	}
	%>	
		</tbody>
		
		<tfoot>
			
		<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>Cargo</b></th>
				<th align="center"><b>Login</b></th>
				<th align="center"><b>Senha</b></th>
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
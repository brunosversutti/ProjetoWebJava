<%@page import="DTO.ProfessorDTO"%>
<%@page import="DAO.ProfessorDAO"%>
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


<title>Professores Cadastrados</title>

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

<h2>Professores Cadastrados</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
			<legend>Novo Professor</legend>
			<a href='/Academics/professor/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Novo Professor</a><br>
			</fieldset>	
	<table id="tabela" class="display" border="5" align="center">
			<legend>Listagem de Professores</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>CPF</b></th>
				<th align="center"><b>Telefone</b></th>
				<th align="center"><b>Especialidade</b></th>
				<th align="center"><b>Titulo</b></th>
				<th align="center"><b>Cidade</b></th>
				<th align="center"><b>UF</b></th>
				<th align="center"><b>Modificar</b></th>
			</tr>
		</thead>
	
	<%
	HttpSession sessao = request.getSession(true);
	//CidadeDAO cidDAO = new CidadeDAO();
	ProfessorDAO profDAO = new ProfessorDAO();
	
	ResultSet rs = profDAO.BuscarPessoaProfessor();
	
	while (rs.next()){
		
		CidadeDTO cidDTO = new CidadeDTO();
		PessoaDTO pessoaDTO = new PessoaDTO();
		ProfessorDTO profDTO = new ProfessorDTO();
		List<ProfessorDTO> professores = new ArrayList<ProfessorDTO>();
		//List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();
		//List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();
		professores = profDAO.Listar();
		
		cidDTO.setCodigo(rs.getLong("IDCIDADE"));
		cidDTO.setCidade(rs.getString("NOMECIDADE"));
		cidDTO.setUf(rs.getString("UF"));
		
		pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
		pessoaDTO.setCidade(cidDTO);
		pessoaDTO.setNome(rs.getString("NOME"));
		pessoaDTO.setNascimento(rs.getString("NASCIMENTO"));
		pessoaDTO.setTelefone(rs.getString("TELEFONE"));
		pessoaDTO.setLogin(rs.getString("LOGIN"));
		pessoaDTO.setSenha(rs.getString("SENHA"));
		pessoaDTO.setRg(rs.getString("RG"));
		pessoaDTO.setCpf(rs.getString("CPF"));
		
		profDTO.setCodigo(rs.getLong("IDPROFESSOR"));
		profDTO.setPessoa(pessoaDTO);
		profDTO.setTitulo(rs.getString("TITULO"));
		profDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
		
		professores.add(profDTO);
		
	%>			
		<tbody>
		
		<tr>
			<td align="center"><%= profDTO.getCodigo()%></td>
			<td align="center"><%= profDTO.getPessoa().getNome()%></td>
			<td align="center"><%= profDTO.getPessoa().getCpf()%></td>
			<td align="center"><%= profDTO.getPessoa().getTelefone()%></td>
			<td align="center"><%= profDTO.getEspecialidade() %></td>
			<td align="center"><%= profDTO.getTitulo() %></td>
			<td align="center"><%= profDTO.getPessoa().getCidade().getCidade() %></td>
			<td align="center"><%= profDTO.getPessoa().getCidade().getUf() %></td>
			<td align="center"><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%= cidDTO.getCodigo()%>&cidade=<%=cidDTO.getCidade()%>'>Editar<img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			
		</tr>
		
	<%
	sessao.setAttribute("cidadeDTO", cidDTO);
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
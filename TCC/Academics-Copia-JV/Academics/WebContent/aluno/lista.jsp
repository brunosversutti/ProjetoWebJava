<%@page import="DTO.CidadeDTO"%>
<%@page import="DTO.PessoaDTO"%>
<%@page import="DTO.CursoDTO"%>
<%@page import="DTO.AlunoDTO"%>
<%@page import="DAO.AlunoDAO"%>
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
          <li><a href="/Academics/aluno/cadastro.jsp">Novo Aluno</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
          
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
	
	<div class="container">

<h2>Alunos Cadastrados</h2>

	<div class="row col-md-6 col-md-offset-2">
					
			<fieldset>
			<legend>Novo Aluno</legend>
			<a href='/Academics/aluno/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Novo Aluno</a><br>
			</fieldset>	
	<table id="tabela">
			<legend>Lista de Alunos</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Codigo</b></th>
				<th align="center"><b>RA</b></th>
				<th align="center"><b>Nome</b></th>
				<th align="center"><b>CPF</b></th>
				<th align="center"><b>RG</b></th>
				<th align="center"><b>Telefone</b></th>
				<th align="center"><b>Curso</b></th>
				<th align="center"><b>Titulo</b></th>
				<th align="center"><b>Periodo</b></th>
			</tr>
		</thead>
	
		<%
	HttpSession sessao = request.getSession(true);
	
	AlunoDAO alunoDAO = new AlunoDAO();
	ResultSet rs = alunoDAO.BuscarPessoaAluno();
	
	while (rs.next()){
		
		AlunoDTO alunoDTO = new AlunoDTO();
		PessoaDTO pessoaDTO = new PessoaDTO();
		CidadeDTO cidadeDTO = new CidadeDTO();
		CursoDTO cursoDTO = new CursoDTO();
		
		List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
		List<PessoaDTO> pessoas = new ArrayList<PessoaDTO>();
		List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();
		List<CursoDTO> cursos = new ArrayList<CursoDTO>();
		
		
		//alunos = alunoDAO.Listar();
		
				alunoDTO = new AlunoDTO();
				pessoaDTO = new PessoaDTO();
				cidadeDTO = new CidadeDTO();
				cursoDTO = new CursoDTO();
				
				cidadeDTO.setCodigo(rs.getLong("IDCIDADE"));
				cidadeDTO.setCidade(rs.getString("NOMECIDADE"));
				cidadeDTO.setUf(rs.getString("UF"));
				
				pessoaDTO.setCidade(cidadeDTO);
				pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
				pessoaDTO.setNome(rs.getString("NOME"));
				pessoaDTO.setNascimento(rs.getString("NASCIMENTO"));
				pessoaDTO.setTelefone(rs.getString("TELEFONE"));
				pessoaDTO.setLogin(rs.getString("LOGIN"));
				pessoaDTO.setSenha(rs.getString("SENHA"));
				pessoaDTO.setRg(rs.getString("RG"));
				pessoaDTO.setCpf(rs.getString("CPF"));
				
				pessoaDTO.setNivel(rs.getInt("NIVELUSUARIO"));
				cursoDTO.setCodigo(rs.getLong("IDCURSO"));
				cursoDTO.setNome(rs.getString("NOMECURSO"));
				cursoDTO.setDuracao(rs.getInt("DURACAO"));
				cursoDTO.setTitulo(rs.getString("TITULO"));
				cursoDTO.setPeriodo(rs.getString("PERIODO"));
				
				alunoDTO.setCodigo(rs.getLong("IDALUNO"));
				alunoDTO.setPessoa(pessoaDTO);
				alunoDTO.setrA(rs.getInt("RA"));
				alunoDTO.setCurso(cursoDTO);
		
		
		cidades.add(cidadeDTO);
		pessoas.add(pessoaDTO);
		cursos.add(cursoDTO);
		alunos.add(alunoDTO);
		
		
	%>
	
	
	
	
			
		<tbody>
		
		<tr>
			<td><%=alunoDTO.getCodigo()%></td>
			<td><%=alunoDTO.getrA()%></td>
			<td><%=alunoDTO.getPessoa().getNome()%></td>
			<td><%=alunoDTO.getPessoa().getCpf()%></td>
			<td><%=alunoDTO.getPessoa().getRg() %></td>
			<td><%=alunoDTO.getPessoa().getTelefone() %></td>
			<td><%=alunoDTO.getCurso().getTitulo() %></td>
			<td><%=alunoDTO.getCurso().getPeriodo() %></td>
			<td><a href='../Servlets.Atualizar/AtualizaCidades?acao=Alterar&codigo=<%= cursoDTO.getCodigo()%>&nome=<%=cursoDTO.getNome()%>'>Editar<img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
			
			
		</tr>
		
	<%
	sessao.setAttribute("alunoDTO", alunoDTO);
	}
	%>	
	</tbody>
		
	<tfoot>
			
			<tr>
				<td align="center"><b>Codigo</b></td>
				<td align="center"><b>RA</b></td>
				<td align="center"><b>Nome</b></td>
				<td align="center"><b>CPF</b></td>
				<td align="center"><b>RG</b></td>
				<td align="center"><b>Telefone</b></td>
				<td align="center"><b>Curso</b></td>
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
<%@page import="DTO.AlunoDTO"%>
<%@page import="DTO.PessoaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="DTO.AlunoAtivDTO"%>
<%@page import="DAO.AlunoAtivDAO"%>
<%@ page session = "false" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">

<link href="/Academics/css/bootstrap.min.css" rel="stylesheet">
<link href="/Academics/css/main.css" rel="stylesheet">
<script src="/Academics/js/bootstrap.min.js"></script>
<script src="/Academics/js/jquery.min.js"></script>

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
			<legend>Repositorio de Arquivos</legend>
			<a href='/Academics/cidades/cadastro.jsp'class="btn btn-lg btn-primary btn-block">Nova Cidade</a><br>
			</fieldset>	
				<table border="5" align="center">
			<legend>Lista de Arquivos</legend>
	<thead>
			
			<tr>
				<th align="center"><b>Arquivo</b></th>
				<th align="center"><b>Aluno</b></th>
				<th align="center"><b>ID</b></th>
				<th align="center"><b>Link</b></th>
			</tr>
		</thead>
	
	<%
	
	AlunoAtivDAO alunoAtivDAO = new AlunoAtivDAO();
	
	ResultSet rs = alunoAtivDAO.ListaDownloads();
	
	
	while (rs.next()){
		
		AlunoAtivDTO alunoAtivDTO = new AlunoAtivDTO();
		AlunoDTO alunoDTO = new AlunoDTO();
		PessoaDTO pessoaDTO = new PessoaDTO();
		List<AlunoAtivDTO> atividades = new ArrayList<AlunoAtivDTO>();
		atividades = alunoAtivDAO.Listar();
		alunoAtivDTO.setNomeArquivo(rs.getString("NOMEARQUIVO"));
		alunoAtivDTO.setCodigo(rs.getLong("IDATIVALUNO"));
		pessoaDTO.setNome(rs.getString("NOME"));
		alunoDTO.setPessoa(pessoaDTO);
		alunoAtivDTO.setAluno(alunoDTO);
		String nomeArquivo = rs.getString("NOMEARQUIVO");
		String idDownload = String.valueOf(alunoAtivDTO.getCodigo());
		String linkDownload = "/Academics/Servlets/ServletDownload?idArquivo=" + idDownload;
	%>			
		<tbody>
		
		<tr>
			<td>Arquivo:<%= alunoAtivDTO.getNomeArquivo()%></td>
			<td>Aluno: <%=alunoAtivDTO.getAluno().getPessoa().getNome()%></td>
			<td>Objeto: <%=alunoAtivDTO.getCodigo() %></td>
			<td>Link: <a href=<%=linkDownload %>><%=alunoAtivDTO.getCodigo()%><img 
			src="/Academics/content/imagens/editar.png" border ="0"></a></td>
		</tr>
		
	<%
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
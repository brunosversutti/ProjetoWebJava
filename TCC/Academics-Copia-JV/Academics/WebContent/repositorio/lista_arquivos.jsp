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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arquivos Enviados</title>
</head>
<body>
	
	<table border="2" align="center">
	
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
			<td>Arquivo: <%= alunoAtivDTO.getNomeArquivo()%></td>
			<td>Aluno: <%=alunoAtivDTO.getAluno().getPessoa().getNome()%></td>
			<td>Objeto: <%=alunoAtivDTO.getCodigo() %></td>
			<td>Link: <a href=<%=linkDownload %>><%=alunoAtivDTO.getCodigo()%></a></td>
			
		</tr>
		
	<%
	}
	%>	
		</tbody>
	</table>
</body>
</html>
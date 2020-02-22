<%@page import="DTO.AlunoSemDTO"%>
<%@page import="BUS.AlunoSemBUS"%>
<%@page import="DTO.CursoProfSemDTO"%>
<%@page import="DTO.ItensDisciplinaDTO"%>
<%@page import="DTO.AlunoDTO"%>
<%@page import="DTO.CursoDTO"%>
<%@page import="DAO.AtividadeDAO"%>
<%@ page import="DTO.PessoaDTO"%>
<%@page import="DTO.DisciplinaDTO"%>
<%@page import="DAO.DisciplinaDAO"%>
<%@page session="true" %>
<%@ page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	PessoaDTO pessoaDTOLogin = (PessoaDTO) session
			.getAttribute("usuarioLogado");

	if (pessoaDTOLogin == null) {
		pessoaDTOLogin = new PessoaDTO();
		pessoaDTOLogin.setNome("administrador");
	}

	if (pessoaDTOLogin == null) {
%>
<jsp:forward page="/Index.jsp"></jsp:forward>
<%
	}
%>    
    

	<%
	HttpSession sessao = request.getSession(true);
	
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	AtividadeDAO atividadeDAO = new AtividadeDAO();
	//ResultSet rs = disciplinaDAO.BuscarDisciplinas();
	
	ResultSet rs = atividadeDAO.BuscarAtividadesAluno(pessoaDTOLogin);
	
	CursoDTO cursoDTO;
	DisciplinaDTO disciplinaDTO;
	ItensDisciplinaDTO itensDisciplinaDTO;
	CursoProfSemDTO cursoProfSemDTO;
	AlunoDTO alunoDTO;
	AlunoSemDTO alunoSemDTO;
	PessoaDTO pessoaDTO;
	
	List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>(); 
	List<ItensDisciplinaDTO> itensDisciplinas = new ArrayList<ItensDisciplinaDTO>();
	List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
	
	while (rs.next()){
		
		disciplinaDTO = new DisciplinaDTO();
		itensDisciplinaDTO = new ItensDisciplinaDTO();
		cursoProfSemDTO = new CursoProfSemDTO();
		cursoDTO = new CursoDTO();
		alunoDTO = new AlunoDTO();
		alunoSemDTO = new AlunoSemDTO();
		pessoaDTO = new PessoaDTO();
		
		
		
		
		
		disciplinaDTO.setCodigo(rs.getLong("IDDISCIPLINA"));
		disciplinaDTO.setNome(rs.getString("NOMEDISCIPLINA"));
		disciplinaDTO.setDuracao(rs.getInt("DURACAO"));
		disciplinas.add(disciplinaDTO);
		
		cursoDTO.setCodigo(rs.getLong("IDCURSO"));
		cursoDTO.setNome(rs.getString("NOMECURSO"));
		cursoDTO.setPeriodo(rs.getString("PERIODO"));
		cursoDTO.setTitulo(rs.getString("TITULO"));
		
		cursoProfSemDTO.setCodigo(rs.getLong("IDCURSOPROFSEM"));
		cursoProfSemDTO.setCurso(cursoDTO);
		
		
		itensDisciplinaDTO.setCodigo(rs.getLong("IDITDISCIPLINA"));
		itensDisciplinaDTO.setDisciplina(disciplinaDTO);
		itensDisciplinaDTO.setCursoprofsem(cursoProfSemDTO);
		
		alunoDTO.setCodigo(rs.getLong("IDALUNO"));
		alunoDTO.setCurso(cursoDTO);
		alunoDTO.setPessoa(pessoaDTO);
		
		alunoSemDTO.setAluno(alunoDTO);
		
		itensDisciplinas.add(itensDisciplinaDTO);
		alunos.add(alunoDTO);
	sessao.setAttribute("cidadeDTO", disciplinaDTO);
	}
	%>
    
    
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



<title>Atividades Avaliativas</title>

</head>
<body>
Bem vindo! <%=pessoaDTOLogin.getNome()%> || <%=pessoaDTOLogin.getCodigo()%>

<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><a href="/Academics/professor/menu.jsp"><img src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li><a href="/Academics/professor/menu.jsp">Home</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
          
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
	
	<div class="container">

<h2>Atividades Avaliativas</h2>

	<div class="row col-md-6 col-md-offset-2">
						
	<table id="tabela">
	
	<%
		//for(int i=0; i<alunos.size(); i++){
			int j = 0;
	
	%>
	
			<legend><%=alunos.get(j).getCurso().getNome() %> </legend>
			
	<% 
	
		//}
	%>		
			
<thead>
			
			<tr>
				<th align="center"><b>Disciplina</b></th>
				<th align="center"><b>Atividade</b></th>

			</tr>
		</thead>
	
			
		<tbody>
		
		<%
			for(int i=0; i<itensDisciplinas.size(); i++){
				
		%>		
		
		<tr>
			
			<td><%=itensDisciplinas.get(i).getDisciplina().getNome() %></td>
			
		</tr>
		
		
		
		<% 
		
			}
		
		%>		
			
		
	
		</tbody>
		
		<tfoot>
			
		<tr>
				<th align="center"><b>Disciplina</b></th>
				<th align="center"><b>Atividade</b></th>
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
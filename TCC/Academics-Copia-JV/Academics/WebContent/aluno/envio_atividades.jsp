<%@page import="DTO.AtividadeDTO"%>
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

<%@page import="DAO.CursoDAO"%>
<%@page import="DAO.DisciplinaDAO"%>
<%@page import="DTO.ProfessorDTO"%>
<%@page import="DAO.ProfessorDAO"%>
<%@page import="DTO.ProfSemDTO"%>
<%@page import="DAO.ProfSemDAO"%>
<%@page import="DTO.CursoProfSemDTO"%>
<%@page import="DAO.CursoProfSemDAO"%>
<%@page import="DTO.SemestreDTO"%>
<%@page import="DAO.SemestreDAO"%>
<%@page import="VO.ProfessorVO"%>
<%@page import="VO.SemestreVO"%>
<%@page import="VO.CursoVO"%>
<%@page import="VO.ProfSemVO"%>
<%@page import="VO.DisciplinaVO"%>
<%@page import="VO.AtividadeVO"%>
<%@page import="VO.AlunoVO"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>


<%@page session="true"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>

<%@page errorPage="/Util/PaginaDeErro.jsp"%>


<jsp:useBean id="alunoDTO" scope="request" class="DTO.AlunoDTO"></jsp:useBean>
<jsp:setProperty property="*" name="alunoDTO" />
<jsp:useBean id="atividadeDTO" scope="request" class="DTO.AtividadeDTO"></jsp:useBean>
<jsp:setProperty property="*" name="atividadeDTO" />

<jsp:useBean id="professorVO" class="VO.ProfessorVO"></jsp:useBean>
<jsp:useBean id="semestreVO" class="VO.SemestreVO"></jsp:useBean>
<jsp:useBean id="cursoVO" class="VO.CursoVO"></jsp:useBean>
<jsp:useBean id="atividadeVO" class="VO.AtividadeVO"></jsp:useBean>
<jsp:useBean id="semestreDTO" class="DTO.SemestreDTO"></jsp:useBean>
<jsp:useBean id="professorDTO" class="DTO.ProfessorDTO"></jsp:useBean>
<jsp:useBean id="cursosDTO" class="DTO.CursoDTO"></jsp:useBean>
<jsp:useBean id="profSemDTO" class="DTO.ProfSemDTO"></jsp:useBean>
<jsp:useBean id="profSemVO" class="VO.ProfSemVO"></jsp:useBean>
<jsp:useBean id="disciplinaVO" class="VO.DisciplinaVO"></jsp:useBean>
<jsp:useBean id="alunoVO" class="VO.AlunoVO"></jsp:useBean>

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
	Bem vindo!
	<%=pessoaDTOLogin.getNome()%>
	||
	<%=pessoaDTOLogin.getCodigo()%>

	<header>
	<div id="header">
		<div class="container">
			<div class="col-lg-3 logo">
				<a href="/Academics/aluno/menu.jsp"><img
					src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a>
			</div>
			<div class="col-lg-9">
				<nav id="menuprincipal">
				<ul>
					<li><a href="/Academics/aluno/menu.jsp">Home</a></li>
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


			<legend>Envio de Atividades</legend>
			
			



		
			

	<%
	
	HttpSession sessao = request.getSession(true);
	
	DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
	AtividadeDAO atividadeDAO = new AtividadeDAO();
	//ResultSet rs = disciplinaDAO.BuscarDisciplinas();
	
	ResultSet rs = atividadeDAO.BuscarAtividadesAluno(pessoaDTOLogin);
	
	CursoDTO cursoDTO;
//	AtividadeDTO atividadeDTO;
	DisciplinaDTO disciplinaDTO;
	ItensDisciplinaDTO itensDisciplinaDTO;
	CursoProfSemDTO cursoProfSemDTO;
//	AlunoDTO alunoDTO;
	AlunoSemDTO alunoSemDTO;
	PessoaDTO pessoaDTO;
	
	String teste1="";
	
	List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>(); 
	List<ItensDisciplinaDTO> itensDisciplinas = new ArrayList<ItensDisciplinaDTO>();
	List<AlunoDTO> alunos = new ArrayList<AlunoDTO>();
	List<AtividadeDTO> atividades = new ArrayList<AtividadeDTO>();
	 
	while(rs.next()){
		
		disciplinaDTO = new DisciplinaDTO();
		itensDisciplinaDTO = new ItensDisciplinaDTO();
		cursoProfSemDTO = new CursoProfSemDTO();
		cursoDTO = new CursoDTO();
		alunoDTO = new AlunoDTO();
		alunoSemDTO = new AlunoSemDTO();
		pessoaDTO = new PessoaDTO();
		atividadeDTO = new AtividadeDTO();
		
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
		
		atividadeDTO.setCodigo(rs.getLong("IDATIVIDADE"));
		atividadeDTO.setItenDisciplina(itensDisciplinaDTO);
		atividadeDTO.setNome(rs.getString("NOMEATIV"));
		
		sessao.setAttribute("codAl", alunoDTO.getCodigo());
		sessao.setAttribute("codAt", atividadeDTO.getCodigo());
		
	}
	
	%>
			<%
					ArrayList<DisciplinaDTO> disciplina = (ArrayList) disciplinaVO
							.getDisciplinas();
					ArrayList<CursoDTO> cursos = (ArrayList) cursoVO.getCursos();
					ArrayList<AtividadeDTO> listaAtividades = (ArrayList) atividadeVO
							.getAtividades();
					ArrayList<AlunoDTO> listaAlunos = (ArrayList) alunoVO.getAlunos();
					
					
				%>
				
				<form method="post" action="../Servlets/ServletUploadFile" enctype="multipart/form-data">
				
				<select name="disciplina" class="form-control">
				<%
						for (int i = 0; i < disciplina.size(); i++) {
				%>
				<option value=<%=disciplina.get(i).getCodigo()%>>
					<%=disciplina.get(i).getNome()%> -
					<%=listaAtividades.get(i).getNome()%>
				</option>
				<%
					}
				%>
			</select> <br> <br>
							
		<input name="file" class="btn btn-lg btn-primary btn-block" type="file"/>
			<br> 
			<br>
		<input type="submit" class="btn btn-lg btn-primary btn-block" value="Enviar"/>
		</form>	
		</div>
	</div>
	<footer>
	<div class="container">
		<div class="col-md-offset-4">Desenvolvido por ACADEMICS® - Todos
			os direitos reservados.</div>
	</div>
	</footer>

</body>
</html>
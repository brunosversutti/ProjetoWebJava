<%@page import="DTO.ItensDisciplinaDTO"%>
<%@page import="DTO.ProfSemDTO"%>
<%@page import="DAO.CursoProfSemDAO"%>
<%@page import="DTO.CursoProfSemDTO"%>
<%@page import="javax.xml.ws.RequestWrapper"%>
<%@ page import="DTO.PessoaDTO"%>
<%@page import="DTO.ProfessorDTO" %>
<%@page import="DAO.ProfessorDAO" %>
<%@page import="DTO.SemestreDTO" %>
<%@page import="DAO.SemestreDAO" %>
<%@page import="DTO.DisciplinaDTO" %>
<%@page import="DAO.DisciplinaDAO" %>
<%@page import="DTO.CursoDTO" %>
<%@page import="DAO.CursoDAO" %>
<%@page import="VO.ProfessorVO" %>
<%@page import="VO.SemestreVO" %>
<%@page import="VO.CursoVO" %>
<%@page import="VO.CursoProfSemVO" %>

<%@ page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
<jsp:useBean id="professorVO" class="VO.ProfessorVO"></jsp:useBean>	
<jsp:useBean id="semestreVO" class="VO.SemestreVO"></jsp:useBean>
<jsp:useBean id="cursoVO" class="VO.CursoVO"></jsp:useBean>
<jsp:useBean id="semestreDTO" class="DTO.SemestreDTO"></jsp:useBean>
<jsp:useBean id="professorDTO" class="DTO.ProfessorDTO"></jsp:useBean>
<jsp:useBean id="cursoProfSemDTO" class="DTO.CursoProfSemDTO"></jsp:useBean>
<jsp:useBean id="cursoDTO" class="DTO.CursoDTO"></jsp:useBean>
<jsp:useBean id="profSemDTO" class="DTO.ProfSemDTO"></jsp:useBean>
<jsp:useBean id="profSemVO" class="VO.ProfSemVO"></jsp:useBean>
<jsp:useBean id="disciplinaVO" class="VO.DisciplinaVO"></jsp:useBean>
<jsp:useBean id="cursoProfSemVO" class="VO.CursoProfSemVO"></jsp:useBean>
 
 
    


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
    
    CursoProfSemDAO cursoProfSemDAO = new CursoProfSemDAO();
    
    PessoaDTO pessoaDTO;
    ProfessorDTO profDTO;
    List<CursoProfSemDTO> cursosProfSemDTO = new ArrayList<CursoProfSemDTO>();
    List<DisciplinaDTO> disciplinas = new ArrayList<DisciplinaDTO>();
    List<ItensDisciplinaDTO> itensDisciplinas = new ArrayList<ItensDisciplinaDTO>();
    
    ResultSet rs = cursoProfSemDAO.BuscarPessoaCursoProfSem(pessoaDTOLogin);
    
    
    
    while(rs.next()){
    	

			List<CursoDTO> cursos = new ArrayList<CursoDTO>();
			List<SemestreDTO> semestres = new ArrayList<SemestreDTO>();
			List<ProfSemDTO> profSemestres = new ArrayList<ProfSemDTO>();
			disciplinas = new ArrayList<DisciplinaDTO>();
			itensDisciplinas = new ArrayList<ItensDisciplinaDTO>();
			pessoaDTO = new PessoaDTO();
			professorDTO = new ProfessorDTO();
			semestreDTO = new SemestreDTO();
			ProfSemDTO profSemestreDTO = new ProfSemDTO();
			cursoDTO = new CursoDTO();
			cursoProfSemDTO = new CursoProfSemDTO();
			ItensDisciplinaDTO itDisciplinaDTO = new ItensDisciplinaDTO();
			DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
			
			pessoaDTO.setCodigo(rs.getLong("IDPESSOA"));
			pessoaDTO.setNome(rs.getString("NOME"));
			
			
			professorDTO.setCodigo(rs.getLong("IDPROFESSOR"));
			professorDTO.setPessoa(pessoaDTO);
			professorDTO.setTitulo(rs.getString("TITULO"));
			professorDTO.setEspecialidade(rs.getString("ESPECIALIDADE"));
			
			semestreDTO.setCodigo(rs.getLong("IDSEMESTRE"));
			semestreDTO.setAno(rs.getInt("ANO"));
			semestreDTO.setPeriodo(rs.getString("PERIODO"));
			
			profSemestreDTO.setCodigo(rs.getLong("IDPROFSEMESTRE"));
			profSemestreDTO.setProfessor(professorDTO);
			profSemestreDTO.setSemestre(semestreDTO);
			
			cursoDTO.setCodigo(rs.getLong("IDCURSO"));
			cursoDTO.setNome(rs.getString("NOMECURSO"));
			cursoDTO.setPeriodo(rs.getString("PERIODO"));
				
			disciplinaDTO.setCodigo(rs.getLong("IDDISCIPLINA"));
			disciplinaDTO.setNome(rs.getString("NOMEDISCIPLINA"));
			
			cursoProfSemDTO.setCodigo(rs.getLong("IDCURSOPROFSEM"));
			cursoProfSemDTO.setCurso(cursoDTO);
			cursoProfSemDTO.setProfSemestre(profSemestreDTO);
			
			
			itDisciplinaDTO.setCodigo(rs.getLong("IDITDISCIPLINA"));
			itDisciplinaDTO.setDisciplina(disciplinaDTO);
			
			semestres.add(semestreDTO);
			profSemestres.add(profSemestreDTO);
			cursos.add(cursoDTO);
			disciplinas.add(disciplinaDTO);
			
			cursosProfSemDTO.add(cursoProfSemDTO);
			itensDisciplinas.add(itDisciplinaDTO);	
    }
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<title>Criar Atividade Avaliativa</title>
</head>
<body>

<%=pessoaDTOLogin.getNome()%>

<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><a href="/Academics/professor/menu.jsp"><img src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li><a href="../professor/menu.jsp">Home</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">
	
	<form class="col-md-5 col-md-offset-4" action="../Servlets/ServletAberturaAtividade" method="post">
	<h2>Criar Atividade Avaliativa</h2>
		Selecione o curso:<BR>	
		<select name="curso" class="form-control">
			
			<%
					
					for (int i = 0; i < cursosProfSemDTO.size(); i++) {
							
			%>	
					<option value= <%=cursosProfSemDTO.get(i).getCurso().getCodigo()%>> <%=cursosProfSemDTO.get(i).getCurso().getNome()%></option>
					
			<%
						
				}
			%>

		</select>
		<br>
		Nome da Atividade:
			<input type="text" class="form-control" name="nomeAtividade"> </input><br>
		Selecione o tipo de Atividade:<BR>
		
		<select name="tipo" class="form-control">
			<option value=1>Avaliacao</option>
			<option value=2>Atividade em Sala</option>
			<option value=3>Trabalho</option>
		</select>
		<br>
		
		Selecione a disciplina:<BR>
		
		<select name="disciplina" class="form-control">
			<%
					for (int j = 0; j < itensDisciplinas.size(); j++) {
						
			%>
					<option value= <%=itensDisciplinas.get(j).getCodigo()%>> <%=itensDisciplinas.get(j).getDisciplina().getNome()%></option>
					
			<%
								
				}
			%>
		</select>
		<br>
	
		<input type="submit" value="Criar Atividade" class="btn btn-primary">
	</form>
	</div>
	</div>
	<footer>
  <div class="container">
  <div class="col-md-offset-4">
  Desenvolvido por ACADEMICS ® - Todos os direitos reservados.
  </div>
  </div>
</footer>
</body>
</html>
<%@page import="javax.xml.ws.RequestWrapper"%>
<%@ page import="DTO.PessoaDTO"%>
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
<link href="/Academics/css/bootstrap.min.css" rel="stylesheet">
<link href="/Academics/css/main.css" rel="stylesheet">
<script src="/Academics/js/bootstrap.min.js"></script>
<script src="/Academics/js/jquery.min.js"></script>
<title>Menu Aluno </title>
</head>
<body>
Bem vindo! <%=pessoaDTOLogin.getNome() +" || "+ pessoaDTOLogin.getCodigo()%>
<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><a href="#"><img src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></a></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">
<h2 class="col-md-offset-4">O que gostaria de fazer?</h2>

<div class="col-lg-5 col-md-offset-4">
<a href="/Academics/aluno/consulta_notas.jsp" class="botoes botao_notas">Consultar notas</a>
<a href="/Academics/aluno/envio_atividades.jsp" class="botoes botao_atividade">Enviar atividade</a>
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
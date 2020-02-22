<%@page errorPage="/Util/PaginaDeErro.jsp" %>    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<title>Cadastrar Disciplina</title>
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
          <li><a href="/Academics/disciplinas/lista.jsp">Disciplinas</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">

<h2>Cadastrar Cidade</h2>
	
	<form class="col-md-5 col-md-offset-4" name="frmaluno" action="../Servlets/ServletDisciplina" method="post">
				<fieldset>
				<legend>Dados disciplina</legend>
				<label>Nome:</label><br>
				<input type="text" class="form-control" name="nome"> </input><br>
				<label>Carga horaria</label><br>
				<input type="text" class="form-control" name="carga"> </input><br>
			</fieldset>
			<input type="submit" name="inserirDisciplina" value="Salvar" class="btn btn-lg btn-primary btn-block">
			<input type="reset" name="limpaCampos" value="Limpar" class="btn btn-lg btn-default btn-block">
		
  <br>
</form>
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
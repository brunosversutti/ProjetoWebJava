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
<title>ACADEMICS || Cadastro de Semestres</title>
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
          <li><a href="/Academics/semestres/lista.jsp">Semestres</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">

<h2>Cadastrar Semestre</h2>
	
	<form class="col-md-5 col-md-offset-4" name="frmsemestre" action="../Servlets/ServletSemestre" method="post">
			<fieldset>
				<label>Ano:</label><br>
				<input type="text" class="form-control" name="ano"> </input><br>
				<label>Período:</label><br>
				<select name="periodo" class="form-control">
					<option value="1º Semestre">1º Semestre</option>
					<option value="2º Semestre">2º Semestre</option>
				</select>
				<label><input type="checkbox" id="cbStatus" name="situacao" value="true" class="form-control">Ativo</label>
			</fieldset>
			<input type="submit" name="inserirAluno" value="Salvar" class="btn btn-lg btn-primary btn-block" onclick="VerificaCPF();">
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
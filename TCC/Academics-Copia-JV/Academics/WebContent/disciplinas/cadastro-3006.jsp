<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Cadastrar Disciplina</title>
<!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet">

	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">
	     <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	    <script src="../js/ie-emulation-modes-warning.js"></script>

	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    <script src="../js/jquery-latest.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/cssform.css">
</head>
<body>
<header id="header">
	<div class="container">
		<div class="col-md-4"><a href=""><img src="http://moodle.ifal.edu.br/theme/essential/pix/logo-moodle.png"/></a></div>
		<nav class="col-md-4 col-md-offset-4" id="menu_principal">
			<ul>
				<li><a href="#">Início</a></li>
				<li><a href="#">Cadastrar</a></li>
				<li><a href="#">Consultar</a></li>
				<li><a href="#">Sair</a></li>
			</ul>
		</nav>
	</div>
	</header>
	<div class="container">
	<div class="row col-md-4" id="sidebar">
			<h4 class="titulo_sidebar">Título</h1>
			<p class="text-justify">
			  Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo.
			  Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. 
			</p>
			<h4 class="titulo_sidebar">Menu Principal</h1>
			<p class="text-justify">
			  <div class="menu_sidebar">
				  <ul>
					<li><a href="#">Início</a></li>
					<li><a href="#">Cadastrar</a></li>
					<li><a href="#">Consultar</a></li>
					<li><a href="#">Sair</a></li>
				</ul>
			  </div>
			</p>
			<h4 class="titulo_sidebar">Título</h1>
			<p class="text-justify">
			  Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo.
			  Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. Texto conteúdo. 
			</p>
	</div>
	<div class="row col-md-6 col-md-offset-2">
		<form class="formulario" name="frmdisciplina" action="../Servlets/ServletDisciplina" method="post">
			<fieldset>
				<legend>Dados disciplina</legend>
				<label>Nome:</label><br>
				<input type="text" class="form-control" name="nome"> </input><br>
				<label>Carga horaria</label><br>
				<input type="text" class="form-control" name="carga"> </input><br>
			</fieldset>
			<input type="submit" name="inserirDisciplina" value="Salvar" class="btn btn-lg btn-primary btn-block">
			<input type="reset" name="limpaCampos" value="Limpar" class="btn btn-lg btn-default btn-block">
		</form>
	</div>
	</div>
</body>
</html>
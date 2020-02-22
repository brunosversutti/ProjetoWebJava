<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Cadastrar Cidades</title>
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
				<li><a href="#">In�cio</a></li>
				<li><a href="#">Cadastrar</a></li>
				<li><a href="#">Consultar</a></li>
				<li><a href="#">Sair</a></li>
			</ul>
		</nav>
	</div>
	</header>
	<div class="container">
	<div class="row col-md-4" id="sidebar">
			<h4 class="titulo_sidebar">T�tulo</h1>
			<p class="text-justify">
			  Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do.
			  Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. 
			</p>
			<h4 class="titulo_sidebar">Menu Principal</h1>
			<p class="text-justify">
			  <div class="menu_sidebar">
				  <ul>
					<li><a href="#">In�cio</a></li>
					<li><a href="#">Cadastrar</a></li>
					<li><a href="#">Consultar</a></li>
					<li><a href="#">Sair</a></li>
				</ul>
			  </div>
			</p>
			<h4 class="titulo_sidebar">T�tulo</h1>
			<p class="text-justify">
			  Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do.
			  Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. Texto conte�do. 
			</p>
	</div>
	<div class="row col-md-6 col-md-offset-2">
		<form class="formulario" name="frmaluno" action="../Servlets/ServletCidade" method="post" onsubmit="VerificaCPF();">
			
			<fieldset>
				<label>Cidade:</label><br>
				<input type="text" class="form-control" name="cidade"> </input><br>
				<label>Estado</label>
				<select class="form-control" name="uf">
					<option value="AC">Acre</option>
					<option value="AL">Alagoas</option>
					<option value="AP">Amap�</option>
					<option value="AM">Amazonas</option>
					<option value="BA">Bahia</option>
					<option value="CE">Cear�</option>
					<option value="DF">Distrito Federal</option>
					<option value="ES">Esp�rito Santo</option>
					<option value="GO">Goi�s</option>
					<option value="MA">Maranh�o</option>
					<option value="MT">Mato Grosso</option>
					<option value="MS">Mato Grosso do Sul</option>
					<option value="MG">Minas Gerais</option>
					<option value="PA">Par�</option>
					<option value="PB">Para�ba</option>
					<option value="PR">Paran�</option>
					<option value="PE">Pernambuco</option>
					<option value="PI">Piau�</option>
					<option value="RJ">Rio de Janeiro</option>
					<option value="RN">Rio Grande do Norte</option>
					<option value="RS">Rio Grande do Sul</option>
					<option value="RO">Rond�nia</option>
					<option value="RR">Roraima</option>
					<option value="SC">Santa Catarina</option>
					<option value="SP" selected>S�o Paulo</option>
					<option value="SE">Sergipe</option>
					<option value="TO">Tocantins</option>
				</select>
				<BR>	
			</fieldset> 
			<BR>
			<input type="submit" name="inserirAluno" value="Salvar" class="btn btn-lg btn-primary btn-block" onclick="VerificaCPF();">
			<input type="reset" name="limpaCampos" value="Limpar" class="btn btn-lg btn-default btn-block">
		</form>
	</div>
	</div>
</body>
</html>
<%@ page import="DTO.PessoaDTO"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Login no Sistema</title>
<link rel="icon" href="../content/imgs/book.png" type="image/x-icon" />
<link rel="shortcut icon" href="../content/imgs/book.png" type="image/x-icon" />

<!-- Bootstrap core CSS -->
	    <link href="../css/bootstrap.min.css" rel="stylesheet">

	    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	    <link href="../css/ie10-viewport-bug-workaround.css" rel="stylesheet">
	     <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	    <script src="js/ie-emulation-modes-warning.js"></script>

	    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	    <!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	    <![endif]-->
	    <script src="../js/jquery-latest.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../css/cssform.css">
</head>
<body>

<script type="text/javascript">
	function Validate(){
		var usuario=document.formLogin.usuario;
		var senha=document.formLogin.senha;
		
		if ((usuario.value==null)||(usuario.value=="")){
			alert("Informe o nome do usuário");
			usuario.focus();
			return false;
		}
		
		if ((senha.value==null)||(senha.value=="")){
			alert("Informe a senha do usuário");
			senha.focus();
			return false;
		}
		
		return true
	}
</script>


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
	<div class="col-md-6 col-md-offset-3">
	<form class="formulario" name="formLogin" action="../ServletLogin" method="post" onsubmit="return Validate()">
	<%
	Boolean isLoginOk = (Boolean)session.getAttribute("loginOk");
	if(isLoginOk != null && !isLoginOk)
	{%>
		<h1>Dados para autenticação inválidos</h1>
	<%
		session.setAttribute("loginOk", true);
	}
%>	
		<fieldset><legend>Login</legend>
			<label>Usuário:</label><br>
			<input type="text" class="form-control" name="usuario">
			<label>Senha:</label><br>
			<input type="password" class="form-control" name="senha"><br>
			<input type="submit" class="btn btn-lg btn-primary btn-block" value="Entrar">
		</fieldset>
	</form>
	</div>
	</div>
	</body>
	</html>
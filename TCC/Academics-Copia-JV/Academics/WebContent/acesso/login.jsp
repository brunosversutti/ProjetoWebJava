<%@page errorPage="/Util/PaginaDeErro.jsp" %>
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
<link href="/Academics/css/bootstrap.min.css" rel="stylesheet">
<link href="/Academics/css/main.css" rel="stylesheet">
<script src="/Academics/js/bootstrap.min.js"></script>
<script src="/Academics/js/jquery.min.js"></script>
<title>ACADEMICS || Cadastro de Cidades</title>

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


	<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><img src="/Academics/content/imagens/LOGO.png" alt="ACADEMICS"></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li>Sistema de Controle Educacional</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">
	<div class="container">
	<div class="col-md-6 col-md-offset-3">
	<form class="col-md-5 col-md-offset-4" name="formLogin" action="../ServletLogin" method="post" onsubmit="return Validate()">
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
	</div>
	</body>
	</html>
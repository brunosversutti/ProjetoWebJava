<%@page import="DTO.CidadeDTO"%>
<%@page import="DAO.CidadeDAO"%>
<%@ page session = "false" %>
<%@ page import = "java.util.List" %>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<jsp:useBean id="cidadeVO" class="VO.CidadeVO"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de Professor</title>
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
		<script language="javascript">
		function VerificaCPF () {
		if (vercpf(document.frmprof.cpfProfessor.value)) 
		{document.frmprof.submit();}else 
		{errors="1";if (errors) alert('CPF N�O V�LIDO');
		document.retorno = (errors == '');}}
		function vercpf (cpfProfessor) 
		{if (cpfProfessor.length != 11 || cpfProfessor == "00000000000" || cpfProfessor == "11111111111" || cpfProfessor == "22222222222" || cpfProfessor == "33333333333" || cpfProfessor == "44444444444" || cpfProfessor == "55555555555" || cpfProfessor == "66666666666" || cpfProfessor == "77777777777" || cpfProfessor == "88888888888" || cpfProfessor == "99999999999")
		return false;
		add = 0;
		for (i=0; i < 9; i ++)
		add += parseInt(cpfProfessor.charAt(i)) * (10 - i);
		rev = 11 - (add % 11);
		if (rev == 10 || rev == 11)
		rev = 0;
		if (rev != parseInt(cpfProfessor.charAt(9)))
		return false;
		add = 0;
		for (i = 0; i < 10; i ++)
		add += parseInt(cpfProfessor.charAt(i)) * (11 - i);
		rev = 11 - (add % 11);
		if (rev == 10 || rev == 11)
		rev = 0;
		if (rev != parseInt(cpfProfessor.charAt(10)))
		return false;
		alert('CPF inv�lido!');return true;}
		</script>
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
	
	<%
		ArrayList<CidadeDTO> cidades = (ArrayList) cidadeVO.getCidades();

			if(request.getAttribute("cidadeSelecionada") == null)
				request.setAttribute("cidadeSelecionada","0");
				String cidadeSelecionada = (String)request.getAttribute("cidadeSelecionada");
	%>
	
	
	
	
	<div class="row col-md-6 col-md-offset-2">
		<form class="formulario" name="frmprof" action="../Servlets/ServletProfessor" method="post" onsubmit="VerificaCPF();">
			<fieldset>
				<legend>Dados pessoais</legend>
				<label>Nome:</label><br>
				<input type="text" class="form-control" name="nome"> </input><br>
				<label>Data de Nascimento:</label><br>
				<input type="date" class="form-control" name="nascimento"> </input><br>
				<label>RG:</label><br>
				<input type="text" class="form-control" name="rg"> </input><br>
				<label>CPF:</label><br>
				<input type="text" size="12" class="form-control" name="cpf"> </input><br>
				<label>Telefone:</label><br>
				<input type="text" class="form-control" name="telefone"> </input><br>
			</fieldset>

			<fieldset>
				<legend>Endere�o</legend>
				<label>Logradouro:</label><br>
				<input type="text" class="form-control" name="logradouro"> </input><br>
				<label>N�mero:</label><br>
				<input type="text" class="form-control" name="numero"> </input><br>
				<label>Bairro:</label><br>
				<input type="text" class="form-control" name="bairro"> </input><br>
				<label>Cidade:</label><br>
				<select class="form-control" name="cidade">
					<%
						for (int i = 0; i < cidades.size(); i++) {
					%>
						<option value= <%=cidades.get(i).getCidade()%> ><%=cidades.get(i).getCidade()%> -<%=cidades.get(i).getUf()%></option>
					<%
						}
					%>
				</select><br>
				<label>CEP:</label><br>
				<input type="text" class="form-control" name="cep"> </input><br>
			</fieldset> 
			</br>
			<fieldset>
				<legend>Dados administrativos</legend>
				<label>T�tulo:</label><br>
				<select class="form-control" id="titulos" name="titulo">
					<option value="bacharel">Bacharel</option>
					<option value="pos">P�s graduado</option>
					<option value="mestre">Mestre</option>
					<option value="doutor">Doutor</option>
				</select>
				<label>Especialidade:</label><br>
				<input type="text" class="form-control" name="especialidade"> </input><br>
				<label>Login:</label><br>
				<input type="text" class="form-control" name="login"> </input><br>
				<label>Senha:</label><br>
				<input type="password" class="form-control" name="senha"> </input><br>
			</fieldset>
			</br>
			<input type="submit" name="inserirProfessor" value="Salvar" class="btn btn-lg btn-primary btn-block" onclick="VerificaCPF();">
			<input type="reset" name="limpaCampos" value="Limpar" class="btn btn-lg btn-default btn-block">
		</form>
	</div>
	</div>
</body>
</html>
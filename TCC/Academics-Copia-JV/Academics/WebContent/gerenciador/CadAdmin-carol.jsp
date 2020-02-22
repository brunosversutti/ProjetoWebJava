<%@page import="DTO.CidadeDTO"%>
<%@page import="DAO.CidadeDAO"%>
<%@ page session="false"%>
<%@ page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:useBean id="cidadeVO" class="VO.CidadeVO"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Cadastrar Administrador</title>

<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>ACADEMICS || Cadastro de Administrador</title>
</head>
<body>
	<header>
	<div id="header">
		<div class="container">
			<div class="col-lg-3 logo">
				<a href="#"><img src="img/logo.png" alt="ACADEMICS"></a>
			</div>
			<div class="col-lg-9">
				<nav id="menuprincipal">
				<ul>
					<li><a href="#">Home</a></li>
					<li><a href="#">Sair</a></li>
				</ul>
				</nav>
			</div>
			<%
		ArrayList<CidadeDTO> cidades = (ArrayList) cidadeVO.getCidades();

		if (request.getAttribute("cidadeSelecionada") == null)
			request.setAttribute("cidadeSelecionada", "0");
		String cidadeSelecionada = (String) request
				.getAttribute("cidadeSelecionada");
	%>
		</div>
	</div>
	<script language="javascript">
		function VerificaCPF() {
			if (vercpf(document.frmaluno.cpf.value)) {
				document.frmaluno.submit();
			} else {
				errors = "1";
				if (errors)
					alert('CPF NÃO VÁLIDO');
				document.retorno = (errors == '');
			}
		}
		function vercpf(cpf) {
			if (cpf.length != 11 || cpf == "00000000000"
					|| cpf == "11111111111" || cpf == "22222222222"
					|| cpf == "33333333333" || cpf == "44444444444"
					|| cpf == "55555555555" || cpf == "66666666666"
					|| cpf == "77777777777" || cpf == "88888888888"
					|| cpf == "99999999999")
				return false;
			add = 0;
			for (i = 0; i < 9; i++)
				add += parseInt(cpf.charAt(i)) * (10 - i);
			rev = 11 - (add % 11);
			if (rev == 10 || rev == 11)
				rev = 0;
			if (rev != parseInt(cpf.charAt(9)))
				return false;
			add = 0;
			for (i = 0; i < 10; i++)
				add += parseInt(cpf.charAt(i)) * (11 - i);
			rev = 11 - (add % 11);
			if (rev == 10 || rev == 11)
				rev = 0;
			if (rev != parseInt(cpf.charAt(10)))
				return false;
			alert('CPF inválido!');
			return true;
		}
	</script>
	<link rel="stylesheet" type="text/css" href="../css/cssform.css">
	</head>
	<div class="container">
		<form class="col-md-5 col-md-offset-4">
			<h2>Cadastrar Administrador</h2>
			Nome:<BR> <input type="text" name="txtNomeCadAdm"
				class="form-control"> CPF:<BR> <input type="text"
				name="txtCpfCadAdm" class="form-control"> RG:<BR> <input
				type="text" name="txtRgCadAdm" class="form-control"> Data de
			Nascimento:<BR> <input type="text" name="txtNascimentoCadAdm"
				class="form-control"> Telefone:<BR> <input type="text"
				name="txtTelCadAdm" class="form-control"> Login:<BR> <input
				type="text" name="txtLoginCadAdm" class="form-control">
			Senha:<BR> <input type="password" name="pswCadAdm"
				class="form-control"> Cargo:<BR> <input type="text"
				name="txtCargoCadAdm" class="form-control"> Função:<BR>
			<input type="text" name="txtFuncaoCadAdm" class="form-control">
			Logradouro:<BR> <input type="text" name="txtLogCadAdm"
				class="form-control"> Bairro:<BR> <input type="text"
				name="txtBairroCadAdm" class="form-control"> Número:<BR>
			<input type="text" name="txtNumeroCadAdm" class="form-control">
			CEP:<br> <input type="text" name="txtCepCadAdm"
				class="form-control"> Cidade:<BR> 
				<select name="cidadeCadAdm" class="form-control">
				<%
					for (int i = 0; i < cidades.size(); i++) {
				%>
				<option value=<%=cidades.get(i).getCidade()%>><%=cidades.get(i).getCidade()%> 
				-<%=cidades.get(i).getUf()%></option>
				<%
					}
				%>
			</select><BR> <input type="submit" value="Cadastrar"
				class="btn btn-primary">
	</div>
	

	</div>
	</form>
	<footer>
	<div class="container">
		<div class="col-md-offset-4">Desenvolvido por ACADEMICS® - Todos
			os direitos reservados.</div>
	</div>
	</footer>
</body>
</html>
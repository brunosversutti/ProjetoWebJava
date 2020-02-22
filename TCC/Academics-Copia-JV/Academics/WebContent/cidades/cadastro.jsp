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
<title>ACADEMICS || Cadastro de Cidades</title>
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
          <li><a href="/Academics/cidades/lista.jsp">Cidades</a></li>
          <li><a href="/Academics/Login/logoff.jsp">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">

<h2>Cadastrar Cidade</h2>
	
	<form class="col-md-5 col-md-offset-4" name="frmaluno" action="../Servlets/ServletCidade" method="post" onsubmit="VerificaCPF();">
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
  <br>
  <input type="submit" name="inserirAluno" value="Salvar" class="btn btn-lg btn-primary btn-block" onclick="VerificaCPF();">
</form>
</div>
<footer>
  <div class="container">
  <div class="col-md-offset-4">
  Desenvolvido por ACADEMICS� - Todos os direitos reservados.
  </div>
  </div>
</footer>
</body>
</html>
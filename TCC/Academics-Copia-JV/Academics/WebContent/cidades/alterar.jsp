<%@page import="DTO.CidadeDTO"%>
<jsp:useBean id="cidadeDTO" scope="request" class="DTO.CidadeDTO"></jsp:useBean>
<jsp:setProperty property="*" name="cidadeDTO" />    
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>    
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
          <li><a href="#">Sair</a></li>
        </ul>
      </nav>
    </div>
  </div>
  </div>
</header>
<div class="container">

<h2>Cadastrar Cidade</h2>
	
	<form class="col-md-5 col-md-offset-4" name="frmaluno" action="../Servlets.Atualizar/AtualizaCidades" method="post" onsubmit="VerificaCPF();">
				<input type="hidden" name="acao" value="Alterar">
				<input type="hidden" name="codigo" readonly="readonly" value='<jsp:getProperty property="codigo" name="cidadeDTO"/>'>
				<label>Cidade:</label><br>
				<input type="text" class="form-control" name="cidade" value= '<jsp:getProperty property="cidade" name="cidadeDTO"/>'><br>
				<label>Estado</label>
				
			<select class="form-control" name="uf">
			<option value ="AC" <%= (cidadeDTO.getUf().equals("AC") ? "selected" : "") %> >Acre</option>
			<option value ="AL" <%= (cidadeDTO.getUf().equals("AL") ? "selected" : "") %> >Alagoas</option>
			<option value ="AP" <%= (cidadeDTO.getUf().equals("AP") ? "selected" : "") %> >Amapá</option>
			<option value ="AM" <%= (cidadeDTO.getUf().equals("AM") ? "selected" : "") %> >Amazonas</option>
			<option value ="BA" <%= (cidadeDTO.getUf().equals("BA") ? "selected" : "") %> >Bahia</option>
			<option value ="CE" <%= (cidadeDTO.getUf().equals("CE") ? "selected" : "") %> >Ceará</option>
			<option value ="DF" <%= (cidadeDTO.getUf().equals("DF") ? "selected" : "") %> >Distrito Federal</option>
			<option value ="ES" <%= (cidadeDTO.getUf().equals("ES") ? "selected" : "") %> >Espírito Santo</option>
			<option value ="GO" <%= (cidadeDTO.getUf().equals("GO") ? "selected" : "") %> >Goiás</option>
			<option value ="MA" <%= (cidadeDTO.getUf().equals("MA") ? "selected" : "") %> >Maranhao</option>
			<option value ="MT" <%= (cidadeDTO.getUf().equals("MT") ? "selected" : "") %> >Mato Grosso</option>
			<option value ="MS" <%= (cidadeDTO.getUf().equals("MS") ? "selected" : "") %> >Mato Grosso do Sul</option>
			<option value ="MG" <%= (cidadeDTO.getUf().equals("MG") ? "selected" : "") %> >Minas Gerais</option>
			<option value ="PA" <%= (cidadeDTO.getUf().equals("PA") ? "selected" : "") %> >Pará</option>
			<option value ="PB" <%= (cidadeDTO.getUf().equals("PB") ? "selected" : "") %> >Paraiba</option>
			<option value ="PR" <%= (cidadeDTO.getUf().equals("PR") ? "selected" : "") %> >Parana</option>
			<option value ="PE" <%= (cidadeDTO.getUf().equals("PE") ? "selected" : "") %> >Pernambuco</option>
			<option value ="PI" <%= (cidadeDTO.getUf().equals("PI") ? "selected" : "") %> >Piaui</option>
			<option value ="RJ" <%= (cidadeDTO.getUf().equals("RJ") ? "selected" : "") %> >Rio de Janeiro</option>
			<option value ="RN" <%= (cidadeDTO.getUf().equals("RN") ? "selected" : "") %> >Rio Grande do Norte</option>
			<option value ="RS" <%= (cidadeDTO.getUf().equals("RS") ? "selected" : "") %> >Rio Grande do Sul</option>
			<option value ="RO" <%= (cidadeDTO.getUf().equals("RO") ? "selected" : "") %> >Rondonia</option>
			<option value ="RR" <%= (cidadeDTO.getUf().equals("RR") ? "selected" : "") %> >Roraima</option>
			<option value ="SC" <%= (cidadeDTO.getUf().equals("SC") ? "selected" : "") %> >Santa Catarina</option>
			<option value ="SP" <%= (cidadeDTO.getUf().equals("SP") ? "selected" : "") %> >São Paulo</option>
			<option value ="SE" <%= (cidadeDTO.getUf().equals("SE") ? "selected" : "") %> >Sergipe</option>
			<option value ="TO" <%= (cidadeDTO.getUf().equals("TO") ? "selected" : "") %> >Tocantins</option>
		</select>
<br>
		
		
  <br>
  <input type="submit" name="inserirAluno" value="Alterar" class="btn btn-lg btn-primary btn-block" onclick='window.location="/Academics/cidades/lista.jsp"'>
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
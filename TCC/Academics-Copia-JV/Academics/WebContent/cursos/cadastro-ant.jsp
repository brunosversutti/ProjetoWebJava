<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/main.css" rel="stylesheet">
<script src="../js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<title>ACADEMICS || Cadastro de Curso</title>

 <link href="../css/bootstrap.min.css" rel="stylesheet">
		<link href="../css/main.css" rel="stylesheet">
		<script src="../js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	    
</head>
<body>
<header>
  <div id="header">
  <div class="container">
    <div class="col-lg-3 logo"><a href="#"><img src="img/logo.png" alt="ACADEMICS"></a></div>
    <div class="col-lg-9">
      <nav id="menuprincipal">
        <ul>
          <li><a href="#">Home</a></li>
          <li><a href="#">Sair</a></li>
        </ul>
      </nav>
    </div>
    <link rel="stylesheet" type="text/css" href="../css/cssform.css">
  </div>
  </div>
</header>
<div class="container">
<form class="col-md-5 col-md-offset-4">

<h2>Cadastrar Curso</h2>
Nome:<br> 
<input type="text" name="nomeCurso" class="form-control"><br>
Duração (semestres):<BR>
<input type="number" name="duracao" step="1" min="1" max="10" class="form-control"><br>
Titulo:<br> 
<select name="titulo" class="form-control">     
    <option value="bacharel">Bacharel</option> 
    <option value="noturno">Tecnólogo</option>  
    </select><br>
Período:<BR>
<select name="periodo" class="form-control">    
    <option value="diurno">Diurno</option> 
    <option value="noturno">Noturno</option>  
    <option value="integral">Integral</option>
    </select> <br> <br>
    <input type="submit" value="Cadastrar" class="btn btn-primary">
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
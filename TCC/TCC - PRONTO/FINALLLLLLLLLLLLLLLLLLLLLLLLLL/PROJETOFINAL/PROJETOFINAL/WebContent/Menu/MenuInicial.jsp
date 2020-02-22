<%-- <%@page import="javax.xml.ws.RequestWrapper"%>  --%>
<%@page import="Dto.UsuarioDTO"%>

<%@page import="java.util.List"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>

<%
	session.removeAttribute("itensVenda");

	UsuarioDTO usuarioDTOLogin = (UsuarioDTO) session
			.getAttribute("usuarioLogado");

	if (usuarioDTOLogin == null) {
		usuarioDTOLogin = new UsuarioDTO();
		usuarioDTOLogin.setNome("administrador");
	}

	if (usuarioDTOLogin == null) {
%>
<jsp:forward page="index.jsp"></jsp:forward>
<%
	}
%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title></title>


  <link href="bibliotecas/bootstrap/css/bootstrap.min.css" rel="stylesheet">


  <link href="css/simple-sidebar.css" rel="stylesheet">
  <link href="css/relatorio.css" rel="stylesheet">

</head>

<body>


  <div class="d-flex" id="wrapper">
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading" class="logo1"><h3>Property ADM</h3></div>
      <div class="list-group list-group-flush">
        <a href="Imovel/IndexImovel.jsp" class="list-group-item list-group-item-action bg-light">Imóveis</a>
        <a href="Relatorio/Relatorio.jsp" class="list-group-item list-group-item-action bg-light">Relatório de Mudanças</a>
       
        <a href="#" class="list-group-item list-group-item-action bg-light">Sair</a>
        
      </div>
    </div>
   

    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
      
      

        <button class="btn btn-primary" id="menu-toggle">Esconder Menu</button>
           Seja bem vindo<%=usuarioDTOLogin.getNome()%>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
          
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Dropdown
              </a>
              <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                
                <a class="dropdown-item" href="PROJETOFINAL/ListarImovel">Imóveis</a>
                <a class="dropdown-item" href="Relatorio/Relatorio.jsp">Relatório de Mudanças</a>
                
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="/Logoff.jsp">Sair</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      <div class="col-md-12">
        
    </div>
    
      </div>
    </div>
 
  <script src="bibliotecas/jquery/jquery.min.js"></script>
  <script src="bibliotecas/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>

</html>

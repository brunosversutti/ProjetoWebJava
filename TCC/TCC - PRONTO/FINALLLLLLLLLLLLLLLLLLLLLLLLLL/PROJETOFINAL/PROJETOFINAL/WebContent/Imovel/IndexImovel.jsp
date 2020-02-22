<%@page import="Dto.ImovelDTO"%>

<%@page import="java.util.List"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title></title>


  <link href="../bibliotecas/bootstrap/css/bootstrap.min.css" rel="stylesheet">


  <link href="../css/simple-sidebar.css" rel="stylesheet">
  <link href="../css/relatorio.css" rel="stylesheet">

</head>

<body>

  <%
    List<ImovelDTO> imoveis = (List<ImovelDTO>)session.getAttribute("listaImovel");
  %>

  <div class="d-flex" id="wrapper">
    <div class="bg-light border-right" id="sidebar-wrapper">
      <div class="sidebar-heading" class="logo1"><h3>Property ADM</h3></div>
      <div class="list-group list-group-flush">
        <a href="#" class="list-group-item list-group-item-action bg-light">Imóveis</a>
        <a href="../Relatorio/Relatorio.jsp" class="list-group-item list-group-item-action bg-light">Relatório de Mudanças</a>
       
        <a href="#" class="list-group-item list-group-item-action bg-light">Sair</a>
        
      </div>
    </div>
   

    <div id="page-content-wrapper">

      <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">

        <button class="btn btn-primary" id="menu-toggle">Esconder Menu</button>
            
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
                
                <a class="dropdown-item" href="#">Imóveis</a>
                <a class="dropdown-item" href="Relatorio/Relatorio.jsp">Relatório de Mudanças</a>
                
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#">Sair</a>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      
      <h1>Imóveis</h1>

       <% if (imoveis.size() > 0) {  %> 

      <div class="col-md-12">
         <table class="table table-hover">
      <thead>
        <tr>
          <th scope="col" id="COL01">Código</th>
          <th scope="col" id="COL02">Endereço</th>
          <th scope="col" id="COL03">CEP</th>
          <th scope="col" id="COL04">Preço</th>
          <th scope="col" id="COL05">Metragem</th>
          <th scope="col" id="COL06">Quadra</th>
          <th scope="col" id="COL07">Lote</th>
          <th scope="col" id="COL08">Situação</th>
          <th scope="col" id="COL09"></th>
          <th scope="col" id="COL10"></th>
        </tr>
      </thead>
      <tbody>
        <% 
        for (ImovelDTO imovelDTO : imoveis) { 
        %> 
        <tr>
          <td id="COL01"><%=imovelDTO.getIdimovel()%></td>
          <td id="COL02"><%=imovelDTO.getEndereco()%></td>
          <td id="COL03"><%=imovelDTO.getCep()%></td>
          <td id="COL04"><%=imovelDTO.getPreco()%></td>
          <td id="COL05"><%=imovelDTO.getMetragem()%></td>
          <td id="COL06"><%=imovelDTO.getQuadra()%></td>
          <td id="COL07"><%=imovelDTO.getLote()%></td>
          <td id="COL08"><%=imovelDTO.getSituacao()%></td>
          <td id="COL09"><a
			href='/PROJETOFINAL/BuscarImovel?acao=Alterar&idimovel=<%=imovelDTO.getIdimovel()%>&endereco=<%=imovelDTO.getEndereco()%>
			&cep=<%=imovelDTO.getCep()%>&preco=<%=imovelDTO.getPreco()%>&metragem=<%=imovelDTO.getMetragem()%>
			&quadra=<%=imovelDTO.getQuadra()%>&lote=<%=imovelDTO.getLote()%>&situacao=<%=imovelDTO.getSituacao()%>'><img
			src="/PROJETOFINAL/img/lapis.png" border="0"></a></td>
			<td id="COL10"> <a
			href='/PROJETOFINAL/BuscarImovel?acao=Excluir&idimovel=<%=imovelDTO.getIdimovel()%>&endereco=<%=imovelDTO.getEndereco()%>
			&cep=<%=imovelDTO.getCep()%>&preco=<%=imovelDTO.getPreco()%>&metragem=<%=imovelDTO.getMetragem()%>
			&quadra=<%=imovelDTO.getQuadra()%>&lote=<%=imovelDTO.getLote()%>&situacao=<%=imovelDTO.getSituacao()%>'><img
			src="/PROJETOFINAL/img/x.png" border="0"></a></td>
          
        </tr>
        <%
         }
        %>
      </tbody>
    </table> 
    </div>
    <%
      } else {
     %>
       <p class="1">Nenhuma dado cadastrado</p> <%
      }
     %>
    <input id="index" class="btn btn-primary" type='button' value='Inserir Imóvel'
     onclick='window.location="/PROJETOFINAL/Imovel/Inserir.jsp"'></td>
      </div>
    </div>
  </div>
  <script src="../bibliotecas/jquery/jquery.min.js"></script>
  <script src="../bibliotecas/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script>
    $("#menu-toggle").click(function(e) {
      e.preventDefault();
      $("#wrapper").toggleClass("toggled");
    });
  </script>

</body>

</html>

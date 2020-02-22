<%@page import="Dto.ImovelDTO"%>
<jsp:useBean id="imovelDTO" class="Dto.ImovelDTO"></jsp:useBean>
<jsp:setProperty property="*" name="imovelDTO" />
<%@page import="java.util.List"%>
<%@page errorPage="/Util/PaginaDeErro.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Simple Sidebar - Start Bootstrap Template</title>

  <link href="bibliotecas/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="css/simple-sidebar.css" rel="stylesheet">
  <link href="css/imovel.css" rel="stylesheet">
</head>
<body>

  <div class="d-flex" id="wrapper">
    <div  class="bg-light border-right" id="sidebar-wrapper" class="menu">
      <div class="sidebar-heading" class="logo1"><h3>Property ADM</h3></div>
      <div class="list-group list-group-flush">
        
        <a href="../Imovel/imovel.html" class="list-group-item list-group-item-action bg-light">Imóveis</a>
        <a href="Relatorio/Relatorio.jsp" class="list-group-item list-group-item-action bg-light">Relatório de Mudanças</a>
        
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
        <div class="container-fluid">
  <div class="row">
    <h1>Excluir Imóvel</h1>
    <div class="col-md-12">
        <form role="form" action="/PROJETOFINAL/AtualizarImovel" method="post">
        <input type="hidden" name="acao" value="Exclusao">
        <div class="form-group">
          <label for="exampleInputCODIGO">
            Código
          </label>
          <input type="number"  value='<jsp:getProperty property="idimovel" name="imovelDTO"/>' name="idimovel" class="form-control" id="exampleInputCODIGO" readonly="readonly"/>
        </div>
        <div class="form-group">
           
          <label for="exampleInputEndereco">
            Endereço
          </label>
          <input type="text" value='<jsp:getProperty property="endereco" name="imovelDTO"/>' name="endereco" class="form-control" id="exampleInputEndereco" readonly="readonly" />
        </div>
        <div class="form-group">
           
          <label for="exampleInputCEP">
            CEP
          </label>
          <input type="number" value='<jsp:getProperty property="cep" name="imovelDTO"/>' name="cep" class="form-control" id="exampleInputCEP" readonly="readonly" />
        </div>
        <div class="form-group">
           
          <label for="exampleInputPreco">
            Preço
          </label>
          <input type="number" value='<jsp:getProperty property="preco" name="imovelDTO"/>' name="preco" class="form-control" id="exampleInputPreco" readonly="readonly" />
        </div>
        <div class="form-group">
           
          <label for="exampleInputMetragem">
            Metragem
          </label>
          <input type="number" value='<jsp:getProperty property="metragem" name="imovelDTO"/>' name="metragem" class="form-control" id="exampleInputMetragem" readonly="readonly" />
        </div>
        <div class="form-group">
           
          <label for="exampleInputQuadra">
            Quadra
          </label>
          <input type="text" value='<jsp:getProperty property="quadra" name="imovelDTO"/>' name="quadra" class="form-control" id="exampleInputQuadra" readonly="readonly"/>
        </div>
        <div class="form-group">
           
          <label for="exampleInputLote">
            Lote
          </label>
          <input type="text" value='<jsp:getProperty property="lote" name="imovelDTO"/>' name="lote" class="form-control" id="exampleInputLote" readonly="readonly" />
        </div>
        <div class="form-group">
           
          <label for="exampleInputLote">
            Situação
          </label>
          <input type="text" value='<jsp:getProperty property="situacao" name="imovelDTO"/>' name="situacao" class="form-control" id="exampleInputLote" readonly="readonly" />
        </div>
      </div>
</br>
</br>
</br>
         <input id="excluir" class="btn btn-primary"
          type='submit' value='Excluir' >

      </form>
    </div>
  </div>
</div>
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

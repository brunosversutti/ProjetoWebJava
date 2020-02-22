<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Business.ImovelBusiness"%>
<link rel=stylesheet type="text/css" href="../js/Mylayout.css" />
<%@page errorPage="/Util/PaginaDeErro.jsp"%>

<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	String produtoInicial = request.getParameter("produtoInicial"); 
	String produtoFinal = request.getParameter("produtoFinal");
	
	if(produtoInicial == null || produtoInicial.isEmpty())
		produtoInicial = "0";
	
	if(produtoFinal == null || produtoFinal.isEmpty())
		produtoFinal = "9999999999";
	
	String filtro = "";
	filtro = "CODIGO BETWEEN " + produtoInicial + " AND " + produtoFinal; 

	ImovelBusiness imovelBusiness = new ImovelBusiness();
	ResultSet rsImovel = imovelBusiness.Relatorio(filtro);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>

<body>
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
        </tr>
      </thead>
      <tbody>
       <%
			while(rsImovel.next()) {
				 %>
        <tr>
          <td id="COL01"><%=rsImovel.getInt("idimovel")%></td>
          <td id="COL02"><%=rsImovel.getString("ENDERECO")%></td>
          <td id="COL03"><%=rsImovel.getString("CEP")%></td>
          <td id="COL04"><%=rsImovel.getString("PRECO")%></td>
          <td id="COL05"><%=rsImovel.getString("METRAGEM")%></td>
          <td id="COL06"><%=rsImovel.getString("QUADRA")%></td>
          <td id="COL07"><%=rsImovel.getString("LOTE")%></td>
          <td id="COL08"><%=rsImovel.getString("SITUACAO")%></td>
             <% } %>
        </tr>
    
      </tbody>
    </table> 

</body>
</html>
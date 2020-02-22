var xmlRequest 

function createRequestObject() {
	var xmlHttpReq;

	// Mozilla/Safari
	if (window.XMLHttpRequest) {
		xmlHttpReq = new XMLHttpRequest();
	}
	// IE
	else if (window.ActiveXObject) {
		xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
	}

	return xmlHttpReq;
}

function GetXmlHttpObject()
{
	var xmlHttp=null;
	try
	{
		// Firefox, Opera 8.0+, Safari
		xmlHttp=new XMLHttpRequest();
	}
	catch (e)
	{
		// Internet Explorer
		try
		{
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e)
		{
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}

function carregarItens()
{
	//xmlRequest = createRequestObject();
	xmlRequest = GetXmlHttpObject();
	var url = "/ExemploJSP2/Venda/Itens.jsp";
	
	xmlRequest.open("GET", url, false);
	xmlRequest.onreadystatechange = mudancaEstadoCarregarItens;
	xmlRequest.send(null);

	return url;
}

function mudancaEstadoCarregarItens() {

	if(xmlRequest.readyState == 4){
		if (xmlRequest.status == 200) {
			document.getElementById("idItens").innerHTML = xmlRequest.responseText;
		} else {
			throw new Error("Problem retrieving data.ajax.status = " + xmlRequest.status + "ajax.responseText=" + xmlRequest.responseText);
			alert ("ERRO");
		}
	}
}

function adicionarItem(urlDestino) {

	var produto = document.getElementById("selectProdutos").value;
	var quantidade = document.getElementById("quantidade").value;
	var valor = document.getElementById("valor").value;

	if((produto == null) || (produto == "")){
		alert("Produto deve ser informado");
		document.getElementById("selectProdutos").focus();
		return
	}

	if((quantidade == null) || (quantidade == "")){
		alert("Quantidade deve ser informado");
		document.getElementById("quantidade").focus();
		return
	}

	if((valor == null) || (valor == "")){
		alert("Valor deve ser informado");
		document.getElementById("valor").focus();
		return
	}

	xmlRequest = createRequestObject();
	var url = urlDestino;

	url += "?acao=Incluir";
	url += "&produto=" + produto;
	url += "&quantidade=" + quantidade;
	url += "&valor=" + valor;

	xmlRequest.open("GET", url, false);
	xmlRequest.onreadystatechange = mudancaEstadoAdicionarItem;
	xmlRequest.send(null);

	return url;
}

function mudancaEstadoAdicionarItem() {

	if(xmlRequest.readyState == 4){
		if (xmlRequest.status == 200) {
			document.getElementById("idItens").innerHTML = xmlRequest.responseText;
			document.getElementById("quantidade").value = "";
			document.getElementById("valor").value = "";
			document.getElementById("selectProdutos").focus();
		} else {
			throw new Error("Problem retrieving data.ajax.status = " + xmlRequest.status + "ajax.responseText=" + xmlRequest.responseText);
			alert ("ERRO");
		}
	}
}

function excluirItem(urlDestino, indice) {
	xmlRequest = createRequestObject();

	var url = urlDestino;

	url += "?acao=Excluir";
	url += "&indiceItem=" + indice;
	
	xmlRequest.open("GET", url, false);
	xmlRequest.onreadystatechange = mudancaEstadoExcluirItem;
	xmlRequest.send(null);

	return url;
}

function mudancaEstadoExcluirItem() {

	if(xmlRequest.readyState == 4){
		if (xmlRequest.status == 200) {
			document.getElementById("idItens").innerHTML = xmlRequest.responseText;
			document.getElementById("quantidade").value = "";
			document.getElementById("valor").value = "";
			document.getElementById("selectProdutos").focus();
		} else {
			throw new Error("Problem retrieving data.ajax.status = " + xmlRequest.status + "ajax.responseText=" + xmlRequest.responseText);
			alert ("ERRO");
		}
	}
}

function abrirPag(valor, corpo) {
	var url = valor;
	corpoOpcao = corpo;

	xmlRequest.open("POST", url, true);
	xmlRequest.onreadystatechange = mudancaEstado;
	xmlRequest.send(null);
	return url;
}


function dateMask(inputData, e) {
	var tecla;

	if (document.all) // Internet Explorer
		tecla = event.keyCode;
	else
		//Outros Browsers
		tecla = e.which;

	if (tecla >= 47 && tecla < 58) { // numeros de 0 a 9 e '/'
		var data = inputData.value;

		//se for um numero coloca no input
		if (tecla > 47 && tecla < 58) {
			if (data.length == 2 || data.length == 5) {
				data += '/';

			}
		} else if (tecla == 47) { //se for a barra, so deixa colocar se estiver na posicao certa
			if (data.length != 2 && data.length != 5) {
				return false;
			}
		}
		//atualiza o input da data
		inputData.value = data;
		return true;

	} else if (tecla == 8 || tecla == 0) // Backspace, Delete e setas direcionais(para mover o cursor, apenas para FF)
		return true;
	else
		return false;
}

<jsp:useBean id="usuarioDTO" class="Dto.UsuarioDTO"></jsp:useBean>
<jsp:setProperty property="*" name="usuarioDTO" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page errorPage="/Util/PaginaDeErro.jsp"%>
    
<!DOCTYPE html>
<html class="wide wow-animation" lang="en">

<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Montserrat:300,400,700%7CPoppins:300,400,500,700,900">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet" href="css/style.css">
    <style>
        .ie-panel {
            display: none;
            background: #212121;
            padding: 10px 0;
            box-shadow: 3px 3px 5px 0 rgba(0, 0, 0, .3);
            clear: both;
            text-align: center;
            position: relative;
            z-index: 1;
        }
        
        html.ie-10 .ie-panel,
        html.lt-ie-10 .ie-panel {
            display: block;
        }
    </style>
</head>

<body>
<%
	Boolean isLoginOk = (Boolean)session.getAttribute("loginOk");
	if(isLoginOk != null && !isLoginOk)
	{%>
		<h1>Dados para autenticaÃ§Ã£o invÃ¡lidos</h1>
	<%
		session.setAttribute("loginOk", true);
	}
%>
<script type="text/javascript">
	function Validate(){
		var login=document.formLogin.login;
		var senha=document.formLogin.senha;
		
		if ((login.value==null)||(login.value=="")){
			alert("Informe o nÃºmero de RA");
			login.focus();
			return false;
		}
		
		if ((senha.value==null)||(senha.value=="")){
			alert("Informe a senha do usuÃ¡rio");
			senha.focus();
			return false;
		}
		
		return true
	}
</script>
    <div class="ie-panel">

    </div>
    <div class="preloader">
        <div class="preloader-body">
            <div class="cssload-container">
                <div class="cssload-speeding-wheel"></div>
            </div>
            <p>Loading...</p>
        </div>
    </div>
    <div class="page">
        <header class="section page-header">
            <!--RD Navbar-->
            <div class="rd-navbar-wrap">
                <nav class="rd-navbar rd-navbar-classic" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-static"
                    data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-lg-stick-up-offset="46px" data-xl-stick-up-offset="46px" data-xxl-stick-up-offset="46px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">

                    <div class="rd-navbar-aside-outer rd-navbar-collapse bg-gray-dark">
                    </div>
                    <div class="rd-navbar-main-outer">
                        <div class="rd-navbar-main">
                            <!--RD Navbar Panel-->
                            <div class="rd-navbar-panel">
                                <!--RD Navbar Toggle-->
                                <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                                <!--RD Navbar Brand-->

                                <div class="rd-navbar-brand">
                                    <div class="rd-navbar-main-element">
                                        <div class="rd-navbar-nav-wrap">
                                            <!--login-->
                                            <div class="rd-navbar-main-element">
                                                <div class="rd-navbar-nav-wrap">
                                                    <ul class="rd-navbar-nav">
                                                        <li class="rd-nav-item active"><a class="rd-nav-link" href="index.html">Home</a>
                                                        </li>
                                                        <li class="rd-nav-item"><a class="rd-nav-link" href="#" data-custom-scroll-to="SobreNos">Sobre nós</a>
                                                            </a>
                                                        </li>
                                                        <li class="rd-nav-item"><a class="rd-nav-link" href="" data-custom-scroll-to="Desenvolvedores">Desenvolvedores</a>
                                                        </li>
                                                        <li class="rd-nav-item"><a class="rd-nav-link" href="#" data-custom-scroll-to="Contato">Contato</a>
                                                        </li>
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                                                        <li style="float:right">
                                                            <div class="bs-example">
                                                                <!--BotÃ£oLOGIN-->
                                                                <div class="btn-group btn-group-toggle" data-toggle="buttons">
                                                                    <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#janelalogin" role="button" style="font-size: 13px">Entrar</button>
                                                                    <!--BotÃ£oLOGIN-->
                                                                    <!--BotÃ£oCADASTRO-->
                                                                    <button type="submit" class="btn btn-primary" data-toggle="modal" data-target="#janelaregistro" role="button" style="font-size: 13px">Cadastrar</button>
                                                                </div>
                                                                <!--BotÃ£oCADASTRO-->
                                                            </div>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <!--Main section-->
        <section class="section main-section parallax-scene-js" style="background:url('https://s2.best-wallpaper.net/wallpaper/3840x2160/1805/Vector-design-city-skyscrapers-night_3840x2160.jpg') no-repeat center center; background-size:cover;">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-10 col-12">
                        <div class="main-decorated-box text-center text-xl-left">
                            <h1 class="text-white text-xl-center wow slideInRight" data-wow-delay=".3s"><span class="align-top offset-top-30 d-inline-block font-weight-light prefix-text">Sua</span><span class="big font-weight-bold d-inline-flex offset-right-170">melhor</span><span class="biggest d-block d-xl-flex font-weight-bold">Administração.</span></h1>
                            <div class="decorated-subtitle text-italic text-white wow slideInLeft">A solução em suas mãos</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--SOBRE-->
        <section class="section section-sm position-relative" id="SobreNos">
            <div class="container">
                <div class="row row-30">
                    <div class="col-lg-6">
                        <div class="block-decorate-img wow fadeInLeft" data-wow-delay=".2s"><img src="https://www.optidatacloud.com/blog/wp-content/uploads/2017/10/produtividade-5-ferramentas-para-gerenciar-e-organizar-.jpg" alt="" width="570" height="351" />
                        </div>
                    </div>
                    <div class="col-lg-6 col-12">
                        <div class="block-sm offset-top-45">

                            <div class="section-name wow fadeInRight" data-wow-delay=".2s">Sobre nós</div>

                            <h3 class="wow fadeInLeft text-capitalize devider-bottom" data-wow-delay=".3s">O que<span class="text-primary"> Fazemos</span></h3>
                            <p class="offset-xl-40 wow fadeInUp" data-wow-delay=".4s">Somos pessoas buscando o melhor para nossos clientes. Usando como base a praticidade e a agilidade para o dia a dia de uma pessoa totalmente sem tempo. O lugar onde vocês esta, sempre será¡ o lugar para negociar.</p>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <div class="decor-text decor-text-1">SOBRE</div>
        </section>
        <!--CaracterÃ­sticas-->
        <section class="section custom-section position-relative section-md" id="CaracterÃ­sticas">
            <div class="container">
                <div class="row">
                    <div class="col-xl-7 col-lg-7 col-12">
                        <div class="section-name wow fadeInRight">Nossas características</div>
                        <h3 class="text-capitalize devider-left wow fadeInLeft" data-wow-delay=".2s">Por que os empresários <span class="text-primary"><br> Nos escolhem?</span></h3>
                        <p>Estamos no ramo a muito tempo, portanto temos prioridade para falar do assunto quando se trata de orgaziar seus imóveis.</p>
                        <div class="row row-15">
                            <div class="col-xl-6 wow fadeInUp" data-wow-delay=".2s">
                                <div class="box-default">
                                    <div class="box-default-title">Soluções inovadoras</div>
                                    <p class="box-default-description">Buscando agilidade em sua consquistas.</p><span class="box-default-icon novi-icon icon-lg mercury-icon-lightbulb-gears"></span>
                                </div>
                            </div>
                            <div class="col-xl-6 wow fadeInUp" data-wow-delay=".3s">
                                <div class="box-default">
                                    <div class="box-default-title">Melhor manuseio de seus imóveis</div>
                                    <p class="box-default-description">Esteja pronto para qualquer opotunidade e então acerte em cheio suas negociacões .</p><span class="box-default-icon novi-icon icon-lg mercury-icon-target-2"></span>
                                </div>
                            </div>
                            <div class="col-xl-6 wow fadeInUp" data-wow-delay=".4s">
                                <div class="box-default">
                                    <div class="box-default-title">Profissionais capacitados</div>
                                    <p class="box-default-description">Equipe totalmente capacidade, afim de garantir a segurança e melhor apresentação de suas negociações.</p><span class="box-default-icon novi-icon icon-lg mercury-icon-user"></span>
                                </div>
                            </div>
                            <div class="col-xl-6 wow fadeInUp" data-wow-delay=".5s">
                                <div class="box-default">
                                    <div class="box-default-title">Confiaança de bons negócios</div>
                                    <p class="box-default-description">Seu negócio Ã© nosso negÃ³cio.</p><span class="box-default-icon novi-icon icon-lg mercury-icon-partners"></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="image-left-side wow slideInRight" data-wow-delay=".5s"><img src="https://menthes.com.br/wp-content/uploads/2016/09/lideranca2.jpg" alt="" width="636" height="240" />
            </div>
            <div class="decor-text decor-text-2 wow fadeInUp" data-wow-delay=".3s">Atributos</div>
        </section>

        <!--Desenvolvedores-->
        <section class="section section-sm position-relative" id="Desenvolvedores">
            <div class="container">
                <div class="row row-30">
                    <div class="col-lg-6">
                        <div class="block-decorate-img wow fadeInLeft" data-wow-delay=".2s"><img src="http://www.rentcafe.com/blog/wp-content/uploads/2012/01/Geek-crew.jpg" alt="" width="570" height="351" />
                        </div>
                    </div>
                    <div class="col-lg-6 col-12">
                        <div class="block-sm offset-top-45">

                            <div class="section-name wow fadeInRight" data-wow-delay=".2s">Desenvolvedores</div>

                            <h3 class="wow fadeInLeft text-capitalize devider-bottom" data-wow-delay=".3s">Nossa<span class="text-primary"> Equipe</span></h3>
                            <p class="offset-xl-40 wow fadeInUp" data-wow-delay=".4s">Somos pessoas buscando o melhor para nossos clientes. Usando como base a praticidade e a agilidade para o dia a dia de uma pessoa totalmente sem tempo. O lugar onde você esta, sempre será¡ o lugar para negociar.</p>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <div class="decor-text decor-text-1">EQUIPE</div>
        </section>
        <!--Counters-->
        <section class="section bg-image-2">
            <div class="container section-md">
                <div class="row row-30 text-center">
                    <div class="col-xl-4 col-md-4 col-12">
                        <div class="counter-classic">
                            <div class="counter-classic-number"><span class="icon-lg novi-icon offset-right-10 mercury-icon-time"></span><span class="counter text-white" data-speed="2000">2019</span>
                            </div>
                            <div class="counter-classic-title">Atuando desde</div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-4 col-12">
                        <div class="counter-classic">
                            <div class="counter-classic-number"><span class="icon-lg novi-icon offset-right-10 mercury-icon-folder"></span><span class="counter text-white" data-speed="2000">5000</span>
                            </div>
                            <div class="counter-classic-title">Armazenamento de documentos, facilitando suas administrações</div>
                        </div>
                    </div>
                    <div class="col-xl-4 col-md-4 col-12">
                        <div class="counter-classic">
                            <div class="counter-classic-number"><span class="icon-lg novi-icon offset-right-10 mercury-icon-users"></span><span class="counter text-white" data-speed="2000">1000</span><span class="symbol text-white">+</span>
                            </div>
                            <div class="counter-classic-title">Membros</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--Owl Carousel-->
        <section class="section section-md bg-gray-lighten">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-10">
                        <div class="section-name wow fadeInRight text-center" data-wow-delay=".2s">Clientes</div>
                        <h3 class="wow fadeInLeft text-capitalize text-center" data-wow-delay=".3s">O que dizem<span class="text-primary"> Sobre Nós</span></h3>
                        <div class="owl-carousel review-carousel" data-items="1" data-sm-items="1" data-md-items="1" data-lg-items="1" data-xl-items="1" data-xxl-items="1" data-dots="true" data-nav="false" data-stage-padding="0" data-loop="false" data-margin="0" data-mouse-drag="true"
                            data-autoplay="false">
                            <div class="item">
                                <div class="item-preview wow fadeInDown" data-wow-delay=".2s"><img src="https://specials-images.forbesimg.com/imageserve/5c76b7d331358e35dd2773a9/416x416.jpg?background=000000&cropX1=0&cropX2=4401&cropY1=0&cropY2=4401" alt="" width="216" height="108" />
                                </div>
                                <div class="item-description wow fadeInUp" data-wow-delay=".3s">
                                    <p>
                                        As publicações em meu site com o nome de Property ADM atigem um numero muito superior as outras empresas da no ramo. Os administradores estão de parabéns.
                                    </p>
                                    <div class="item-subsection"><span class="item-subsection-title devider-left">Face Mark</span><span>Cliente</span></div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="item-preview wow fadeInDown" data-wow-delay=".2s"><img src="https://specials-images.forbesimg.com/imageserve/5c76b4b84bbe6f24ad99c370/416x416.jpg?background=000000&cropX1=0&cropX2=4000&cropY1=0&cropY2=4000" alt="" width="216" height="108" />
                                </div>
                                <div class="item-description wow fadeInUp" data-wow-delay=".3s">
                                    <p>Realmente acho que esse pessoa da Property ADM tem futuro. Em tão pouco tempo e com tão pouca experiência no ramo, conseguiram chegar longe. Eles me lembram de onde tudo começou, em minha garagem.
                                    </p>
                                    <div class="item-subsection"><span class="item-subsection-title devider-left">Dr.Bill</span><span>Cliente</span></div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="item-preview wow fadeInDown" data-wow-delay=".2s"><img src="https://s.ebiografia.com/assets/img/authors/st/ev/steve-jobs-2-l.jpg" alt="" width="216" height="108" />
                                </div>
                                <div class="item-description wow fadeInUp" data-wow-delay=".3s">
                                    <p>Gostei, achei objetivo, de fácil interprestação. Já¡ posso ver um futuro negócio entre nós.</p>
                                    <div class="item-subsection"><span class="item-subsection-title devider-left">Mr.Steve</span><span>Cliente</span></div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="item-preview wow fadeInDown" data-wow-delay=".2s"><img src="https://specials-images.forbesimg.com/imageserve/5bb22ae84bbe6f67d2e82e05/416x416.jpg?background=000000&cropX1=904&cropX2=1403&cropY1=262&cropY2=761" alt="" width="216" height="108" />
                                </div>
                                <div class="item-description wow fadeInUp" data-wow-delay=".3s">
                                    <p>Só tenho uma coisa a dizer, se um dia a história desse site virar livro, eu serei o primeiro a vende-la.</p>
                                    <div class="item-subsection"><span class="item-subsection-title devider-left">Jeff Books</span><span>Cliente</span></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--Footer-->
        <footer class="section footer-classic section-sm" id="Contato">
            <div class="container">
                <div class="row row-30">
                    <div class="col-lg-3 wow fadeInLeft">
                        <!--Brand-->

                        <p class="footer-classic-description offset-top-0 offset-right-25">Em busca da organizaÃ§Ã£o e mater sua cabeÃ§a livre de problemas.</p>
                    </div>
                    <div class="col-lg-3 col-sm-8 wow fadeInUp">
                        <P class="footer-classic-title">Informações para contato</P>
                        <div class="d-block offset-top-0">Unitoledo<span class="d-lg-block">Araçatuba</span><a class="d-inline-block accent-link" href="mailto:#">unitoledo@hotmail.com</a>
                            <p><a class="d-inline-block" href="tel:#">0800 111 00 99</a></p>
                        </div>

                    </div>
                    <div class="col-lg-2 col-sm-4 wow fadeInUp" data-wow-delay=".3s">

                        <ul class="footer-classic-nav-list">
                            <li><a href="#SobreNos">Sobre nós</a></li>
                            <li><a href="#Desenvolvedores">Desenvolvedores</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-4 wow fadeInLeft" data-wow-delay=".2s">
                        <img src="http://www.toledo.br/wp-content/uploads/2017/05/1-2.png" width="150" height="120">
                        <ul class="footer-classic-nav-list">
                            <li><a href="http://www.toledo.br/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Acesse o Site</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <div class="snackbars" id="form-output-global"></div>



    <!--CADASTRO-->
    <form class="modal fade" id="janelaregistro" action="/PROJETOFINAL/Registrar" method="post">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Registrar-se</h4>
                    <button type="button" class="close" data-dismiss="modal">
            <span>&times;</span>
          </button>
                </div>
             
                <!--CADASTRO-->
<%
	String[] erros = (String[]) request.getAttribute("erros");
	if (erros != null && erros.length > 0) {
%>
<div class="htmldbNotification">
<ul>
	<%
		for (int i = 0; i < erros.length; i++) {
	%>
	<li><%=erros[i]%> <%
 	}
 %>
</ul>
</div>
<%
	}
%>

                <!--Corpo-->
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group ">
                            <label for="text">Nome</label>
                            <input type="text" value='<jsp:getProperty property="nome" name="usuarioDTO"/>' name="nome" id="name" class="form-control" placeholder="Digite seu nome" required>
                        </div>
                        <label for="email">Email</label>
                        <input type="email" value='<jsp:getProperty property="login" name="usuarioDTO"/>' name="email" id="email" class="form-control" placeholder="Digite seu e-mail" required>
                    </div>
                    <div class="form-group ">
                        <label for="number">CPF</label>
                        <input type="number" value='<jsp:getProperty property="cpf" name="usuarioDTO"/>' name="cpf" id="cpf" class="form-control" placeholder="Digite seu CPF" required>
                    </div>
                    <div class="form-group ">
                        <label for="text">Endereço</label>
                        <input type="text" value='<jsp:getProperty property="endereco" name="usuarioDTO"/>' name="endereco" id="endereco" class="form-control" placeholder="Digite seu endereço" required>
                    </div>
                     <div class="form-group ">
                        <label for="number">Telefone</label>
                        <input type="number" value='<jsp:getProperty property="telefone" name="usuarioDTO"/>'  name="telefone" id="telefone" class="form-control" placeholder="Digite seu telefone (somente números)" required>
                    </div>
                    <div class="form-group ">
                        <label for="text">Data de Nascimento</label>
                        <input type="text" value='<jsp:getProperty property="datanascimento" name="usuarioDTO"/>' name="datanascimento" id="datanascimento" class="form-control" placeholder="Digite sua data de nascimento Ex: aaaa/mm/dd" required>
                    </div>
                    <div class="form-group ">
                        <label for="text">Usuário</label>
                        <input type="text" value='<jsp:getProperty property="login" name="usuarioDTO"/>' name="login" id="login" class="form-control" placeholder="Digite seu usuário" required>
                    </div>
                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" value='<jsp:getProperty property="senha" name="usuarioDTO"/>' name="senha" id="senha" class="form-control" placeholder="Digite sua senha" required>
                    </div>
                    
                </div>
                <!--RodapÃ©-->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"> Cancelar </button>
                    <button type="submit" class="btn btn-primary" > Cadastrar </button>
                </div>
            </div>
        </div>
    </form>
    <!--Janela-->
    <!--Corpo-->

    <!--LOGIN-->
    <form class="modal fade" id="janelalogin" name="formLogin" action="/PROJETOFINAL/Login" method=post onsubmit="return Validate()">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Efetuar Login</h4>
                    <button type="button" class="close" data-dismiss="modal">
            <span>&times;</span>
          </button>
                </div>
                <!--Corpo-->
                <div class="modal-body">
                    <div class="form-group">
                        <label for="user">Usuário</label>
                        <input type="text"  name="login" id="user" class="form-control" placeholder="Digite seu usuário" required>
                    </div>

                    <div class="form-group">
                        <label for="password">Senha</label>
                        <input type="password" name="senha" id="senha" class="form-control" placeholder="Digite sua senha" required>
                    </div>
                </div>

                <!--RodapÃ©-->
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal"> Cancelar </button>
                    <button type="submit" class="btn btn-primary"> Logar </button>
                </div>
            </div>

    </form>
    <!--LOGIN-->



    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script>
        window.jQuery || document.write('<script src="bootstrap-4.3.1-dist/js/jquery-slim.min.js"><\/script>')
    </script>
    <script src="js/core.min.js"></script>
    <script src="js/script.js"></script>

</body>

</html>
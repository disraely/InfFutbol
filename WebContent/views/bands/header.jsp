<%@ page pageEncoding="UTF-8"%>
<%@ page import="model.Usuario"%>
<%
	HttpSession sesion = request.getSession();
	Usuario userObj = (Usuario) sesion.getAttribute("authUsuario");	
%>
<div class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Info Futbol</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      	<li><img src="img/Soccer.png"/></li>
        <li class="active"><a href="#">Noticias <span class="sr-only">(current)</span></a></li>
	    <li><a href="views/about.html">Futbol peruano</a></li>
	    <li><a href="views/services.html">Futbol internacional</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Mas <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Busqueda">
        </div>
        <button type="submit" class="btn btn-default">Buscar</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=userObj.getUsuNom()%> <span class="caret"></span></a>
          	<ul class="dropdown-menu">
            	<li><a href="#">Perfil</a></li>
            	<li><a href="#">Privacidad</a></li>
            	<li><a href="#">Mi cuenta</a></li>
            	<li role="separator" class="divider"></li>
            	<li><a href="#">Cerrar sesión</a></li>
          	</ul>
        </li>
        <li><a href="#">Salir</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</div>
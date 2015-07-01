<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Usuario"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--jsp:useBean id="list" scope="session" class="java.util.list"/-->

<html>
<%
	HttpSession sesion = request.getSession();
	String errorMsg = (String) sesion.getAttribute("authEmail");
	//if (errorMsg!=null && !errorMsg.equals(""))
	//	out.print("<script>alert('"+errorMsg+"')</script>");
%>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="img/favicon.ico">
    
	<title>InfoFutbol | Bienvenido</title>
		
    <!-- Bootstrap core CSS -->
	<link href="css/bootstrap.css" rel="stylesheet">
	<!-- Custom styles for this template -->
    <link href="css/font-awesome.css" rel="stylesheet">
    <!--link href="css/main.css" rel="stylesheet"-->

    <!-- Custom styles for this template -->
    <link href="starter-template.css" rel="stylesheet">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
</head>
<body>
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
        <li class="active"><a href="#">Regresar <span class="sr-only">(current)</span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</div>
<div class="panel panel-primary">
	<!-- Default panel contents -->
	<div class="panel-heading">Registro de nuevo usuario</div>
  		<div class="panel-body">
  			<% if (errorMsg!=null && !errorMsg.equals("")) {%>
			<div class="alert alert-danger" role="alert">
    			<strong>Mensaje:</strong> <%=errorMsg%>.
  			</div>
			<% }%>
  			<form id="eventForm" method="post" class="form-horizontal" name="frmNewUsuario" action="./NuevoUsuario" enctype="multipart/form-data">
  				<div class="form-group">
  					<label class="col-xs-3 control-label">Nombre:</label>
  					<div class="col-xs-5">
      					<input type="text" id="txtNombre" name="txtNombre" class="form-control" placeholder="Ingrese su Nombre" required>
      				</div>
  				</div>
  				<div class="form-group">
  					<label class="col-xs-3 control-label">Apellido:</label>
  					<div class="col-xs-5">
      					<input type="text" id="txtApellido" name="txtApellido" class="form-control" placeholder="Ingrese su Apellido" required>
      				</div>
  				</div>
  				<div class="form-group">
  					<label class="col-xs-3 control-label">Foto de perfil:</label>
  					<div class="col-xs-5">
			    		<input type="file" id="txtFoto" name="txtFoto">
			    		<p class="help-block">Seleccione una foto de perfil</p>
			    	</div>
  				</div>
    			<div class="form-group">
        			<label class="col-xs-3 control-label">Fecha de nacimiento:</label>
        			<div class="col-xs-5 date">
            		<div class="input-group input-append date">
                		<input type="text" class="form-control" id="txtFecha" name="txtFecha" placeholder="Seleccione su Fecha de nacimiento" required/>
            		</div>
        			</div>
    			</div>
    			<div class="form-group">
        			<label class="col-xs-3 control-label">Email:</label>
        			<div class="col-xs-5">
        				<input type="email" class="form-control" id="txtEmail" name="txtEmail" placeholder="Ingrese su correo electronico" required>
        			</div>
    			</div>
    			<div class="form-group">
    				<label class="col-xs-3 control-label">Contraseña:</label>
    				<div class="col-xs-5">
    					<input type="password" class="form-control" id="txtPassword" name="txtPassword" placeholder="Ingrese su contraseña" required>
    				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-xs-3 control-label">Pregunta secreta:</label>
    				<div class="col-xs-5">
      					<select id="txtPregunta" name="txtPregunta" class="form-control">
        					<option></option>
        					<option>Lugar de nacimiento de la madre</option>
							<option>Primera mascota</option>
							<option>Nombre abuela/o</option>
							<option>Canción preferida</option>
      					</select>
      				</div>
    			</div>
    			<div class="form-group">
    				<label class="col-xs-3 control-label">Respuesta secreta:</label>
    				<div class="col-xs-5">
      					<input type="text" id="txtRespuesta" name="txtRespuesta" class="form-control" placeholder="Ingrese su respuesta Secreta">
      				</div>
      			</div>
      			<div class="form-group">
    				<label class="col-xs-3 control-label">Club Favorito:</label>
    				<div class="col-xs-5">
      					<input type="text" id="txtClub" name="txtClub" class="form-control" placeholder="Ingrese su Club favorito">
					</div>
    			</div>	
    			<div class="form-group">
        			<div class="col-xs-5 col-xs-offset-3">
            		<button type="submit" class="btn btn-primary" name="btnGuardar" value="Guardar">Guardar</button>
  					<!--button type="submit" class="btn btn-danger" name="btnCancelar" value="Cancelar">Cancelar</button-->
  					<a href="index.jsp" class="btn btn-mini btn-danger">Cancelar</a>
        			</div>
    			</div>
			</form>
  		</div>
 	</div>

	<%@include file="../bands/footer.jsp"%>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
   		$(function() {
    		$('#txtFecha').datepicker();
  		});
  	</script>
</body>
</html>

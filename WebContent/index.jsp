
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<%
	HttpSession sesion = request.getSession();
	String errorMsg = (String) sesion.getAttribute("authError");
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
    	<link href="css/cover.css" rel="stylesheet">
    	<link href="css/main.css" rel="stylesheet">
	</head>

	<body>
		<div class="site-wrapper">
			<div class="site-wrapper-inner">
				<div class="cover-container">
         			<div class="masthead clearfix">
         				<br/>
         				<br/>
         				<br/>
         				<form class="form-signin" name="frmUsuario" action="./AuthenticationServlet" method="post">
							<h2 class="form-signin-heading"><img src="img/favicon.ico"></h2>
				        	<h2 class="form-signin-heading">Info Futbol</h2>
				        	<label for="inputEmail" class="sr-only">Email</label>
				        	<input type="email" id="txtEmail" name="txtEmail" class="form-control" placeholder="Email address" required autofocus>
				        	<label for="inputPassword" class="sr-only">Password</label>
				        	<input type="password" id="txtPassword" name="txtPassword" class="form-control" placeholder="Password" required>
				        	<div class="checkbox">
				          		<label>
				            		<input type="checkbox" value="remember-me"> Recordar
				          		</label>
				       		</div>
				       		<% if (errorMsg!=null && !errorMsg.equals("")) {%>
				       		<div class="alert alert-danger" role="alert">
    							<strong>Mensaje:</strong> <%=errorMsg%>.
  							</div>
				       		<% }%>
				       		<button class="btn btn-lg btn-primary btn-block" type="submit" id="btnLoguear" value="Loguear">Ingresar</button>
				       		<a href="./registrarusuario" class="btn btn-mini btn-secondary btn-block" type="submit" id="btnRegistrar" value="Registrar">Registrarse</a>
				      	</form>
          			</div>
          	
          			<div class="mastfoot">
            			<div class="inner">
              				<p>Info Futbol para <a href="https://groups.google.com/forum/?hl=en#!forum/toa-miunsa-2015">toa-miunsa-2015</a>, por <a href="">disraely.ar.m@gmail.com</a>.</p>
            			</div>
          			</div>
				</div>
			</div>
		</div>

	    <!-- Bootstrap core JavaScript
	    ================================================== -->
	    <!-- Placed at the end of the document so the pages load faster -->
	    <script src="js/jquery.js"></script>
	    <script src="js/bootstrap.js"></script>
	</body>
</html>

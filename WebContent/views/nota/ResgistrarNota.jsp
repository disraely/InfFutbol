<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Usuario"%>
<%@ page import="model.Estadistica"%>
<%@ page import="java.util.List"%>
<%
	HttpSession sesion3 = request.getSession();
	List<Estadistica> estadisticalist = (List<Estadistica>) sesion3.getAttribute("listEstadistica");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
	<%@include file="../bands/header.jsp"%>
	<br/><br/>
	<section class="section-showcase">
		<div class="container showcase-content">
			<div class="panel panel-primary">
			<!-- Default panel contents -->
			<div class="panel-heading">Ingresar Nueva Nota</div>
		  		<div class="panel-body">
		  			<form id="eventForm" method="post" class="form-horizontal" name="frmNewUsuario" action="<%= request.getContextPath() %>/NotasServlet" enctype="multipart/form-data">
		    			<div class="form-group">
		    				<label class="col-xs-3 control-label">Partido:</label>
		    				<div class="col-xs-5">
		      					<select id="txtPartido" name="txtPartido" class="form-control">
		        					<% for(int i = 0 ; i < estadisticalist.size() ; i++) {
		        						Estadistica estadistica = new Estadistica();
		        						estadistica = (Estadistica) estadisticalist.get(i);
    								%>
		        					<option value="<%=estadistica.getEstIde()%>"><%=estadistica.getEstPriEqu() + " - " + estadistica.getEstSegEqu() %></option>
									<%} %>
		      					</select>
		      				</div>
		    			</div>
		    			<input type="hidden" class="form-control" id="txtUsuario" name="txtUsuario" value="<%=userObj.getUsuIde()%>"/>
		    			<div class="form-group">
		        			<label class="col-xs-3 control-label">Fecha:</label>
		        			<div class="col-xs-5 date">
		            		<div class="input-group input-append date">
		                		<input type="text" class="form-control" id="txtFecha" name="txtFecha" placeholder="Fecha de la nota" required/>
		            		</div>
		        			</div>
		    			</div>
		    			<div class="form-group">
		    				<label class="col-xs-3 control-label">Titulo:</label>
		    				<div class="col-xs-5">
		      					<input type="text" id="txtTitulo" name="txtTitulo" class="form-control" placeholder="Titulo de la nota" required>
		      				</div>
		      			</div>
		      			<div class="form-group">
		    				<label class="col-xs-3 control-label">Descripcion:</label>
		    				<div class="col-xs-5">
		    					<textarea class="form-control" rows="3" id="txtDescripcion" name="txtDescripcion" placeholder="Descripcion de la nota" required></textarea>
							</div>
		    			</div>	
		    			<div class="form-group">
		    				<label class="col-xs-3 control-label">Fuente:</label>
		    				<div class="col-xs-5">
		      					<input type="text" id="txtFuente" name="txtFuente" class="form-control" placeholder="Fuente de la nota" required>
		      				</div>
		      			</div>
		      			<div class="form-group">
		  					<label class="col-xs-3 control-label">Imagen:</label>
		  					<div class="col-xs-5">
					    		<input type="file" id="txtImg" name="txtImg">
					    		<p class="help-block">Seleccione una imagen</p>
					    	</div>
		  				</div>
		    			<div class="form-group">
		    				<div class="col-xs-5 col-xs-offset-3">
            					<button type="submit" class="btn btn-primary" name="btnGuardar" value="Guardar">Guardar</button>
            					<!--button type="submit" class="btn btn-primary" name="btnGuardar" value="Guardar">Guardar</button-->
  								<a href="views/principal.jsp" class="btn btn-mini btn-danger">Cancelar</a>
  								<!--button type="submit" class="btn btn-danger" name="btnCancelar" value="Cancelar">Cancelar</button-->
		        			</div>
		    			</div>
					</form>
		  		</div>
		 	</div>
		</div>
	</section>
	


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
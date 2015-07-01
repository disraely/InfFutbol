<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Usuario"%>
<%@ page import="model.Nota"%>
<%@ page import="java.util.List"%>
<%
	HttpSession sesion2 = request.getSession();
	List<Nota> notalist = (List<Nota>) sesion2.getAttribute("list");
	List<Nota> notasGeneral = (List<Nota>) sesion2.getAttribute("listOther");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--jsp:useBean id="list" scope="session" class="java.util.list"/-->

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
    <!--link href="starter-template.css" rel="stylesheet"-->
</head>
<body>
	<%@include file="bands/header.jsp"%>
	<br/><br/>
	<section class="section-showcase">
		<div class="container showcase-content">
		</div>
	</section>
	
	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading">Mis Ultimas noticias</div>
							<a href="<%=request.getContextPath() %>/NotasServlet?op=create" class="btn btn-mini btn-link">Nuevo</a>
							<table class="table table-hover">
    							<thead>
      								<tr>
        								<th>#</th>
        								<th>Fecha</th>
        								<th>Titulo</th>
        								<th></th>
      								</tr>
    							</thead>
    							<tbody>
    								<% for(int i = 0 ; i < notalist.size() ; i++) {
    									Nota nota = new Nota();
    									nota = (Nota) notalist.get(i);
    								%>
      								<tr>
        								<td><%=i+1%></td>
        								<td><%=nota.getNotFec() %></td>
        								<td><%=nota.getNotTit() %></td>
        								<td>
        									<a href="<%=request.getContextPath() %>/NotasServlet?op=view&id=<%= nota.getNotIde()%>" class="btn btn-mini btn-success">Ver</a>
        									<a href="<%=request.getContextPath() %>/NotasServlet?op=update&id=<%= nota.getNotIde()%>" class="btn btn-mini btn-primary">Editar</a>
        									<a href="<%=request.getContextPath() %>/NotasServlet?op=delete&id=<%= nota.getNotIde()%>" class="btn btn-mini btn-danger">Eliminar</a>
        								</td>
      								</tr>   
      								<% }%>   							
    							</tbody>
  							</table>
						</div>
			  		</div>
				</div>
			</div>
		</div>
	</section>

  	<section>
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="panel panel-primary">
						<!-- Default panel contents -->
						<div class="panel-heading">Ultimas noticias de otros usuarios</div>
							<table class="table table-hover">
    							<thead>
      								<tr>
        								<th>#</th>
        								<th>Fecha</th>
        								<th>Titulo</th>
        								<th></th>
      								</tr>
    							</thead>
    							<tbody>
    								<% for(int i = 0 ; i < notalist.size() ; i++) {
    									Nota nota = new Nota();
    									nota = (Nota) notalist.get(i);
    								%>
      								<tr>
        								<td><%=i+1%></td>
        								<td><%=nota.getNotFec() %></td>
        								<td><%=nota.getNotTit() %></td>
        								<td>
        									<a href="nota" class="btn btn-mini btn-success">Ver</a>
        								</td>
      								</tr>   
      								<% }%>   							
    							</tbody>
  							</table>
						</div>
			  		</div>
				</div>
			</div>
		</div>
	</section>
	
	<!--section>
		<div class="container">
			<div class="row">
				<div class="col-md-4">
					<div class="block block-primary">
						<h3><i class="fa fa-check"></i> Grupo A</h3>
						<table class="table">
    						<thead>
      							<tr>
        							<th>Pais</th>
        							<th>PJ</th>
        							<th>G</th>
        							<th>E</th>
        							<th>P</th>
        							<th>GF</th>
        							<th>GC</th>
        							<th>PTS</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>CHILE</td>
        							<td>2</td>
        							<td>1</td>
        							<td>1</td>
        							<td>0</td>
        							<td>5</td>
        							<td>3</td>
        							<td>4</td>
      							</tr>
      							<tr>
        							<td>BOLIVIA</td>
        							<td>2</td>
        							<td>1</td>
        							<td>1</td>
        							<td>0</td>
        							<td>3</td>
        							<td>2</td>
        							<td>4</td>
      							</tr>
      							<tr>
        							<td>MÉXICO</td>
        							<td>2</td>
        							<td>0</td>
        							<td>2</td>
        							<td>0</td>
        							<td>3</td>
        							<td>3</td>
        							<td>2</td>
      							</tr>
      							<tr>
        							<td>ECUADOR</td>
        							<td>2</td>
        							<td>0</td>
        							<td>0</td>
        							<td>2</td>
        							<td>2</td>
        							<td>5</td>
        							<td>0</td>
      							</tr>
    						</tbody>
  						</table>
					</div>
				</div>
				<div class="col-md-4">
					<div class="block block-secondary">
						<h3><i class="fa fa-check"></i> Grupo B</h3>
						<table class="table">
    						<thead>
      							<tr>
        							<th>Pais</th>
        							<th>PJ</th>
        							<th>G</th>
        							<th>E</th>
        							<th>P</th>
        							<th>GF</th>
        							<th>GC</th>
        							<th>PTS</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>PARAGUAY</td>
        							<td>2</td>
        							<td>1</td>
        							<td>1</td>
        							<td>0</td>
        							<td>3</td>
        							<td>2</td>
        							<td>4</td>
      							</tr>
      							<tr>
        							<td>URUGUAY</td>
        							<td>1</td>
        							<td>1</td>
        							<td>0</td>
        							<td>0</td>
        							<td>1</td>
        							<td>0</td>
        							<td>3</td>
      							</tr>
      							<tr>
        							<td>ARGENTINA</td>
        							<td>1</td>
        							<td>0</td>
        							<td>1</td>
        							<td>0</td>
        							<td>2</td>
        							<td>2</td>
        							<td>1</td>
      							</tr>
      							<tr>
        							<td>JAMAICA</td>
        							<td>2</td>
        							<td>0</td>
        							<td>0</td>
        							<td>2</td>
        							<td>0</td>
        							<td>2</td>
        							<td>0</td>
      							</tr>
    						</tbody>
  						</table>
					</div>
				</div>
				<div class="col-md-4">
					<div class="block block-primary">
						<h3><i class="fa fa-check"></i> Grupo C</h3>
						<table class="table">
    						<thead>
      							<tr>
        							<th>Pais</th>
        							<th>PJ</th>
        							<th>G</th>
        							<th>E</th>
        							<th>P</th>
        							<th>GF</th>
        							<th>GC</th>
        							<th>PTS</th>
      							</tr>
    						</thead>
    						<tbody>
      							<tr>
        							<td>BRASIL</td>
        							<td>1</td>
        							<td>1</td>
        							<td>0</td>
        							<td>0</td>
        							<td>2</td>
        							<td>1</td>
        							<td>3</td>
      							</tr>
      							<tr>
        							<td>VENEZUELA</td>
        							<td>1</td>
        							<td>1</td>
        							<td>0</td>
        							<td>0</td>
        							<td>1</td>
        							<td>0</td>
        							<td>1</td>
      							</tr>
      							<tr>
        							<td>PERU</td>
        							<td>1</td>
        							<td>0</td>
        							<td>0</td>
        							<td>1</td>
        							<td>1</td>
        							<td>2</td>
        							<td>0</td>
      							</tr>
      							<tr>
        							<td>COLOMBIA</td>
        							<td>1</td>
        							<td>0</td>
        							<td>0</td>
        							<td>1</td>
        							<td>0</td>
        							<td>1</td>
        							<td>0</td>
      							</tr>
    						</tbody>
  						</table>
					</div>
				</div>
			</div>
		</div>
	</section-->
	
	<!-- <section class="no-pad-top">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<div class="block block-light block-center">
						<i class="fa fa-html5 fa-primary fa-6 fa-border"></i>
						<h3 class="heading-primary">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean pharetra varius maximus.</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="block block-light block-center">
						<i class="fa fa-pie-chart fa-primary fa-6 fa-border"></i>
						<h3 class="heading-primary">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean pharetra varius maximus.</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="block block-light block-center">
						<i class="fa fa-unlock-alt fa-primary fa-6 fa-border"></i>
						<h3 class="heading-primary">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean pharetra varius maximus.</p>
					</div>
				</div>
				<div class="col-md-3">
					<div class="block block-light block-center">
						<i class="fa fa-question-circle fa-primary fa-6 fa-border"></i>
						<h3 class="heading-primary">Lorem Ipsum</h3>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean pharetra varius maximus.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section class="section-light extra-pad">
		<div class="container">
			<div class="row">
				<div class="col-md-5">
					<h2 class="page-header">Use <span class="em-primary">SkyApp</span> on All Devices</h2>
					<ul class="list list-feature">
						<li><i class="fa fa-check fa-6 fa-primary"></i> <span>Lorem ipsum dolor</span></li>
						<li><i class="fa fa-check fa-6 fa-primary"></i> <span>Lorem ipsum dolor</span></li>
						<li><i class="fa fa-check fa-6 fa-primary"></i> <span>Lorem ipsum dolor</span></li>
						<li><i class="fa fa-check fa-6 fa-primary"></i> <span>Lorem ipsum dolor</span></li>
					</ul>
					<br>
					<a href="#" class="btn btn-primary btn-lg">Read More</a>
				</div>
				<div class="col-md-5">
					<img class="device" src="img/device-imac.png">
				</div>
			</div>
		</div>
	</section>
	
	<section class="section-primary extra-pad">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<img class="device device-small" src="img/device-iphone.png">
				</div>
				<div class="col-md-6">
					<h2 class="page-header">Try SkyApp For 30 Days FREE!</h2>
					<p class="lead">Lorem ipsum dolor sit amet, consectetur adipiscing elit Phasellus et odio.</p>
					<a href="#" class="btn btn-lg btn-default btn-rounded">Start Trial</a>
				</div>
			</div>
		</div>
	</section> -->

	<%@include file="bands/footer.jsp"%>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>
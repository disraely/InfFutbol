<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Nota"%>
<%@ page import="model.Imagen"%>
<%
	HttpSession sesion2 = request.getSession();
	Imagen loadImg = (Imagen) sesion2.getAttribute("loadImg");
	Nota viewNota = (Nota) sesion2.getAttribute("viewNota");
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
    <!--link href="starter-template.css" rel="stylesheet"-->
</head>
<body>
	<%@include file="../bands/header.jsp"%>
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
						<div class="panel-heading">Ver noticia</div>
							<div class="col-md-5">
								<h2 class="page-header"><%=viewNota.getNotTit() %></h2>
								
								<p contenteditable="true">
									<%=viewNota.getNotDes() %>
								</p>
								
								<br>
								<h5><%=viewNota.getNotFue() %></h5>
							</div>
							<div class="col-md-5">
								<br>
								<img class="device" src="repositoryImg/<%=loadImg.getImgNom() %>">
								<!--img class="device" src="img/device-imac.png"-->
							</div>
						</div>
			  		</div>
				</div>
			</div>
		</div>
	</section>

	<%@include file="../bands/footer.jsp"%>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>
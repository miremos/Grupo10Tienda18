<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

<link rel="stylesheet" href="Styles.css">
<link rel="stylesheet" href="home.css">

<style>  
  h1{
  animation: backInDown; 
  animation-duration: 2s; 
  }
  h4{
  animation: zoomInUp; 
  animation-duration: 2s; 
  }  
  </style>
  
<title>Home</title>
</head>
<jsp:include page="menu.jsp"></jsp:include>
<body
	background="https://static.vecteezy.com/system/resources/previews/002/303/917/non_2x/abstract-gray-background-with-wavy-lines-vector.jpg">



	<div align="center">
		<h1>
			<span>Bienvenido</span> a nuestra tienda
		</h1>
	</div>

	<div align="center">
		<h4>
			¡ Estamos para <span>Servirte !</span>
		</h4>
	</div>

	<div align="center">
		<img src="img/tienda.png" align="middle" width="426px" height="426px"
			title="Mi primera tienda virtual"
			class="animate__animated animate__fadeInLeftBig">
	</div>
	<div align="center">
		<p class="animate__animated animate__zoomInUp">Estamos felices de
			que nos hayas visitado, este es nuestro espacio virtual para que
			puedas conocer todos nuestros productos.</p>
	</div>

	<footer>
		<div align="center">
			<p style="line-height: 120%">CONTACTENOS:</p>
			<p style="line-height: 50%">PBX: 7654753</p>
			<p style="line-height: 50%">Cel: +57 3004145580</p>
			<p style="line-height: 50%">Correo: MiTienda@outlook.com</p>
			<p style="line-height: 50%">2021&copy;</p>

		</div>

	</footer>



</body>
</html>
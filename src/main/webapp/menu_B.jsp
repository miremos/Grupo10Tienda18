<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link rel="stylesheet" href="CSS/menu.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Tienda Virtual</title>
</head>
<body  >

<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #1C2833 ;">
<ul  class="navbar-nav me-auto mb-2 mb-lg-0 ">
<li class="nav-item">
    <a class="nav-link active"  aria-current="page" href="principal.jsp"> <i class="fas fa-home"></i> Inicio</a>
  </li>
  <li class="nav-item">
    <a  class="nav-link active" aria-current="page" href="listarusu"> <i class="fas fa-user-tie"></i> Usuarios</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="listar"><i class="fas fa-users"></i> Clientes</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="listarpro"><i class="fas fa-people-carry"></i> Proveedores</a>
  </li>
   <li class="nav-item">
    <a class="nav-link active" href="listarduc"><i class="fas fa-leaf"></i> Productos</a>
  </li>
   <li class="nav-item">
    <a class="nav-link active" href="ventas.jsp"><i class="fas fa-cart-arrow-down"></i> Ventas</a>
  </li>
  
 
  
  <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
          <i class="fas fa-file-import"></i> Consultas y Reportes
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="listarusureporte">Reporte Usuarios</a></li>
            <li><a class="dropdown-item" href="listarclientereporte">Reporte Clientes</a></li>
            <li><a class="dropdown-item" href="listarventas">Reporte Ventas</a></li>
           
          </ul>
  </li>
 
</ul>
<div class="dropdown" style="text-align: right; width: 220px">
			
			<button style="border: none"
				class="btn btn-outline-light dropdown-toggle" type="button"
				id="dropdownMenuButton1" data-bs-toggle="dropdown"
				aria-expanded="true">
				Usuario	logeado
			</button>
			<div class="dropdown-menu text-center">
				<a class="dropdown-item" href="#"><img src="img/usuario.png"
					alt="30" width="30" /></a> <a class="dropdown-item" href="#">Usuario
					logeado</a> <a class="dropdown-item" href="#"></a>
				
				<div class="dropdown-divider"></div>
				<a class="dropdown btn btn-outline-primary" style="border: none"
					href="index.jsp">SALIR</a>
			</div>
		</div>
</nav>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>
	
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_usuario.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Editar Cliente</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var cedula = "<%=request.getParameter("cedula")%>"
	var cliente = $.ajax({
		type: "GET",
		url: "http://localhost:8080/consultarCliente?documento="+cedula,
				success: function (data){
					$.each(data, function(i, item){
						document.getElementById("cedula").value = item.cedulaCliente;
						document.getElementById("direccionCliente").value = item.direccionCliente;
						document.getElementById("emailCliente").value = item.emailCliente;
						document.getElementById("nombreCliente").value = item.nombreCliente;
						document.getElementById("telefonoCliente").value = item.telefonoCliente;
					})
				}
	});
	
	function editarCliente(){
		var cedula = document.getElementById("cedula").value;
		var direccion = document.getElementById("direccionCliente").value;
		var correo = document.getElementById("emailCliente").value;
		var nombre = document.getElementById("nombreCliente").value;
		var telefono = document.getElementById("telefonoCliente").value;
		
		var editar = $.ajax({
			type: "GET",
			url: "http://localhost:8080/editarCliente?cedulaCliente="+cedula+"&direccionCliente="+direccion+"&emailCliente="+correo+"&nombreCliente="+nombre+"&telefonoCliente="+telefono,
			success: function(data){
				window.location.replace("http://localhost/clientes.jps");
			}
		})
	}



</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Modificar Cliente</h1>
		<form action ="" method ="get" onsubmit="editarCliente()">
		<img class= "img2" src= "imagenes/5.jpg" alt="">
			<div class = contenedor>
		
			<label class = "label" >Cédula</label> 
			<input class = "inputs" type="text" name="cedulaCliente" id="cedula">		
			<label class = "label">Direccion</label> 
			<input class = "inputs" type="text" name="direccionCliente" id="direccionCliente">		
			<label class = "label">Email</label> 
			<input class = "inputs" type="text" name="emailCliente" id="emailCliente">	
			<label class = "label">Nombre</label> 
			<input class = "inputs" type="text" name="nombreCliente" id="nombreCliente">	
			<label class = "label">Telefono</label> 
			<input class = "inputs" type="text" name="telefonoCliente" id="telefonoCliente">	
			<button class="boton" type="submit">Aceptar</button>
		</div>
	</form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_usuario.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Agregar Cliente</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

function registrarCliente(){
	
	var cedula = document.getElementById("cedulaCliente").value;
	var direccion = document.getElementById("direccionCliente").value;
	var correo = document.getElementById("emailCliente").value;
	var nombre = document.getElementById("nombreCliente").value;
	var telefono = document.getElementById("telefonoCliente").value;
	
	var agregar = $.ajax({
		type: "GET",
		url:"http://localhost:8080/registrarCliente?cedulaCliente="+cedula+"&direccionCliente="+direccion+"&emailCliente="+correo+"&nombreCliente="+nombre+"&telefonoCliente="+telefono,
				
				success: function(data){
					window.location.replace("http://localhost:8080/clientes.jps");
				}
	});
}



</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Agregar Cliente</h1>

<form action ="" method = "get" onsubmit="registrarCliente()">

	<img class= "img" src= "imagenes/4.jpg" alt="">
		<div class="contenedor">
		
			<label class = "label" >Cédula</label> <input class = "inputs" type="text" name="cedulaCliente" id="cedulaCliente" placeholder="&#128179">
			<label class = "label" >Direccion</label> <input class = "inputs" type="text" name="direccionCliente" id="direccionCliente" placeholder = "&#128204">
			<label class = "label" >Correo electronico</label> <input class = "inputs" type="text" name="emailCliente" id="emailCliente" placeholder = "&#9993">		
			<label class = "label" >Nombre</label> <input class = "inputs" type="text" name="nombreCliente" id="nombreCliente" placeholder = "&#129333">
			<label class = "label" >Telefono</label> <input class = "inputs" type="text" name="telefonoCliente" id="telefonoCliente" placeholder = "&#128222">
				
			<button class="boton" type="submit">Aceptar</button>
		
		</div>	
		
</form>


</body>
</html>
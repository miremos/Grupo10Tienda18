<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_usuario.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Agregar Proveedor</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

function registrarProveedor(){
	
	var nit = document.getElementById("nitProveedor").value;
	var ciudad = document.getElementById("ciudadProveedor").value;
	var direccion = document.getElementById("direccionProveedor").value;
	var nombre = document.getElementById("nombreProveedor").value;
	var telefono = document.getElementById("telefonoProveedor").value;
	
	var agregar = $.ajax({
		type: "GET",
		url: "http://localhost:8080/registrarProveedor?nitProveedor="+nit+"&ciudadProveedor="+ciudad+"&direccionProveedor="+direccion+"&nombreProveedor="+nombre+"&telefonoProveedor="+telefono,	
		success: function(data){
			window.location.replace("http://localhost:8080/proveedores.jps");
				}
	});
}



</script>


</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Agregar Proveedor</h1>

<form action ="" method = "get" onsubmit="registrarProveedor()">

	<img class= "img" src= "imagenes/7.jpg" alt="">
		<div class="contenedor">
	
			
				
			<label class = "label" >NIT</label> <input class = "inputs" type="text" name="nitProveedor" id="nitProveedor" placeholder="&#128179">
			
			<label class = "label" >Ciudad</label> <input class = "inputs" type="text" name="ciudadProveedor" id="ciudadProveedor" placeholder = "&#9993">
		
			<label class = "label" >Dirección</label> <input class = "inputs" type="text" name="direccionProveedor" id="direccionProveedor" placeholder = "&#129333">
		
			<label class = "label" >Nombre</label> <input class = "inputs" type="text" name="nombreProveedor" id="nombreProveedor" placeholder = "&#128204">
		
			<label class = "label" >Teléfono</label> <input class = "inputs" type="text" name="telefonoProveedor" id="telefonoProveedor" placeholder = "&#129333">
				
			<button class="boton" type="submit">Aceptar</button>
		
		</div>	
		
</form>


</body>
</html>
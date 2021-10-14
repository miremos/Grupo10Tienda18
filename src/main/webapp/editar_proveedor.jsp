<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_usuario.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Editar Proveedor</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var nit = "<%=request.getParameter("nit")%>"
	var proveedor = $.ajax({
		type: "GET",
		url: "http://localhost:8080/consultarProveedor?documento=" +nit,
				success: function (data){
					$.each(data, function(i, item){
						document.getElementById("nit").value = item.nitProveedor;
						document.getElementById("ciudadProveedor").value = item.ciudadProveedor;
						document.getElementById("direccionProveedor").value = item.direccionProveedor;
						document.getElementById("nombreProveedor").value = item.nombreProveedor;
						document.getElementById("telefonoProveedor").value = item.telefonoProveedor;
					})
				}
	});
	
	function editarProveedor(){
		var nit = document.getElementById("nit").value;
		var ciudad = document.getElementById("ciudadProveedor").value;
		var direccion = document.getElementById("direccionProveedor").value;
		var nombre = document.getElementById("nombreProveedor").value;
		var telefono = document.getElementById("telefonoProveedor").value;
		
		var editar = $.ajax({
			type: "GET",
			url: "http://localhost:8080/editarProveedor?nitProveedor="+nit+"&ciudadProveedor="+ciudad+"&direccionProveedor="+direccion+"&nombreProveedor="+nombre+"&telefonoProveedor="+telefono,
			success: function(data){
				window.location.replace("http://localhost/proveedores.jps");
			}
		})
	}



</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

	<h1 class="titulo">Modificar Proveedor</h1>
		<form action ="" method ="get" onsubmit="editarProveedor()">
		<img class= "img2" src= "imagenes/8.jpg" alt="">
			<div class = contenedor>
		
			<label class = "label" >NIT</label> 
			<input class = "inputs" type="text" name="nitProveeedor" id="nit" >		
			<label class = "label">Ciudad</label> 
			<input class = "inputs" type="text" name="ciudadProveedor" id="ciudadProveedor" >		
			<label class = "label">Dirección</label> 
			<input class = "inputs" type="text" name="direccionProveedor" id="direccionProveedor">	
			<label class = "label">Nombre</label> 
			<input class = "inputs" type="text" name="nombreProveedor" id="nombreProveedor" >	
			<label class = "label">Telefono</label> 
			<input class = "inputs" type="text" name="telefonoProveedor" name="telefonoProveedor"  >	
			<button class="boton" type="submit">Aceptar</button>
		</div>
	</form>


</body>
</html>
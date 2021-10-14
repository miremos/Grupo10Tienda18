<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_usuario.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Registrar Usuario</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

function registrarUsuario(){
	
	var cedula = document.getElementById("cedulaUsuario").value;
	var correo = document.getElementById("emailUsuario").value;
	var nombre = document.getElementById("nombreUsuario").value;
	var password = document.getElementById("password").value;
	var usuario = document.getElementById("usuario").value;
	
	var agregar = $.ajax({
		type: "GET",
		url: "http://localhost:8080/registrarUsuario?cedulaUsuario="+cedula+"&emailUsuario="+correo+"&nombreUsuario="+nombre+"&password="+password+"&usuario="+usuario,
		
				success: function(data){
					window.location.replace("http://localhost:8080/usuarios.jps");
				}
	});
}



</script>


</head>
<body>
<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Agregar Usuarios</h1>


<form action ="" method = "get" onsubmit="registrarUsuario()">


	<img class= "img" src= "imagenes/2.jpg" alt="">
		<div class="contenedor">
	
			
				
			<label class = "label" >Cédula</label> <input class = "inputs" type="text" name="cedulaUsuario" id="cedulaUsuario" placeholder="&#128179">
			
			<label class = "label" >Correo</label> <input class = "inputs" type="text" name="emailUsuario"  id="emailUsuario" placeholder = "&#9993">
		
			<label class = "label" >Nombre</label> <input class = "inputs" type="text" name="nombreUsuario"  id="nombreUsuario" placeholder = "&#129333">
		
			<label class = "label" >Contraseña</label> <input class = "inputs" type="text" name="password" id="password" placeholder = "&#128204">
		
			<label class = "label" >Usuario</label> <input class = "inputs" type="text" name="usuario" id="usuario" placeholder = "&#129333">
				
			<button class="boton" type="submit">Aceptar</button>
			
			
		
		</div>	
		
</form>


</body>
</html>
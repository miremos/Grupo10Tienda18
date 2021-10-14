<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/editar_usuario.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />

<title>Editar Usuario</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var cedula = "<%=request.getParameter("cedula")%>"
	var usuario = $.ajax({
		type: "GET",
		url: "http://localhost:8080/consultarUsuario?documento="+cedula,
				success: function (data){
					$.each(data, function(i, item){
						document.getElementById("cedula").value = item.cedulaUsuario;
						document.getElementById("emailUsuario").value = item.emailUsuario;
						document.getElementById("nombreUsuario").value = item.nombreUsuario;
						document.getElementById("password").value = item.password;
						document.getElementById("usuario").value = item.usuario;
					})
				}
	});
	
	function editarUsuario(){
		var cedula = document.getElementById("cedula").value;
		var correo = document.getElementById("emailUsuario").value;
		var nombre = document.getElementById("nombreUsuario").value;
		var password = document.getElementById("password").value;
		var usuario = document.getElementById("usuario").value;
		
		var editar = $.ajax({
			type: "GET",
			url: "http://localhost:8080/editarUsuario?cedulaUsuario="+cedula+"&emailUsuario="+correo+"&nombreUsuario="+nombre+"&password="+password+"&usuario="+usuario,
			success: function(data){
				window.location.replace("http://localhost/usuarios.jps");
			}
		})
	}



</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Modificar Usuario</h1>
		
		<form action ="" method ="get" onsubmit="editarUsuario()">
		<img class= "img" src= "imagenes/3.jpg" alt="">
			<div class = contenedor>
		
			<label class = "label" >Cédula</label> 
			<input class = "inputs" type="text" name="cedulaUsuario" id="cedula" disabled>		
			<label class = "label">Correo electrónico</label> 
			<input class = "inputs" type="text" name="emailUsuario" id="emailUsuario">		
			<label class = "label">Nombre</label> 
			<input class = "inputs" type="text" name="nombreUsuario" id="nombreUsuario">	
			<label class = "label">Contraseña</label> 
			<input class = "inputs" type="text" name="password" id="password">	
			<label class = "label">Usuario</label> 
			<input class = "inputs" type="text" name="usuario" id="usuario">	
			<button class="boton" type="submit">Aceptar</button>
		</div>
	</form>



</body>
</html>
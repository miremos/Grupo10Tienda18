<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="Usuarios/css/estilos_agregar.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Agregar Usuario</title>

</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1 class="titulo">AGREGAR USUARIO</h1>
	<form  method="post" id="Formulario" action="http://localhost:8080/registrarUsuario">
		<img class="img" src="Usuarios/imagenes/2.jpg" alt="">

		<div class="card col-sm-4" style="border: none">
			<div class="card-body">
				<br>
				<div class="contenedor">
					<label class="label">Cédula</label>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">&#128179</span> <input
							type="number" name="cedulaUsuario" id="cedulaUsuario"
							placeholder="Digite su número de identificación"
							aria-describedby="basic-addon1" class="form-control" required>
					</div>
					<label class="label">Correo</label>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">&#9993</span> <input
							type="email" name="emailUsuario" id="correo"
							placeholder="Digite su correo electrónico"
							aria-describedby="basic-addon1" class="form-control" required>
					</div>
					<label class="label">Nombre</label>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">&#129333</span> <input
							type="text" name="nombreUsuario" id="nombre" placeholder="Digite su nombre completo"
							class="form-control" aria-describedby="basic-addon1"
							pattern="[A-Za-zñÑ´ ]{3,100}" required>
					</div>
					<label class="label">Contraseña</label>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">&#128204</span> <input
							type="text" name="password" id="password" placeholder="Digite su contraseña"
							class="form-control" aria-describedby="basic-addon1"
							pattern="[A-Za-z0-9!?-@+_/&%$Ññ]{3,100}" required>
					</div>
					<label class="label">Usuario</label>
					<div class="input-group">
						<span class="input-group-text" id="basic-addon1">&#129333</span><input
							type="text" name="usuario" id="usuario"
							placeholder="Digite su nombre de usuario" class="form-control"
							aria-describedby="basic-addon1"
							pattern="[A-Za-z0-9!?-@+_/&%$Ññ´]{3,100}" required>
					</div>
					<br>
					
					<div class="form-group">
					
						<input type="submit" name="accion" id="accion" value="AGREGAR"
							class="btn btn-outline-success btn-lg"> <a
							class="btn btn-outline-primary btn-lg" type="button"
							href="usuarios.jsp">CANCELAR</a>
					</div>
				</div>
			</div>
		</div>

	</form>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
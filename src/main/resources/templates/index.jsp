<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Usuarios/css/estilos_login.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet">

<title>Login</title>
</head>
<body>
	<form class="form-sign" action="Validar" method="post">
		<img src="Usuarios/imagenes/1.jpg" alt="" style="">
		<div class="card col-sm-3" style="border: none">
			<div>
				<div class="card-body">
					<div class="form-group text-center">
						<h1 class="titulo">Login</h1>
						<img src="img/logoUsuario.png" alt="70" width="170" /> <br> <label>Bienvenidos
							al sistema</label>
					</div>
					<nav class="navbar navbar-light bg-light">
						<div class="input-group">
							<span class="input-group-text" id="basic-addon1"><img
								src="img/usuarioB.png" alt="20" width="20" /></span> <input type="text"
								name="usuario" class="form-control" placeholder="Username"
								aria-label="Username" aria-describedby="basic-addon1"
								required="required">
						</div>
					</nav>
					<nav class="navbar navbar-light bg-light">
						<div class="input-group">
							<span class="input-group-text" id="basic-addon1"><img
								src="img/candado.png" alt="20" width="20" /></span> <input
								type="password" name="pass" class="form-control"
								placeholder="Password" aria-label="Password"
								aria-describedby="basic-addon1" required="required">
						</div>
					</nav>
					<br>
					<div class="contenedor">
						<input type="submit" name="accion" value="Ingresar"
							class="btn btn-primary btn-b">
					</div>
				</div>
			</div>
		</div>
	</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*,java.util.*" %>
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
<link rel="stylesheet" href="tabla.css">
<link rel="stylesheet" href="Usuarios/css/estilos_agregar.css">
<title>Consultar Usuario</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<script>

var int cedula = Integer.parseInt(request.getParameter("cedula"));
	var cedula = $.ajax({
		type: "POST",
		url: "http://localhost:8080/consultarUsuario",
		success: function(data){
			$.each(data, function(i, item){
				lista = document.getElementById("myTable");
				var tr = document.createElement("tr");
				var columna1 = document.createElement("td");
				columna1.innerHTML = item.cedulaUsuario;
				var columna2 = document.createElement("td");
				columna2.innerHTML = item.emailUsuario;
				var columna3 = document.createElement("td");
				columna3.innerHTML = item.nombreUsuario;
				var columna4 = document.createElement("td");
				columna4.innerHTML = item.password;
				var columna5 = document.createElement("td");
				columna5.innerHTML = item.usuario;
				var columna6 = document.createElement("td");
				columna6.innerHTML = "<a href='eliminarUsuario?cedula="+item.cedulaUsuario+"'>Eliminar</a>";				
				var columna7 = document.createElement("td");
				columna7.innerHTML = "<a href='editar.jsp'>Editar</a>";
				
				lista.appendChild(tr);
				tr.appendChild(columna1);
				tr.appendChild(columna2);
				tr.appendChild(columna3);
				tr.appendChild(columna4);
				tr.appendChild(columna5);
				tr.appendChild(columna6);
				tr.appendChild(columna7);
				
			});
			
		}
	})
	
</script>




</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>CONSULTAR USUARIO</h1>

	
	<form action="usuarios.jsp" method="post">
		<div class="d-flex">
			<div id="main-container">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>CEDULA</th>
							<th>CORREO</th>
							<th>NOMBRE</th>
							<th>CONTRASEÑA</th>
							<th>USUARIO</th>
							<th colspan="2">ACCIONES</th>
						</tr>
					</thead>
					
					<tbody id= "myTable">
				
				</tbody>
				</table>


				<div class="alert alert-success d-flex align-items-center"
					role="alert">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi flex-shrink-0 me-2"
						viewBox="0 0 16 16" role="img" aria-label="Success:">
  	<path
							d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
  </svg>
					<strong>Usuario Encontrado</strong>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>

				


				<div class="alert alert-danger d-flex align-items-center"
					role="alert">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi flex-shrink-0 me-2"
						viewBox="0 0 16 16" role="img" aria-label="Danger:">
    <path
							d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
  </svg>
					<strong>Usuario Inexistente</strong>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				
			</div>
		</div>
	</form>

	<nav class="navbar navbar-light bg-light"
		style="text-align: right; width: 620px">
		<form action="usuarios.jsp">
			<div class="dropdown">
				<button name="accion" value="Agregar"
					class=" btn btn-outline-primary" style="border: none">
					<img src="img/volver.png" alt="70" width="70" />
				</button>
			</div>
		</form>
	</nav>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
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
<title>Consultar Cliente</title>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>
	<h1>CONSULTAR CLIENTE</h1>
	<%
	int cedula = Integer.parseInt(request.getParameter("cedula"));

	Class.forName("com.mysql.jdbc.Driver");
	Connection connexion = java.sql.DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/tiendagrupo18?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8",
			"root", "admin");

	PreparedStatement ps = connexion.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente =" + cedula);
	ResultSet result = ps.executeQuery();
	%>
	<form action="clientes.jsp" method="post">
		<div class="d-flex">
			<div id="main-container">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Cedula</th>
							<th>Direccion</th>
							<th>Correo</th>
							<th>Nombre</th>
							<th>Telefono</th>
							<th colspan="2">Acciones</th>
						</tr>
					</thead>
					<%
					int i = 0;
					while (result.next()) {
						i++;
					%>
					<tr>

						<td><%=result.getInt("cedula_cliente")%>
						<td><%=result.getString("direccion_cliente")%>
						<td><%=result.getString("email_cliente")%>
						<td><%=result.getString("nombre_cliente")%>
						<td><%=result.getString("telefono_cliente")%>
						<td><a
							href="editar.jsp?cedula=<%=result.getInt("cedula_cliente")%>"><img
								src="img/editar.png" alt="30" width="30" /></a></td>
						<td><a
							href="eliminar.jsp?cedula=<%=result.getInt("cedula_cliente")%>"><img
								src="img/eliminar.png" alt="30" width="30" /></a></td>
					</tr>
				</table>

				<div class="alert alert-success d-flex align-items-center"
					role="alert">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi flex-shrink-0 me-2"
						viewBox="0 0 16 16" role="img" aria-label="Success:">
  	<path
							d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
  </svg>
					<strong>Cliente Encontrado</strong>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>
				<%
				}
				if (i == 0) {
				%>

				<div class="alert alert-danger d-flex align-items-center"
					role="alert">
					<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
						fill="currentColor" class="bi flex-shrink-0 me-2"
						viewBox="0 0 16 16" role="img" aria-label="Danger:">
    <path
							d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
  </svg>
					<strong>Cliente Inexistente</strong>
					<button type="button" class="btn-close" data-bs-dismiss="alert"
						aria-label="Close"></button>
				</div>

				<%
				}
				%>
			</div>
		</div>
	</form>

	<nav class="navbar navbar-light bg-light"
		style="text-align: right; width: 620px">
		<form action="clientes.jsp">
			<div class="dropdown">
				<button name="accion" value="Agregar"
					class="btn btn-outline-primary" style="border: none">
					<img src="img/volver.png" alt="70" width="70" />
				</button>
			</div>
		</form>
	</nav>
</body>
</html>
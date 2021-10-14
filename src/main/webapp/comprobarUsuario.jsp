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
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<%
	String usuario = request.getParameter("usuario");
	String password = request.getParameter("pass");

	Class.forName("org.mariadb.jdbc.Driver");
	//Class.forName("com.mysql.jdbc.Driver");
	//Connection connexion = java.sql.DriverManager.getConnection("jdbc:mysql:/localhost:3306/tiendagrupo18", "root", "admin");
	//Connection connexion = java.sql.DriverManager.getConnection(
			//"jdbc:mysql://localhost:3306/db_springboot?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8","root", "admin");
	
	Connection connexion = java.sql.DriverManager.getConnection(
			"jdbc:mariadb://camiloc2.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/grupo18_equipo10",
			"admin", "Admin123$");
	PreparedStatement ps = connexion.prepareStatement("SELECT * FROM usuarios WHERE usuario=? AND password=?");
	ps.setString(1, usuario);
	ps.setString(2, password);
	ResultSet result = ps.executeQuery();
	int i = 0;
	while (result.next()) {
		i++;
	}
	if (i == 1) {
		//out.println("Usuario autorizado");
		response.sendRedirect("principal.jsp");

	} else

	//out.println("Usuario o contraseña incorrecta");
	//response.sendRedirect("index.jsp");	
	{
	%>

	<div class="alert alert-danger d-flex align-items-center" role="alert">
		<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
			fill="currentColor" class="bi flex-shrink-0 me-2" viewBox="0 0 16 16"
			role="img" aria-label="Danger:">
    <path
				d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
  </svg>
		<div>

			<strong>usuario o contraseña errados, intente de nuevo</strong> <a
				type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close" href="index.jsp"></a>

		</div>
	</div>

	<%
	}
	
	%>





</body>
</html>
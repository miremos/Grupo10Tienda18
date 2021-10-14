<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/buscar.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Buscar Cliente</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var cedula = "<%=request.getParameter("cedula")%>"
var clientes = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarCliente?documento="+cedula,
			
	success : function (data){
		$.each(data, function(i,item){
			lista = document.getElementById("myTable");
			var tr = document.createElement("tr");
			var columna1 = document.createElement("td");
			columna1.innerHTML = item.cedulaCliente;
			var columna2 = document.createElement("td");
			columna2.innerHTML = item.direccionCliente;
			var columna3 = document.createElement("td");
			columna3.innerHTML = item.emailCliente;
			var columna4 = document.createElement("td");
			columna4.innerHTML = item.nombreCliente;
			var columna5 = document.createElement("td");
			columna5.innerHTML = item.telefonoCliente;
			var columna6 = document.createElement("td");
			//columna6.innerHTML = "<a href = 'eliminarUsuario?cedula="+item.cedulaUsuario+"'>Eliminar</a>";
			columna6.innerHTML = "<a href = '' onclick= 'eliminarCliente("+item.cedulaCliente+")'>Eliminar</a>";
			var columna7 = document.createElement("td");
			columna7.innerHTML = "<a href = 'editar_usuario.jsp?cedula="+item.cedulaUsuario+"'>Editar</a>";
			
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


function eliminarCliente(cedula){
	alert(cedula);
	

	
	var eliminar = $.ajax({
		type: "GET",
		url: "http://localhost:8080/eliminarCliente?cedula="+cedula,
		success: function (data){
			
		}		
	});
}
</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>
<h1 class="titulo"> Cliente Encontrado</h1>




<div class="contenedor" >

	<a href="clientes.jsp" style="margin-left: 130px; margin-bottom: 20px;" class="btn btn-info" role="button" ><i class="fas fa-long-arrow-alt-left"></i> Volver</a>

	<table class="table">
    <thead class="thead-dark">
 	
	<tbody id=myTable>
	<tr style="background-color: #1C2833; color:white; " >
	<th>Cedula</th>
	<th>Dirección</th>
	<th>Email</th>
	<th>Nombre</th>
	<th>Teléfono</th>
	<th colspan = "2" >Acciones</th>
	</tr>	
	
	</tbody>
	
	</table>

	
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
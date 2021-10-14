<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
<link rel="stylesheet" href="CSS/tabla_usuario.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var cliente = $.ajax({
	type: "GET",
	url: "http://localhost:8080/listarCliente",
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
			//columna6.innerHTML = "<a href = 'eliminarCliente?cedula="+item.cedulaCliente+"'>Eliminar</a>";
			columna6.innerHTML = "<a href = '' onclick= 'eliminarCliente("+item.cedulaCliente+")'>Eliminar</a>";
			var columna7 = document.createElement("td");
			columna7.innerHTML = "<a href = 'editar_cliente.jsp?cedula="+item.cedulaCliente+"'>Editar</a>";
			
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



<h1 class="titulo">Clientes</h1>

	<form action="buscar_cliente.jsp" method="get" class="form-inline my-2 my-lg-0" style="display: flex; float:left; margin-left:130px; height:40px;padding-right: 550px; ">
      <input class="form-control mr-sm-2" type="search" name="cedula" id="cedula" placeholder="Número de Cédula" aria-label="Search">
      <button class="btn btn-info" style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
    </form>
    
    <a class="btn btn-info" role="button" href = "Agregar_Cliente.jsp" ><i class="fas fa-user-tie"></i>  Agregar Cliente</a>
    

<div class="contenedor" style="margin-top: 30px;">

	
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

</body>
</html>
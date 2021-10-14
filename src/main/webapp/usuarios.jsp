<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link rel="stylesheet" href="CSS/tabla_usuario.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var usuarios = $.ajax({
	type: "GET",
	url: "http://localhost:8080/listarUsuario",
	success : function (data){
		$.each(data, function(i,item){
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
			//columna6.innerHTML = "<a href = 'eliminarUsuario?cedula="+item.cedulaUsuario+"'>Eliminar</a>";
			columna6.innerHTML = "<a href = '' onclick= 'eliminarUsuario("+item.cedulaUsuario+")'>Eliminar</a>";
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


function eliminarUsuario(cedula){
	alert("Eliminar Usuario  " + cedula);
	
	//result = confirm("Eliminar usuario");
	
	//if (resultado === true) {
	  //  window.alert('Okay, si estas seguro.');
	//} else { 
	  //  window.alert('Pareces indeciso');
	//}
	
	var eliminar = $.ajax({
		type: "GET",
		url: "http://localhost:8080/eliminarUsuario?cedula="+cedula,
		succes: function (data){
			
		}		
	});
}


</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Usuarios</h1>


	<form action="buscar_usuario.jsp" method="get" class="form-inline my-2 my-lg-0" style="display: flex; float:left; margin-left:130px; height:40px;padding-right: 550px; ">
      <input class="form-control mr-sm-2" type="search" name="cedula" id="cedula"  placeholder="Número de Cédula" aria-label="Search">
      <button class="btn btn-info" style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
    </form>
<a  class="btn btn-info" role="button" href = "Registrar_Usuario.jsp" ><i class="fas fa-user-tie"></i>  Agregar Usuario</a>


<div class="contenedor" style="margin-top: 30px;">

	
	<table class="table">
    <thead class="thead-dark">
 	
	<tbody id=myTable>
	<tr style="background-color: #1C2833; color:white; " >
	<th>Cedula</th>
	<th>Correo</th>
	<th>Nombre</th>
	<th>Contraseña</th>
	<th>Usuarios</th>
	<th colspan = "2" >Acciones</th>
	</tr>	
	
	</tbody>
	
	</table>
	
</div>


</body>
</html>
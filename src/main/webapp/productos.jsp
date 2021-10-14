<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="CSS/tabla_usuario.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Productos</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var usuarios = $.ajax({
	type: "GET",
	url: "http://localhost:8080/listarProducto",
	success : function (data){
		$.each(data, function(i,item){
			lista = document.getElementById("myTable");
			var tr = document.createElement("tr");
			var columna1 = document.createElement("td");
			columna1.innerHTML = item.codigoProducto;
			var columna2 = document.createElement("td");
			columna2.innerHTML = item.ivaCompra;
			var columna3 = document.createElement("td");
			columna3.innerHTML = item.nitProveedor;
			var columna4 = document.createElement("td");
			columna4.innerHTML = item.nombreProducto;
			var columna5 = document.createElement("td");
			columna5.innerHTML = item.precioCompra;
			var columna6 = document.createElement("td");
			columna6.innerHTML = item.precioVenta;
			var columna7 = document.createElement("td");
			//columna7.innerHTML = "<a href = 'eliminarCliente?codigo="+item.codigoProducto+"'> Eliminar</a>";
			columna7.innerHTML = "<a href = '' onclick= 'eliminarProducto("+item.codigoProducto+")'>Eliminar</a>";
			var columna8 = document.createElement("td");
			columna8.innerHTML = "<a href = 'editar_producto.jsp?codigo="+item.codigoProducto+"'>Editar</a>";
			
			lista.appendChild(tr);
			tr.appendChild(columna1);
			tr.appendChild(columna2);
			tr.appendChild(columna3);
			tr.appendChild(columna4);
			tr.appendChild(columna5);
			tr.appendChild(columna6);
			tr.appendChild(columna7);
			tr.appendChild(columna8);
		});
	}

})

function eliminarProducto(codigo){
	alert("Eliminar Producto  " + codigo);
	
	//result = confirm("Eliminar usuario");
	
	//if (resultado === true) {
	  //  window.alert('Okay, si estas seguro.');
	//} else { 
	  //  window.alert('Pareces indeciso');
	//}
	
	var eliminar = $.ajax({
		type: "GET",
		url: "http://localhost:8080/eliminarProducto?codigo="+codigo,
		succes: function (data){
			
		}		
	});
}

</script>

</head>
<body>

</body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Productos</h1>

	<form action="buscar_producto.jsp" method="get" class="form-inline my-2 my-lg-0" style="display: flex; float:left; margin-left:130px; height:40px;padding-right: 500px; ">
      <input class="form-control mr-sm-2" type="search" name="codigo" placeholder="Código producto" aria-label="Search">
      <button class="btn btn-info" style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
    </form>

    <a class="btn btn-info" role="button" href = "Agregar_Producto.jsp" ><i class="fas fa-leaf"></i>  Agregar Producto</a>

<div class="contenedor" style="margin-top: 30px;">

	
	<table class="table">
    <thead class="thead-dark">
 	
	<tbody id=myTable>
	<tr style="background-color: #1C2833; color:white; " >
	<th>Código</th>
	<th>IVA Compra</th>
	<th>NIT Proveedor</th>
	<th>Nombre Producto</th>
	<th>Precio Compra</th>
	<th>Precio Venta</th>
	<th colspan = "2" >Acciones</th>
	</tr>	
	
	</tbody>
	
	</table>
	
</div>

</html>
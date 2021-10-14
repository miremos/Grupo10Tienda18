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
<title>Buscar Producto</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
var codigo = "<%=request.getParameter("codigo")%>"
var usuarios = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarProducto?codigo="+codigo, 
			
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
</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>
<h1 class="titulo"> Producto Encontrado</h1>




<div class="contenedor" >

	<a href="productos.jsp" style="margin-left: 130px; margin-bottom: 20px;" class="btn btn-info" role="button" ><i class="fas fa-long-arrow-alt-left"></i> Volver</a>

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


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
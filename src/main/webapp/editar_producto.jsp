<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_producto.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Editar Producto</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	var codigo = "<%=request.getParameter("codigo")%>"
	var producto = $.ajax({
		type: "GET",
		url: "http://localhost:8080/consultarProducto?codigo="+codigo,
				success: function (data){
					$.each(data, function(i, item){
						document.getElementById("codigo").value = item.codigoProducto;
						document.getElementById("ivaCompra").value = item.ivaCompra;
						document.getElementById("nitProveedor").value = item.nitProveedor;
						document.getElementById("nombreProducto").value = item.nombreProducto;
						document.getElementById("precioCompra").value = item.precioCompra;
						document.getElementById("precioVenta").value = item.precioVenta;
					})
				}
	});
	
	function editarProducto(){
		var codigo = document.getElementById("codigo").value;
		var iva = document.getElementById("ivaCompra").value;
		var nit = document.getElementById("nitProveedor").value;
		var nombre = document.getElementById("nombreProducto").value;
		var p_venta = document.getElementById("precioCompra").value;
		var p_compra = document.getElementById("precioVenta").value;
		
		
		var editar = $.ajax({
			type: "GET",
			url: "http://localhost:8080/editarProducto?codigoProducto="+codigo+"&ivaCompra="+iva+"&nitProveedor="+nit+"&nombreProducto="+nombre+"&precioCompra="+p_compra+"&precioVenta="+p_venta,
			success: function(data){
				window.location.replace("http://localhost/productos.jps");
			}
		})
	}



</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Agregar Producto</h1>

<form action ="" method ="get" onsubmit="editarProducto()">

	<img class= "img" src= "imagenes/12.jpg" alt="">
		<div class="contenedor">
		
			<label class = "label" >Código Producto</label> <input class = "inputs" type="text" name="codigoProducto" id="codigo" disabled>
			<label class = "label" >IVA Compra</label> <input class = "inputs" type="text" name="ivaCompra" id="ivaCompra" >
			<label class = "label" >NIT Proveedor</label> <input class = "inputs" type="text" name="nitProveedor" id="nitProveedor">			
			</div>
			
			<div class="contenedor2">
			<label class = "label" >Nombre Producto</label> <input class = "inputs" type="text" name="nombreProducto" id="nombreProducto">
			<label class = "label" >Precio Compra</label> <input class = "inputs" type="text" name="precioCompra" id="precioCompra">
			<label class = "label" >Precio Venta</label> <input class = "inputs" type="text" name="precioVenta" id="precioVenta">
			
			</div>
			<button class = "boton" type="submit">Aceptar</button>
		
		
		
</form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/agregar_producto.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />
<title>Agregar Productos</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">

function registrarProducto(){
	
	var codigo = document.getElementById("codigoProducto").value;
	var iva = document.getElementById("ivaCompra").value;
	var nit = document.getElementById("nitProveedor").value;
	var nombre = document.getElementById("nombreProducto").value;
	var p_compra = document.getElementById("precioCompra").value;
	var p_venta = document.getElementById("precioVenta").value;
	
	var agregar = $.ajax({
		type: "GET",
		url: "http://localhost:8080/registrarProducto?codigoProducto="+codigo+"&ivaCompra="+iva+"&nitProveedor="+nit+"&nombreProducto="+nombre+"&precioCompra="+p_compra+"&precioVenta="+p_venta,
				success: function(data){
					window.location.replace("http://localhost:8080/productos.jps");
				}
	});
}



</script>

</head>
<body>

<jsp:include page = "/menu_B.jsp"></jsp:include>

<h1 class="titulo">Agregar Producto</h1>

<form action ="" method = "get" onsubmit="registrarProducto()">

	<img class= "img" src= "imagenes/11.jpg" alt="">
		<div class="contenedor">
		
			<label class = "label" >Código Producto</label> <input class = "inputs" type="text" name="codigoProducto" id="codigoProducto" placeholder="&#128179">
			<label class = "label" >IVA Compra</label> <input class = "inputs" type="text" name="ivaCompra" id="ivaCompra" placeholder = "&#128204">
			<label class = "label" >NIT Proveedor</label> <input class = "inputs" type="text" name="nitProveedor" id="nitProveedor" placeholder = "&#9993">			
			</div>
			
			<div class="contenedor2">
			<label class = "label" >Nombre Producto</label> <input class = "inputs" type="text" name="nombreProducto" id="nombreProducto" placeholder = "&#127811">
			<label class = "label" >Precio Compra</label> <input class = "inputs" type="text" name="precioCompra" id="precioCompra" placeholder = "&#36">
			<label class = "label" >Precio Venta</label> <input class = "inputs" type="text" name="precioVenta" id="precioVenta" placeholder = "&#36">
			
			</div>
			<button class = "boton" type="submit">Aceptar</button>
		
		
		
</form>

</body>
</html>
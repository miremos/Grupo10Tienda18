<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>

var cedula = "<%=request.getParameter("cedula")%>"

var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarCliente?documento="+cedula, 
			success: function (data){
				$.each(data, function(i, item){
					document.getElementById("cedula").value = item.cedulaCliente;
					document.getElementById("nombre").value = item.nombreCliente;
		
				})
			}
});

var codigo = "<%=request.getParameter("codigo1")%>"
var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarProducto?codigo="+codigo,  
			success: function (data){
				$.each(data, function(i, item){
					document.getElementById("codigo1").value = item.codigoProducto; 
					document.getElementById("producto1").value = item.nombreProducto; 
		
				})
			}
});

var codigo = "<%=request.getParameter("codigo2")%>"
var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarProducto?codigo="+codigo,  
			success: function (data){
				$.each(data, function(i, item){
					document.getElementById("codigo2").value = item.codigoProducto; 
					document.getElementById("producto2").value = item.nombreProducto; 
		
				})
			}
});

</script>

</head>
<body>

<h1 class="titulo">Ventas</h1>

	<form action="pruebaVentas.jsp" method="get" class="form-inline my-2 my-lg-0" >
      <label class = "label" >Cédula</label>
      <input class="form-control mr-sm-2" type="search" name="cedula" id="cedula" placeholder="Número de Cédula" aria-label="Search">
 
      <button class="btn btn-info" style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
    
    
    
    </form>
		
	
			<label class = "label" >Nombre</label> 
			<input class = "inputs" type="text" name="nombre" id="nombre" >		
			
		<form action="" method="get" class="form-inline my-2 my-lg-0" >
            <label class = "label" >Codigo</label>
      <input class="form-control mr-sm-2" type="search" name="codigo1" id="codigo1" placeholder="codigo" aria-label="Search">
      <button class="btn btn-info" style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
    </form>
    
    <label class = "label" >Nombre producto</label> 
			<input class = "inputs" type="text" name="producto1" id="producto1" >	
		
		<form action="" method="get" class="form-inline my-2 my-lg-0" >
            <label class = "label" >Codigo</label>
      <input class="form-control mr-sm-2" type="search" name="codigo2" id="codigo2" placeholder="codigo" aria-label="Search">
      <button class="btn btn-info" style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
    </form>
    
    <label class = "label" >Nombre producto</label> 
			<input class = "inputs" type="text" name="producto2" id="producto2" >

</body>
</html>
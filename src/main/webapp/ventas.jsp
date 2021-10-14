<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ventas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" >
<link rel="stylesheet" href="CSS/ventas.css">
<link  rel="icon"   href="imagenes/favicon.png" type="image/png" />

<link rel="stylesheet" href="css/alertify.rtl.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script  src="js/alertify.min.js"></script>
<script>




function registrarVenta(){
	var codigo = document.getElementById("consecutivo").value;
	var cedula = document.getElementById("cedula").value;
	var cedulausu = document.getElementById("cedulausu").value;
	var totalventa = document.getElementById("totaliva").value;
	var valorventa = document.getElementById("totalVenta4").value;
	var iva = document.getElementById("totalIva5").value;
	
	var agregar = $.ajax({
		type: "GET",
		url:"http://localhost:8080/registrarVenta?codigoVenta="+codigo+"&cedulaCliente="+cedula+"&cedulaUsuario="+cedulausu+"&totalVenta="+totalventa+"&valorVenta="+valorventa+"&ivaVenta="+iva,
		
				success: function(data){
					alertify.success("VENTA REGISTRADA EXITOSAMENTE " );
				      
					//window.location.replace("http://localhost:8080/ventas.jps");
				}
	});
	
	
	
}


var cedula = "<%=request.getParameter("cedula")%>"
var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarCliente?documento="+cedula, 
			success: function (data){
				$.each(data, function(i, item){
					
					document.getElementById("cedula").value = item.cedulaCliente;
					document.getElementById("nombreCliente").value = item.nombreCliente;
					
					alertify.success("VENTA REGISTRADA EXITOSAMENTE " );
					
				})
			}
});



var cedulausu = "<%=request.getParameter("cedulausu")%>"
var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarUsuario?documento="+cedulausu, 
			success: function (data){
				$.each(data, function(i, item){
					document.getElementById("cedulausu").value = item.cedulaUsuario;
					document.getElementById("nombreUsuario").value = item.nombreUsuario;
					
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
					document.getElementById("Total1").value = item.precioVenta;
				})
			}
});


$(document).ready(function () {
        $("#Agregar1").click(function (e) {
            var mat1 = $("#cantidad1").val();
            var price1 = $("#Total1").val();
            var mat2 = $("#cantidad2").val();
            var price2 = $("#Total2").val();
            var mat3 = $("#cantidad3").val();
            var price3 = $("#Total3").val();
            
            var resultado1 = parseInt(mat1) * parseInt(price1);
           
            var resultado2 = parseInt(mat2) * parseInt(price2);
            
            var resultado3 = parseFloat(mat3) * parseInt(price3);
            
            $("#valorTotal1").val(resultado1);
            $("#valorTotal2").val(resultado2);
            $("#valorTotal3").val(resultado3);
            
            var valor1 = $("#valorTotal1").val();
            var valor2 = $("#valorTotal2").val();
            var valor3 = $("#valorTotal3").val();
            
            var resultado4 = parseInt(valor1) + parseInt(valor2) + parseInt(valor3);
           
            var resultado5 = resultado4 * 0.19;
            
            var resultado6 = resultado4 + resultado5;        
    
            
            $("#totalVenta4").val(resultado4);
            $("#totalIva5").val(resultado5);
            $("#totaliva").val(resultado6);
        });
    });
    

var codigo = "<%=request.getParameter("codigo2")%>"
var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarProducto?codigo="+codigo,  
			success: function (data){
				$.each(data, function(i, item){
					document.getElementById("codigo2").value = item.codigoProducto; 
					document.getElementById("producto2").value = item.nombreProducto; 
					document.getElementById("Total2").value = item.precioVenta;
				})
			}
});




var codigo = "<%=request.getParameter("codigo3")%>"
var ventas = $.ajax({
	type: "GET",
	url: "http://localhost:8080/consultarProducto?codigo="+codigo,  
			success: function (data){
				$.each(data, function(i, item){
					document.getElementById("codigo3").value = item.codigoProducto; 
					document.getElementById("producto3").value = item.nombreProducto; 
					document.getElementById("Total3").value = item.precioVenta;
		
				})
			}
});


</script>

</head>
<body style="background: url(imagenes/fondob.jpg)">

<jsp:include page = "/menu_B.jsp"></jsp:include>




<h1 class="titulo">VENTAS</h1>
<div class="container">
<input type="submit" class="btn btn-primary" value="Agregar Compra" id="Agregar1"/>

</div>
<br>
<form action="ventas.jsp" method="get" onsubmit="registrarVenta()"  class="form-inline my-2 my-lg-0" >

	
	<div class="container">
	<FONT SIZE=5>Cédula Cliente</font>
	
      <input class="" type="search" name="cedula" id="cedula" placeholder="Cédula Cliente" aria-label="Search" >
      <button class="btn btn-info"  style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
<FONT SIZE=5>Cliente</font> <input class = "inputs" type="text" name="nombreCliente" id="nombreCliente" >
 <FONT SIZE=5>Consecutivo</font><input class = "inputs" type="text" name="consecutivo" id="consecutivo" >
</div>
<br>
<div class="container">
<FONT SIZE=5>Cédula Usuario</font>

      <input class="" type="search" name="cedulausu" id="cedulausu" placeholder="Cédula Usuario" aria-label="Search" >
      <button class="btn btn-info"  style="width:150px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> Buscar</button>
      
    
    
     <FONT SIZE=5>Usuario</font> <input class = "inputs" type="text" name="nombreUsuario" id="nombreUsuario" >
     </div>
    
     

   
   <br>
        
     <h4 class= "titulos">Cod. Producto</h4>
     <h4 class= "titulos">Nombre Producto</h4>
     <h4 class= "titulos">Cantidad</h4>
     <h4 class= "titulos" >Valor Total</h4>
    <div class="container">
    <!--  --> <div class = "form2" id="contenido">
			    
      		<input class="" type="search" name="codigo1" id="codigo1" placeholder="codigo" aria-label="Search">
      		
      		<button class="btn btn-info"   style="width:50px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> </button>
   
     
    <input class = "input1" type="text" name="producto1" id="producto1" >    
    <input class = "input2" type="text" name="cantidad1" id="cantidad1" value="0">
    <input class = "input3" type="text" name="valorTotal1" id="valorTotal1" value="0">
    <input class = "input3" type="hidden" name="Total1" id="Total1">
    
     
     
     </div>
     <div class = "form3">
     
    
      <input class="" type="search" name="codigo2" id="codigo2" placeholder="Código" aria-label="Search">
      <button class="btn btn-info" style="width:50px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> </button>
    
    
     <input class = "input1" type="text" name="producto2" id="producto2" >
    <input class = "input2" type="text" name="cantidad2" id="cantidad2" value="0">
    <input class = "input3" type="text" name="valorTotal2" id="valorTotal2" value="0">
    <input class = "input3" type="hidden" name="Total2" id="Total2">
     </div>
     
     
    <div class = "form4">
     
    
      <input class="" type="search" name="codigo3" id="codigo3" placeholder="Código" aria-label="Search">
      <button class="btn btn-info" style="width:50px; margin-left:10px; " type="submit"><i class="fas fa-search"></i> </button>
    
    
     <input class = "input1" type="text" name="producto3" id="producto3" >
    <input class = "input2" type="text" name="cantidad3"  id="cantidad3"value="0">
    <input class = "input3" type="text" name="valorTotal3" id="valorTotal3" value="0">
    <input class = "input3" type="hidden" name="Total3" id="Total3">
     </div>
     
     </div>
     
   <div class="t1">
     <label class = "label" >TOTAL VENTA</label>
      <input class = "total1" type="text" name="totalVenta4" id="totalVenta4" value="0">
   </div>  
   
   <div class="t2">
      <label class = "label" >TOTAL IVA</label>
      <input class = "total2" type="text" name="totalIva5" id="totalIva5"  value="0">
   </div>
   
   <div class="t3">
      <label class = "label" >TOTAL CON IVA</label>
      <input class = "total3" type="text" name="totaliva" id="totaliva" value="0">
    </div>
    
    <div class="boton_confirmar">
    <button class="btn btn-info" style="width:120px; margin-left:600px; " type="submit"><i class="far fa-check-circle"></i> Confirmar </button>
    </div>
     

   </form>
    
  



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


				
			<form class="d-flex" action="/ver/"  method="GET" >
				
					<input class="form-control me-2" type="number"  name="id" 
					placeholder="Numero de cedula" aria-label="Search" required>
					<a class="btn btn-primary btn-xs" th:href="@{/ver/} + ${cliente.id}" th:text="${cliente.id}"></a>
				<button class="btn btn-outline-primary"  type="submit"  >BUSCAR</button>
				
				
			</form>



</body>
</html>
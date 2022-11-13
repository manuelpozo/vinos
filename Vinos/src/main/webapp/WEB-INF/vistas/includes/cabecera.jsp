<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="es-ES" />
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<title>Vinos</title>

<base href="${pageContext.request.contextPath}/">

<link rel="stylesheet" href="css/datatables.min.css" />
<script src="js/datatables.min.js"></script>

</head>
<body class="h-100 d-flex flex-column">
<h1 class="text-center text-white bg-primary border border-5 border-secondary mx-2 mt-1  py-5 ">La Bodeguita de Idoia</h1>
 
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary  border border-5 border-secondary mx-2 mt-0 ">
		<div class="container-fluid">
			<a class="navbar-brand" href="index">Bodega App</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				
				<span class="navbar-text">${sessionScope.usuario.email}</span>
				<ul class="navbar-nav mb-2 mb-lg-0">
				
					<li class="nav-item"><c:if
							test="${sessionScope.usuario == null}">
							<a class="nav-link" href="login">Login</a>
						</c:if> <c:if test="${sessionScope.usuario != null}">
							<a class="nav-link" href="LogoutServlet">Desconectar</a>
						</c:if></li>
					
				</ul>
			</div>
		</div>
	</nav>
	<c:if test="${texto != null}">
		<div class="alert alert-${nivel} alert-dismissible fade show"
			role="alert">
			${texto}
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</c:if>
	<main class="container">
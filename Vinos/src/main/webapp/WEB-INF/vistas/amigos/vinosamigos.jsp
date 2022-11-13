<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera.jsp"%>
<div class="mt-5">
<table class="table table-hover table-bordered table-striped mt-3 pb-3">
	<thead>
		<tr>
			<th>Id</th>
			<th>Marca</th>
			<th>Bodega</th>
			<th>Cosecha</th>
			<th>Denominacion</th>
			<th>Tipo</th>
			<th>Precio</th>
			<th>Stock</th>
			
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${vinoslista}" var="v">
			<tr>
				<th>${v.id}</th>
				<td>${v.marca}</td>
				<td>${v.bodega}</td>
				<td>${v.cosecha}</td>
				<td>${v.denominacion }</td>
				<td>${v.tipo}</td>
				<td>${v.precio}</td>
				<td>${v.stock}</td>
				
				
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td>Id</td>
			<td>Marca</td>
			<td>Bodega</td>
			<td>Cosecha</td>
			<td>Denominacion</td>
			<td>Tipo</td>
			<td>Precio</td>
			<td>Stock</td>
			<td></td>
			
		</tr>
	</tfoot>
</table>

</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
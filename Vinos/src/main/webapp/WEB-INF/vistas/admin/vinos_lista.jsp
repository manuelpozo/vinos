<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera_admin.jsp"%>

<div class="col text-end mt-3 mb-3">  
  <a class="btn btn-primary  btn-lg" href="VinoInsertarServlet?op=agregar">Añadir Vino</a>
  
</div>

<table class="table table-hover table-bordered table-striped  mt-3 pb-3">
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
			<th>Localizacion</th>
			<th>Se vende</th>
			<th>Opciones</th>
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
				<td>${v.localizacion}</td>
				<td>${v.se_vende} </td>
				<td>
					<a class="btn btn-primary btn-sm" href="VinosAdminServlet?id=${v.id}&op=editar">Editar</a>
					<a class="btn btn-danger btn-sm" href="VinosAdminServlet?id=${v.id}&op=borrar">Borrar</a>
				</td>
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
			<td>Localizacion</td>
			<td>Se vende</td>
			<td>Opciones</td>
		</tr>
	</tfoot>
</table>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
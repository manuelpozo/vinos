<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera_admin.jsp"%>


<div class="container ">
	<div class="row">
		<div class="col-8 mt-5">
			<table class="table table-hover table-bordered table-striped ">
				<thead>
					<tr>
						<th>Id</th>
						<th>Denominacion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${denominacioneslista}" var="d">
						<tr>
							<th>${d.id}</th>
							<td>${d.denominacion}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td></td>
					</tr>
				</tfoot>
			</table>
		</div>
	<div class="col-4 mt-3">
		
		
	

		<form action="DenomAdminServlet" method="post" class="row g-3 needs-validation " novalidate>
		<input type="hidden" name="op" value="insertar" />
	<!-- 		<div class="col-md-4 ps-4 mt-3"> -->
	    	<label for="Denominacion" class="form-label">Denominacion</label>
	    	<input type="text" class="form-control" id="denominacion" name="denominacion" required >
				<div class="invalid-feedback">
		     		Introduzca La Denominacion.
		  		</div>
	  		
  			<!--   	</div>-->
  			<button type="submit" class="btn btn-warning">Insertar</button>
  		</form>  
  		
  		
  		<form action="DenomAdminServlet" method="post" class="row g-3 needs-validation mt-3" novalidate>
		<input type="hidden" name="op" value="editar" />
	
	    	<label for="Id" class="form-label">Id</label>
	    	<input type="number" class="form-control" id="id" name="id" required >
	    	<div class="invalid-feedback">
		     		Introduzca el id de la Denominacion a editar.
		  		</div>
	    	<label for="Denominacion" class="form-label">Denominacion</label>
	    	<input type="text" class="form-control" id="denominacion" name="denominacion" required >
				<div class="invalid-feedback">
		     		Introduzca la Denominacion.
		  		</div>
	  		
  			<button type="submit" class="btn btn-primary">Editar</button>
  		</form> 
  		
  		<form action="DenomAdminServlet" method="post" class="row g-3 needs-validation mt-3" novalidate>
		<input type="hidden" name="op" value="borrar" />
	
	    	<label for="Id" class="form-label">Id</label>
	    	<input type="number" class="form-control" id="id" name="id" required >
	    	<div class="invalid-feedback">
		     		Introduzca el id de la Denominacion a borrar.
		  		</div>
	    	
	  		
  			<button type="submit" class="btn btn-danger">Borrar</button>
  		</form> 
  		 

	</div>
</div>
</div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
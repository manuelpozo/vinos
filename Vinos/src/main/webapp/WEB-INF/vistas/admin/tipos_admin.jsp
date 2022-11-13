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
						<th>Tipo</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${tiposlista}" var="t">
						<tr>
							<th>${t.id}</th>
							<td>${t.tipo}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>Id</td>
						<td>Tipo</td>
					</tr>
				</tfoot>
			</table>
		</div>
	  <div class="col-4 mt-3">
		<!-- <c:if test="${texto != null}">
			<div class="alert alert-info alert-dismissible fade show"
				role="alert">
				${texto}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
			</div>
			
		</c:if>
		-->
	

		<form action="TiposAdminServlet" method="post" class="row g-3 needs-validation " novalidate>
		<input type="hidden" name="op" value="insertar" />
	<!-- 		<div class="col-md-4 ps-4 mt-3"> -->
	    	<label for="Tipo" class="form-label">Tipo</label>
	    	<input type="text" class="form-control" id="tipo" name="tipo" required >
				<div class="invalid-feedback">
		     		Introduzca el tipo de vino.
		  		</div>
	  		
  			<!--   	</div>-->
  			<button type="submit" class="btn btn-warning">Insertar</button>
  		</form>  
  		
  		
  		<form action="TiposAdminServlet" method="post" class="row g-3 needs-validation mt-3" novalidate>
		<input type="hidden" name="op" value="editar" />
	
	    	<label for="Id" class="form-label">Id</label>
	    	<input type="number" class="form-control" id="id" name="id" required >
	    	<div class="invalid-feedback">
		     		Introduzca el id del tipo a editar.
		  		</div>
	    	<label for="Tipo" class="form-label">Tipo</label>
	    	<input type="text" class="form-control" id="tipo" name="tipo" required >
				<div class="invalid-feedback">
		     		Introduzca el tipo de vino.
		  		</div>
	  		
  			<button type="submit" class="btn btn-primary">Editar</button>
  		</form> 
  		
  		<form action="TiposAdminServlet" method="post" class="row g-3 needs-validation mt-3" novalidate>
		<input type="hidden" name="op" value="borrar" />
	
	    	<label for="Id" class="form-label">Id</label>
	    	<input type="number" class="form-control" id="id" name="id" required >
	    	<div class="invalid-feedback">
		     		Introduzca el id del tipo a borrar.
		  		</div>
	    	
	  		
  			<button type="submit" class="btn btn-danger">Borrar</button>
  		</form> 
  		 

	</div>
</div>
</div>



<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
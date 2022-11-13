<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera_admin.jsp"%>

<c:if test="${op == 'borrar'}">
		
		<div class="alert alert-danger alert-dismissible fade show mt-3" role="alert" >
  <strong>Cuidado; </strong>Esta en el formulario de borrar vinos.
  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>

	</c:if>


<form action="VinosAdminServlet" method="post" class="row g-3 needs-validation mt-5" novalidate>

	<input type="hidden" name="op" value="${op}" />
	
	<div class="col-md-2 ">
		<label for="id" class="form-label">Id</label>
		<input type="number" class="form-control" readonly  id="id" name="id"
				value="${vino.id}">
  	</div>
  		
  	<div class="col-md-7  ">
    <label for="marca" class="form-label">Marca</label>
    <input type="text" class="form-control" id="marca" name="marca" value="${vino.marca}"
    	<c:choose>
		<c:when test="${op != 'borrar'}">required</c:when>
		<c:when test="${op == 'borrar'}">readonly</c:when>
		</c:choose>
	>
    
    <div class="invalid-feedback">
      Por favor, indique la marca.
    </div>
	</div>
  
  
  	<div class="col-md-2  ">
    <label for="cosecha" class="form-label">Cosecha</label>
    <input type="number" class="form-control" id="cosecha" name="cosecha"  value="${vino.cosecha }"
    	<c:choose>
		<c:when test="${op != 'borrar'}">required</c:when>
		<c:when test="${op == 'borrar'}">readonly</c:when>
		</c:choose>
	>
      <div class="invalid-feedback">
        Proporcione un año.
      </div>
    </div> 
  
	
<div class="col-md-2  ">
    <label for="tipo" class="form-label">Tipo</label>
    
    <c:choose>
		<c:when test="${op != 'borrar'}">
    	<select class="form-select" id="tipo" name="tipo" required>
    		<option selected   value="${vino.tipo}">${vino.tipo}</option>
      		<c:forEach items="${listatipos}" var="t">
      			<option value="${t.tipo}">${t.tipo}</option>
			</c:forEach>
	 	</select>
	 	</c:when>
		<c:when test="${op == 'borrar'}">
		<input type="text" class="form-control" id="tipo" name="tipo"value="${vino.tipo}" readonly>
		
		</c:when>
	</c:choose>
		
    <div class="invalid-feedback">
      Por favor, elija  el tipo de vino
    </div>
</div>
  
  <div class="col-md-7 ">
    <label for="bodega" class="form-label">Bodega</label>
  <input type="text" class="form-control" id="bodega" name="bodega" value="${vino.bodega}" <c:choose>
				<c:when test="${op != 'borrar'}">required</c:when>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
	>
      <div class="invalid-feedback">
        Proporcione una Bodega.
      </div>
    </div>
    
    <div class="col-md-2  ">
    <label for="denominacion" class="form-label">Denominacion</label>
    
 	 <c:choose>
		<c:when test="${op != 'borrar'}">
    	<select class="form-select" id="denominacion" name="denominacion" required>
    		<option selected   value="${vino.denominacion}">${vino.denominacion}</option>
      		<c:forEach items="${listadenominaciones}" var="d">
      			<option value="${d.denominacion}">${d.denominacion}</option>
			</c:forEach>
	 	</select>
	 	</c:when>
		<c:when test="${op == 'borrar'}">
		<input type="text" class="form-control" id="denominacion" name="denominacion"value="${vino.denominacion}" readonly>
		
		</c:when>
	</c:choose>
    <div class="invalid-feedback">
      Por favor, elija la denominacion del vino
    </div>
</div>


  <div class="col-md-3  mt-5">
    <label for="precio" class="form-label">Precio</label>
    <input type="number" class="form-control" id="precio" name ="precio" value="${vino.precio}" <c:choose>
				<c:when test="${op != 'borrar'}">required</c:when>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
	>
    <div class="invalid-feedback">
      Introduzca el precio del vino.
    </div>
  </div>
  
  <div class="col-md-3  mt-5">
    <label for="stock" class="form-label">Stock</label>
    <input type="number" class="form-control" id="stock" name ="stock" value="${vino.stock}"<c:choose>
				<c:when test="${op != 'borrar'}">required</c:when>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
	>
    <div class="invalid-feedback">
      Introduzca el stock del vino.
    </div>
  </div>
  
  <div class="col-md-2  mt-5">
    <label for="se_vende" class="form-label">Se vende</label>
    	<c:choose>
			<c:when test="${op != 'borrar'}">
				<select class="form-select" id="se_vende" name="se_vende" required>
					<option selected  disabled value="${vino.se_vende}">${vino.se_vende}</option>
       				<option value="si">Si</option>
  					<option value="no">No</option>
  				</select>
    		</c:when>
    		
    		<c:when test="${op == 'borrar'}">
				<input type="text" class="form-control" id="se_vende" name="se_vende"value="${vino.se_vende}" readonly>
			</c:when>
    	</c:choose>
	 <div class="invalid-feedback">
      Elija si esta el vino en venta.
    </div>
  </div>
  
 <div class="col-md-3  mt-5">
    <label for="localizacion" class="form-label">Localizacion</label>
    <input type="text" class="form-control" id="localizacion" name ="localizacion" value="${vino.localizacion}"<c:choose>
				<c:when test="${op != 'borrar'}">required</c:when>
				<c:when test="${op == 'borrar'}">readonly</c:when>
			</c:choose>
	>  
	 <div class="invalid-feedback">
      Introduzca el lugar de almacenamiento.
    </div>
  </div>
  


<div class="col-12 mt-5 mb-3 ">
		
		<button type="submit" <c:choose>
				
				<c:when test="${op != 'borrar'}">class="btn btn-primary"</c:when>
				<c:when test="${op == 'borrar'}">class="btn btn-danger"</c:when>
			</c:choose>
			>
			
			
			<c:choose>
				
				<c:when test="${op == 'editar'}">Editar</c:when>
				<c:when test="${op == 'borrar'}">Borrar</c:when>
							
			</c:choose>
			</button>
			<a href="VinosTodosServlet" class="btn btn-secondary ms-3">Cancelar</a>
		
	</div>

</form>
	

	
<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
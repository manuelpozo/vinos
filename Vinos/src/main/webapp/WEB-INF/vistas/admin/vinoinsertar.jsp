<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/vistas/includes/cabecera_admin.jsp"%>

<form action="VinoInsertarServlet" method="post" class="row g-3 needs-validation " novalidate>
  
  
  		<input type="hidden" name="op" value="${op}" />
  		
	<div class="col-md-1 mt-5">
		<label for="id" class="form-label">Id</label>
		<input type="number" class="form-control" readonly  id="id" name="id"
				value="${vino.id}">
  		</div>
  	
  	

  <div class="col-md-6 mt-5 ">
    <label for="marca" class="form-label">Marca</label>
    <input type="text" class="form-control" id="marca" name="marca" required>
   <div class="invalid-feedback">
      Por favor, seleccione la marca
    </div>
</div>
  
 <div class="col-md-2  mt-5">
    <label for="cosecha" class="form-label">Cosecha</label>
    <input type="number" class="form-control" id="cosecha" name="cosecha"  required>
      <div class="invalid-feedback">
        Proporcione un año.
      </div>
    </div> 
  
  <div class="col-md-3  mt-5">
    <label for="tipo" class="form-label">Tipo</label>
    <select class="form-select" id="tipo" name="tipo" required>
    	<option selected  disabled value="">Seleccione un tipo de vino</option>
      		<c:forEach items="${tiposlista}" var="t">
      			<option value="${t.tipo}">${t.tipo}</option>
			</c:forEach>
	 </select>
    <div class="invalid-feedback">
      Por favor, elija  el tipo de vino
    </div>
</div>
  
  <div class="col-md-8  mt-5">
    <label for="bodega" class="form-label">Bodega</label>
    <input type="text" class="form-control" id="bodega" name="bodega" value="${incidencia.descripcion}" required>
      <div class="invalid-feedback">
        Proporcione una Bodega.
      </div>
    </div>
    
  
    
    
    <div class="col-md-4 mt-5 ">
    <label for="denominacion" class="form-label">Denominacion</label>
    <select class="form-select" id="denominacion" name="denominacion" required>
    	<option selected  disabled value="">Seleccione una denominacion</option>
      		<c:forEach items="${denomlista}" var="d">
      			<option value="${d.denominacion}">${d.denominacion}</option>
			</c:forEach>
	 </select>
    <div class="invalid-feedback">
      Por favor, elija la denominacion del vino
    </div>
</div>


   
  
  <div class="col-md-3  mt-5">
    <label for="precio" class="form-label">Precio</label>
    <input type="number" class="form-control" id="precio" name ="precio" required>
    <div class="invalid-feedback">
      Introduzca el precio del vino.
    </div>
  </div>
  
  <div class="col-md-3  mt-5">
    <label for="stock" class="form-label">Stock</label>
    <input type="number" class="form-control" id="stock" name ="stock" required>
    <div class="invalid-feedback">
      Introduzca el stock del vino.
    </div>
  </div>
  
  <div class="col-md-2  mt-5">
    <label for="se_vende" class="form-label">Se vende</label>
    
			<select class="form-select" id="se_vende" name="se_vende" required>
			<option selected  disabled value="">En venta?</option>
       		<option value="si">Si</option>
  			<option value="no">No</option>
  			
    		</select>
	 <div class="invalid-feedback">
      Elija si esta el vino en venta.
    </div>
  </div>
  
  
  
 <div class="col-md-4  mt-5">
    <label for="localizacion" class="form-label">Localizacion</label>
    <input type="text" class="form-control" id="localizacion" name ="localizacion"required>   
	 <div class="invalid-feedback">
      Introduzca el lugar de almacenamiento.
    </div>
  	</div>

<div class="col-12 mt-5 mb-3 ">
		
		<button type="submit" class="btn btn-primary">Añadir
	
			</button>
			<a href="VinosTodosServlet" class="btn btn-secondary ms-3">Cancelar</a>
		</div>
	


</form>
	


<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
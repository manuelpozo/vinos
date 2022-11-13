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
			<th>Email</th>
			<th>Password</th>
			<th>Rol</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usuarioslista}" var="u">
			<tr>
				<th>${u.id}</th>
				<td>${u.email}</td>
				<td>${u.password}</td>
				<td>${u.rol}</td>
				
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td>Id</td>
			<td>Email</td>
			<td>Password</td>
			<td>Rol</td>
			
		</tr>
	</tfoot>
</table>

</div>

<div class="col-4 mt-3">

<form action="UsuariosAdminServlet" method="post" class="row g-3 needs-validation " novalidate>
		<input type="hidden" name="op" value="insertar" />
	
	    	<label for="Email" class="form-label">Email</label>
	    	<input type="email" class="form-control" id="email" name="email" required >
				<div class="invalid-feedback">
		     		Introduzca el email.
		  		</div>
	  		
  			<label for="Password" class="form-label">Password</label>
	    	<input type="text" class="form-control" id="password" name="password" required >
				<div class="invalid-feedback">
		     		Introduzca el password.
		  		</div>
		  	<label for="Rol" class="form-label">Rol</label>
	    	<select class="form-select" id="rol" name="rol" required>
    		 	<option selected  disabled value="">Seleccione un rol</option>
      		 	<option value="admin">Administrador</option>
  				<option value="usuario">Usuario</option>
  			</select>
    			<div class="invalid-feedback">
     		 	Selecciona un rol.
    			</div>
  			<button type="submit" class="btn btn-warning">Insertar</button>
  		</form>  
  		
  		
  		<form action="UsuariosAdminServlet" method="post" class="row g-3 needs-validation mt-3" novalidate>
		<input type="hidden" name="op" value="editar" />
	
	    	<label for="Id" class="form-label">Id</label>
	    	<input type="number" class="form-control" id="id" name="id" required >
	    		<div class="invalid-feedback">
		     		Introduzca el id del Usuario a editar.
		  		</div>
	    	<label for="Email" class="form-label">Email</label>
	    	<input type="email" class="form-control" id="email" name="email" required >
				<div class="invalid-feedback">
		     		Introduzca el email del Usuario.
		  		</div>
	  		<label for="Password" class="form-label">Password</label>
	    	<input type="text" class="form-control" id="password" name="password" required >
				<div class="invalid-feedback">
		     		Introduzca el password del usuario.
		  		</div>
		  		<label for="Rol" class="form-label">Rol</label>
	    	<select class="form-select" id="rol" name="rol" required>
    	 	<option selected  disabled value="">Seleccione un rol</option>
       		<option value="admin">Administrador</option>
  			<option value="usuario">Usuario</option>
  		
    		</select>
   		 <div class="invalid-feedback">
     		 Selecciona un rol.
     		 </div>
  			<button type="submit" class="btn btn-primary">Editar</button>
  		</form> 
  		
  		<form action="UsuariosAdminServlet" method="post" class="row g-3 needs-validation mt-3" novalidate>
		<input type="hidden" name="op" value="borrar" />
	
	    	<label for="Id" class="form-label">Id</label>
	    	<input type="number" class="form-control" id="id" name="id" required >
	    	<div class="invalid-feedback">
		     		Introduzca el id del usuario a borrar.
		  		</div>
	    	
	  		
  			<button type="submit" class="btn btn-danger">Borrar</button>
  		</form> 
  		 
		<br>
	</div>
</div>
</div>

<%@ include file="/WEB-INF/vistas/includes/pie.jsp"%>
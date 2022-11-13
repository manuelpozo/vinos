package com.manuel.controladores;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.manuel.acceso_datos.AccesoDatos;
import com.manuel.modelos.Tipo;



@WebServlet("/TiposAdminServlet")
public class TiposAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccesoDatos ad = new AccesoDatos();
		ArrayList <Tipo> tiposlista =ad.tiposTodos() ;
		System.out.println(tiposlista);
		request.setAttribute("tiposlista",tiposlista);
	
		request .getRequestDispatcher("WEB-INF/vistas/admin/tipos_admin.jsp").forward(request, response);
		
		
		
	}
	
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String tipo= request.getParameter("tipo");
		
		Long idLong=null;
		if(id != null && id.trim().length() > 0) {
			idLong = Long.parseLong(id);}
			
		Tipo tipoob =null;
		if(!op.equals("insertar")) {
			tipoob = new Tipo(idLong, tipo);
		}
		else {tipoob =new Tipo(null,tipo);}
		String texto = null;
		
switch(op) {
		
		case "borrar":
			AccesoDatos ad =new AccesoDatos();
			ad.borrarTipo(idLong);
			texto = "Se ha borrado correctamente el tipo de id " +idLong; 
			break;
		case "editar":
			AccesoDatos ad1 =new AccesoDatos();
			ad1.modificar(tipoob);
			texto = "Se ha modificado correctamente el tipo  " + tipoob.getId() + " como " + tipoob.getTipo();
			break;
		case "insertar":
			AccesoDatos ad2 =new AccesoDatos();
			ad2.insertar(tipoob);
			texto = "Se ha añadido correctamente el tipo  " + tipoob.getId() + " como " + tipoob.getTipo();
			break;
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}
		request.setAttribute("texto", texto);
		doGet(request, response);
		//request.getRequestDispatcher("WEB-INF/vistas/admin/tipos_admin.jsp").forward(request, response);
	
	
	}	

}

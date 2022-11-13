package com.manuel.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manuel.acceso_datos.AccesoDatos;
import com.manuel.modelos.Denominacion;



@WebServlet("/DenomAdminServlet")
public class DenomAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccesoDatos ad = new AccesoDatos();
		ArrayList <Denominacion> denominacioneslista =ad.denomTodas() ;
		System.out.println(denominacioneslista);
		request.setAttribute("denominacioneslista",denominacioneslista);
	
		request .getRequestDispatcher("WEB-INF/vistas/admin/denom_admin.jsp").forward(request, response);	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String denominacion= request.getParameter("denominacion");
		
		Long idLong=null;
		if(id != null && id.trim().length() > 0) {
			idLong = Long.parseLong(id);}
			
		Denominacion denomob =null;

		if(!op.equals("insertar")) {
			denomob = new Denominacion(idLong, denominacion);
		}
		else {denomob =new Denominacion(null,denominacion);}
		String texto = null;
		
switch(op) {
		
		case "borrar":
			AccesoDatos ad =new AccesoDatos();
			ad.borrarDenominacion(idLong);;
			texto = "Se ha borrado correctamente la Denominacion de id " +idLong; 
			break;
		case "editar":
			AccesoDatos ad1 =new AccesoDatos();
			ad1.editar(denomob);
			texto = "Se ha modificado correctamente la Denominacion  " + denomob.getId() + " como " + denomob.getDenominacion();
			break;
		case "insertar":
			AccesoDatos ad2 =new AccesoDatos();
			ad2.insertar(denomob);
			texto = "Se ha añadido correctamente la Denominacion  " + denomob.getId() + " como " + denomob.getDenominacion();
			break;
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}
		request.setAttribute("texto", texto);
		doGet(request, response);
		//request.getRequestDispatcher("WEB-INF/vistas/admin/tipos_admin.jsp").forward(request, response);
	
	
	}	

}

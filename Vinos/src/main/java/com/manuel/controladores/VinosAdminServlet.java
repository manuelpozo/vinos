package com.manuel.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manuel.acceso_datos.AccesoDatos;
import com.manuel.modelos.Vino;


@WebServlet("/VinosAdminServlet")
public class VinosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		
		Long idLong =null;
		
		if(id != null) {
			idLong = Long.parseLong(id);
		}
		
		request.setAttribute("op", op);
		AccesoDatos ad= new AccesoDatos();
		request.setAttribute("vino", ad.vinoPorId(idLong));
		request.setAttribute("listatipos", ad.tiposTodos());
		request.setAttribute("listadenominaciones", ad.denomTodas());
		request.getRequestDispatcher("WEB-INF/vistas/admin/vinos_admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = request.getParameter("op");
		Long id = Long.parseLong(request.getParameter("id"));
		String marca =request.getParameter("marca");
		String bodega =request.getParameter("bodega");
		Long cosecha =Long.parseLong(request.getParameter("cosecha")); 
		String denominacion =request.getParameter("denominacion");
		String tipo =request.getParameter("tipo");
		Long precio =Long.parseLong(request.getParameter("precio"));
		Long stock =Long.parseLong(request.getParameter("stock"));
		String localizacion =request.getParameter("localizacion");
		String se_vende = request.getParameter("se_vende");
		Vino vino= new Vino(id,marca,bodega,cosecha,denominacion,tipo, precio, stock,localizacion,se_vende);
		System.out.println(vino);
		String texto = null;
		
		
		
		
switch(op) {
		
		case "borrar":
			AccesoDatos ad =new AccesoDatos();
			ad.borrarVino(id);

			texto = "Se ha borrado correctamente el vino de id " +id; 
			break;
		case "editar":
			AccesoDatos ad1 =new AccesoDatos();
			ad1.editar(vino);
			texto = "Se ha modificado correctamente el tipo  " + vino.getMarca() + " del " + vino.getCosecha();
			break;
		
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}
		request.setAttribute("texto", texto);
		request.getRequestDispatcher("VinosTodosServlet").forward(request, response);
		
	
	}	

}



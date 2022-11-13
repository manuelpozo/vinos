package com.manuel.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manuel.acceso_datos.AccesoDatos;
import com.manuel.modelos.Vino;



@WebServlet("/VinoInsertarServlet")
public class VinoInsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	AccesoDatos ad = new AccesoDatos();
	request.setAttribute("denomlista", ad.denomTodas());
	request.setAttribute("tiposlista", ad.tiposTodos());
	request.getRequestDispatcher("WEB-INF/vistas/admin/vinoinsertar.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getParameter("bodega"));
		System.out.println(request.getParameter("cosecha"));
		System.out.println((request.getParameter("denominacion")));
		
		System.out.println((request.getParameter("tipo")));
		System.out.println((request.getParameter("precio")));
		System.out.println(Integer.parseInt(request.getParameter("stock")));
		
		
		String marca =request.getParameter("marca");
		String bodega =request.getParameter("bodega");
		Long cosecha =Long.parseLong(request.getParameter("cosecha")); 
		String denominacion =request.getParameter("denominacion");
		String tipo =request.getParameter("tipo");
		Long precio =Long.parseLong(request.getParameter("precio"));
		Long stock =Long.parseLong(request.getParameter("stock"));
		String localizacion =request.getParameter("localizacion");
		String se_vende = request.getParameter("se_vende");
		Long id_vino = null;
		Vino vino= new Vino(id_vino,marca,bodega,cosecha,denominacion,tipo, precio, stock,localizacion,se_vende);
		System.out.println(vino);
		String texto = null;
		AccesoDatos ad = new AccesoDatos();
		ad.insertar(vino);
		
		texto = "Se ha añadido correctamente el vino " + vino.getMarca() + " cosecha del "+ vino.getCosecha();
		request.setAttribute("texto", texto);
		request.getRequestDispatcher("VinosTodosServlet").forward(request, response);
		
		
		
	}

}

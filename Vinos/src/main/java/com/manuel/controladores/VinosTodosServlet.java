package com.manuel.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manuel.acceso_datos.AccesoDatos;
import com.manuel.modelos.Usuario;
import com.manuel.modelos.Vino;



@WebServlet("/VinosTodosServlet")
public class VinosTodosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario.getRol().equals("admin")) {
			AccesoDatos ad = new AccesoDatos();
			ArrayList <Vino> vinoslista =ad.vinosTodos() ;
			request.setAttribute("vinoslista",vinoslista);
			request .getRequestDispatcher("WEB-INF/vistas/admin/vinos_lista.jsp").forward(request, response);
		}
		if (usuario.getRol().equals("amigo")) 
			{AccesoDatos ad = new AccesoDatos();
			ArrayList <Vino> vinoslista =ad.vinosTodos() ;
			request.setAttribute("vinoslista",vinoslista);
			request .getRequestDispatcher("WEB-INF/vistas/amigos/vinosamigos.jsp").forward(request, response);
			}
		else {
			AccesoDatos ad = new AccesoDatos();
			ArrayList <Vino> vinoslistacliente =ad.vinosTodosCliente() ;
			request.setAttribute("vinoslistacliente",vinoslistacliente);
			request .getRequestDispatcher("WEB-INF/vistas/vinoscliente.jsp").forward(request, response);
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

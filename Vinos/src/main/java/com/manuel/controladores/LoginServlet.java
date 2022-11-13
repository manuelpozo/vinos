package com.manuel.controladores;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manuel.acceso_datos.AccesoDatos;

import com.manuel.modelos.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/vistas/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Usuario usuario = new Usuario(null, email,password,null);
		System.out.println(usuario);
		Usuario usuarioValidado =validarUsuario(usuario);
		
		
		if(usuarioValidado != null) {
			request.getSession().setAttribute("usuario", usuarioValidado);
			response.sendRedirect(request.getContextPath() + "/VinosTodosServlet");}
			else {
				request.setAttribute("error", "El usuario o la contraseña son incorrectos");
				request.getRequestDispatcher("WEB-INF/vistas/login.jsp").forward(request, response);
			}	//	if(usuarioRegistrado.getRol().equals("admin")) {
		//	request.getRequestDispatcher("/WEB-INF/vistas/admin/vinos_admin.jsp").forward(request, response);
			//	response.sendRedirect("vinos");
		//} 
	//	else {
			//	request.getRequestDispatcher("/WEB-INF/vistas/vinosusuario.jsp").forward(request, response);
			//	//response.sendRedirect("/WEB-INF/vistas/vinosusuario.jsp");
		//	}
		//	}
			
		}
	
	private Usuario validarUsuario(Usuario usuario) {
		Usuario validado = null;
		AccesoDatos ad = new AccesoDatos();
		validado = ad.buscarEmPw(usuario);
		System.out.println(validado);
		return validado;
	}
	

}
	



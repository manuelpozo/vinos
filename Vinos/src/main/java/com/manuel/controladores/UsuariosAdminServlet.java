package com.manuel.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manuel.acceso_datos.AccesoDatos;
import com.manuel.modelos.Usuario;


@WebServlet("/UsuariosAdminServlet")
public class UsuariosAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccesoDatos ad =new AccesoDatos();
		ArrayList <Usuario> usuariosLista =ad.usuariosTodos();
		request.setAttribute("usuarioslista", usuariosLista);
		request.getRequestDispatcher("WEB-INF/vistas/admin/usuarios_admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String rol= request.getParameter("rol");
		
		Long idLong=null;
		if(id != null && id.trim().length() > 0) {
			idLong = Long.parseLong(id);}
			
		Usuario usuarioob =null;
		if(!op.equals("insertar")) {
			usuarioob = new Usuario(idLong, email,password,rol);
		}
		else {usuarioob =new Usuario(null,email,password,rol);}
		String texto = null;
		
switch(op) {
		
		case "borrar":
			AccesoDatos ad =new AccesoDatos();
			ad.borrarUsuario(idLong);
			texto = "Se ha borrado correctamente el usuario de id " +idLong; 
			break;
		case "editar":
			AccesoDatos ad1 =new AccesoDatos();
			ad1.editar(usuarioob);
			texto = "Se ha modificado correctamente el usuario  " + usuarioob.getId() + " como " + usuarioob.getEmail();
			break;
		case "insertar":
			AccesoDatos ad2 =new AccesoDatos();
			ad2.insertar(usuarioob);
			texto = "Se ha añadido correctamente el tipo  " + usuarioob.getId() + " como " + usuarioob.getEmail();
			break;
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}
		request.setAttribute("texto", texto);
		doGet(request, response);
		//request.getRequestDispatcher("WEB-INF/vistas/admin/tipos_admin.jsp").forward(request, response);
	
	
	}

}

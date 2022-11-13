package com.manuel.acceso_datos;

import java.sql.Connection;
import java.util.ArrayList;

import com.manuel.modelos.Denominacion;
import com.manuel.modelos.Tipo;
import com.manuel.modelos.Usuario;
import com.manuel.modelos.Vino;


public interface I_Conexion {
	
	String USER="root";
	String PASS="admin";
	String DB="bodega";
	String DRIVER="com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + DB + "?useSSL=false&noAccessToProcedureBodies=true";
	
	//private static final String SQL_SELECT = "select vinos.id,vinos.marca,vinos.bodega,vinos.cosecha,denominaciones.denominacion,"
		//		+ "tipos.tipo,vinos.precio,vinos.stock,vinos.localizacion from vinos inner join denominaciones on denominaciones.id=vinos.denominacion INNER join tipos on tipos.id=vinos.tipo";
		 String VINOS_TODOS ="call vinos_todos()";
		 String VINOS_TODOS_CLIENTE="call vinos_todos_cliente()";
		 //String VINO_INSERTAR ="call vino_insertar(?,?,?,?,?,?,?,?)";
		 String VINO_INSERTAR ="INSERT INTO vinos(marca,bodega,cosecha,denominacion,tipo,precio,stock,localizacion,se_vende) VALUES (?,?,?,?,?,?,?,?,?)";
		 //String VINO_EDITAR ="call vino_modificar(?;?;?;?;?;?;?;?;?)";
		 String VINO_EDITAR= "UPDATE vinos SET marca=?, bodega =?, cosecha=?, denominacion=?, tipo=?, precio=?, stock=?, localizacion=?, se_vende=? WHERE id=?";
		 String VINO_BORRAR = "call vino_borrar(?)";
		 //String VINO_POR_ID ="call vino_por_id(?)";
		 String VINO_POR_ID ="SELECT * FROM vinos WHERE id=?";
		 
		 String USUARIO_POR_EM_PW = "select * from usuarios where email=? and password=?";
		 //String USUARIO_POR_EM_PW = "call usuario_buscar_email_pw(?,?)";
		 String USUARIOS_TODOS = "call usuarios_todos";
		 String USUARIO_BORRAR = "call usuario_borrar (?)";
		 String USUARIO_INSERTAR = "INSERT INTO usuarios (email,password,rol) VALUES(?,?,?)";
		 String USUARIO_EDITAR ="UPDATE usuarios SET email=?,password=?,rol=? WHERE id=?";
		 String USUARIO_POR_ID = "SELECT * FROM usuarios WHERE id=?";
		 
		 String TIPOS_TODOS ="call tipos_todos()";
		 //String TIPO_INSERTAR ="call tipo_insertar(?)";
		 String TIPO_INSERTAR ="INSERT INTO tipos (tipo) VALUES(?)";
		 
		 //String TIPO_EDITAR ="call tipo_modificar(?;?)";
		 String TIPO_EDITAR ="UPDATE tipos SET tipo=? Where id=?";
		 String TIPO_BORRAR = "call tipo_borrar(?)";
		 String TIPO_POR_ID ="call tipo_por_id(?)";
		
		 String DEN_TODOS ="call den_todas()";
		 //String DEN_INSERTAR ="call den_insertar(?)";
		 String DEN_INSERTAR ="INSERT INTO denominaciones (denominacion) VALUES(?)";
		 //String DEN_EDITAR ="call den_modificar(?;?)";
		 String DEN_EDITAR ="UPDATE denominaciones SET denominacion=? WHERE id=?";
		 String DEN_BORRAR = "call den_borrar(?)";
		 String DEN_POR_ID ="call den_por_id(?)";
		 
		 
		 	Connection conectar();
			void desconectar(Connection con);
			
			Vino vinoPorId(Long id);
			ArrayList<Vino> vinosTodos();
			ArrayList<Vino> vinosTodosCliente();
			Vino insertar(Vino vino);
			Vino editar(Vino vino);
			void borrarVino(Long id);
			
			Usuario usuarioPorId(Long id);
			Usuario buscarEmPw (Usuario usuario);
			ArrayList<Usuario> usuariosTodos();
			Usuario insertar(Usuario usuario);
			Usuario editar(Usuario usuario);
			void borrarUsuario(Long id);
			
			Denominacion denomPorId(Long id);
			ArrayList<Denominacion> denomTodas();
			Denominacion insertar(Denominacion denominacion);
			Denominacion editar(Denominacion denominacion);
			void borrarDenominacion(Long id);
			
			Tipo tipoPorId(Long id);
			ArrayList<Tipo> tiposTodos();
			Tipo insertar(Tipo tipo);
			Tipo modificar(Tipo tipo);
			void borrarTipo(Long id);
}

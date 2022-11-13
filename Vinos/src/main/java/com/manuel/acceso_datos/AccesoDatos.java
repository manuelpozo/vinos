package com.manuel.acceso_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.manuel.modelos.Denominacion;
import com.manuel.modelos.Tipo;
import com.manuel.modelos.Usuario;
import com.manuel.modelos.Vino;


public class AccesoDatos implements I_Conexion{

	@Override
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USER, PASS);
		} catch (ClassNotFoundException e) {
			;
			System.out.println("accesodatos.conectar(): NO SE ENCONTRO EL mysql-connector-java.jar");
			return null;
		} catch (SQLException e) {

			System.out.println("accesodatos.conectar(): NO SE PUDO CONECTAR A LA BD");
			System.out.println("REVISA EL USUARIO, CONTRASEÑA Y EL NOMBRE Y CONEXION A LA BD");
			return null;
		} catch (Exception e) {

			System.out.println("accesodatos.conectar(): ERROR DESCONOCIDO");
			return null;
		}
		System.out.println("accesodatos.conectar(): CONEXION ESTABLECIDA");
		return con;
	}

	@Override
	public void desconectar(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la desconexion", e);
	}
		
	}

	@Override
	public Vino vinoPorId(Long id) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(VINO_POR_ID);) {
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			Vino vino = null;

			if (rs.next()) {
				vino = new Vino(rs.getLong("id"), rs.getString("marca"),
						rs.getString("bodega"),rs.getLong("cosecha"),rs.getString("denominacion"),
						rs.getString("tipo"),rs.getLong("precio"), rs.getLong("stock"),rs.getString("Localizacion"),rs.getString("se_vende"));
			}
			desconectar(con);
			return vino;
			
		} catch (Exception e) {
			throw new AccesoDatosException("error al obtener vino por id",e);
		}			
	}

	@Override
	public ArrayList<Vino> vinosTodos() {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(VINOS_TODOS);
				ResultSet rs = ps.executeQuery()) {

			ArrayList<Vino> vinoslista = new ArrayList<>();

			while (rs.next()) {
				vinoslista.add(new Vino(rs.getLong("id"), rs.getString("marca"),
						rs.getString("bodega"),rs.getLong("cosecha"),rs.getString("denominacion"),
						rs.getString("tipo"),rs.getLong("precio"), rs.getLong("stock"),rs.getString("Localizacion"),rs.getString("se_vende")));
				
			}
			desconectar(con);
			System.out.println(vinoslista);
			return vinoslista;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los vinos", e);
		}
	}
	@Override
	public ArrayList<Vino> vinosTodosCliente() {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(VINOS_TODOS_CLIENTE);
				ResultSet rs = ps.executeQuery()) {

			ArrayList<Vino> vinoslistacliente = new ArrayList<>();

			while (rs.next()) {
				vinoslistacliente.add(new Vino(rs.getLong("id"), rs.getString("marca"),
						rs.getString("bodega"),rs.getLong("cosecha"),rs.getString("denominacion"),
						rs.getString("tipo"),rs.getLong("precio"), rs.getLong("stock"),rs.getString("localizacion"),rs.getString("se_vende")));
				
			}
			desconectar(con);
			System.out.println(vinoslistacliente);
			return vinoslistacliente;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los vinos", e);
		}
	}
	@Override
	public Vino insertar(Vino vino) {
		try ( Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(VINO_INSERTAR, Statement.RETURN_GENERATED_KEYS);) {
			System.out.println(vino);
			ps.setString(1, vino.getMarca());
			ps.setString(2, vino.getBodega());
			ps.setLong(3, vino.getCosecha());
			ps.setString(4, vino.getDenominacion());
			ps.setString(5, vino.getTipo());
			ps.setLong(6, vino.getPrecio());
			ps.setLong(7, vino.getStock());
			ps.setString(8, vino.getLocalizacion());
			ps.setString(9, vino.getSe_vende());
			ps.executeUpdate();
			
			//ResultSet rs =ps.executeQuery();
			ResultSet rs = ps.getGeneratedKeys();
			
			rs.next();
			
			
			vino.setId(rs.getLong(1));
			desconectar(con);
			return vino;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de insertar vino ha fallado", e);
		}
	}

	@Override
	public Vino editar(Vino vino) {
try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(VINO_EDITAR);) {
			
	ps.setString(1, vino.getMarca());
	ps.setString(2, vino.getBodega());
	ps.setLong(3, vino.getCosecha());
	ps.setString(4, vino.getDenominacion());
	ps.setString(5, vino.getTipo());
	ps.setLong(6, vino.getPrecio());
	ps.setLong(7, vino.getStock());
	ps.setString(8, vino.getLocalizacion());
	ps.setString(9, vino.getSe_vende());
			ps.setLong(10, vino.getId());
			
			ps.executeUpdate();
			desconectar(con);
			return vino;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de modificar vino ha fallado", e);
		}
	}

	@Override
	public void borrarVino(Long id) {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(VINO_BORRAR);) {
				ps.setLong(1, id);

				ps.executeUpdate();
				desconectar(con);
			} catch (Exception e) {
				throw new AccesoDatosException("La operacion de borrar vino ha fallado", e);
			}
		
	}

	@Override
	public Usuario usuarioPorId(Long id) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(USUARIO_POR_ID);) {
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			Usuario usuario  = null;

			if (rs.next()) {
				usuario = new Usuario(rs.getLong("id"), rs.getString("email"),
						rs.getString("password"),rs.getString("rol"));
			}
			desconectar(con);
			return usuario;
			
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de obtener vino por id ha fallado", e);
		}
	}

	@Override
	public Usuario buscarEmPw(Usuario usuario) {
		try(Connection con = conectar(); 
			PreparedStatement ps =con.prepareStatement(USUARIO_POR_EM_PW);){
			ps.setString(1, usuario.getEmail());
			ps.setString(2, usuario.getPassword());
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setRol(rs.getString("rol"));
				desconectar (con);
				return usuario;
			}
			else {
				return null;
			}
			
		
		} catch (SQLException e) {
			throw new AccesoDatosException("La operacion de obtener usuario por email y pass ha fallado", e);
		} 
		
	}

	@Override
	public ArrayList<Usuario> usuariosTodos() {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(USUARIOS_TODOS);
				ResultSet rs = ps.executeQuery()) {

			ArrayList<Usuario> usuarioslista = new ArrayList<>();

			while (rs.next()) {
				usuarioslista.add(new Usuario(rs.getLong("id"), rs.getString("email"),
						rs.getString("password"),rs.getString("rol")));
				
			}
			desconectar(con);
			System.out.println(usuarioslista);
			return usuarioslista;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los usuarios", e);
		}
	}

	@Override
	public Usuario insertar(Usuario usuario) {
		try (Connection con = conectar();
				PreparedStatement ps =con.prepareStatement(USUARIO_INSERTAR,Statement.RETURN_GENERATED_KEYS);){
				ps.setString(1, usuario.getEmail());
				ps.setString(2, usuario.getPassword());
				ps.setString(3, usuario.getRol());
				
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				
				usuario.setId(rs.getLong(1));
				desconectar(con);
				return usuario;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("La operacion de insertar usuario ha fallado", e);
		}
	}

	@Override
	public Usuario editar(Usuario usuario) {
		try (Connection con = conectar();
				PreparedStatement ps =con.prepareStatement(USUARIO_EDITAR);){
				ps.setString(1, usuario.getEmail());
				ps.setString(2, usuario.getPassword());
				ps.setString(3,usuario.getRol());
				ps.setLong(4,usuario.getId());
				
				ps.executeUpdate();
				desconectar(con);
				
				return usuario;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de modificar usuario ha fallado", e);
		}
	}

	@Override
	public void borrarUsuario(Long idLong) {
		try(Connection con=conectar(); PreparedStatement ps =con.prepareStatement(USUARIO_BORRAR);){
			ps.setLong(1,  idLong);
			ps. executeUpdate();
			desconectar(con);
		} catch (SQLException e) {
			throw new AccesoDatosException("La operacion de borrar usuario ha fallado", e);
		}
		
	}

	@Override
	public Denominacion denomPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Denominacion> denomTodas() {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(DEN_TODOS);
				ResultSet rs = ps.executeQuery()) {

			ArrayList<Denominacion> denomlista = new ArrayList<>();

			while (rs.next()) {
				denomlista.add(new Denominacion(rs.getLong("id"), rs.getString("denominacion")));
				
			}
			desconectar(con);
			System.out.println(denomlista);
			return denomlista;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los tipos", e);
		}
	}

	@Override
	public Denominacion insertar(Denominacion denominacion) {
		
			try (Connection con = conectar();
					PreparedStatement ps =con.prepareStatement(DEN_INSERTAR,Statement.RETURN_GENERATED_KEYS);){
					ps.setString(1, denominacion.getDenominacion());
					ps.executeUpdate();
					ResultSet rs = ps.getGeneratedKeys();
					rs.next();
					
					denominacion.setId(rs.getLong(1));
					desconectar(con);
					return denominacion;
				
			} catch (SQLException e) {
				throw new AccesoDatosException("La operacion de insertar Denominacion ha fallado", e);
			}
		}

	@Override
	public Denominacion editar(Denominacion denominacion) {
		try (Connection con = conectar();
				PreparedStatement ps =con.prepareStatement(DEN_EDITAR);
			){
				ps.setString(1, denominacion.getDenominacion());
				ps.setLong(2,denominacion.getId());
				ps.executeUpdate();
				desconectar(con);
				
				return denominacion;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de modificar Denominacion ha fallado", e);
		}
	}

	@Override
	public void borrarDenominacion(Long id) {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(DEN_BORRAR);) {
				ps.setLong(1, id);

				ps.executeUpdate();
				desconectar(con);
			} catch (Exception e) {
				throw new AccesoDatosException("La operacion de borrar Denominacion ha fallado", e);
			}
		
	}

	@Override
	public Tipo tipoPorId(Long id) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(TIPO_POR_ID);) {
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			Tipo tipo  = null;

			if (rs.next()) {
				tipo = new Tipo(rs.getLong("id"), rs.getString("tipo"));}
						
			desconectar(con);
			return tipo;
			
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de obtener vino por id ha fallado", e);
		}
	}

	@Override
	public ArrayList<Tipo> tiposTodos() {
		
			try (Connection con = conectar();
					PreparedStatement ps = con.prepareStatement(TIPOS_TODOS);
					ResultSet rs = ps.executeQuery()) {

				ArrayList<Tipo> tiposlista = new ArrayList<>();

				while (rs.next()) {
					tiposlista.add(new Tipo(rs.getLong("id"), rs.getString("tipo")));
					
				}
				desconectar(con);
				System.out.println(tiposlista);
				return tiposlista;
			} catch (Exception e) {
				throw new AccesoDatosException("No se han podido obtener todos los tipos", e);
			}
	}

	@Override
	public Tipo insertar(Tipo tipo) {
		try (Connection con = conectar();
				PreparedStatement ps =con.prepareStatement(TIPO_INSERTAR,Statement.RETURN_GENERATED_KEYS);){
				ps.setString(1, tipo.getTipo());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				
				tipo.setId(rs.getLong(1));
				desconectar(con);
				return tipo;
			
		} catch (SQLException e) {
			throw new AccesoDatosException("La operacion de insertar tipo ha fallado", e);
		}
	}

	@Override
	public Tipo modificar(Tipo tipo) {
		try (Connection con = conectar();
				PreparedStatement ps =con.prepareStatement(TIPO_EDITAR);
			){
				ps.setString(1, tipo.getTipo());
				ps.setLong(2,tipo.getId());
				ps.executeUpdate();
				desconectar(con);
				
				return tipo;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de modificar usuario ha fallado", e);
		}
	}

	@Override
	public void borrarTipo(Long id) {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(TIPO_BORRAR);) {
				ps.setLong(1, id);

				ps.executeUpdate();
				desconectar(con);
			} catch (Exception e) {
				throw new AccesoDatosException("La operacion de borrar tipo ha fallado", e);
			}
		
		
	}

	
	

}

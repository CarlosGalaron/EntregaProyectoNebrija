package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Usuario;

/**
 * Clase Dao para desarollar las sentencias sql dirigidas a la base de datos y comunicar la vista y el controlador para los metodos de la clase usuario
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
public class DaoUsuario {
	/**
	 * Metodo para solicitar la conexion
	 */
	public static Connection con =null;
	public DaoUsuario() throws SQLException {
		DaoUsuario.con = DBConexion.getConexion();
	}
	/**
	 * Metodo para insertar los datos del formulario en la base de datos
	 */
	public void insertar(Usuario usuario) throws SQLException {
		String sql ="INSERT INTO usuario (nombreUsuario, correoUsuario) VALUES (?,?)"; 
		//después de values se ponen los interrogantes porque es un preparedStatement que coloca en el objeto creado los values introducidos.
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString (1,usuario.getNombreUsuario());
		ps.setString (2,usuario.getCorreoUsuario());

		ps.executeUpdate(); //executeUpdate para recibir, executeQuery para enviar
		ps.close();//para cerrar el PreparedStatement

	}
	/**
	 * Metodo para pedir el paquete de datos en forma de array de usuarios
	 */
	 public ArrayList<Usuario> listar() throws SQLException {
	        String sql = "SELECT nombreUsuario, correoUsuario FROM usuario";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        ArrayList<Usuario> ls = null;

	        while (rs.next()) {
	        	if(ls ==null){
	    			ls = new ArrayList<Usuario>();
	    			}
	            ls.add(new Usuario(rs.getString("nombreUsuario"), rs.getString("correoUsuario")));
	        }

	        ps.close();
	        rs.close();
	        return ls;
	    }
	 	/**
		 * Metodo para transformar los datos en un paquete json
		 */
	    public String listarJson() throws SQLException {
	        ArrayList<Usuario> usuarios = this.listar();
	        Gson gson = new Gson();
	        return gson.toJson(usuarios);
	    }	
	   
	    /**
		 * Metodo para pedir los datos del usuario a partir del corero
		 */
	    public Usuario obtenerPorCorreo(String correoUsuario) throws SQLException {
	        String sql = "SELECT idUsuario, nombreUsuario, correoUsuario, permiso FROM usuario WHERE correoUsuario = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, correoUsuario);
	        ResultSet rs = ps.executeQuery();

	        Usuario usuario = null;
	        if (rs.next()) {
	            usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nombreUsuario"), rs.getString("correoUsuario"), rs.getInt("permiso"));
	        }
	        ps.close();
	        rs.close();
	        return usuario;
	    }
	    /**
		 * Metodo para pedir los datos del usuario a partir del nombre
		 */
	    public Usuario obtenerPorNombre(String nombreUsuario) throws SQLException {
	        String sql = "SELECT idUsuario, nombreUsuario, correoUsuario, permiso FROM usuario WHERE nombreUsuario = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, nombreUsuario);
	        ResultSet rs = ps.executeQuery();

	        Usuario usuario = null;
	        if (rs.next()) {
	            usuario = new Usuario(rs.getInt("idUsuario"), rs.getString("nombreUsuario"), rs.getString("correoUsuario"), rs.getInt("permiso"));
	        }
	        ps.close();
	        rs.close();
	        return usuario;
	    }
}

package DAO;

import java.sql.*;
import modelo.Pieza;


/**
 * Clase Dao para desarollar las sentencias sql dirigidas a la base de datos y comunicar la vista y el controlador para los metodos de la clase Pieza
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
public class DaoPieza {
	/**
	 * Metodo para solicitar la conexion
	 */	
	public static Connection con =null;
	public DaoPieza() throws SQLException {
		this.con = DBConexion.getConexion();
	}
	/**
	 * Metodo para insertar los datos del formulario en la base de datos
	 */
	public void insertar(Pieza pi) throws SQLException {
		String sql ="INSERT INTO Pieza (tipo, altura, anchura, profundidad) VALUES (?,?,?,?)"; 
		//después de values se ponen los interrogantes porque es un preparedStatement que coloca en el objeto creado los values introducidos.
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString (1,pi.getTipo());
		ps.setInt (2,pi.getAltura());
		ps.setInt (3,pi.getAnchura());
		ps.setInt (4,pi.getProfundidad());
		int filas=ps.executeUpdate(); //para probar? //executeUpdate para recibir, executeQuery para enviar
		ps.close();//para cerrar el PreparedStatement

	}
		
}


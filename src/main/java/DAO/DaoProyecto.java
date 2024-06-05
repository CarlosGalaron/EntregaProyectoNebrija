package DAO;

import java.sql.*;
import java.util.ArrayList;

import com.google.gson.Gson;

import modelo.Proyecto;
import DAO.DBConexion;
/**
 * Clase Dao para desarollar las sentencias sql dirigidas a la base de datos y comunicar la vista y el controlador para los metodos de la clase proyecto
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
public class DaoProyecto {

	/**
	 * Metodo para solicitar la conexion
	 */	
	public static Connection con =null;
	public DaoProyecto() throws SQLException {
		this.con = DBConexion.getConexion();
	}
	/**
	 * Metodo para insertar los datos del formulario en la base de datos
	 */
	public void insertar(Proyecto p) throws SQLException {
		String sql ="INSERT INTO Proyecto (idProyecto, nombreProyecto, numeroPiezas, usuarioAdministrador) VALUES (?,?,?,?)"; 
		//después de values se ponen los interrogantes porque es un preparedStatement que coloca en el objeto creado los values introducidos.
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt (1,p.getIdProyecto());
		ps.setString (2,p.getNombreProyecto());
		ps.setInt (3,p.getNumeroPiezas());
		ps.setString (4,p.getUsuarioAdministrador());
		

		ps.executeUpdate(); //executeUpdate para recibir, executeQuery para enviar
		ps.close();//para cerrar el PreparedStatement

	}
	/**
	 * Metodo para pedir el paquete de datos en forma de array de proyectos
	 */
	public ArrayList<Proyecto> listar() throws SQLException {
        String sql = "SELECT nombreProyecto, usuarioAdministrador FROM proyecto";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Proyecto> ls = null;

        while (rs.next()) {
        	if(ls ==null){
    			ls = new ArrayList<Proyecto>();
    			}
            ls.add(new Proyecto(rs.getString("nombreproyecto"), rs.getString("usuarioAdministrador")));
        }

        ps.close();
        rs.close();
        return ls;
    }
	/**
	 * Metodo para transformar los datos en un paquete json
	 */
    public String listarJson() throws SQLException {
        ArrayList<Proyecto> proyectos = this.listar();
        Gson gson = new Gson();
        return gson.toJson(proyectos);
    }	
}

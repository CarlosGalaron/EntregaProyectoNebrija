package modelo;

import DAO.DaoProyecto;
import java.sql.*;

/**
 * Esta clase posee los metodos del CRUD del objeto Proyeecto, los distintos constructores necesarios y los getters y setters
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
public class Proyecto {
	
	private int idProyecto;
	private String nombreProyecto;
	private int numeroPiezas=0;
	private String usuarioAdministrador;
	
	public Proyecto() {
		
	}
	/**Constructor completo para extraer de la base de datos
	*@param idProyecto atributo para declarar el id del proyecto, auntogenerado, autoincremental, primary key
	*@param nombreProyecto atributo para declarar el nombre del proyecto
	*@param numeroPiezas atributo para declarar el numero de piezas registradas
	*@param usuarioAdministrador atributo para declarar el nombre del usuario que creo el proyecto
	**/
	public Proyecto(int idProyecto, String nombreProyecto, int numeroPiezas, String usuarioAdministrador) {
		super();
		this.idProyecto = idProyecto;
		this.nombreProyecto = nombreProyecto;
		this.numeroPiezas = numeroPiezas;
		this.usuarioAdministrador = usuarioAdministrador;
	}
	
	/**Constructor para registrar proyectos en la base de datos
	*@param nombreProyecto atributo para declarar el nombre del proyecto
	*@param usuarioAdministrador atributo para declarar el nombre del usuario que creo el proyecto
	**/
	public Proyecto(String nombreProyecto, String usuarioAdministrador) {
		super();
		this.nombreProyecto = nombreProyecto;
		this.usuarioAdministrador = usuarioAdministrador;
	}
	
	public int getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(int idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getNombreProyecto() {
		return nombreProyecto;
	}
	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}
	public int getNumeroPiezas() {
		return numeroPiezas;
	}
	public void setNumeroPiezas(int numeroPiezas) {
		this.numeroPiezas = numeroPiezas;
	}
	public String getUsuarioAdministrador() {
		return usuarioAdministrador;
	}
	public void setUsuarioAdministrador(String usuarioAdministrador) {
		this.usuarioAdministrador = usuarioAdministrador;
	}
	/**
	 * Metodo para insertar en la BD
	 */
	public void insertarBD () throws SQLException {
		DaoProyecto dao = new DaoProyecto ();
		dao.insertar(this);
	
	}
	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", nombreProyecto=" + nombreProyecto+ ", numeroPiezas="
				+ numeroPiezas + ", usuarioAdministrador=" + usuarioAdministrador + "]";

	}
}

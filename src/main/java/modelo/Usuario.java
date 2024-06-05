package modelo;

import java.sql.SQLException;
import DAO.DaoUsuario;

/**
 * Esta clase posee los metodos del CRUD del objeto Usuario, los distintos constructores necesarios y los getters y setters
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */

public class Usuario {
	
	private int idUsuario;
	private String nombreUsuario;
	private String correoUsuario;
	private int permiso;
	
	public Usuario() {
		
	}
	
	/**Constructor completo para extraer de la base de datos
	*@param idUsuario atributo para declarar el id del usuario, auntogenerado, autoincremental, primary key
	*@param nombreUsuario atributo para declarar el nombre del usuario
	*@param correoUsuario atributo para declarar el email del usuario
	*@param permisoUsuario atributo para declarar los permisos de acceso del usuario cuando su sesion esta iniciada
	**/
	public Usuario(int idUsuario, String nombreUsuario, String correoUsuario, int permiso) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.correoUsuario = correoUsuario;
		this.permiso = permiso;
	}

	/**Constructor sin idUsuario ni permiso para insertar en la base de datos
	*@param nombreUsuario
	*@param correoUsuario
	**/
		public Usuario(String nombreUsuario, String correoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.correoUsuario = correoUsuario;
		
	}
	/**Constructor sin idUsuario pero con permiso evaluar los permisos del usuario
	*@param nombreUsuario
	*@param correoUsuario
	*@param permisoUsuario
	**/
		public Usuario(String nombreUsuario, String correoUsuario, int permiso) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.correoUsuario = correoUsuario;
		this.permiso = permiso;	
		}
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}
	/**
	 * Metodo para insertar en la base de datos
	 */
	public void insertarBD () throws SQLException {
		DaoUsuario dao = new DaoUsuario ();
		dao.insertar(this);
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", correoUsuario="
				+ correoUsuario + ", permiso=" + permiso + "]";
	}
	
	
}


package modelo;

import java.sql.SQLException;

import DAO.DaoPieza;

/**
 * Esta clase posee los metodos del CRUD del objeto Pieza, los distintos constructores necesarios y los getters y setters
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
public class Pieza {
	
	private String idPieza;
	private String tipo;
	private int altura;
	private int anchura;
	private int profundidad;
	private String proyectoGestor;
	
	public Pieza() {
		
	}
	/** Constructor para pedir todos los atributos a la base de datos
	 * @param tipo atributo para declarar de que tipo es la pieza
	 * @param altura atributo para declarar la medida en mm del eje x
	 * @param anchura atributo para declarar atributo para declarar la medida en mm del eje y
	 * @param profundidad atributo para declarar atributo para declarar la medida en mm del eje z
	 */
	public Pieza(String idPieza, String tipo, int altura, int anchura, int profundidad, String proyectoGestor) {
		super();
		this.idPieza = idPieza;
		this.tipo = tipo;
		this.altura = altura;
		this.anchura = anchura;
		this.profundidad = profundidad;
		this.proyectoGestor = proyectoGestor;
	}
	
	
	public String getIdPieza() {
		return idPieza;
	}
	public void setIdPieza(String idPieza) {
		this.idPieza = idPieza;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getAnchura() {
		return anchura;
	}
	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}
	public String getProyectoGestor() {
		return proyectoGestor;
	}
	public void setProyectoGestor(String proyectoGestor) {
		this.proyectoGestor = proyectoGestor;
	}
	/** Constructor para registrar en la base de datos
	 * @param tipo atributo para declarar el tipo de pieza
	 * @param altura atributo para declarar la medida en mm del eje x
	 * @param anchura atributo para declarar la medida en mm del eje y
	 * @param profundidad atributo para declarar la medida en mm del eje z
	 */
	public Pieza(String tipo, int altura, int anchura, int profundidad) {
		super();
		this.tipo = tipo;
		this.altura = altura;
		this.anchura = anchura;
		this.profundidad = profundidad;
	}
	/**
	 * Metodo para insertar en la base de datos
	 */
		public void insertarBD () throws SQLException {
			DaoPieza dao = new DaoPieza ();
			dao.insertar(this);
		}
		@Override
	public String toString() {
		return "Pieza [idPieza=" + idPieza + ", tipo=" + tipo + ", altura=" + altura + ", anchura=" + anchura
				+ ", profundidad=" + profundidad + ", proyectoGestor=" + proyectoGestor + "]";
		
	}
}

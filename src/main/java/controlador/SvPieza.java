package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Pieza;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Servlet para insertar piezas en la base de datos
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */

public class SvPieza extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor vacio
     */
    public SvPieza() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Metodo do Post para registrar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            String tipo = request.getParameter("tipo");
            int altura = Integer.parseInt(request.getParameter("altura"));
            int anchura = Integer.parseInt(request.getParameter("anchura"));
            int profundidad = Integer.parseInt(request.getParameter("profundidad"));
            
            Pieza pi1 = new Pieza(tipo, altura, anchura, profundidad);
            System.out.println(pi1.toString());
        
		pi1.insertarBD();
		} catch (NumberFormatException e) {
            System.err.println("Error al parsear uno de los parámetros: " + e.getMessage());
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

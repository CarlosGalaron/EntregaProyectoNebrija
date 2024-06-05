package controlador;

import java.sql.SQLException;

import DAO.DaoProyecto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Proyecto;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet para insertar y listar proyectos en la base de datos
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
@WebServlet("/listarProyectos")//para redirigir al fetch(no olvidar)

public class SvProyecto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Constructor vacio 
     */
    public SvProyecto() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * Método doGet para listar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();

	        try {
	            DaoProyecto daoProyecto = new DaoProyecto();
	            String jsonProyectos = daoProyecto.listarJson();
	            out.print(jsonProyectos);
	            out.flush();
	        } catch (SQLException e) {
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            out.print("{\"error\": \"" + e.getMessage() + "\"}");
	            out.flush();
	        }
	    }

	/**
	 * Metodo doPost para registrar
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            String nombreProyecto = request.getParameter("nombreProyecto");
            String usuarioAdministrador = request.getParameter("usuarioAdministrador");

            Proyecto p1 = new Proyecto(nombreProyecto, usuarioAdministrador);
            System.out.println(p1.toString());
        
		p1.insertarBD();
		} catch (NumberFormatException e) {
            System.err.println("Error al parsear uno de los parámetros: " + e.getMessage());
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

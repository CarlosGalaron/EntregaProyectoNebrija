package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.DaoUsuario;

/**
 * Servlet para insertar y listar usuarios en la base de datos
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
@WebServlet(urlPatterns= {"/listarUsuario"}) //para redirigir al fetch

public class SvUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor vacio
     */
    public SvUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Metodo doGet para listar
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();

	        try {
	            DaoUsuario daoUsuario = new DaoUsuario();
	            String jsonUsuarios = daoUsuario.listarJson();
	            out.print(jsonUsuarios);
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
		 response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();

	        try {
	            String nombreUsuario = request.getParameter("nombreUsuario");
	            String correoUsuario = request.getParameter("correoUsuario");

	            Usuario usuario = new Usuario(nombreUsuario, correoUsuario);
	            usuario.insertarBD();
	            
	        } catch (SQLException e) {
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            out.print("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
	        }
	        

	        out.flush();
	    }

}

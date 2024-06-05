package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelo.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.DaoUsuario;

/**
 * Servlet para pedir los datos necesarios para el login
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */

@WebServlet("/Login")//direccion del html/js para redirigir al fetch

public class SvGestionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor vacio
     */
    public SvGestionUsuario() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * Método doPost para pedir el nombre y correo del usuario a la base de datos y obtener la sesión
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        PrintWriter out = response.getWriter();
	        String action = request.getParameter("action");

	        try {
	            if ("login".equals(action)) {
	                String correoUsuario = request.getParameter("correoUsuario");
	                String nombreUsuario = request.getParameter("nombreUsuario");

	                DaoUsuario dao = new DaoUsuario();
	                Usuario usuario = dao.obtenerPorCorreo(correoUsuario);

	                if (usuario != null && nombreUsuario.equals(usuario.getNombreUsuario())) {
	                    HttpSession session = request.getSession();
	                    session.setAttribute("usuario", usuario);
	                    out.print("{\"success\": true}");
	                } else {
	                    out.print("{\"success\": false, \"error\": \"Credenciales incorrectas\"}");
	                }
	            } else {
	                out.print("{\"success\": false, \"error\": \"Acción no reconocida\"}");
	            }
	        } catch (SQLException e) {
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	            out.print("{\"error\": \"" + e.getMessage() + "\"}");
	        }
	        out.flush();
	    }

}

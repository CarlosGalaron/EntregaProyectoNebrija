
package DAO;

import java.sql.*;
/**
 * Conectar la aplicación con la base de datos
 * @Autor Carlos Galaron
 * @Version 4/06/2024 v 1.0
 */
	public class DBConexion {
		/**
		 * URL de la base de datos
		 */
		public static final String JDBC_URL = "jdbc:mysql://localhost:3306/atsbd"; 
		public static Connection instance =null;
		/**
		 * Metodo para solicitar la conexion
		 */
		public static Connection getConexion () throws SQLException { 

			if(instance == null) {
			instance = DriverManager.getConnection(JDBC_URL, "ATSUser", "1234");
			
				}
			return instance;
			}

		} 
	


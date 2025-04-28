package capaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDSistema {

	//VALORES PARA LA CONEXION CON MySQL
	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/sistema_incripcion_cursos";
	private static String usuario="root";
	private static String clave="admin";
	
	//OBJETOS PARA REALIZAR LA CONEXION Y RECUPERACION DE DATOS DESDE MySQL
	private static Connection cn; //ESTABLECER LA CONEXION CON MYSQL
	
	public static Connection getConexion() { 
		try {
			Class.forName(driver);
			cn=DriverManager.getConnection(url,usuario,clave);
			System.out.println("Conexion Exitosa");
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println("Error"+e.getMessage());
		}
		return cn; 
	}
	
}

package capaDatos;

import java.sql.Connection;

public class ProbarConexion {

	public static void main(String[] args) {
		
		ProbarConexion.LLamarConexion();
		

	}
	
	public static void LLamarConexion() {
		Connection cn=BDSistema.getConexion();
		if(cn== null) System.out.println("Conexion Erronea");
	}

}

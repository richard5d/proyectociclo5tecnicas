package arreglos;
import java.util.ArrayList;

import entidad.Usuario;

public class ArregloUsuarios {
	public static ArrayList<Usuario> usuarios = new ArrayList<>();
	
	public static void adicionar(Usuario usuario) {
		ArregloUsuarios.usuarios.add(usuario);
	}
	//busca solo por email
	public static Usuario buscar(String email) {
		for(int i=0;i<ArregloUsuarios.usuarios.size();i++) {
			Usuario usuario=ArregloUsuarios.usuarios.get(i);
			if(usuario.getEmail().equals(email)) {
				return usuario;
			}
		}
		return null;
	}
	//busca por email y password
	public static Usuario buscar(String email,String password) {
		for(int i=0;i<ArregloUsuarios.usuarios.size();i++) {
			Usuario usuario=ArregloUsuarios.usuarios.get(i);
			if(usuario.getEmail().equals(email) && usuario.getPassword().equals(password)) 
				return usuario;
		}
		return null;
	}
}

package co.edu.udea.iw.dto;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla tab_administradores.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class Administrador extends Usuario {

	/**
	 * Constructor para la clase Administrador heredado de la clase abstracta Usuario. 
	 * @param id - Identificador, login o nombre de usuario para un administrador.
	 * @param nombre - Nombre real de un administrador.
	 * @param apellidos - Apellidos de un administrador.
	 * @param correo - Correo electronico de un administrador.
	 * @param contrasena - Contrasena de un administrador.
	 */
	public Administrador(String id, String nombre, String apellidos, String correo, String contrasena) {
		super(id, nombre, apellidos, correo, contrasena);
	}
}

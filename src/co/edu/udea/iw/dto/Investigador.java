package co.edu.udea.iw.dto;

/**
 * Clase que se utilizara como objeto de transferencia de datos para la tabla tab_investigadores.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class Investigador extends Usuario{

	/**
	 * Constructor para la clase Investigador heredado de la clase abstracta Usuario. 
	 * @param id - Identificador, login o nombre de usuario para un investigador.
	 * @param nombre - Nombre real de un investigador.
	 * @param apellidos - Apellidos de un investigador.
	 * @param correo - Correo electronico de un investigador.
	 * @param contrasena - Contrasena de un investigador.
	 */
	public Investigador(String id, String nombre, String apellidos, String correo, String contrasena) {
		super(id, nombre, apellidos, correo, contrasena);
	}	
}

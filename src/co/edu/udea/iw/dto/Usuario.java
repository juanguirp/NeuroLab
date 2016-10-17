package co.edu.udea.iw.dto;

/**
 * Clase abstracta que permitira definir subclases de usuarios que pueden acceder al sistema.
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public abstract class Usuario {
	
	/* Variables de instancia global que representan las
	 * caracteristicas o atributos que posee un tipo de usuario.
	 */
	private String id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String contrasena;
	
	/**
	 * Constructor para un objeto que extienda de la clase Usuario.
	 * @param id - Identificador, login o nombre de usuario.
	 * @param nombre - Nombre real de un usuario.
	 * @param apellidos - Apellidos de un usuario.
	 * @param correo - Correo electronico de un usuario.
	 * @param contrasena - Contrasena de un usuario.
	 */
	public Usuario(String id, String nombre, String apellidos, String correo, String contrasena) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.contrasena = contrasena;
	}
	
	/* 
	 * Getters y Setters para los atributos de un tipo de usuario.
	 */
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}

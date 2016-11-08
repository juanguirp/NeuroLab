package co.edu.udea.iw.ws.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UsuarioWs {

	private String login;
	private String nombres;
	private String apellidos;
	private String contrasena;
	
	public UsuarioWs(){}
	
	public UsuarioWs(String login, String nombres, String apellidos, String contrasena) {
		this.login = login;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.contrasena = contrasena;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
	
}

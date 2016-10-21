package co.edu.udea.iw.bl;

import co.edu.udea.iw.exception.NeuroLabDaoException;

public interface AdministradorBl {

	public boolean validarAdministrador(String id, String contrasena) throws NeuroLabDaoException;
	public void crearCuentaAdministrador(String id, String nombre,String apellidos, String correo, String contrasena) throws NeuroLabDaoException;
	
	
}

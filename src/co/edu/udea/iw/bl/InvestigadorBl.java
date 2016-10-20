package co.edu.udea.iw.bl;

import co.edu.udea.iw.exception.NeuroLabDaoException;

public interface InvestigadorBl {

	public boolean validarInvestigador(String id, String contrasena) throws NeuroLabDaoException;
	public void crearCuentaInvestigador(String id, String nombre,String apellidos, String contrasena) throws NeuroLabDaoException;
	
}

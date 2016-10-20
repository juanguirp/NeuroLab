package co.edu.udea.iw.bl.imp;

import co.edu.udea.iw.bl.InvestigadorBl;
import co.edu.udea.iw.dao.InvestigadorDao;
import co.edu.udea.iw.dto.Investigador;
import co.edu.udea.iw.exception.NeuroLabDaoException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

public class InvestigadorBlImp implements InvestigadorBl {

	InvestigadorDao investigadorDao;
	
	@Override
	public boolean validarInvestigador(String id, String contrasena) throws NeuroLabDaoException {
		Investigador investigador = new Investigador(id, "", "", "", contrasena);
		String contrasenaEnBd;
		String contrasenaCifrada;
		
		try{
			investigador = investigadorDao.obtenerInvestigador(id);
			if(investigador != null){
				Cifrar conversor = new Cifrar();
				contrasenaEnBd = investigador.getContrasena();
				contrasenaCifrada = conversor.encrypt(contrasena);
				if(contrasenaEnBd == contrasenaCifrada){
					return true;
				}
			}
		} catch (NeuroLabDaoException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public void crearCuentaInvestigador(String id, String nombre, String apellidos, String correo, String contrasena) throws NeuroLabDaoException {
		
		if(id == null || "".equals(id.trim())){
			throw new NeuroLabDaoException("Debe especificar un identificador o nombre de usuario valido");
		}
		if(nombre == null || "".equals(nombre.trim())){
			throw new NeuroLabDaoException("Debe especificar su nombre");
		}
		if(apellidos == null || "".equals(apellidos.trim())){
			throw new NeuroLabDaoException("Debe especificar sus apellidos");
		}
		if(correo == null || "".equals(correo.trim())){
			throw new NeuroLabDaoException("Debe especificar un correo electronico");
		}
		if(contrasena == null || "".equals(contrasena.trim())){
			throw new NeuroLabDaoException("Debe especificar una contrasena");
		}
		if(!Validaciones.isEmail(correo)){
			throw new NeuroLabDaoException("El correo debe ser valido");
		}
		
		Investigador investigador = new Investigador(id, nombre, apellidos, correo, contrasena);
		investigadorDao.registrarInvestigador(investigador);

	}

}

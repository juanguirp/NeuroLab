package co.edu.udea.iw.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.iw.dto.Administrador;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.TipoDispositivo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

public interface DispositivoBl {

	public void registrarDispositivo(int id, TipoDispositivo tipoDispositivo, Boolean disponible, String especificaciones,
			Administrador adminRegistrador, Date fechaRegistro) throws NeuroLabDaoException;
	public void eliminarDispositivo(int id) throws NeuroLabDaoException;
	public List<Dispositivo> listarDispositivos() throws NeuroLabDaoException;
	
}

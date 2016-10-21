package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import co.edu.udea.iw.dao.SolicitudPrestamoDao;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

public class SolicitudPrestamoDaoHibernate implements SolicitudPrestamoDao {

	@Override
	public List<SolicitudPrestamo> listarSolicitudes() throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolicitudPrestamo obtenerSolicitud(int id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registrarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminarSolicitud(int id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

}

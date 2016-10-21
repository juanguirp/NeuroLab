package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import co.edu.udea.iw.dao.SolicitudPrestamoDao;
import co.edu.udea.iw.dto.SolicitudPrestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla
 * tab_solicitudes_prestamo.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class SolicitudPrestamoDaoHibernate implements SolicitudPrestamoDao {

	/**
	 * Entrega una lista con las solicitudes en la base de datos.
	 * 
	 * @return lista de solicitudes.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#listarSolicitudes()
	 */
	@Override
	public List<SolicitudPrestamo> listarSolicitudes() throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Entrega los datos de una solicitud dado su identificador.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud.
	 * @return DTO de una solicitud con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#obtenerSolicitud(int)
	 */
	@Override
	public SolicitudPrestamo obtenerSolicitud(int id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Permite crear una nueva solicitud y registrarla en la base de datos.
	 * 
	 * @param solicitudPrestamo
	 *            - DTO con los datos de la solicitud a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#registrarSolicitud(co.edu.udea.iw
	 *      .dto.SolicitudPrestamo)
	 */
	@Override
	public void registrarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * Actualiza la informacion de una solicitud en la base de datos.
	 * 
	 * @param solicitudPrestamo
	 *            - DTO con los datos de la solicitud a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#actualizarSolicitud(co.edu.udea.
	 *      iw.dto.SolicitudPrestamo)
	 */
	@Override
	public void actualizarSolicitud(SolicitudPrestamo solicitudPrestamo) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * Permite eliminar una solicitud de la base de datos.
	 * 
	 * @param id
	 *            - Numero que identifica una solicitud.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.SolicitudPrestamoDao#eliminarSolicitud(int)
	 */
	@Override
	public void eliminarSolicitud(int id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

}

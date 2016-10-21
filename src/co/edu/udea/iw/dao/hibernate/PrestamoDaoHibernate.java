package co.edu.udea.iw.dao.hibernate;

import java.util.List;

import co.edu.udea.iw.dao.PrestamoDao;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.NeuroLabDaoException;

/**
 * Implementacion de la interface que permite acceder a la tabla tab_prestamos.
 * 
 * @author Juan Guillermo Restrepo Pineda <juan.restrepo48@udea.edu.co>
 */
public class PrestamoDaoHibernate implements PrestamoDao {

	/**
	 * Entrega una lista con los prestamos en la base de datos.
	 * 
	 * @return lista de prestamos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#listarPrestamos()
	 */
	@Override
	public List<Prestamo> listarPrestamos() throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Entrega los datos de un prestamo dado su identificador.
	 * 
	 * @param id
	 *            - Numero que identifica un prestamo.
	 * @return DTO de un prestamo con sus datos.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#obtenerPrestamo(int)
	 */
	@Override
	public Prestamo obtenerPrestamo(int id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Permite crear un nuevo prestamo y registrarlo en la base de datos.
	 * 
	 * @param -
	 *            DTO con los datos del administrador a guardar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#registrarPrestamo(co.edu.udea.iw.dto.
	 *      Prestamo)
	 */
	@Override
	public void registrarPrestamo(Prestamo prestamo) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * Actualiza la informacion de un prestamo en la base de datos.
	 * 
	 * @param prestamo
	 *            - DTO con los datos del prestamo a modificar.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#actualizarPrestamo(co.edu.udea.iw.dto.
	 *      Prestamo)
	 */
	@Override
	public void actualizarPrestamo(Prestamo prestamo) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

	/**
	 * Permite eliminar un prestamo de la base de datos.
	 * 
	 * @param id
	 *            - Numero que identifica un prestamo.
	 * @throws NeuroLabDaoException
	 *             cuando hay algun problema en la conexion.
	 * @see co.edu.udea.iw.dao.PrestamoDao#eliminarPrestamo(int)
	 */
	@Override
	public void eliminarPrestamo(int id) throws NeuroLabDaoException {
		// TODO Auto-generated method stub

	}

}
